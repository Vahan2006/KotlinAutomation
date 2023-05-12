package TestCases

import Locators.CartLocators
import Locators.CheckoutLocations
import Locators.LogInLocators
import Locators.ProductsLocators
import Methods.AssertionMethods
import Methods.GeneralMethods
import UserData.Credentials
import UserData.ProductNames
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import kotlin.math.truncate

class CheckoutSystem {
    private lateinit var driver: WebDriver

    @BeforeMethod
    fun beforeEach(){
        this.driver = ChromeDriver()
        driver.manage().window().maximize()
        val genMeth = GeneralMethods(driver)
        val credentials = Credentials()
        val logInLoc = LogInLocators()
        val assertMeth = AssertionMethods(driver)
        val productLoc = ProductsLocators()
        val cartLoc = CartLocators()
        val productNames = ProductNames()
        driver.get("https://www.saucedemo.com")
        genMeth.type(logInLoc.userNameField, credentials.getStandardUserName())
        genMeth.type(logInLoc.passwordField, credentials.getPassword())
        genMeth.click(logInLoc.logInButton)
        genMeth.click(productLoc.bagLocator)
        assertMeth.asserThatEquals(productLoc.bagRemoveButtonLocator, "Remove")
        genMeth.click(productLoc.cartLocator)
        assertMeth.asserThatEquals(cartLoc.addedProductLocator,productNames.bag )
    }
    @Test
    fun ban(){
        val cartLoc = CartLocators()
        val checkLoc = CheckoutLocations()
        val genMeth = GeneralMethods(driver)
        val credentials = Credentials()
        genMeth.click(cartLoc.checkoutButton)
        genMeth.type(checkLoc.firstName, credentials.getStandardUserName())
        genMeth.type(checkLoc.lastName, credentials.getUserLastName())
        genMeth.type(checkLoc.postalCode, credentials.getPostalCode())
        genMeth.click(checkLoc.continueButton)
    }



}