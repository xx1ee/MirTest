package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private static final By USERNAME_FIELD = By.name("user");
    private static final By PASSWORD_FIELD = By.name("password");
    private static final By LOGIN_BUTTON = By.id("button_submit_login_form");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    public LoginPage enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_FIELD)).sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_FIELD)).sendKeys(password);
        return this;
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON)).click();
    }

    public void login(String username, String password) {
        enterUsername(username)
                .enterPassword(password)
                .clickLoginButton();
    }
}
