package baseentities;

import core.configuration.ReadProperties;

public abstract class BasePage extends BaseEntity {
    public void openPageByUrl(String pagePath) {
        driver.get(ReadProperties.getUiConfig().url() + pagePath);
    }
}
