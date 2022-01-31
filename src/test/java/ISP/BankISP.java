package ISP;

import Bank.Bank;
import Bank.BankAccount;
import Exceptions.AccNotFound;
import Exceptions.InvalidAmount;
import Exceptions.MaxBalance;
import Exceptions.MaxWithdraw;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BankISP {

    //BCC

    //addAccount method

    @Test
    public void test1(){    //C1-T
        Bank b = new Bank();
        BankAccount ba = new BankAccount();
        BankAccount ba2 = new BankAccount();
        b.addAccount(ba);
        assertEquals(1, b.addAccount(ba2));
    }

    @Test
    public void test2(){    //C1-F
        Bank b = new Bank();
        BankAccount ba = null;
        assertEquals(0, b.addAccount(ba));
    }

    //addAccount method

    @Test
    public void test3(){    //C2-T
        Bank b = new Bank();
        b.addAccount("Account123", 6500, 2500);
        assertEquals(1, b.addAccount("Account154", 5050, 1000));
    }

    @Test
    public void test4(){    //C2-F
        Bank b = new Bank();
        //TODO
    }

    //addAccount method

    @Test
    public void test5() throws Exception {    //C2-T C4-F
        Bank b = new Bank();
        b.addAccount("Account832", 5000, "935002");
        assertEquals(1, b.addAccount("Account743", 5100, "123557"));
    }

    @Test
    public void test6() throws Exception {    //C3-F C4-T
        Bank b = new Bank();
        assertThrows(Exception.class, () -> {
            b.addAccount("CurrentAccount567", 4500, "657555");
        });
    }

    //addAccount method

    @Test
    public void test7() {    //C5-T
        Bank b = new Bank();
        b.addAccount("StudentAccount1", "Institution1", 10500, 0);
        assertEquals(1, b.addAccount("StudentAccount2", "Institution2", 7000, 0));
    }

    @Test
    public void test8() {    //C5-F
        Bank b = new Bank();
        //TODO
    }

    //findAccount method

    @Test
    public void test9() {    //C1-T C6-T
        Bank b = new Bank();
        BankAccount ba = new BankAccount("BankAccount", 4000, 0);
        b.addAccount(ba);
        assertNotNull(b.findAccount(ba.getAccNumber()));
    }

    @Test
    public void test10() {    //C1-T C6-F
        Bank b = new Bank();
        BankAccount ba = new BankAccount("BankAccount", 4000, 0);
        b.addAccount(ba);
        assertNull(b.findAccount("12556"));
    }

    @Test
    public void test11() {    //C1-F C6-F
        Bank b = new Bank();
        assertNull(b.findAccount("55629"));
    }

    //deposit method

    @Test
    public void test12() {    //C1-T C6-T C7-T C8-T
        Bank b = new Bank();
        BankAccount ba = new BankAccount("BankAccount778", -500, -1000);
        b.addAccount(ba);
        assertThrows(InvalidAmount.class, () -> {
            b.deposit(b.getAccounts()[0].getAccNumber(), -100);
        });
    }

    @Test
    public void test13() {    //C1-T C6-T C7-T C8-F
        Bank b = new Bank();
        BankAccount ba = new BankAccount("BankAccount123", 2300, -1000);
        b.addAccount(ba);
        assertDoesNotThrow(() -> {
            b.deposit(b.getAccounts()[0].getAccNumber(), 2500);
        });
    }

    @Test
    public void test14() {    //C1-T C6-T C7-F C8-T
        Bank b = new Bank();
        BankAccount ba = new BankAccount("BankAccount001", 0, -1000);
        b.addAccount(ba);
        assertThrows(InvalidAmount.class, () -> {
            b.deposit(b.getAccounts()[0].getAccNumber(), -500);
        });
    }

    @Test
    public void test15() {    //C1-T C6-F C7-T C8-T
        Bank b = new Bank();
        BankAccount ba = new BankAccount("BankAccount002", -2500, -10000);
        b.addAccount(ba);
        assertThrows(InvalidAmount.class, () -> {
            b.deposit("12557", -2000);
        });
    }

    @Test
    public void test16() {    //C1-T C6-T C7-F C8-F
        Bank b = new Bank();
        BankAccount ba = new BankAccount("BankAccount002", 3500, -100);
        b.addAccount(ba);
        assertDoesNotThrow(() -> {
            b.deposit(b.getAccounts()[0].getAccNumber(), 1500);
        });
    }

    //withdraw method

    @Test
    public void test17() {    //C2-T C6-T C9-T C10-T C11-T
        Bank b = new Bank();
        b.addAccount("SavingsAccount", -1000, 0);
        assertThrows(MaxWithdraw.class, () -> {
            b.withdraw(b.getAccounts()[0].getAccNumber(), 0);
        });
    }

    @Test
    public void test18() {    //C2-T C6-T C9-T C10-T C-11-F
        Bank b = new Bank();
        b.addAccount("SavingsAccount", 0, 1000);
        assertThrows(MaxBalance.class, () -> {
            b.withdraw(b.getAccounts()[0].getAccNumber(), 0);
        });
    }

    @Test
    public void test19() {    //C2-T C6-T C9-F C10-F C11-T
        Bank b = new Bank();
        b.addAccount("SavingsAccount", 500, 1000);
        assertThrows(MaxWithdraw.class, () -> {
            b.withdraw(b.getAccounts()[0].getAccNumber(), 1100);
        });
    }

    @Test
    public void test20() {    //C2-T C6-T C9-F C10-T C11-T
        Bank b = new Bank();
        b.addAccount("SavingsAccount", 10000, 0);
        assertThrows(MaxWithdraw.class, () -> {
            b.withdraw(b.getAccounts()[0].getAccNumber(), 0);
        });
    }

    @Test
    public void test21() {    //C2-T C6-F C9-T C10-T C11-T
        Bank b = new Bank();
        b.addAccount("SavingsAccount", -10000, -1000);
        assertThrows(AccNotFound.class, () -> {
            b.withdraw("11111", 0);
        });
    }

    @Test
    public void test22() {    //C2-T C6-T C9-F C10-F C11-F
        Bank b = new Bank();
        b.addAccount("SavingsAccount", 2500, 2000);
        assertDoesNotThrow(() -> {
            b.withdraw(b.getAccounts()[0].getAccNumber(), 100);
        });
    }

    //display method

    @Test
    public void test23(){    //C2-T C12-T
        Bank b = new Bank();
        b.addAccount("SavingsAccount", 1000, 500);
        assertNotNull(b.display());
    }

    @Test
    public void test24(){    //C2-F C12-F
        Bank b = new Bank();
        assertTrue(b.display().isEmpty());
    }

    //getAccounts method

    @Test
    public void test25(){    //C5-T C13-T
        Bank b = new Bank();
        b.addAccount("StudentAccount", "Institution", 3400, 0);
        assertNotNull(b.getAccounts()[0]);
    }

    @Test
    public void test26(){    //C5-F C13-F
        Bank b = new Bank();
        assertNull(b.getAccounts()[0]);
    }

    //setAccounts method

    @Test
    public void test27(){    //C5-T C14-T
        Bank b = new Bank();
        b.addAccount("StudentAccount", "Institution", 3700, 0);
        BankAccount[] accounts = new BankAccount[1];
        accounts[0] = b.findAccount(b.getAccounts()[0].getAccNumber());
        assertDoesNotThrow(() -> {
            b.setAccounts(accounts);
        });
    }

    @Test
    public void test28(){    //C5-F C14-F failure
        Bank b = new Bank();
        assertThrows(NullPointerException.class, () -> {
            b.setAccounts(null);
        });
    }
}
