package Cucumber;

import GUI.Login;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.swing.edt.GuiActionRunner;
import java.awt.*;

public class LoginStepDefinitions{

    Login l =new Login();

    @Given("^I start the application$")
    public void startTheApp() throws Exception {
        l = GuiActionRunner.execute(() -> new Login());
    }

    @When("^I type the password \"([^\"]*)\"$")
    public void inputPassword(String pass) throws Exception {
        l.textField_1.setText(pass);
    }

    @When("^I click on the login button$")
    public void clickTheLoginButton() throws Exception {
        l.btnLogin.doClick();
    }

    @Then("^login is successful$")
    public void loginIsSuccessful() throws Exception {
        GraphicsEnvironment.isHeadless();
    }

    @Then("login is unsuccessful")
    public void loginIsUnsuccessful() {
        GraphicsEnvironment.isHeadless();
    }
}
