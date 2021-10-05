package GraphCoverage;

import Bank.CurrentAccount;
import org.junit.Test;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CurrentAccountGraphCov {

    @Test
    public void testConstructor(){      //[1,2]
        assertDoesNotThrow(() -> {
            CurrentAccount ca = new CurrentAccount("CurrentAccount", 5000, "16569");
        });
    }

    @Test
    public void testConstructor2(){      //[1,3]
        assertThrows(Exception.class, () -> {
            CurrentAccount ca = new CurrentAccount("CurrentAccount", 2000, "181818");
        });
    }
}