package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
//import org.testng.asserts.SoftAssert;
import pages.BasePage;
import pages.PaginaCursos;
import pages.PaginaIntroduccionTesting;
import pages.PaginaPrincipal;
import pages.PaginaRegistro;
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import java.util.List;

public class FreeRangeSteps {
    //SoftAssert soft = new SoftAssert();

    PaginaPrincipal landingPage = new PaginaPrincipal();
    PaginaCursos cursoPage = new PaginaCursos();
    PaginaIntroduccionTesting introduccionTestingPage = new PaginaIntroduccionTesting();
    PaginaRegistro registro = new PaginaRegistro();
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


    @When("I select the {string} button")
    public void selectEmpezarHoyBotton(String buttonText) {
    if (buttonText.equalsIgnoreCase("Empezar hoy")) {
        academiaPage.clickOnElegirPlanButtonLink();
    }
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
    }

    @Then("I can validate the options in the checkout page")
    public void validateCheckoutPlans() {
        List<String> lista = registro.returnPlanDropdownValues();
List<String> listaEsperada = Arrays.asList(
    "Academia: $16.99 / mes • 15 productos",
    "Academia: $176 / año • 15 productos",
    "Free: Gratis • 3 productos"
);

        Assert.assertEquals(listaEsperada, lista);

    BasePage.pause(5); // pausa reutilizable desde la clase base
    }

}





