package pages;

public class PaginaAcademia extends BasePage {

    private String academiaLink = "//a[normalize-space()='Academia' and @href]";
    private String empezarHoyButton = "//a[normalize-space()='Empezar hoy' and @href]";

    // Constructor que llama al constructor de la clase base BasePage
    public PaginaAcademia() {
        super(driver);
    }

    public void clickAcademiaLink() {
        clickElement(academiaLink);
    }

    public void clickEmpezarHoyButton() {
        clickElement(empezarHoyButton);
    }
    
}


