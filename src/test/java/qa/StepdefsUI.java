package qa;

import browser.BrowserDriver;
import pageobjects.GlobalPage;
import pageobjects.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import static org.junit.Assert.*;


public class StepdefsUI {
    private BrowserDriver browser;
    private LoginPage loginPage;
    private GlobalPage globalPage;
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

    @Given("^user (.*) is logged in$")
    public void user_is_logged_in(String user)
    {
        this.loginPage = new LoginPage(this.browser.driver);
        this.name = user;
        this.loginPage.createSession(this.name);
    }

    @When("^he visits another (.*)$")
    public void he_visits_another_page(String url)
    {
        // TODO check parameter is a url
        this.browser.driver.get(url);
    }

    @And("^comes back$")
    public void comes_back()
    {
        this.loginPage.loadPage();
    }

    @Then("^session still available$")
    public void session_still_available()
    {
        this.globalPage = new GlobalPage(this.browser.driver);
        String sessionName = this.globalPage.getSessionName();
        // TODO this concatenation maybe is not good idea
        assertEquals(this.name + " Session", sessionName);
    }

}
