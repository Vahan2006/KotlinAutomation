package Locators

import org.openqa.selenium.By

class LogInLocators {
    val userNameField: By = By.id("user-name")
    val passwordField: By = By.id("password")
    val logInButton: By = By.id("login-button")
    val titleAfterLoggingIn: By = By.className("app_logo")
    val errorMessageLocator: By = By.className("error-message-container");
}