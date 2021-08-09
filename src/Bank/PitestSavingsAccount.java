package Bank;

import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;
import org.junit.Test;

import static org.junit.Assert.*;

public class PitestSavingsAccount {

    @Test
    public void testGetNetBalance(){    //addition with subtraction killed
        SavingsAccount sa = new SavingsAccount("SavingsAccount", 5000, 2500);
        assertTrue(sa.getNetBalance() > 5000);
    }

    @Test
    public void testWithdrawMethod() throws MaxBalance, MaxWithdraw {
        SavingsAccount sa = new SavingsAccount("SavingsAccount", 5000, 2500);
        assertEquals(sa.withdraw(500), 500, 0);
    }

    @Test
    public void testWithdrawMethodException() {
        assertThrows(MaxWithdraw.class, () ->{
            SavingsAccount sa = new SavingsAccount("SavingsAccount", 5000, 2500);
            sa.withdraw(20000);
        });
    }
}
