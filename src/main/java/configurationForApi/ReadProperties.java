package configurationForApi;


import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private static final Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(ReadProperties.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String username() {
        return properties.getProperty("username");
    }
    public static String password() {
        return properties.getProperty("password");
    }
    public static String url() {
        return properties.getProperty("url");
    }
    public static String token() {
        return properties.getProperty("token");
    }
    public static String database() {
        return properties.getProperty("database");
    }


}
