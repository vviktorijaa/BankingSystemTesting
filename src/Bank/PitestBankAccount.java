package Bank;

import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;
import org.junit.Test;
import static org.junit.Assert.*;

public class PitestBankAccount {

    @Test
    public void testBankAccountConstructor(){
        BankAccount ba = new BankAccount("Example", 1000, 500);
        assertEquals(1000, ba.getBalance(), 0);
        assertEquals(500, ba.getMinBalance(), 0);
        assertEquals("Example", ba.getName());
    }

    @Test
    public void testAccNumber(){ //integer addition with subtraction killed
        BankAccount ba = new BankAccount("BankAccount", 1000, 500);
        assertTrue(Integer.parseInt(ba.getAccNumber()) > 0);
    }

    @Test
    public void testSetAndGetName(){
        BankAccount ba = new BankAccount();
        ba.setName("ExampleName");
        assertEquals(ba.getName(), "ExampleName");
    }

    @Test
    public void testSetAndGetBalance(){
        BankAccount ba = new BankAccount();
        ba.setBalance(1000.0);
        assertEquals(ba.getBalance(), 1000.0, 0);
    }

    @Test
    public void testSetAndGetMinBalance(){
        BankAccount ba = new BankAccount();
        ba.setMinBalance(0);
        assertEquals(ba.getMinBalance(), 0, 0);
    }

    @Test
    public void testDepositMethod(){
        BankAccount ba=new BankAccount("Name", 500, 0);
        assertEquals(ba.deposit(100), 600, 0);
    }

    @Test
    public void testWithdrawMethod() throws MaxBalance, MaxWithdraw {   //ОК
        BankAccount ba=new BankAccount("BankAccount", 1500, 0);
        assertTrue(ba.withdraw(500) == 1000);
    }

    @Test
    public void testWithdrawMethodException(){  //ОК
        BankAccount ba=new BankAccount("BankAccount", 500, 0);
        assertThrows(MaxBalance.class, () -> {
            ba.withdraw(1500);
        });
    }

    @Test
    public void testWithdrawNarrowCase() throws MaxBalance, MaxWithdraw {   //amount<min_balance mutant killed
        BankAccount ba=new BankAccount("BankAccount", 1500, 100);
        assertEquals(ba.withdraw(1400), 100, 0);
    }

    @Test
    public void testToStringMethod(){   //ОК
        BankAccount ba=new BankAccount("BankAccount", 200, 0);
        assertEquals(ba.toString(), "Name: BankAccount, Id: " + ba.getAccNumber() + ", Balance: 200.0, Type: "+BankAccount.class);
    }
}
