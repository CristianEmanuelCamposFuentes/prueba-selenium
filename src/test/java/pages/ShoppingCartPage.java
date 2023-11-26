
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage {
    @FindBy(css = ".cart_item")
    private List<WebElement> cartItems;

    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void removeItemsFromCart() {
        for (WebElement cartItem : cartItems) {
            isElementDisplayed(cartItem);
            cartItem.findElement(By.className("cart_button")).click();
        }
    }

    public void continueShopping() {
        isElementDisplayed(continueShoppingButton);
        continueShoppingButton.click();
    }
}

