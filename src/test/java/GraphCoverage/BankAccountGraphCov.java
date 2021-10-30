package GraphCoverage;

import Bank.BankAccount;
import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class BankAccountGraphCov {

    //PPC

    @Test
    public void testWithdraw() throws MaxBalance, MaxWithdraw {     //[1,2,3]
        BankAccount ba = new BankAccount("BankAccount", 17800, 500);
        assertEquals(16800, ba.withdraw(1000), 0);
    }

    @Test
    public void testWithdraw2(){    //[1,2,4]
        BankAccount ba = new BankAccount("BankAccount", 2000, 500);
        assertThrows(MaxBalance.class, () -> {
            ba.withdraw(3000);
        });
    }
}