package ISP;

import Bank.BankAccount;
import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankAccountISP {

    //BCC

    @Test
    public void setGetName(){   //C1-T C5-T
        BankAccount ba = new BankAccount();
        ba.setName("Bank Account 1");
        assertEquals("Bank Account 1", ba.getName());
    }

    @Test
    public void setGetName2(){   //C1-F C5-F
        BankAccount ba = new BankAccount();
        assertNull(ba.getName());
    }

    @Test
    public void setGetBalance(){   //C2-T C6-T C7-T
        BankAccount ba = new BankAccount();
        ba.setBalance(500);
        assertEquals(500, ba.getBalance(), 0);
    }

    @Test
    public void setGetBalance2(){   //C2-T C6-T C7-F
        BankAccount ba = new BankAccount();
        ba.setBalance(-1000);
        assertEquals(-1000, ba.getBalance(), 0);
    }

    @Test
    public void setGetBalance3(){   //C2-F C6-T C7-T
        BankAccount ba = new BankAccount();
        assertEquals(0, ba.getBalance(), 0);
    }

    @Test
    public void setGetMinBalance(){   //C3-T C6-T C7-T
        BankAccount ba = new BankAccount();
        ba.setMinBalance(0);
        assertEquals(0, ba.getMinBalance(), 0);
    }

    @Test
    public void setGetMinBalance2(){   //C3-T C6-T C7-F
        BankAccount ba = new BankAccount();
        ba.setMinBalance(-1000);
        assertEquals(-1000, ba.getMinBalance(), 0);
    }

    @Test
    public void setGetMinBalance3(){   //C3-F C6-T C7-T
        BankAccount ba = new BankAccount();
        assertEquals(0, ba.getMinBalance(), 0);
    }

    @Test
    public void getAccNumber(){   //C4-T C5-T
        BankAccount ba = new BankAccount("Bank Account", 6500, 100);
        assertTrue(ba.getAccNumber().length() == 5);
    }

    @Test
    public void getAccNumber2(){   //C4-F C5-F
        BankAccount ba = new BankAccount();
        assertNull(ba.getAccNumber());
    }

    @Test
    public void deposit() {    //C6-T C7-T C8-T C9-T
        BankAccount ba = new BankAccount("Bank Account 1235", 2100, 0);
        assertTrue(ba.deposit(3000) > 0);
    }

    @Test
    public void deposit2() {    //C6-T C7-T C8-T C9-F
        BankAccount ba = new BankAccount("Bank Account 5432", 1000, 100);
        assertEquals(2100, ba.deposit(1100), 0);
    }

    @Test
    public void deposit3() {    //C6-T C7-T C8-F C9-T
        BankAccount ba = new BankAccount("Bank Account 7891", 500, -1000);
        assertEquals(700, ba.deposit(200), 0);
    }

    @Test
    public void deposit4() {    //C6-T C7-F C8-T C9-T
        BankAccount ba = new BankAccount("Bank Account 7891", -500, -1000);
        assertEquals(-100, ba.deposit(400), 0);
    }

    @Test
    public void deposit5() {    //C6-T C7-T C8-F C9-F
        BankAccount ba = new BankAccount("Bank Account 7891", 1000, -1000);
        assertEquals(1000, ba.deposit(0), 0);
    }


    //C6 И C8 T не заедно не може да врати и double и да фрли исклучок
    @Test
    public void testWithdraw() throws MaxBalance, MaxWithdraw {    //C6-T C7-T C8-F C9-T C10-T
        BankAccount ba = new BankAccount("Bank Account 7364", 500, 0);
        assertEquals(200, ba.withdraw(300), 0);
    }

    @Test
    public void testWithdraw2() throws MaxBalance, MaxWithdraw {    //C6-T C7-T C8-F C9-F C10-T
        BankAccount ba = new BankAccount("Bank Account 7364", 500, 0);
        assertEquals(500, ba.withdraw(0), 0);
    }

    @Test
    public void testWithdraw3() throws MaxBalance, MaxWithdraw {    //C6-T C7-T C8-F C9-F C10-F
        BankAccount ba = new BankAccount("Bank Account 7364", 500, 0);
        assertEquals(600, ba.withdraw(-100), 0);
    }

    @Test
    public void testWithdraw4() throws MaxBalance, MaxWithdraw {    //C6-F C7-F C8-T C9-T C10-F
        BankAccount ba = new BankAccount("Bank Account 7364", 500, 0);
        assertThrows(MaxBalance.class, () -> {
            ba.withdraw(900);
        });
    }

    @Test
    public void testWithdraw5() throws MaxBalance, MaxWithdraw {    //C6-F C7-F C8-T C9-F C10-F
        BankAccount ba = new BankAccount("Bank Account 7364", -500, 0);
        assertThrows(MaxBalance.class, () -> {
            ba.withdraw(0);
        });
    }

    @Test
    public void testToString() {    //C11-T
        BankAccount ba = new BankAccount("BankAccount", 4000, 100);
        String expected = "Name: "+ba.getName()+", Id: "+ba.getAccNumber()+", Balance: "+ba.getBalance()+", Type: "+ba.getClass();
        assertEquals(expected, ba.toString());
    }

    @Test
    public void testToString2() {    //C11-F
        BankAccount bankAccount = null;
        assertThrows(NullPointerException.class, () -> {
            bankAccount.toString();
        });
    }
}