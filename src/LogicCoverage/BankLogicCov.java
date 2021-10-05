package LogicCoverage;

import Bank.Bank;
import Exceptions.AccNotFound;
import Exceptions.InvalidAmount;
import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BankLogicCov {

    private Bank b;

    @BeforeEach
    public void setup(){
        b = new Bank();
    }

    @Test
    public void testAddAccount(){   //getAccounts()[i] == null
        assertTrue(b.addAccount(null) == 0);
    }

    @Test
    public void testAddAccount2(){   //getAccounts()[i] != null
        for(int i=0; i<100; i++){
            b.addAccount("SavingsAccount", 1500, 500);
        }
        assertFalse(b.getAccounts()[99] == null);
    }

    @Test   //getAccounts()[i]==null -> T && getAccounts()[i].acc_num.equals(aacountNum) -> F
    public void testFindAccount() {   //getAccounts()[i] == null -> T && getAccounts()[i].acc_num.equals(aacountNum) -> F
        assertNull(b.findAccount("5678"));
    }

    @Test
    public void testFindAccount2() {   //getAccounts()[i] == null -> F && getAccounts()[i].acc_num.equals(aacountNum) -> T
        b.addAccount("AccountName", "InstitutionName", 20000, 1500);
        assertNotNull(b.findAccount(b.getAccounts()[0].getAccNumber()));
    }

    @Test
    public void testFindAccount3() {   //getAccounts()[i] == null -> F && getAccounts()[i].acc_num.equals(aacountNum) -> F
        for(int i=0; i<100; i++){
            b.addAccount("AccountName", "InstitutionName", 20000, 1500);
        }
        assertNull(b.findAccount("19384"));
    }

    @Test
    public void testDeposit() throws Exception {   //amt < 0 -> T
        b.addAccount("AccountName", 10000, "tradeLicense");
        assertThrows(InvalidAmount.class, () -> {
            b.deposit(b.getAccounts()[0].getAccNumber(), -100);
        });
    }

    @Test
    public void testDeposit2() throws Exception {   //amt < 0 -> F && temp == null -> T
        b.addAccount("AccName", 35000, 10000);
        assertThrows(AccNotFound.class, () -> {
            b.deposit("12345", 5000);
        });
    }

    @Test
    public void testDeposit3() {   //amt < 0 -> F && temp == null -> F
        b.addAccount("AccName", 1000, 10000);
        assertDoesNotThrow(() -> {
            b.deposit(b.getAccounts()[0].getAccNumber(), 500);
        });
    }

    @Test
    public void testWithdraw() throws InvalidAmount, MaxBalance, AccNotFound, MaxWithdraw {   //temp == null
       b.addAccount("FirstAccount", 15000, 10000);
       assertThrows(AccNotFound.class, () ->{
            b.withdraw("accNum", 1000);
        });
    }

    @Test
    public void testWithdraw2() throws InvalidAmount, MaxBalance, AccNotFound, MaxWithdraw {   //temp == null -> F && amt <= 0 -> T && amt > temp.getBalance() -> F
        b.addAccount("AccountTwo", 7500, 15000);
        assertThrows(InvalidAmount.class, () ->{
            b.withdraw(b.getAccounts()[0].getAccNumber(), 0);
        });
    }

    @Test
    public void testWithdraw3() throws InvalidAmount, MaxBalance, AccNotFound, MaxWithdraw {   //temp == null -> F && amt <= 0 -> F && amt > temp.getBalance() -> T
        b.addAccount("AccountTwo", 500, 10000);
        assertThrows(MaxBalance.class, () ->{
            b.withdraw(b.getAccounts()[0].getAccNumber(), 1000);
        });
    }

    @Test
    public void testWithdraw4() throws InvalidAmount, MaxBalance, AccNotFound, MaxWithdraw {   //temp == null -> F && amt <= 0 -> F && amt > temp.getBalance() -> F
        b.addAccount("AccountTwo", 2500, 1000);
        assertNull(b.withdraw(b.getAccounts()[0].getAccNumber(), 300));
    }

    @Test
    public void testDisplay() {
       assertEquals(0, b.display().size());
    }

    @Test
    public void testDisplay2() {
        b.addAccount("Account", 8000, 20000);
        assertTrue(b.display().size() == 1);
    }
}
