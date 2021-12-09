//package Cucumber;
//
//import GUI.DepositAcc;
//import GUI.Login;
//import GUI.Menu;
//import cucumber.api.java.en.And;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import org.assertj.swing.edt.GuiActionRunner;
//import java.awt.*;
//
//public class DepositStepDefinitions {
//
//    Login l = new Login();
//    Menu m = new Menu();
//    DepositAcc deposit = new DepositAcc();
//
//
//    @Given("The application is started")
//    public void theApplicationIsStarted() {
//        l = GuiActionRunner.execute(() -> new Login());
//        l.textField_1.setText("admin");
//    }
//
//    @When("I click on the Deposit To Account button")
//    public void iClickOnTheDepositToAccountButton() {
//        m.btnDepositToAccount.doClick();
//    }
//
//    @And("input (\\d+) as Account Number")
//    public void inputAsAccountNumber(int accNum) {
//        deposit.textField.setText(String.valueOf(accNum));
//    }
//
//    @And("input (\\d+) in Amount field")
//    public void inputInAmountField(int amount) {
//        deposit.textField_1.setText(String.valueOf(amount));
//    }
//
//    @And("click on the Reset button")
//    public void clickOnTheResetButton() {
//        deposit.btnReset.doClick();
//    }
//
//    @And("click on the Deposit button")
//    public void clickOnTheDepositButton() {
//        deposit.btnDeposit.doClick();
//    }
//
//    @Then("the deposit is successful")
//    public void theDepositIsSuccessful() {
//        GraphicsEnvironment.isHeadless();
//    }
//
//    @Then("the deposit is not successful")
//    public void theDepositIsNotSuccessful() {
//        GraphicsEnvironment.isHeadless();
//    }
//}
