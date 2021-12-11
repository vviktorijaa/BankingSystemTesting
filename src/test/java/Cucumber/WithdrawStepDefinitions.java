package Cucumber;

import GUI.Login;
import GUI.Menu;
import GUI.WithdrawAcc;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.swing.edt.GuiActionRunner;

import java.awt.*;

public class WithdrawStepDefinitions {

    Login l = new Login();
    Menu m = new Menu();
    WithdrawAcc withdrawAcc = new WithdrawAcc();

    @Given("^The application is started$")
    public void the_application_is_started() throws Exception {
        l = GuiActionRunner.execute(() -> new Login());
        l.textField_1.setText("admin");
    }

    @When("^I click on the Withdraw From Account button$")
    public void i_click_on_the_Withdraw_From_Account_button() throws Exception {
        m.btnWithdrawFromAccount.doClick();
    }

    @And("^input (\\d+) as Account Number$")
    public void input_as_Account_Number(int accNum) throws Exception {
        withdrawAcc.textField.setText(String.valueOf(accNum));
    }

    @And("^input (\\d+) in Amount field$")
    public void input_in_Amount_field(int amount) throws Exception {
        withdrawAcc.textField.setText(String.valueOf(amount));
    }

    @And("^click on the Reset button$")
    public void click_on_the_Reset_button() throws Exception {
        withdrawAcc.btnReset.doClick();
    }

    @And("^click on the Withdraw button$")
    public void click_on_the_Withdraw_button() throws Exception {
        withdrawAcc.btnWithdraw.doClick();
    }

    @Then("^the withdraw is successful$")
    public void the_withdraw_is_successful() throws Exception {
        GraphicsEnvironment.isHeadless();
    }

    @Then("^the withdraw is unsuccessful$")
    public void the_withdraw_is_unsuccessful() throws Exception {
        GraphicsEnvironment.isHeadless();
    }

}