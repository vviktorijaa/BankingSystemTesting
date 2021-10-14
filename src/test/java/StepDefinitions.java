import GUI.Login;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.swing.edt.GuiActionRunner;
import java.awt.*;

public class StepDefinitions{

    @Given("^I start the application$")
    public void i_start_the_application() throws Exception {
        Login login = GuiActionRunner.execute(() -> new Login());
    }

    @When("^I type the password \"([^\"]*)\"$")
    public void i_type_the_password(String pass) throws Exception {
        Login l =new Login();
        l.textField_1.setText(pass);
    }

    @When("^I click on the login button$")
    public void i_click_on_the_login_button() throws Exception {
        Login l = new Login();
        l.btnLogin.doClick();
    }

    @Then("^login is successful$")
    public void login_is_successful() throws Exception {
        GraphicsEnvironment.isHeadless();
    }
}
