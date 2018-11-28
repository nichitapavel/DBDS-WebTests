package browser;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;


public class BrowserDriver implements AutoCloseable {
    public WebDriver driver;

    public BrowserDriver() {
        String hub = System.getProperty("selenium-hub");
        ChromeOptions capabilities = new ChromeOptions()
                .addArguments("--start-maximized");

        try {
            this.driver = new RemoteWebDriver(new URL(hub), capabilities);
        } catch (MalformedURLException e) {
            System.out.println(e.getCause());
        }
    }

    @Override
    public void close() {
        this.driver.quit();
        this.driver = null;
    }

}
