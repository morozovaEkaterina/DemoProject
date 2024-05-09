package selenide_short_version.kinopoisk;

import com.codeborne.selenide.Configuration;

public class Config {

    private static Config config;

    public static Config getInstance() {
        if (config == null) {
            config = new Config();
        }
        return config;
    }

    public Config() {
        Configuration.pageLoadTimeout = 50000L;
    }
}

