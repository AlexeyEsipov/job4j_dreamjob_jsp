package ru.job4j.dream.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

    public static String getProperty(String key) {
        Properties cfg = new Properties();
        try (InputStream in = Config.class.getClassLoader()
                .getResourceAsStream("dream.properties")) {
            cfg.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cfg.getProperty(key);
    }
}
