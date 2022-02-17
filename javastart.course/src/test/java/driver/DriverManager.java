package driver;

import configurations.LocalWebDriveProperties;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();
    private static ThreadLocal<BrowserType> browserTypeThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {
        if (webDriverThreadLocal.get() == null) {
            webDriverThreadLocal.set(BrowserFactory.getBrowser(LocalWebDriveProperties.getLocalBrowser()));
        }
        return webDriverThreadLocal.get();
    }

    public static void disposeDriver() {
        if (!LocalWebDriveProperties.getLocalBrowser().equals(BrowserType.FIREFOX)) {
            webDriverThreadLocal.get().close();
        }
        webDriverThreadLocal.get().quit();
        webDriverThreadLocal.remove();
    }
}
