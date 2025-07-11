package pages;

public class PaginaAcademia extends BasePage {

    private String empezarHoyButton = "//a[contains(., 'Empezar hoy') and @href]";

    // Constructor que llama al constructor de la clase base BasePage
    public PaginaAcademia() {
        super(driver);
    }

    public void clickEmpezarHoyButton() {
        clickElement(empezarHoyButton);
    }
    
    public void clickOnElegirPlanButtonLink() {
        clickElement(empezarHoyButton);
    }

}


