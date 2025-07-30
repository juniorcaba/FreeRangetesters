package steps;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
//import java.util.Arrays;
//import java.util.List;
//import static org.junit.jupiter.api.Assertions.assertTrue;

//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.BasePage;
import pages.PaginaCursos;
import pages.PaginaIntroduccionTesting;
import pages.PaginaPrincipal;
import pages.PaginaRegistro;

//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;

public class FreeRangeSteps {
    SoftAssert soft = new SoftAssert();

    PaginaPrincipal landingPage = new PaginaPrincipal();
    PaginaCursos cursoPage = new PaginaCursos();
    PaginaIntroduccionTesting introduccionTestingPage = new PaginaIntroduccionTesting();
    PaginaRegistro registro = new PaginaRegistro();
    PaginaRegistro paginaRegistro = new PaginaRegistro(BasePage.getDriver());
    pages.PaginaAcademia academiaPage = new pages.PaginaAcademia();

    @Given("I navigate to www.freerangetesters.com")
    public void iNavigateToFRT() {
        BasePage.initializeDriver(); // inicia el navegador
        BasePage.navigateTo("https://www.freerangetesters.com"); // abre la URL
    }

    @When("I go to {word} using the navigation bar")
    public void navigationBarUse(String section) {
        landingPage.clickOnSectionNavigationBar(section);
    }

    @When("^(?:I|The user|The client) select(?:s)? the \"([^\"]+)\" button$")
    public void selectEmpezarHoyBotton(String buttonText) {
        if (buttonText.equalsIgnoreCase("Empezar hoy")) {
            academiaPage.clickOnElegirPlanButtonLink();
        }
    }

    @And("^(?:I|The user|The client) selects? Introducción al Testing de Software$")
    public void navigateToIntro() {
        cursoPage.clickCursosLink(); // primero accede a la sección de cursos
        introduccionTestingPage.clickIntroduccionTestingLink(); // luego haz clic en el curso
    }

    @Then("I should see the page with the title {string}")
    public void iShouldSeeThePageWithTheTitle(String expectedTitle) {
        String actualTitle = introduccionTestingPage.getPageTitle();
        System.out.println("📄 Introducción al Testing de Software: " + actualTitle);
        assertEquals(expectedTitle, actualTitle);
    }

    @Then("The user can see the options mensual and anual")
    public void validarOpcionesPlanes() {
        assertTrue("❌ Las opciones mensual y/o anual no están visibles",
                paginaRegistro.validarOpcionesDePlanesVisibles());

        BasePage.pause(5); // pausa reutilizable desde la clase base

    }
// test kjsdhfjkhsd;kjgh;kjsdfhgk;jdhfglk;jhdfgkl;
}
