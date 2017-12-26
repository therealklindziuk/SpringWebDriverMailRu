package com.klindziuk.mail.pageobject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Hp on 16/12/2017.
 */
public class LoginPage extends BasePage {
    private static final Logger LOGGER = Logger.getLogger(LoginPage.class);

    @FindBy(id = "mailbox:login")
    private WebElement loginField;

    @FindBy(id = "mailbox:password")
    private WebElement passwordField;

    @FindBy(css = "#mailbox\\3a submit > input")
    private WebElement submitButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(this.webDriver, this);
    }

    public boolean isLoginFieldVisible() {
        return isElementVisible(loginField);
    }

    public boolean isPasswordFieldVisible() {
        return isElementVisible(passwordField);
    }

    public boolean isSubmitButtonVisible() {
        return isElementVisible(submitButton);
    }

    public void loginAs(String login, String password) {
        LOGGER.info("Enter credentials: " + login + " / " + password);
        waitForPageLoaded();
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        submitButton.click();
    }

    @Override
    public void waitForPageLoaded() {
        LOGGER.info("Wait for main page loaded...");
        waitForElementVisible(loginField);
        waitForElementVisible(passwordField);
        waitForElementVisible(submitButton);
    }
}
