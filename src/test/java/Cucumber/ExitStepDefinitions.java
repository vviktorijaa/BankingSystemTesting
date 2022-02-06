package Cucumber;

import GUI.Login;
import GUI.Menu;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.swing.edt.GuiActionRunner;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ExitStepDefinitions {

    Login l = new Login();
    Menu m = new Menu();

    @Given("^The application is started$")
    public void the_application_is_started() throws Exception {
        l = GuiActionRunner.execute(() -> new Login());
        l.textField_1.setText("admin");
        l.btnLogin.doClick();
    }

    @When("^user clicks on the Exit button$")
    public void user_clicks_on_the_Exit_button() throws Exception {
        m.btnExit.doClick();
    }

    @Then("^the application closes$")
    public void the_application_closes() throws Exception {
        assertFalse(m.contentPane.isVisible());
    }
}
