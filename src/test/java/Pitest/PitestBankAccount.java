package Pitest;

import Bank.BankAccount;
import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;
import org.junit.Test;
import static org.junit.Assert.*;

public class PitestBankAccount {

    @Test
    public void test1(){
        BankAccount ba = new BankAccount("Example", 1000, 500);
        assertEquals(1000, ba.getBalance(), 0);
        assertEquals(500, ba.getMinBalance(), 0);
        assertEquals("Example", ba.getName());
    }

    @Test
    public void test2(){
        BankAccount ba = new BankAccount("BankAccount", 1000, 500);
        assertTrue(Integer.parseInt(ba.getAccNumber()) > 11000);
    }

    @Test
    public void test3() {
        BankAccount ba = new BankAccount("Name", 500, 0);
        assertEquals(ba.deposit(100), 600, 0);
    }

    @Test
    public void test4() throws MaxBalance, MaxWithdraw {
        BankAccount ba = new BankAccount("BankAccount", 1500, 0);
        assertTrue(ba.withdraw(500) == 1000);
    }

    @Test
    public void test5() throws MaxBalance, MaxWithdraw {
        BankAccount ba = new BankAccount("BankAccount", 1500, 100);
        assertEquals(ba.withdraw(1400), 100, 0);
    }

    @Test
    public void test6() {
        BankAccount ba = new BankAccount("BankAccount", 200, 200);
        assertThrows(MaxBalance.class, () -> {
            ba.withdraw(30);
        });
    }

    @Test
    public void test7() {
        BankAccount ba = new BankAccount("BankAccount", 200, 0);
        assertThrows(MaxBalance.class, () -> {
            ba.withdraw(200);
        });
    }

    @Test
    public void test8() {
        BankAccount ba = new BankAccount("BankAccount", 200, 0);
        assertEquals(ba.toString(), "Name: BankAccount, Id: " + ba.getAccNumber() + ", Balance: 200.0, Type: " + BankAccount.class);
    }

    //line coverage tests

    @Test
    public void test9() {
        BankAccount ba = new BankAccount();
        ba.setName("ExampleName");
        assertEquals(ba.getName(), "ExampleName");
    }

    @Test
    public void test10() {
        BankAccount ba = new BankAccount();
        ba.setBalance(1000.0);
        assertEquals(ba.getBalance(), 1000.0, 0);
    }

    @Test
    public void test11() {
        BankAccount ba = new BankAccount();
        ba.setMinBalance(0);
        assertEquals(ba.getMinBalance(), 0, 0);
    }
}