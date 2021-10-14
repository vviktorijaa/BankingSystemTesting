package Bank;

import Exceptions.AccNotFound;
import Exceptions.InvalidAmount;
import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

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
        for(int i=0; i<100; i++){
            bank.addAccount("StudentAccount", "Institution", 10000, 500);
        }
        assertEquals(bank.getAccounts()[0].toString(), bank.findAccount(bank.getAccounts()[0].getAccNumber()).toString());
    }

    @Test
    public void test5() {
        assertNull(bank.findAccount("account"));
    }

    @Test
    public void test6() {
        bank.addAccount("AccountName", 7500, 10000);
        bank.setAccounts(bank.getAccounts());
        assertThrows(AccNotFound.class, () -> {
            bank.deposit("1234", 0);
        });
    }

    @Test
    public void test7() throws InvalidAmount, MaxBalance, AccNotFound, MaxWithdraw {
        assertThrows(AccNotFound.class, () -> {
            bank.withdraw("accountNum", 1000);
        });
    }

    @Test
    public void test8() throws InvalidAmount, MaxBalance, AccNotFound, MaxWithdraw {
        bank.addAccount("SavingsAccount", 5000, 5000);
        assertThrows(InvalidAmount.class, () -> {
            bank.withdraw(bank.getAccounts()[0].getAccNumber(), 0);
        });
    }

    @Test
    public void test9() throws Exception {
        assertTrue(bank.display().size() == 0);
    }

    @Test
    public void test10() throws Exception {
        for(int i=0; i<100; i++){
            bank.addAccount("CurrentAccount", 7400, "83346");
        }
        assertNotEquals(0, bank.display().size());
    }

    @Test
    public void test11() throws Exception {
        for(int i=0; i<100; i++){
            bank.addAccount("CurrentAccount", 10000, "19302");
        }
        assertDoesNotThrow(()->{
            bank.withdraw(bank.getAccounts()[0].getAccNumber(), 5000);
        });
    }

    @Test
    public void test12() throws Exception {
        bank.addAccount("SavingsAccount", 10000, 10000);
        assertDoesNotThrow(()->{
            bank.deposit(bank.getAccounts()[0].getAccNumber(), 500);
        });
    }

    @Test
    public void test13() throws Exception {
        bank.addAccount("SavingsAccount", 4000, 500);
        assertThrows(InvalidAmount.class, ()-> {
            bank.deposit(bank.getAccounts()[0].getAccNumber(), -3000);
        });
    }
}
