package Methods

import org.openqa.selenium.By
import org.openqa.selenium.NoSuchElementException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.testng.Assert

class AssertionMethods(private val driver: WebDriver) {
    fun asserThatEquals(elementLocator: By, compareWith: String){
        val text = driver.findElement(elementLocator).text;
        Assert.assertEquals(text, compareWith)
    }

    fun assertElementIsNotVisible(locator: By){
        try{
            driver.findElement(locator)
            Assert.assertTrue(false)
        }catch(e: NoSuchElementException){
            Assert.assertTrue(true)
        }
    }

    fun assertElementIsVisible(locator: By){
        val element: WebElement = driver.findElement(locator)
        Assert.assertTrue(element.isDisplayed)
    }

    fun assertBackgroundColor(locator:By, color: String){
        val element: WebElement = driver.findElement(locator)
        val elementColor = element.getCssValue("background-color")
        Assert.assertTrue(color==elementColor)

    }
}