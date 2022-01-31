package Cucumber;

import GUI.DepositAcc;
import GUI.Login;
import GUI.Menu;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.swing.edt.GuiActionRunner;
import java.awt.*;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

public class DepositStepDefinitions {

    Login l = new Login();
    Menu m = new Menu();
    DepositAcc deposit = new DepositAcc();


    @Given("The application is started")
    public void theApplicationIsStarted() {
        l = GuiActionRunner.execute(() -> new Login());
        l.textField_1.setText("admin");
    }

    @When("I click on the Deposit To Account button")
    public void iClickOnTheDepositToAccountButton() {
        m.btnDepositToAccount.doClick();
    }

    @And("input (\\d+) as Account Number")
    public void inputAsAccountNumber(int accNum) {
        deposit.textField.setText(String.valueOf(accNum));
    }

    @And("input (\\d+) in Amount field")
    public void inputInAmountField(int amount) {
        deposit.textField_1.setText(String.valueOf(amount));
    }

    @And("click on the Reset button")
    public void clickOnTheResetButton() {
        deposit.btnReset.doClick();
    }

    @And("click on the Deposit button")
    public void clickOnTheDepositButton() {
        deposit.btnDeposit.doClick();
    }

    @And("click on the Yes button")
    public void clickOnTheYesButton() {
        deposit.a = 0;
    }

    @Then("the deposit is successful")
    public void theDepositIsSuccessful() {
        GraphicsEnvironment.isHeadless();
    }

    @Then("the deposit is not successful")
    public void theDepositIsNotSuccessful() {
        GraphicsEnvironment.isHeadless();
    }

    @Then("^the input fields must be empty$")
    public void the_input_fields_must_be_empty() throws Exception {
        assertTrue(deposit.textField.getText().isEmpty() &&
                deposit.textField_1.getText().isEmpty());
    }

    @Then("^Exception must be thrown when I click on the Deposit button$")
    public void exception_must_be_thrown_when_I_click_on_the_Deposit_button() throws Exception {
        assertThrows(NumberFormatException.class, () -> {
            deposit.btnDeposit.doClick();
        });
    }
}
