package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class GlobalPage {
    private WebDriver driver;
    /* TODO
     the root part of url should be defined only once,
     currently is defined in all page objects
    */
    private String url = "http://cc.etsii.ull.es/odn/global-view";

    public GlobalPage(WebDriver driver) {
        this.driver = driver;
    }

    public void loadPage()
    {
        this.driver.get(this.url);
    }

    public String getSessionName() {
        Wait wait = new WebDriverWait(this.driver, 30);

        String sessionName = "Element not found";

        try
        {
            WebElement sessionDropDown = (WebElement) wait.until
                    (ExpectedConditions.presenceOfElementLocated(
                            By.className("navbar-right")
                    ));

            sessionName = sessionDropDown.findElement(
                    By.className("dropdown-toggle")
            ).getText();
        }
        catch (TimeoutException e)
        {
            // TODO implement expection manage
        }


        return sessionName;
    }

}
