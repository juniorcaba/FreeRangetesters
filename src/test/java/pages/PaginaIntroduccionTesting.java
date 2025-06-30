package pages;

public class PaginaIntroduccionTesting extends BasePage {

private String introduccionTestingLink = "//a[normalize-space()='Introducción al Testing de Software' and @href]";

    // Constructor que llama al constructor de la clase base BasePage
    public PaginaIntroduccionTesting() {
        super(driver);
    }

    public void clickIntroduccionTestingLink() {
        clickElement(introduccionTestingLink);
    }
    
}
