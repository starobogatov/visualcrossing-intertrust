package config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestConfiguration {

    public static Properties loadConfiguration() {
        Properties properties = new Properties();
        loadConfiguration(properties, "application.properties");
        return properties;
    }

    private static void loadConfiguration(Properties properties, String fileName) {
        try (InputStream is = ClassLoader.getSystemResourceAsStream(fileName)) {
            if (is == null) {
                throw new RuntimeException("Configuration file not found in classpath: " + fileName);
            }
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read file: " + fileName, e);
        }
    }
}
