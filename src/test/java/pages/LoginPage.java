package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    @FindBy(id = "user-name")
    private WebElement usernameInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {
        setUsername(username);
        setPassword(password);
        clickLoginButton();
    }

    private void setUsername(String username) {
        isElementDisplayed(usernameInput);
        usernameInput.sendKeys(username);
    }

    private void setPassword(String password) {
        isElementDisplayed(passwordInput);
        passwordInput.sendKeys(password);
    }

    private void clickLoginButton() {
        isElementDisplayed(loginButton);
        loginButton.click();
    }
}

