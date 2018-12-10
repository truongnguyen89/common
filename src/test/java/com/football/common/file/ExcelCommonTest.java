package com.football.common.file;

import com.football.common.util.JsonCommon;

import java.util.List;

public class ExcelCommonTest {
    public static void main(String[] args) {
        try {
            List list = ExcelCommon.readExcelFile("/Users/truongnq/1.Workspace/File/D.xls", 1, 0, 7);
            if (list != null){
                System.out.println(JsonCommon.objectToJsonLog(list.get(0)));
                System.out.println(JsonCommon.objectToJsonLog(list.get(list.size() - 1)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
