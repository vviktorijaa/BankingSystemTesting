package LogicCoverage;

import org.junit.Test;
import Bank.SavingsAccount;
import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SavingsAccountLogicCov {

    @Test
    public void testWithdraw() throws MaxBalance, MaxWithdraw {     //amount >= maxWithLimit
        SavingsAccount sa = new SavingsAccount("SavingsAccount", 1500, 1000);
        assertThrows(MaxWithdraw.class, () -> {
            sa.withdraw(1500);
        });
    }

    @Test
    public void testWithdraw2() throws MaxBalance, MaxWithdraw {       //amount < maxWithLimit
        SavingsAccount sa = new SavingsAccount("SavingsAccount", 2500, 1000);
        assertTrue(sa.withdraw(200) == 200);
    }
}