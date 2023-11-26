package test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.SearchResults;


public class FirstTest extends BaseTest{
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void testWiki() {
        driver.manage().window().maximize();

        HomePage homePage = getHomePage("https://www.wikipedia.com");
        homePage.setSearchInput("Selenium");
        softAssert.assertEquals(homePage.getFooterText(), "Puedes apoyar nuestro trabajo con una donación.");
        SearchResults searchResults = homePage.clickOnSearch();
        softAssert.assertEquals(searchResults.getPageText(), "Selenium");
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
