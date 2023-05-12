package Methods

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver

class GeneralMethods(private val driver: WebDriver) {

    fun type(locator: By, text:String ){
        driver.findElement(locator).sendKeys(text);
    }

    fun click(locator: By){
        driver.findElement(locator).click()
    }
}