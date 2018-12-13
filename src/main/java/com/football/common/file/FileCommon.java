/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.football.common.file;

import com.football.common.constant.Constant;
import com.football.common.model.log.Log;
import com.football.common.response.Response;
import com.football.common.util.ArrayListCommon;
import com.football.common.util.StringCommon;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @author : TruongNQ
 * @date created : Apr 7, 2018
 * @describe : Expression des is undefined on line 13, column 25 in
 * Templates/Classes/Class.java.
 */
public class FileCommon {
    private static final Logger LOGGER = LogManager.getLogger(Constant.LOG_APPENDER.COMMON);

    public static ArrayList<String> readStringFromTextFile(String filePath) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(new File(filePath));
        DataInputStream dataInput = new DataInputStream(fileInputStream);
        BufferedReader bufferReadre = new BufferedReader(new InputStreamReader(dataInput));
        ArrayList<String> list = new ArrayList<String>();
        String line = "";
        while (!StringCommon.isNullOrBlank(line = bufferReadre.readLine())) {
            list.add(line);
        }
        fileInputStream.close();
        dataInput.close();
        bufferReadre.close();
        return list;
    }

    public static StringBuffer readStringBufferFromTextFile(File file) throws Exception {
        StringBuffer rs = new StringBuffer();
        FileInputStream fileInputStream = new FileInputStream(file);
        DataInputStream dataInput = new DataInputStream(fileInputStream);
        BufferedReader bufferReadre = new BufferedReader(new InputStreamReader(dataInput));
        String line = "";
        while (!StringCommon.isNullOrBlank(line = bufferReadre.readLine())) {
            rs.append(line);
        }
        fileInputStream.close();
        dataInput.close();
        bufferReadre.close();
        return rs;
    }

    public static boolean checkFileExists(String pathFile) {
        if (StringCommon.isNullOrBlank(pathFile)) {
            return false;
        }
        try {
            File file = new File(pathFile);
            if (!file.exists()) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static Response writeTextFile(String filePath, List<String> data) {
        if (StringCommon.isNullOrBlank(filePath) || ArrayListCommon.isNullOrEmpty(data)) {
            return Response.BAD_REQUEST;
        }
        BufferedWriter bw = null;
        FileWriter fw = null;
        try {
            fw = new FileWriter(filePath);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < data.size(); i++) {
                bw.write(data.get(i));
                bw.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.INTERNAL_SERVER_ERROR;
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return Response.OK;
    }

    /**
     * Delete file
     *
     * @param filePath
     */
    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
    }

    public static void deleteDirectory(String path) {
        if (path != null) {
            File dir = new File(path);
            if (dir.exists()) {
                //
                File[] files = dir.listFiles();
                for (int i = 0; i < files.length; i++) {
                    if (files[i].isFile()) {
                        deleteFile(files[i].getPath());
                    } else {
                        deleteDirectory(files[i].getPath());
                    }
                }
                //
                dir.delete();
            }
        }
    }

    public static void copyFile(String in, String out) throws Exception {
        FileChannel ic = new FileInputStream(in).getChannel();
        FileChannel oc = new FileOutputStream(out).getChannel();
        oc.transferFrom(ic, 0, ic.size());
        ic.close();
        oc.close();
    }

    public static void copyFolder(String in, String out) throws Exception {
        File newdir = new File(out);
        if (!newdir.exists()) {
            newdir.mkdir();
        }

        File orgdir = new File(in);

        File[] files = orgdir.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {

                copyFile(files[i].getPath(), newdir.getPath() + "\\" + files[i].getName());
            }
        }
    }

    public static String[] getLines(String filePath) throws Exception {
        BufferedReader input = new BufferedReader(new FileReader(filePath));
        ArrayList list = new ArrayList(5000);
        String line = null;
        while ((line = input.readLine()) != null) {
            list.add(line);
        }
        String[] lines = new String[list.size()];
        list.toArray(lines);
        input.close();
        return lines;
    }

    public static void zip(String path) throws Exception {
        int point = path.lastIndexOf(".");
        zip(path, path.substring(0, point));
    }

    public static void zip(String path, String zipFileName) throws Exception {
        File file = new File(path);
        File zipFile = new File(zipFileName + ".zip");
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile));

        if (file.isFile()) {
            addTargetFile(zos, file, file.getName());

        } else {
            File[] fileList = file.listFiles();
            for (int i = 0; i < fileList.length; i++) {
                int point = zipFile.getName().lastIndexOf(".");
                folderZip(fileList[i].getPath(), fileList[i].getName(), zos, zipFile.getName().substring(0, point));
            }
        }
        zos.close();

    }

    private static void folderZip(String path, String fileName, ZipOutputStream zos, String zipFileName)
            throws Exception {
        File file = new File(path);

        if (file.isFile()) {
            addTargetFile(zos, file, fileName);
        } else {
            int point = file.getPath().lastIndexOf(zipFileName);
            String zipfolderPath = file.getPath().substring(point + zipFileName.length());
            File[] fileList = file.listFiles();
            for (int i = 0; i < fileList.length; i++) {
                folderZip(fileList[i].getPath(), zipfolderPath + "\\" + fileList[i].getName(), zos, zipFileName);
            }
        }
    }

    public static void addTargetFile(ZipOutputStream zos, File file, String fileName) throws Exception {
        int EOF = -1;
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));

        ZipEntry target = new ZipEntry(fileName);
        zos.putNextEntry(target);

        byte buf[] = new byte[1024];
        int count;
        while ((count = bis.read(buf, 0, 1024)) != EOF) {
            zos.write(buf, 0, count);
        }
        bis.close();
        zos.closeEntry();
    }

    public static String getPrefix(String fileName) {
        if (fileName == null) {
            return null;
        }
        int point = fileName.lastIndexOf(".");
        if (point != -1) {
            return fileName.substring(0, point);
        }
        return fileName;
    }

    public static String getFileSizeString(int fileSize) {
        int Mb = fileSize / 1024 / 1024;
        if (Mb > 0) {
            return String.valueOf((fileSize / 1024 / 1024)) + "MB";
        } else {
            return String.valueOf((fileSize / 1024)) + "KB";
        }
    }

    public static void close(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (Exception ex) {
                LOGGER.error("Exception when closing InputStream: ", ex);
            }
        }
    }

    public static void close(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (Exception ex) {
                LOGGER.error("Exception when closing InputStream: ", ex);
            }
        }
    }

    public static void close(InputStream is, OutputStream os) {
        if (is != null) {
            try {
                is.close();
            } catch (Exception ex) {
                LOGGER.error("Exception when closing InputStream: ", ex);
            }
        }
        if (os != null) {
            try {
                os.close();
            } catch (Exception ex) {
                LOGGER.error("Exception when closing InputStream: ", ex);
            }
        }
    }

    public static File convertFilePath2File(String filePath) {
        File file = null;
        try {
            if (!StringCommon.isNullOrBlank(filePath)) {
                file = new File(filePath);
            }
        } catch (Exception e) {
            LOGGER.error("Exception when convertFilePath2File(" + filePath + ") ", e);
        }
        return file;
    }


    public static String[] getListFolderFromUrl(String pathName) {
        try {
            File file = new File(pathName);
            String[] directories = file.list(new FilenameFilter() {
                @Override
                public boolean accept(File current, String name) {
                    return new File(current, name).isDirectory();
                }
            });
            return directories;
        } catch (Exception e) {
            LOGGER.error("Exception when getListFolderFromUrl ", e);
            return null;
        }
    }

    public static List<File> getListFilesInFolder(File folder) {
        List<File> fileList = new ArrayList<>();
        try {
            for (final File fileEntry : folder.listFiles()) {
                if (fileEntry.isDirectory()) {
                    fileList.addAll(getListFilesInFolder(fileEntry));
                } else {
                    fileList.add(fileEntry);
                }
            }
        } catch (Exception e) {
            LOGGER.error("Exception when getListFolderFromUrl ", e);
        }
        return fileList;
    }

    public static List<File> getListFilesByExtensionInFolder(File folder, String extension) {
        List<File> fileList = new ArrayList<>();
        try {
            for (final File fileEntry : folder.listFiles()) {
                if (fileEntry.isDirectory()) {
                    fileList.addAll(getListFilesByExtensionInFolder(fileEntry, extension));
                } else if (fileEntry.getName().toLowerCase().endsWith(extension.toLowerCase())) {
                    fileList.add(fileEntry);
                }
            }
        } catch (Exception e) {
            LOGGER.error("Exception when getListFolderFromUrl ", e);
        }
        return fileList;
    }

    public static List<Log> readFileLog(String filePath) throws Exception {
        List<Log> lstLog = new ArrayList<>();
        try {
            for (String a : readStringFromTextFile(filePath)) {
                String jsonString = a.substring(26);//"[21/06/2018 16:07:58,886] {JSON FORMAT}
                try {
                    JSONObject logLine = new JSONObject(jsonString);
                    Log log = new Log();
                    log.setLogId(logLine.getLong("logId"));
                    //Lay thong tin application name
                    int idx = filePath.indexOf("ecpay-", 0);
                    int idxSlash = filePath.indexOf("\\", idx) < 0 ? filePath.indexOf("/", idx) : filePath.indexOf("\\", idx);
                    log.setApplication(filePath.substring(idx, idxSlash));
                    //End Lay thong tin application name
                    log.setMethod(logLine.get("method").toString());
                    log.setStartTime(logLine.get("startTime").toString());
                    log.setEndTime(logLine.get("endTime").toString());
                    log.setDuration(logLine.getLong("duration"));
                    log.setRequest(logLine.get("request").toString());
                    log.setResponse(logLine.get("response").toString());
                    log.setStatus(logLine.get("status").toString());
                    log.setLogPath(filePath);
                    lstLog.add(log);
                } catch (JSONException e) {
                }
            }
        } catch (Exception e) {
            LOGGER.error("Exception when readFileLog(" + filePath + ") ", e);
            throw e;
        } finally {
            zip(filePath, filePath);
            deleteFile(filePath);
        }
        return lstLog;
    }

    public static File renameExtension(File file, String extension) {
        File newfile = new File(FilenameUtils.removeExtension(file.getPath()) + "." + extension);
        if (file.renameTo(newfile))
            return file;
        else
            return null;
    }
}
