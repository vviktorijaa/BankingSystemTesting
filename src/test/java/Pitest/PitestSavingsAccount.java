package Pitest;

import Bank.SavingsAccount;
import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;
import org.junit.Test;
import static org.junit.Assert.*;

public class PitestSavingsAccount {

    @Test
    public void test1(){
        SavingsAccount sa = new SavingsAccount("SavingsAccount", 100, 0);
        assertEquals(sa.getNetBalance(), 105, 0.1);
    }

    @Test
    public void test2() throws MaxBalance, MaxWithdraw {   //replaced double return with 0.0d for Bank/SavingsAccount::withdraw
        SavingsAccount sa = new SavingsAccount("SavingsAccount", 5000, 2500);
        assertEquals(sa.withdraw(500), 500, 0);
    }

    @Test
    public void test3() throws MaxBalance, MaxWithdraw {   //replaced double return with 0.0d for Bank/SavingsAccount::withdraw
        SavingsAccount sa = new SavingsAccount("SavingsAccount", 5000, 2500);
        assertThrows(MaxWithdraw.class, () ->{
            sa.withdraw(2500);
        });
    }
}
