package GraphCoverage;

import Bank.Bank;
import org.junit.Test;
import Exceptions.AccNotFound;
import Exceptions.InvalidAmount;
import Exceptions.MaxBalance;
import static org.junit.Assert.*;

public class BankGraphCov {

    //PPC

    @Test
    public void testAddAccount(){       //[1,2,3,4,5]
        Bank b = new Bank();
        assertEquals(0, b.addAccount(null));
    }

    @Test
    public void testAddAccount2(){      //[1,2,3,5]
        Bank b = new Bank();

    }

    @Test
    public void testFindAccount2(){     //[1,2,3,4,7]
        Bank b = new Bank();
        assertNull(b.findAccount("AccNum"));
    }

    @Test
    public void testFindAccount3(){     //[1,2,3,4,5,6]
        Bank b = new Bank();
        b.addAccount("Acc", 15000, 3000);
        assertNotNull(b.findAccount(b.getAccounts()[0].getAccNumber()));
    }

    @Test
    public void testDeposit() throws Exception {      //[1,2,5]
        Bank b = new Bank();
        b.addAccount("AccountName", 6500, "tradeLicense");
        assertThrows(InvalidAmount.class, () -> {
            b.deposit(b.getAccounts()[0].getAccNumber(), -100);
        });
    }

    @Test
    public void testDeposit2(){      //[1,2,3,6]
        Bank b = new Bank();
        assertThrows(AccNotFound.class, () -> {
            b.deposit("6789", 1000);
        });
    }

    @Test
    public void testWithdraw(){     //[1,2,6]
        Bank b = new Bank();
        assertThrows(AccNotFound.class, () -> {
            b.withdraw("accNum", 500);
        });
    }

    @Test
    public void testWithdraw2(){     //[1,2,3,4,7]
        Bank b = new Bank();
        b.addAccount("Acc", 4000, 10000);
        assertThrows(InvalidAmount.class, () -> {
            b.withdraw(b.getAccounts()[0].getAccNumber(), 0);
        });
    }

    @Test
    public void testWithdraw3(){     //[1,2,3,4,5]
        Bank b = new Bank();
        b.addAccount("AccName", "HighSchool", 10000, 500);
        assertThrows(MaxBalance.class, () -> {
            b.withdraw(b.getAccounts()[0].getAccNumber(), 15000);
        });
    }

    @Test
    public void testDisplay2(){      //[1,2,3,5]
        Bank b = new Bank();
        assertEquals(0, b.display().getSize());
    }
}
