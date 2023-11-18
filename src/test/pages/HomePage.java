package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage {
    @FindBy(id = "searchInput")
    private WebElement searchInput;

    @FindBy(css = "#mw-normal-catlinks > ul > li:nth-child(1) > a")
    private WebElement footerLink;
    @FindBy(xpath = "//*[@id='search-form']/fieldset/button")
    private WebElement searchButton;

    @FindBy(className = "vector-toc-list")
    private List<WebElement> menuSelenium_list;

    // Metodos
    public void setSearchInput(String text) {
        this.searchInput.sendKeys(text);
    }

    public String getFooterText(){
        // return para obtener el valor fuera del metodo
        return this.footerLink.getText();
    }

    // Constructor

}