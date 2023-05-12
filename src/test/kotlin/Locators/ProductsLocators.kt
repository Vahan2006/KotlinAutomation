package Locators

import org.openqa.selenium.By

class ProductsLocators {
    val bagLocator: By = By.id("add-to-cart-sauce-labs-backpack")
    val bagRemoveButtonLocator: By = By.id("remove-sauce-labs-backpack")
    val bikeLightLocator: By = By.id("add-to-cart-sauce-labs-bike-light")
    val jacketLocator: By = By.id("add-to-cart-sauce-labs-fleece-jacket")
    val cartLocator: By = By.className("shopping_cart_link")
    val cartBadgeLocator: By = By.className("shopping_cart_badge")

}