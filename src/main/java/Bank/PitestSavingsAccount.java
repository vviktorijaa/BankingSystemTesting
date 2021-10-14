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
    public void testGetNetBalance1(){
        SavingsAccount sa = new SavingsAccount("SavingsAccount", 100, 0);
        assertEquals(sa.getNetBalance(), 105, 0.1);
    }

    @Test
    public void testWithdrawMethod() throws MaxBalance, MaxWithdraw {   //replaced double return with 0.0d for Bank/SavingsAccount::withdraw
        SavingsAccount sa = new SavingsAccount("SavingsAccount", 5000, 2500);
        assertEquals(sa.withdraw(500), 500, 0);
    }

    @Test
    public void testWithdrawMethod1() throws MaxBalance, MaxWithdraw {   //replaced double return with 0.0d for Bank/SavingsAccount::withdraw
        SavingsAccount sa = new SavingsAccount("SavingsAccount", 5000, 2500);
        assertThrows(MaxWithdraw.class, () ->{
            sa.withdraw(2500);
        });
    }
}
