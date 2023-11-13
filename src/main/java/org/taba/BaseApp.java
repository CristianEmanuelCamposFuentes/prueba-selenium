package org.taba;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseApp {
    // El WebDriver es la instancia del navegador donde usamos Selenium
    // Objeto estatico para el driver
    protected static WebDriver driver;
    // Objeto estatico para el wait que gestiona las esperas
    protected static WebDriverWait wait;
    // El objeto Actions realiza las acciones de interaccion del teclado y el mouse
    protected static Actions actions;

    // Bloque estatico para el drive para todas las instancias futuras de otras clases de página
    // Le agrego una espera de 10 seg
    static {
        // A futuro va a servir para personalizar configuraciones de datos(perfil, extensiones, etc)
        ChromeOptions chromeOptions = new ChromeOptions();
        // Setear navegador
        driver = new ChromeDriver(chromeOptions);
        // Setear espera
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // Setear acciones
        actions = new Actions(driver);
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\crist\\IdeaProjects\\PruebaSelenium\\src\\main\\resources\\drivers\\chromedriver.exe");
    }

    public BaseApp(WebDriver driver) {
        BaseApp.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void navigateTo(String url){
        // get() carga una pagina web nueva en la ventana del navegador actual
        driver.get(url);
    }

    public static void closeBrowser(){
        driver.quit();
    }

    // Metodo que devuelve un web element y Selenium puede trabajar con el, se va a crear esta instancia del WebElement y
    // Navegador (con sus metodos), para después a traves de la herencia reutilizar en tod o el proyecto.
    private WebElement Find(String locator){
        // Espera hasta que el elemento este presente en la página
        // Utiliza el objeto wait para esperar, lleva dos parametros: WebDriverWait(instanciaDelNavegador, tiempoDeEspera)
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public void clickElement(String locator){
        /* Le agrego una espera al elemento web para cuando sea visible y este disponible para cliquear
        /*
         * El objeto By en Selenium se utiliza para localizar elementos en la página web. En otras palabras, es una forma
         *  de decirle a Selenium cómo encontrar un elemento específico en el DOM (Documento de Objeto del Modelo) de la página.
         * */
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));

        element.click();
        /* Otra forma utilizando Find
        Dado un xpath (locator), va a localizarlo y va a hacer un clic sobre este elemento
        Find(locator).click();*/
    }

    public void write(String locator, String textToWrite){
        // Limpiar el campo de texto
        Find(locator).clear();
        // Enviar el texto al campo de texto
        Find(locator).sendKeys(textToWrite);
    }

    public void hoverOverElement(String locator){
        // Lleva el mouse hasta el webElement
        actions.moveToElement(Find(locator));
    }

    public void doubleClick(String locator){
        // Doble click en el webElement
        actions.doubleClick(Find(locator));
    }

    public void rightClick(String locator){
        // Click derecho en el webElement
        actions.contextClick(Find(locator));
    }

    public void dismissAlert(){
        // Cierra el cartel de alerta
        driver.switchTo().alert().dismiss();
    }

    public String textFromElement(String locator){
        // Obtiene el texto dentro del webElement
        return Find(locator).getText();
    }

    public boolean elementIsDisplayed(String locator){
        // Devuelve un booleano si es mostrado o no
        return Find(locator).isDisplayed();
    }

    public boolean elementIsSelected(String locator){
        // Devuelve un booleano si es seleccionado o no
        return Find(locator).isSelected();
    }

    public boolean elementIsEnabled(String locator){
        // Devuelve un booleano si esta habilitado o no
        return Find(locator).isEnabled();
    }

    public List<WebElement> bringMeAllElements(String locator){
        // Retorna una lista de WebElements
        return driver.findElements(By.className(locator));
    }
}