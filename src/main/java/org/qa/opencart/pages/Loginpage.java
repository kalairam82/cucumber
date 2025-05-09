package org.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage {

    private final WebDriver driver;

    //By Locators
    private final By emailInputLocator = By.name("email");
    private final By passwordInputLocator = By.name("password");
    private final By loginButtonLocator = By.xpath("//input[@type='submit']");
    private final By forgottenPasswordLinkLocator = By.linkText("Forgotten Password");
    private final By logoutLinkLocator = By.linkText("Logout");


    // Constructor
    public Loginpage(WebDriver driver) {
        this.driver = driver;

    }

    // Page Methods/Actions
    public void enterEmail(String email) {
        WebElement emailInput = driver.findElement(emailInputLocator);
        emailInput.sendKeys(email);
    }

    public void enterPassword(String password) {
        WebElement passwordInput = driver.findElement(passwordInputLocator);
        passwordInput.sendKeys(password);
    }

    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }

    public String getLoginPageTitle()
    {
        String title = driver.getTitle();
        return title;
    }

    public void clickForgottenPasswordLink() {
        WebElement forgottenPasswordLink = driver.findElement(forgottenPasswordLinkLocator);
        forgottenPasswordLink.click();
    }

    public boolean checkForgotPwdLink(){
        return driver.findElement(forgottenPasswordLinkLocator).isDisplayed();
    }

    public boolean checkLogoutLink(){
        return driver.findElement(logoutLinkLocator).isDisplayed();
    }

    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }

    public String getForgotPwdPageUrl(){
        return driver.getCurrentUrl();
    }


}


