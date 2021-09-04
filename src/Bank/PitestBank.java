package Bank;

import Exceptions.AccNotFound;
import Exceptions.InvalidAmount;
import Exceptions.MaxBalance;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;

public class PitestBank {

    private Bank bank;

    @BeforeEach
    public void setup() {
        bank = new Bank();
    }

    @Test
    public void test1(){
        BankAccount [] b = new  BankAccount[1];
        for(int i=0; i<b.length; i++){
            bank.setAccounts(b);
        }
        assertThrows(AccNotFound.class, () ->{
            bank.withdraw("accountNum", 0);
        });
    }

    @Test
    public void testDeposit(){
        assertThrows(InvalidAmount.class, () -> {
            bank.deposit("accountNum", -1);
        });
    }

    @Test
    public void testDeposit1(){
        assertThrows(AccNotFound.class, () -> {
            bank.deposit("accountNum", 0);
        });
    }

    @Test
    public void testAddAccount(){
        assertEquals(null, bank.findAccount("Account"));
    }

    @Test
    public void testAddBankAccountAndWithdraw() {
        BankAccount ba = new BankAccount("BankAccount", 1500, 50);
        bank.addAccount(ba);
        assertThrows(AccNotFound.class, () -> {
            bank.withdraw("BankAccount", 0);
        });
    }

    @Test
    public void testDisplay() {
        assertFalse(bank.display() == null);    //line 110 in Bank class
    }

    @Test
    public void testInvalidAmountExceptionClass() {
        for(int i=0; i<100; i++){
            bank.addAccount("Acc", "Institution", 5000, 1000);
        }
        assertThrows(InvalidAmount.class, () ->{
            bank.withdraw(bank.getAccounts()[1].acc_num, 0);
        });
    }

    @Test
    public void testMaxBalanceExceptionClass() throws Exception {
        for(int i=0; i<100; i++){
            bank.addAccount("AccountName", 50000, 100);
        }
        assertThrows(MaxBalance.class, () ->{
            bank.withdraw(bank.getAccounts()[1].acc_num, 100000);
        });
    }

    @Test
    public void testMaxBalanceExceptionClass1() throws Exception {
        for(int i=0; i<100; i++){
            bank.addAccount("AccountName", 50000, "tradLicense");
        }
        bank.withdraw(bank.getAccounts()[1].acc_num, 1000);
    }

    @Test
    public void testDeposit11() throws Exception { //replaced int return with 0 for Bank/Bank::addAccount → KILLED, bidejki secondAcc e so index 1 vo nizata kreirani akaunti
        int firstAcc = bank.addAccount("AccountName", 50000, "tradLicense");
        int secondAcc = bank.addAccount("AccountName", 50000, "tradLicense");
        assertTrue(secondAcc != 0);
    }

    @Test
    public void testDeposit2() throws InvalidAmount, AccNotFound {
        for(int i=0; i<100; i++){
            bank.addAccount("AccountName", 50000, 100);
        }
        //assertTrue(bank.deposit(bank.getAccounts()[1].acc_num, 1000));
    }
}
