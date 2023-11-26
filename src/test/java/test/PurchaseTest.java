// PurchaseTest.java
package test;

import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;
import pages.ShoppingCartPage;

public class PurchaseTest extends BaseTest {
    LoginPage loginPage;
    ProductsPage productsPage;
    ShoppingCartPage shoppingCartPage;

    @Test
    public void testPurchaseProduct() {
        loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        productsPage = new ProductsPage(driver);
        productsPage.addRandomProductToCart();
        productsPage.goToShoppingCart();

        shoppingCartPage = new ShoppingCartPage(driver);
//        shoppingCartPage.proceedToCheckout();

        // Add more assertions based on the elements on the "Thank you for your purchase" page.
    }
}

