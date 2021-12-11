package Cucumber;

import GUI.Login;
import GUI.Menu;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.swing.edt.GuiActionRunner;

import java.awt.*;

public class DisplayAccountsStepDefinition {

    Login l = new Login();
    Menu m = new Menu();

    @Given("The application is started")
    public void theApplicationIsStarted() {
        l = GuiActionRunner.execute(() -> new Login());
        l.textField_1.setText("admin");
    }

    @When("I click on the Display Account List button")
    public void iClickOnTheDisplayAccountListButton() {
        m.btnDisplayAccountList.doClick();
    }

    @Then("all the bank accounts must be displayed")
    public void allTheBankAccountsMustBeDisplayed() {
        GraphicsEnvironment.isHeadless();
    }
}
