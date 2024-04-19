package sauceDemoLogin;

import com.codeborne.selenide.Configuration;

public class Config {
    private static Config config;

    private Config() {
        //Configuration.pageLoadTimeout = 5000L;

    }

    public static Config getInstance() {
        if (config == null) {
            config = new Config();
        }
        return config;
    }
}
