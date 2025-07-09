package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.BasePage;
import pages.PaginaCursos;
import pages.PaginaIntroduccionTesting;
import pages.PaginaPrincipal;
import pages.PaginaRegistro;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

public class FreeRangeSteps {

    PaginaPrincipal landingPage = new PaginaPrincipal();
    PaginaCursos cursoPage = new PaginaCursos();
    PaginaIntroduccionTesting introduccionTestingPage = new PaginaIntroduccionTesting();
    PaginaRegistro registro = new PaginaRegistro();

    @Given("I navigate to www.freerangetesters.com")
    public void iNavigateToFRT() {
        landingPage.navigateToFreeRangeTesters();
    }

    @When("I go to {word} using the navigation bar")
    public void navigationBarUse(String section) {
        landingPage.clickOnSectionNavigationBar(section);
    }

    @When("I select the Empezar hoy button")
    public void selectEmpezarHoyButton() {
        landingPage.clickElementWhenVisible("//a[normalize-space()='Empezar hoy' and @href]");
    
    }

    @And("Select Introducción al Testing de Software")
    public void navigateToIntro() {
        cursoPage.clickCursosLink(); // primero accede a la sección de cursos
        introduccionTestingPage.clickIntroduccionTestingLink(); // luego haz clic en el curso
    }

    @Then("I should see the page with the title {string}")
    public void iShouldSeeThePageWithTheTitle(String expectedTitle) {
    String actualTitle = introduccionTestingPage.getPageTitle();
    System.out.println("📄 Introducción al Testing de Software: " + actualTitle);
    assertEquals(expectedTitle, actualTitle);
    

    BasePage.pause(5); // pausa reutilizable desde la clase base

    }

    @Then("I can validate the options in the checkout page")
    public void validateCheckoutPlans() {
        List<String> lista = registro.returnPlanDropdownValues();
        List<String> listaEsperada = Arrays.asList("Academia: $16.99 / mes • 11 productos",
                "Academia: $176 / año • 11 productos", "Free: Gratis • 1 producto");

        Assert.assertEquals(listaEsperada, lista);
    }




}
