package LogicCoverage;

import Bank.Bank;
import Exceptions.AccNotFound;
import Exceptions.InvalidAmount;
import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.*;

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
        int firstAcc = b.addAccount("AccName", 1500, 10000);
        int secondAcc = b.addAccount("AccName", 1500, 10000);
        assertEquals(1, secondAcc);
    }

    @Test
    public void testFindAccount() {   //getAccounts()[i] == null -> T && getAccounts()[i].acc_num.equals(aacountNum) -> F
        assertNull(b.findAccount("5678"));
    }

    @Test
    public void testFindAccount2() {   //getAccounts()[i] == null -> F && getAccounts()[i].acc_num.equals(aacountNum) -> T
        b.addAccount("AccountName", "InstitutionName", 20000, 1500);
        assertNotNull(b.findAccount(b.getAccounts()[0].getAccNumber()));
    }

    @Test
    public void testDeposit() throws Exception {   //amt < 0
        b.addAccount("AccountName", 10000, "tradeLicense");
        assertThrows(InvalidAmount.class, () -> {
            b.deposit(b.getAccounts()[0].getAccNumber(), -100);
        });
    }

    @Test
    public void testDeposit2() throws Exception {   //temp == null
        b.addAccount("AccName", 35000, 10000);
        assertThrows(AccNotFound.class, () -> {
            b.deposit("1234", 5000);
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
    public void testWithdraw2() throws InvalidAmount, MaxBalance, AccNotFound, MaxWithdraw {   //amt <= 0
        b.addAccount("AccountOne", 5000, 20000);
        assertThrows(InvalidAmount.class, () ->{
            b.withdraw(b.getAccounts()[0].getAccNumber(), 0);
        });
    }

    @Test
    public void testWithdraw3() throws InvalidAmount, MaxBalance, AccNotFound, MaxWithdraw {   //amt > temp.getBalance()
        b.addAccount("AccountTwo", 7500, 15000);
        assertThrows(MaxBalance.class, () ->{
            b.withdraw(b.getAccounts()[0].getAccNumber(), 10000);
        });
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
