package Locators

import org.openqa.selenium.By

class CartLocators {
    val addedProductLocator: By = By.cssSelector("#item_4_title_link>div");
    val bagRemoveButtonLocator: By = By.id("remove-sauce-labs-backpack");
    val firstItemInCartLocator: By = By.className("cart_item");
    val checkoutButton: By = By.id("checkout")
}