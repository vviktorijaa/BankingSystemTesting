package ISP;

import Bank.SavingsAccount;
import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;
import org.junit.Test;
import static org.junit.Assert.*;

public class SavingsAccountISP {

    @Test
    public void test1(){ //NetBalance is <= 0
        SavingsAccount sa = new SavingsAccount("SavingsAccount", 0, 1000);
        assertEquals(0, sa.getNetBalance(), 0);
    }

    @Test
    public void test2(){ //NetBalance is > 0
        SavingsAccount sa = new SavingsAccount("SavingsAccount", 2000, 10000);
        assertTrue(sa.getNetBalance() > 0);
    }

    @Test
    public void test3() throws MaxBalance, MaxWithdraw { //amount is > 0
        SavingsAccount sa = new SavingsAccount("SavingsAccount", 5000, 5000);
        assertEquals(500, sa.withdraw(500), 0);
    }

    @Test
    public void test4() throws MaxBalance, MaxWithdraw { //amount is <= 0
        SavingsAccount sa = new SavingsAccount("SavingsAccount", 2000, 500);
        assertTrue(sa.withdraw(0) == 0);
    }
}
