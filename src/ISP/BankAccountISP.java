package ISP;

import Bank.BankAccount;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BankAccountISP {

    @Test
    public void testDeposit(){  //amount = 0
        BankAccount ba = new BankAccount("CurrentAccount", 7000, 100);
        assertEquals(7000, ba.deposit(0), 0);
    }

    @Test
    public void testDeposit2(){  //amount > 0
        BankAccount ba = new BankAccount("CurrentAccount", 10000, 1000);
        assertEquals(11000, ba.deposit(1000), 0);
    }

    @Test
    public void testDeposit3(){  //amount < 0
        BankAccount ba = new BankAccount("CurrentAccount", 7000, 100);
        assertEquals(6000, ba.deposit(-1000), 0);
    }
}