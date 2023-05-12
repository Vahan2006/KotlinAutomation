package TestCases

import Locators.CartLocators
import Locators.LogInLocators
import Locators.ProductsLocators
import Methods.AssertionMethods
import Methods.GeneralMethods
import UserData.Credentials
import UserData.ProductNames
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test

class CartSystem {
    private lateinit var driver: WebDriver

    @BeforeMethod
    fun beforeEach(){
        this.driver = ChromeDriver()
        driver.manage().window().maximize()
        val genMeth = GeneralMethods(driver)
        val credentials = Credentials();
        val logInLoc = LogInLocators();
        driver.get("https://www.saucedemo.com")
        genMeth.type(logInLoc.userNameField, credentials.getStandardUserName())
        genMeth.type(logInLoc.passwordField, credentials.getPassword())
        genMeth.click(logInLoc.logInButton)
    }
    @AfterMethod
    fun afterEach(){driver.quit()}


    //This case will add an item(bag) to the cart and assert that it has been added successfully
    @Test
    fun addItemToCartAndAssert(){
        val genMeth = GeneralMethods(driver)
        val productLoc = ProductsLocators()
        val cartLoc = CartLocators()
        val productNames = ProductNames()
        val assertMeth = AssertionMethods(driver);

        genMeth.click(productLoc.bagLocator);
        assertMeth.asserThatEquals(productLoc.bagRemoveButtonLocator, "Remove")
        genMeth.click(productLoc.cartLocator)
        assertMeth.asserThatEquals(cartLoc.addedProductLocator,productNames.bag )
    }

    //This case will add 3 products to the cart and check that the cart badge counted the amount correctly
    @Test
    fun checkCartBadgeFunctionality(){
        val genMeth = GeneralMethods(driver)
        val productLoc = ProductsLocators()
        val assertMeth = AssertionMethods(driver);

        genMeth.click(productLoc.bagLocator);
        genMeth.click(productLoc.bikeLightLocator);
        genMeth.click(productLoc.jacketLocator);
        assertMeth.asserThatEquals(productLoc.cartBadgeLocator, "3")
    }

    //This case will a product to the cart, remove it from the card, and assert that it has been removed successfully
    @Test
    fun removeItemFromCardAndAssert(){
        val genMeth = GeneralMethods(driver)
        val productLoc = ProductsLocators()
        val cartLoc = CartLocators()
        val productNames = ProductNames()
        val assertMeth = AssertionMethods(driver);

        genMeth.click(productLoc.bagLocator);
        assertMeth.asserThatEquals(productLoc.bagRemoveButtonLocator, "Remove")
        genMeth.click(productLoc.cartLocator)
        assertMeth.asserThatEquals(cartLoc.addedProductLocator,productNames.bag)
        genMeth.click(cartLoc.bagRemoveButtonLocator)
        assertMeth.assertElementIsNotVisible(cartLoc.firstItemInCartLocator);
    }


}