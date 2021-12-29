package Cucumber;

import GUI.AddAccount;
import GUI.AddSavingsAccount;
import GUI.Login;
import GUI.Menu;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.swing.edt.GuiActionRunner;

import static org.junit.Assert.assertTrue;

public class AddAccountStepDefinitions {

    Login l =new Login();
    Menu m = new Menu();
    AddAccount addAcc = new AddAccount();
    AddSavingsAccount savingsAcc = new AddSavingsAccount();
    boolean t = true;


    @Given("^The application is started$")
    public void the_application_is_started() throws Exception {
        l = GuiActionRunner.execute(() -> new Login());
        l.textField_1.setText("admin");
    }

    @When("^I click on the Add Account button$")
    public void i_click_on_the_Add_Account_button() throws Exception {
        m.btnNewButton.doClick();
    }

    @And("^click on the Add Savings Account button$")
    public void click_on_the_Add_Savings_Account_button() throws Exception {
        addAcc.btnAddCurrentAccount.doClick();
    }

    @And("^input \"([^\"]*)\" in the name field$")
    public void input_in_the_name_field(String name) throws Exception {
        savingsAcc.textField.setText(name);
    }

    @And("^input (\\d+) in the balance field$")
    public void input_in_the_balance_field(int balance) throws Exception {
        savingsAcc.textField_1.setText(String.valueOf(balance));
    }

    @And("^input (\\d+) in the maximum withdraw limit field$")
    public void input_in_the_maximum_withdraw_limit_field(int maxWithLimit) throws Exception {
        savingsAcc.textField_2.setText(String.valueOf(maxWithLimit));
    }

    @And("^click on the Add button$")
    public void click_on_the_Add_button() throws Exception {
        savingsAcc.btnAdd.doClick();
    }

    @When("^click on the Reset button$")
    public void click_on_the_Reset_button() throws Exception {
        savingsAcc.btnReset.doClick();
    }

    @And("^click on the yes button in the confirm dialog box$")
    public void click_on_the_yes_button_in_the_confirm_dialog_box() throws Exception {

    }

    @When("^click on the no button in the confirm dialog box$")
    public void click_on_the_no_button_in_the_confirm_dialog_box() throws Exception {
    }

    @Then("^the input fields must be empty$")
    public void the_input_fields_must_be_empty() throws Exception {
        assertTrue(savingsAcc.textField.getText().isEmpty() &&
                    savingsAcc.textField_1.getText().isEmpty() &&
                    savingsAcc.textField_2.getText().isEmpty());
    }

    @Then("^the account is added successfully$")
    public void the_account_is_added_successfully() throws Exception {
//        if(savingsAcc.ch == 0){
//            System.out.println("Account added successfully");
//        }
    }

    @Then("^the account is not added$")
    public void the_account_is_not_added() throws Exception {
//        if(savingsAcc.ch != 0){
//            System.out.println("Account not added");
//        }
    }
}
