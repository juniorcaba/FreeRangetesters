package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FreeRangeTest {
    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //Inicializa el WebDriverManager para Chrome
        WebDriverManager.chromedriver().setup();
        //Crea una instancia del WebDriver
        driver = new ChromeDriver();
    }

    @Test
    public void testFreeRange() {
        //Navega a la URL de FreeRange
        driver.get("https://www.freerangetesters.com/");
        //Verifica que el título de la página sea correcto
        //String title = driver.getTitle();
        //assert title.contains("FreeRange");
    }

    @AfterMethod
    public void tearDown() {
        //Cierra el navegador
        if (driver != null) {
            driver.quit();
        }
    }
}
