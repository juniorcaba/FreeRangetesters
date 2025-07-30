package steps;

import io.cucumber.java.Before;
import pages.BasePage;

public class Hooks {

    @Before
    public void setUp() {
        BasePage.initializeDriver();
    }
}