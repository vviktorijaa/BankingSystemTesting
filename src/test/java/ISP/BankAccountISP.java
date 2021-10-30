package ISP;

import Bank.BankAccount;
import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountISP {

    @Test
    public void test1(){    //setName, getName
        BankAccount ba = new BankAccount();
        ba.setName("BankAccount");
        ba.setBalance(5000);
        ba.setMinBalance(100);
        assertEquals("BankAccount", ba.getName());
    }

    @Test
    public void test2(){    //setBalance, getBalance
        BankAccount ba = new BankAccount();
        ba.setName("Account");
        ba.setBalance(7500);
        ba.setMinBalance(0);
        assertTrue(ba.getBalance() == 7500);
    }

    @Test
    public void test3(){    //setBalance, getBalance
        BankAccount ba = new BankAccount();
        ba.setName("Account");
        ba.setBalance(7500);
        ba.setMinBalance(0);
        assertTrue(ba.getBalance() == 7500);
    }

    @Test
    public void test4(){    //setMinBalance, getMinBalance
        BankAccount ba = new BankAccount();
        ba.setName("Account");
        ba.setBalance(100);
        ba.setMinBalance(100);
        assertTrue(ba.getMinBalance() == 100);
    }

    @Test
    public void test6(){    //deposit amt>0
        BankAccount ba = new BankAccount("BankAccount", 500, 100);
        assertEquals(1000, ba.deposit(500), 0);
    }

    @Test
    public void test7(){    //deposit amt<=0
        BankAccount ba = new BankAccount("BankAccount", 2000, 50);
        assertEquals(2000, ba.deposit(0), 0);
    }

    @Test
    public void test8() throws MaxBalance, MaxWithdraw {    //withdraw amt>0
        BankAccount ba = new BankAccount("BankAccount", 2500, 50);
        assertEquals(2300, ba.withdraw(200), 0);
    }

    @Test
    public void test9() throws MaxBalance, MaxWithdraw {    //withdraw amt<=0
        BankAccount ba = new BankAccount("BankAccount", 4000, 100);
        assertTrue(ba.withdraw(0) == 4000);
    }

    @Test
    public void test10() {    //toString printed
        BankAccount ba = new BankAccount("BankAccount", 4000, 100);
        String expected = "Name: "+ba.getName()+", Id: "+ba.getAccNumber()+", Balance: "+ba.getBalance()+", Type: "+ba.getClass();
        assertEquals(expected, ba.toString());
    }

    @Test
    public void test11() {    //toString not printed
        BankAccount bankAccount = null;
        assertThrows(NullPointerException.class, () -> {
            bankAccount.toString();
        });
    }
}