package LogicCoverage;

import org.junit.Test;
import Bank.BankAccount;
import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class BankAccountLogicCov {

    //CoC

    @Test
    public void testWithdraw() throws MaxBalance, MaxWithdraw {     //TT
        BankAccount ba = new BankAccount("AccountName", 1500, 500);
        assertEquals(1300, ba.withdraw(200), 0);
    }

    @Test
    public void testWithdraw2(){        //TF
        BankAccount ba = new BankAccount("AccountName1", 1000, 0);
        assertThrows(MaxBalance.class, () -> {
            ba.withdraw(1000);
        });
    }

    @Test
    public void testWithdraw3(){        //FT
        BankAccount ba = new BankAccount("AccountName2", 2000, 2000);
        assertThrows(MaxBalance.class, () -> {
            ba.withdraw(500);
        });
    }

    @Test
    public void testWithdraw4(){        //FF
        BankAccount ba = new BankAccount("AccountName3", 2000, 500);
        assertThrows(MaxBalance.class, () -> {
            ba.withdraw(3000);
        });
    }
}