package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {
    @FindBy(id = "searchInput")
    private WebElement searchInput;

    @FindBy(css = "#mw-normal-catlinks > ul > li:nth-child(1) > a")
    private WebElement footerLink;
    @FindBy(xpath = "//*[@id='search-form']/fieldset/button")
    private WebElement searchButton;

    @FindBy(className = "vector-toc-list")
    private List<WebElement> menuSelenium_list;

    @FindBy(css = "#firstHeading > span")
    private WebElement mainHeader;

    @FindBy(css = "#typeahead-suggestions > div > a:nth-child(6) > div.suggestion-text > h3")
    private WebElement listOptions;

    // Metodos
    public void setSearchInput(String text) {
        this.isElementDisplayed(this.searchInput);
        searchInput.sendKeys(text);
    }

    public String getFooterText() {
        this.isElementDisplayed(this.footerLink);

        // return para obtener el valor fuera del metodo
        return this.footerLink.getText();
    }

    public String getMainHeaderText() {

        this.isElementDisplayed(this.mainHeader);
        // return para obtener el valor fuera del metodo
        return this.mainHeader.getText();
    }

    public void clickTo(WebElement webElement) {
        webElement.click();
    }

    public void clickOnSearch() {
        this.isElementDisplayed(this.searchButton);
        this.searchButton.click();
    }

    public void clickOnOptions() {
        this.isElementDisplayed(this.listOptions);
        this.listOptions.click();
    }

    // Constructor del driver, debe estar para funcionar
    // En este caso se hereda de BasePage
    public HomePage(WebDriver driver, String url) {
        super(driver);
        this.driver.get(url);
    }
//    // Analizando lista
//    List<WebElement> playersList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
//            By.cssSelector(".references > li")));
//
//    // Comprueba si la lista es de 5 elementos
//        softAssert.assertEquals(playersList.size(),5);
}