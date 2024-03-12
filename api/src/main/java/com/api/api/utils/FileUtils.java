package com.api.api.utils;
import java.io.File;
//Handle Json data file as input for tests
public class FileUtils {
    public static final String JSON_TEST_DATA = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\testData.json";
    public static String readFileToString(File file, String fileToString) {
        return fileToString;
    }
}
