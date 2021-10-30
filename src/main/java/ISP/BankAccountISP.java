package ISP;

import Bank.BankAccount;
import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    @Test
    public void testWithdraw() throws MaxBalance, MaxWithdraw { //amount^3 <= 0
        BankAccount ba = new BankAccount("SavingsAccount", 7000, 2000);
        assertTrue(ba.withdraw(Math.pow(-1, 3)) > 7000);
    }

    @Test
    public void testWithdraw2() throws MaxBalance, MaxWithdraw { //amount^3 > 0
        BankAccount ba = new BankAccount("SavingsAccount", 2500, 2000);
        assertEquals(2492, ba.withdraw(Math.pow(2, 3)), 0);
    }
}