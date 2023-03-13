package core.configuration;

import org.aeonbits.owner.ConfigFactory;

public class ReadProperties {
    private static final UiConfig uiConfig = ConfigFactory.create(UiConfig.class);
    private static final ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class);
    private static final AuthenticationConfig authenticationConfig = ConfigFactory.create(AuthenticationConfig.class,
            System.getProperties());
    private static final AllureConfig allureConfig = ConfigFactory.create(AllureConfig.class);

    public static UiConfig getUiConfig() {
        return uiConfig;
    }

    public static ApiConfig getApiConfig() {
        return apiConfig;
    }

    public static AuthenticationConfig getAuthenticationConfig() {
        return authenticationConfig;
    }

    public static AllureConfig getAllureConfig() {
        return allureConfig;
    }
}
