package test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;


public class FirstTest extends BaseTest{
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testWiki() {
        driver.manage().window().maximize();

        HomePage homePage = getHomePage();
        homePage.setSearchInput("Selenium");
        softAssert.assertEquals(homePage.getFooterText(), "Puedes apoyar nuestro trabajo con una donación.");
        homePage.clickOnSearch();
        softAssert.assertAll();

//        List<WebElement> menuSelenium_list =
//                wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("vector-toc-list")));
//
//        Assert.assertTrue(!menuSelenium_list.isEmpty());
//
//        Assert.assertEquals(menuSelenium_list.size(), 9);

        //    // Analizando lista
//    List<WebElement> playersList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
//            By.cssSelector(".references > li")));
//
//    // Comprueba si la lista es de 5 elementos
//        softAssert.assertEquals(playersList.size(),5);
    }
}
