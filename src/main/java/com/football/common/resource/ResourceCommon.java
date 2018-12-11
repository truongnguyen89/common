package com.football.common.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 11-Dec-18
 * Time: 2:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class ResourceCommon {
    @Autowired
    private ResourceLoader resourceLoader;

    public Resource getResource(String filePathInResource) {
        return resourceLoader.getResource("classpath:" + filePathInResource);
    }

    public File getFile(String filePathInResource) {
        try {
            return resourceLoader.getResource("classpath:" + filePathInResource).getFile();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
