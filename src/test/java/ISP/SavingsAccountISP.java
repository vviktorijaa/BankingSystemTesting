package ISP;

import Bank.SavingsAccount;
import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;
import org.junit.Test;
import static org.junit.Assert.*;

public class SavingsAccountISP {

    @Test
    public void getNetBalance(){ //returns positive value - F
        SavingsAccount sa = new SavingsAccount("SavingsAccount", 0, 1000);
        assertEquals(0, sa.getNetBalance(), 0);
    }

    @Test
    public void getNetBalance2(){ //returns positive value - T
        SavingsAccount sa = new SavingsAccount("SavingsAccount", 2000, 10000);
        assertTrue(sa.getNetBalance() > 0);
    }

    @Test
    public void withdraw() throws MaxBalance, MaxWithdraw { //amount is > 0
        SavingsAccount sa = new SavingsAccount("SavingsAccount", 5000, 5000);
        assertEquals(500, sa.withdraw(500), 0);
    }

    @Test
    public void withdraw2() throws MaxBalance, MaxWithdraw { //amount is <= 0
        SavingsAccount sa = new SavingsAccount("SavingsAccount", 2000, 500);
        assertTrue(sa.withdraw(0) == 0);
    }
}
