package pages;

import java.util.NoSuchElementException;
import org.openqa.selenium.TimeoutException;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PaginaRegistro extends BasePage {

    By precioPlanAnual = By.xpath("//*[contains(text(), '$176/a')]");
    By precioPlanMensual = By.xpath("//*[contains(text(), '$16.99/m')]");

    public PaginaRegistro(WebDriver driver) {
        super(driver); // Esto pasa el driver a BasePage
    }

    // public boolean validarOpcionesDePlanesVisibles() {
    // List<WebElement> mensual = driver.findElements(precioPlanMensual);
    // List<WebElement> anual = driver.findElements(precioPlanAnual);

    // boolean mensualVisible = !mensual.isEmpty() && mensual.get(0).isDisplayed();
    // boolean anualVisible = !anual.isEmpty() && anual.get(0).isDisplayed();

    // return mensualVisible && anualVisible;
    // }

    public boolean validarOpcionesDePlanesVisibles() {
        return esElementoVisibleYClicable(precioPlanMensual) && esElementoVisibleYClicable(precioPlanAnual);
    }

    public boolean esElementoVisibleYClicable(By localizador) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement elemento = wait.until(ExpectedConditions.elementToBeClickable(localizador));
            return elemento.isDisplayed() && elemento.isEnabled();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

    // private String planDropdown =
    // "//select[@id='cart_cart_item_attributes_plan_with_interval']";

    public PaginaRegistro() {
        super(driver);
    }

    // public List<String> returnPlanDropdownValues() {
    // return getDropdownValues(planDropdown);
    // }

}