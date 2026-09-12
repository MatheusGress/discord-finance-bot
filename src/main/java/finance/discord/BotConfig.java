package finance.discord;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BotConfig {

    private final Properties properties = new Properties();

    public BotConfig() {
        try (InputStream input = getClass().
                getClassLoader()
                .getResourceAsStream("application.properties")) {

            if (input == null) {
                throw new RuntimeException("application.properties not found.");
            }

            properties.load(input);

        } catch (IOException e) {
            throw new RuntimeException("Failed to load application.properties", e);
        }
    }

    public String getToken() {
        return properties.getProperty("discord.bot.token");
    }
}