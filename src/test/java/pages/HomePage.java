package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {
    @FindBy(id = "searchInput")
    private WebElement searchInput;

    @FindBy(css = "#www-wikipedia-org > div.footer > div:nth-child(1) > div > div:nth-child(3) > a > span" )
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

    public SearchResults clickOnSearch() {
        this.isElementDisplayed(this.searchButton);
        this.searchButton.click();
        return new SearchResults(this.driver);
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
        PageFactory.initElements(driver, this);
    }
}