package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductsPage extends BasePage {
    @FindBy(css = ".inventory_item")
    private List<WebElement> productItems;

    @FindBy(id = "shopping_cart_container")
    private WebElement shoppingCartButton;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void addRandomProductToCart() {
        isElementDisplayed(productItems.get(0));
        productItems.get(0).click();
    }

    public void goToShoppingCart() {
        isElementDisplayed(shoppingCartButton);
        shoppingCartButton.click();
    }

    public void proceedToCheckout() {
        isElementDisplayed(checkoutButton);
        checkoutButton.click();
    }
}

