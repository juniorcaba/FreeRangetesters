package pages;

// Importaciones necesarias
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
    protected static WebDriver driver;
    
    //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

public static void initializeDriver() {
    if (driver == null) {
        System.setProperty("file.encoding", "UTF-8");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // opcional, para vista completa
    }
}

    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
    }

    // Método estático para navegar a una URL.
    public static void navigateTo(String url) {
        driver.get(url);
    }

    //Método estático para cerrar la instancia del driver. 
    public static void closeBrowser() {
        driver.quit();
    }

    // Encuentra y devuelve un WebElement en la página utilizando un locator XPath,
    // esperando a que esté presentente en el DOM
    private WebElement Find(String locator) {
    return getWait().until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
}


    public void clickElement(String locator) {
        Find(locator).click();
    }

    private WebDriverWait getWait() {
    return new WebDriverWait(driver, Duration.ofSeconds(5));
}

    public void write(String locator, String keysToSend){
        Find(locator).clear();// Limpia el campo antes de enviar las teclas
        // Envia las teclas al elemento encontrado por el locator
        Find(locator).sendKeys(keysToSend);
    }

    public void selectFromDropdownByValue(String locator, String value){
        Select dropdown = new Select(Find(locator));

        dropdown.selectByValue(value);
    }

    public void selectFromDropdownByIndex(String locator, Integer index){
        Select dropdown = new Select(Find(locator));

        dropdown.selectByIndex(index); // Selecciona el primer elemento del dropdown
    }

    public int dropdownSize(String locator) {
        Select dropdown = new Select(Find(locator));

        List<WebElement> dropdownOptions = dropdown.getOptions();// Obtiene todas las opciones del dropdown

        return dropdownOptions.size(); // Devuelve el número de opciones en el dropdown
    }   

    public String getPageTitle() {
    return driver.getTitle();
}

public static void pause(int seconds) {
    try {
        Thread.sleep(seconds * 1000);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt(); // Restablece el estado de interrupción
    }
}

    public List<String> getDropdownValues(String locator) {
        Select dropdown = new Select(Find(locator)); // Encuentra el elemento del dropdown usando el locator proporcionado
        // Obtiene todas las opciones del dropdown
        // y las almacena en una lista de WebElement
        List<WebElement> dropdownOptions = dropdown.getOptions();
        List<String> values = new ArrayList<>();
        for (WebElement option : dropdownOptions) {
            values.add(option.getText());
        }

        return values;

        
    }
}

