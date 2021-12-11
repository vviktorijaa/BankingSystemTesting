package GraphCoverage;

import Bank.CurrentAccount;
import org.junit.Test;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CurrentAccountGraphCov {

    //PPC

    @Test
    public void testConstructor(){      //[1,2,3]
        assertDoesNotThrow(() -> {
            CurrentAccount ca = new CurrentAccount("CurrentAccount", 5000, "16569");
        });
    }

    @Test
    public void testConstructor2(){      //[1,2,4]
        assertThrows(Exception.class, () -> {
            CurrentAccount ca = new CurrentAccount("CurrentAccount", 2000, "181818");
        });
    }
}