package Pitest;

import Bank.Bank;
import Exceptions.AccNotFound;
import Exceptions.InvalidAmount;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PitestBank {

    private Bank bank;

    @Before
    public void setup() {
        bank = new Bank();
    }

    @Test
    public void test1() throws Exception {
        for(int i=0; i<99; i++){
            bank.addAccount("SavingsAccount", 15000, 10000);
        }
        assertEquals(99, bank.addAccount("CurrentAccount", 5000, "tradeLicense"));
    }

    @Test
    public void test2() {
        int firstAcc = bank.addAccount("SavingsAccount", 15000, 1000);
        int secondAcc = bank.addAccount("SavingsAccount", 23000, 2000);
        assertTrue(secondAcc == 1);
    }

    @Test
    public void test3() {
        int firstAcc = bank.addAccount("StudentAccount", "InstitutionName", 5000, 100);
        int secondAcc = bank.addAccount("StudentAccount2", "InstitutionName2", 10000, 100);
        assertEquals(1, secondAcc);
    }

    @Test
    public void test4() {
        bank.addAccount("AccountName", 7500, 10000);
        bank.setAccounts(bank.getAccounts());
        assertThrows(AccNotFound.class, () -> {
            bank.deposit("1234", 0);
        });
    }

    @Test
    public void test5(){
        bank.addAccount("SavingsAccount", 5000, 5000);
        assertThrows(InvalidAmount.class, () -> {
            bank.withdraw(bank.getAccounts()[0].getAccNumber(), 0);
        });
    }

    @Test
    public void test6() throws Exception {
        for(int i=0; i<100; i++){
            bank.addAccount("CurrentAccount", 7400, "83346");
        }
        assertNotEquals(0, bank.display().size());
    }

    @Test
    public void test7() throws Exception {
        for(int i=0; i<100; i++){
            bank.addAccount("CurrentAccount", 10000, "19302");
        }
        assertDoesNotThrow(()->{
            bank.withdraw(bank.getAccounts()[0].getAccNumber(), 5000);
        });
    }

    @Test
    public void test8() throws Exception {
        bank.addAccount("CurrentAccount", 5600, "11111");
        assertThrows(InvalidAmount.class, () -> {
            bank.deposit(bank.getAccounts()[0].getAccNumber(), -10);
        });
    }

    @Test
    public void test9(){
        bank.addAccount("SavingsAccount", 10000, 5000);
        assertDoesNotThrow(()->{
            bank.deposit(bank.getAccounts()[0].getAccNumber(), 1000);
        });
    }

    //line coverage tests

    @Test
    public void test10(){
        assertThrows(AccNotFound.class, () -> {
            bank.withdraw("112233", 5000);
        });
    }

    @Test
    public void test11(){
        assertTrue(bank.display().isEmpty());
    }
}
