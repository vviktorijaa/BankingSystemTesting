package Pitest;

import Bank.CurrentAccount;
import org.junit.Test;
import static org.junit.Assert.assertThrows;

public class PitestCurrentAccount {

    @Test
    public void test(){   //Negated conditional killed
        assertThrows(Exception.class, () -> {
            CurrentAccount ca = new CurrentAccount("CurrentAccount", 1000, "TradeLicenseNumber");
        });
    }

    @Test
    public void test1() throws Exception {  //changed conditional boundary killed
        CurrentAccount ca = new CurrentAccount("CurrentAccount", 5000, "TradeLicenseNumber");
    }
}
