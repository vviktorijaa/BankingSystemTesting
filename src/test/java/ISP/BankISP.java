package ISP;

import Bank.Bank;
import Bank.BankAccount;
import Exceptions.AccNotFound;
import Exceptions.InvalidAmount;
import Exceptions.MaxBalance;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankISP {

    @Test
    public void test1() throws Exception { //addAcc - savings, current
        Bank b = new Bank();
        b.addAccount("SavingsAccount", 2500, 10000);
        assertEquals(1, b.addAccount("CurrentAccount", 6500, "tradeLicense556"));
    }

    @Test
    public void test2(){ //addAcc F OK
        Bank b = new Bank();
        assertEquals(0, b.addAccount(null));
    }

    @Test
    public void test3(){ //findAcc, addAcc TT OK
        Bank b = new Bank();
        BankAccount ba = new BankAccount("BankAccount", 4600, 100);
        b.addAccount(ba);
        assertNotNull(b.findAccount(b.getAccounts()[0].getAccNumber()));
    }

    @Test
    public void test4(){ //findAcc, studentAcc TF
        Bank b = new Bank();
        b.addAccount("StudentAccount", "Institution", 150000, 10000);
        assertNull(b.findAccount("390201"));
    }

    @Test
    public void test5() { //findAcc FF
        Bank b = new Bank();
        assertThrows(NullPointerException.class, () ->{
            b.findAccount(b.getAccounts()[0].getAccNumber());
        });
    }

    @Test
    public void test6(){ //display TT
        Bank b = new Bank();
        BankAccount ba = new BankAccount("Account", 8000, 50);
        b.addAccount(ba);
        assertTrue(b.display().size() != 0);
    }

    @Test
    public void test7(){ //display FF
        Bank b = new Bank();
        assertTrue(b.display().size() == 0);
    }

    @Test
    public void test8() throws InvalidAmount, AccNotFound { //deposit TTTT
        Bank b = new Bank();
        b.addAccount("Account", 5500, 10000);
        b.deposit(b.getAccounts()[0].getAccNumber(), 6000);
        assertTrue( b.getAccounts()[0].getBalance() == 11500);
    }

    @Test
    public void test9() throws InvalidAmount, AccNotFound { //deposit TTTF
        Bank b = new Bank();
        b.addAccount("Account", 5500, 10000);
        b.deposit(b.getAccounts()[0].getAccNumber(), 1000);
        assertEquals( 6500, b.getAccounts()[0].getBalance(), 0);
    }

    @Test
    public void test10() throws InvalidAmount, AccNotFound { //deposit TTFT
        Bank b = new Bank();
        b.addAccount("Account", 0, 10000);
        b.deposit(b.getAccounts()[0].getAccNumber(), 0);
        assertEquals( 0, b.getAccounts()[0].getBalance(), 0);
    }

    @Test
    public void test11() throws InvalidAmount, AccNotFound { //deposit TFTT
        Bank b = new Bank();
        b.addAccount("Account", 1000, 10000);
        assertThrows(AccNotFound.class, () ->{
            b.deposit("55739", 2000);
        });
    }

    @Test
    public void test12() throws InvalidAmount, AccNotFound { //deposit FFFF
        Bank b = new Bank();
        assertThrows(AccNotFound.class, () ->{
            b.deposit("11111", 0);
        });
    }

    @Test
    public void test13() throws Exception { //withdraw TTTT
        Bank b = new Bank();
        b.addAccount("CurrentAccount", 10000, "tradeLicense1111");
        assertThrows(MaxBalance.class, () ->{
            b.withdraw(b.getAccounts()[0].getAccNumber(), 11000);
        });
    }

    @Test
    public void test14() throws Exception { //withdraw TTTF
        Bank b = new Bank();
        b.addAccount("CurrentAccount2", 6000, "tradeLicense22222");
        b.withdraw(b.getAccounts()[0].getAccNumber(), 500);
        assertEquals(5500, b.getAccounts()[0].getBalance(), 0);
    }

    @Test
    public void test15() throws Exception { //withdraw TTFT
        Bank b = new Bank();
        BankAccount ba = new BankAccount("Account", 0, 0);
        BankAccount ba2 = new BankAccount("BankAccount2", 1500, 50);
        BankAccount [] bankAccounts = new BankAccount[2];
        bankAccounts[0] = ba;
        bankAccounts[1] = ba2;
        b.setAccounts(bankAccounts);
        assertThrows(MaxBalance.class, ()->{
            b.withdraw(b.getAccounts()[0].getAccNumber(), 0);
        });
    }

    @Test
    public void test16() throws Exception { //withdraw TFTT
        Bank b = new Bank();
        BankAccount ba = new BankAccount("BankAccount", 1500, 50);
        b.addAccount(ba);
        assertThrows(AccNotFound.class, ()->{
            b.withdraw("99999", 2000);
        });
    }

    @Test
    public void test17() throws Exception { //withdraw FFFF
        Bank b = new Bank();
        assertThrows(AccNotFound.class, ()->{
            b.withdraw("12345", 0);
        });
    }

    @Test
    public void test18(){ //getAcc account added F
        Bank b = new Bank();
        assertNull(b.getAccounts()[0]);
    }
}
