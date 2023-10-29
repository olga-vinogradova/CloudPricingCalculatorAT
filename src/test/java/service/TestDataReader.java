package service;

import java.util.ResourceBundle;

public class TestDataReader {
    private static final String BASE_NAME = "environment";

    public static String getTestData(String key) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(BASE_NAME);
        return resourceBundle.getString(key);
    }
}
