package GraphCoverage;

import Bank.SavingsAccount;
import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class SavingsAccountGraphCov {

    //PPC

    @Test
    public void testWithdraw2() throws MaxBalance, MaxWithdraw {    //[1,2]
        SavingsAccount sa = new SavingsAccount("Acc", 5000, 10000);
        sa.withdraw(2000);
        assertEquals(3000, sa.getBalance(), 0);
    }

    @Test
    public void testWithdraw(){     //[1,3]
        SavingsAccount sa = new SavingsAccount("Acc", 20000, 10000);
        assertThrows(MaxWithdraw.class, () -> {
            sa.withdraw(15000);
        });
    }
}