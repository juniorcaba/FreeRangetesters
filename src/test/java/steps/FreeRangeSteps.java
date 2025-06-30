package steps;

import io.cucumber.java.en.*;
import pages.BasePage;
import pages.PaginaCursos;
import pages.PaginaIntroduccionTesting;
import pages.PaginaPrincipal;
import static org.junit.Assert.assertEquals;

public class FreeRangeSteps {

    PaginaPrincipal landingPage = new PaginaPrincipal();
    PaginaCursos cursoPage = new PaginaCursos();
    PaginaIntroduccionTesting introduccionTestingPage = new PaginaIntroduccionTesting();

    @Given("I navigate to www.freerangetesters.com")
    public void iNavigateToFRT() {
        landingPage.navigateToFreeRangeTesters();
    }

    @When("I go to {word} using the navigation bar")
    public void navigationBarUse(String section) {
        landingPage.clickOnSectionNavigationBar(section);
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

}
