package LogicCoverage;

import org.junit.Test;
import Bank.CurrentAccount;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CurrentAccountLogicCov {

    //CoC

    @Test
    public void test() throws Exception {
        assertThrows(Exception.class, () -> {
            CurrentAccount ca = new CurrentAccount("AccountName", 4500, "tradeLicense");
        });
    }

    @Test
    public void test2() {
        assertDoesNotThrow(() -> {
            CurrentAccount ca = new CurrentAccount("AccountName", 5000, "tradeLicense");
        });
    }
}