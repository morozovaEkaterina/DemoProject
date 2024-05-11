package sauceDemo;

import com.codeborne.selenide.Configuration;

public class Config {
    private static Config config;

    private Config() {
        Configuration.pageLoadTimeout = 10000L;

    }

    public static Config getInstance() {
        if (config == null) {
            config = new Config();
        }
        return config;
    }
}
