package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("http://cc.etsii.ull.es/odn/");
    }

    public void createSession(String name) {
        Wait wait = new WebDriverWait(this.driver, 30);
        WebElement sessionName = (WebElement) wait.until
                (ExpectedConditions.presenceOfElementLocated(By.id("__username__")));
        sessionName.sendKeys(name);
        this.driver.findElement(By.className("btn")).click();
    }
}
