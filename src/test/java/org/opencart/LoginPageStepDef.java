package org.opencart;

import io.cucumber.java.en.Given;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.qa.opencart.pages.Loginpage;
import org.testng.Assert;
public class LoginPageStepDef {
    private WebDriver driver;
    private Loginpage loginPage;

    @Before
    public void setup(){
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

    @Given("I am on the OpenCart login page")
    public void i_am_on_the_open_cart_login_page() {
        {
            driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login ");
            loginPage = new Loginpage(driver);
        }
    }

    @Given("I have entered a valid username and password")
    public void i_have_entered_a_valid_username_and_password(){
        {
            loginPage.enterEmail("septbatch2024@open.com");
            loginPage.enterPassword("Selenium@12345");

        }

    }

    @When("I click on the login button")
    public void ii_click_on_the_login_button() {
        {
            loginPage.clickLoginButton();
        }

    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully(){
        Assert.assertEquals(loginPage.getLoginPageTitle(),"My Account");
    }


}

