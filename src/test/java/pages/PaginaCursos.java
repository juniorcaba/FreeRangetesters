package pages;

public class PaginaCursos extends BasePage {

    private String cursosLink = "//a[normalize-space()='Cursos' and @href]";

    // Constructor que llama al constructor de la clase base BasePage
    public PaginaCursos() {
        super(driver);
    }

    public void clickCursosLink() {
    clickElement(cursosLink);
}

}