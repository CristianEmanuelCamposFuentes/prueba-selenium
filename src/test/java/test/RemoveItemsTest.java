package test;

import org.testng.annotations.Test;
import pages.ProductsPage;
import pages.ShoppingCartPage;

public class RemoveItemsTest extends BaseTest {
    ProductsPage productsPage;
    ShoppingCartPage shoppingCartPage;

    @Test
    public void testRemoveItemsFromCart() {
        productsPage = new ProductsPage(driver);
        productsPage.addRandomProductToCart();
        productsPage.addRandomProductToCart();
        productsPage.addRandomProductToCart();
        productsPage.goToShoppingCart();

        shoppingCartPage = new ShoppingCartPage(driver);
        shoppingCartPage.removeItemsFromCart();

        // Add assertions to check that the cart is empty.
    }
}

