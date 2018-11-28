package qa;

import browser.BrowserDriver;
import pageobjects.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.*;


public class StepdefsUI {
    private BrowserDriver browser;
    private LoginPage loginPage;
    private String name;

    @Before
    public void beforeScenario() {
        this.browser = new BrowserDriver();
    }

    @After
    public void afterScenario() {
        this.browser.close();
    }

    @Given("^user named (.*)$")
    public void user_named(String name)
    {
        this.loginPage = new LoginPage(this.browser.driver);
        this.name = name;
    }

    @When("^he creates session$")
    public void he_create_session()
    {
        this.loginPage.createSession(this.name);
    }

    @Then("^attribute page is loaded$")
    public void attribute_page_is_loaded()
    {
        assertTrue(this.browser.driver.getCurrentUrl().contains("attribute"));
    }
}
