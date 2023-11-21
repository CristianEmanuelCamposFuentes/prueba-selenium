package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    // DRIVER
    WebDriver driver;

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
        searchInput.sendKeys(text);
    }

    public String getFooterText() {
        // return para obtener el valor fuera del metodo
        return this.footerLink.getText();
    }

    public String getMainHeaderText() {
        // return para obtener el valor fuera del metodo
        return this.mainHeader.getText();
    }

    public void clickTo(WebElement webElement){
        webElement.click();
    }

    public void clickOnSearch(){
        this.searchButton.click();
    }

    public void clickOnOptions(){
        this.listOptions.click();
    }

    // Constructor del driver, debe estar para funcionar
    public HomePage(WebDriver driver, String url) {
        this.driver = driver;
        this.driver.get(url);
        // Se debe utilizar para inicializar todos los elementos declarados y la pagina
        PageFactory.initElements(driver, this);
    }


//    // Espera
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


//    // Analizando lista
//    List<WebElement> playersList = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
//            By.cssSelector(".references > li")));
//
//    // Comprueba si la lista es de 5 elementos
//        softAssert.assertEquals(playersList.size(),5);
}