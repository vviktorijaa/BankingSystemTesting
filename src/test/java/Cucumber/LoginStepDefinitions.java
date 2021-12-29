package Cucumber;

import GUI.DepositAcc;
import GUI.Login;
import GUI.Menu;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.swing.edt.GuiActionRunner;

import javax.swing.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginStepDefinitions{

    Login l =new Login();
    Menu m = new Menu();

    @Given("^I start the application$")
    public void startTheApp() {
        l = GuiActionRunner.execute(() -> new Login());
    }

    @When("^I type the password \"([^\"]*)\"$")
    public void inputPassword(String pass) {
        l.textField_1.setText(pass);
    }

    @When("^I click on the login button$")
    public void clickTheLoginButton() {
        l.btnLogin.doClick();
    }

    @Then("^login is successful$")
    public void loginIsSuccessful(){
        assertTrue(m.contentPane.isVisible());
    }

    @Then("login is unsuccessful")
    public void loginIsUnsuccessful() {
        System.out.println("Unsuccessful login");
    }
}
