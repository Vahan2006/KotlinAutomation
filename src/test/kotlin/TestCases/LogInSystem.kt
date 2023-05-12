package TestCases

import Locators.LogInLocators
import Methods.AssertionMethods
import Methods.GeneralMethods
import UserData.Credentials
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class LogInSystem {
    private lateinit var driver: WebDriver

    @BeforeMethod
    fun beforeClass(){
        this.driver = ChromeDriver()
        driver.manage().window().maximize()
    }

    @AfterMethod
    fun afterClass(){
        driver.quit()
    }

    @Test
    fun logInWithStandardUser(){
        val genMeth = GeneralMethods(driver)
        val credentials = Credentials();
        val logInLoc = LogInLocators();
        val assertMethods = AssertionMethods(driver);
        driver.get("https://www.saucedemo.com")
        genMeth.type(logInLoc.userNameField, credentials.getStandardUserName())
        genMeth.type(logInLoc.passwordField, credentials.getPassword())
        genMeth.click(logInLoc.logInButton)
        assertMethods.assertElementIsVisible(logInLoc.titleAfterLoggingIn)

    }

    @Test
    fun logInWithInvalidData(){
        val genMeth = GeneralMethods(driver)
        val credentials = Credentials();
        val logInLoc = LogInLocators();
        val assertMethods = AssertionMethods(driver);
        driver.get("https://www.saucedemo.com")
        genMeth.type(logInLoc.userNameField, credentials.getPassword())
        genMeth.type(logInLoc.passwordField, credentials.getFakePassword())
        genMeth.click(logInLoc.logInButton)
        assertMethods.assertElementIsVisible(logInLoc.errorMessageLocator)
        assertMethods.assertBackgroundColor(logInLoc.errorMessageLocator, "rgba(226, 35, 26, 1)")
    }
}