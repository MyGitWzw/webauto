package com.webauto.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2021/12/27 15:50
 */
public class PropertiesUtil {
    public static Properties properties = new Properties();

    static {

        FileInputStream fis  = null;
        try {
            fis = new FileInputStream(new File("src/test/resources/config.properties"));
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static String getFilePath(String filePath){
        return properties.getProperty(filePath);
    }

}
