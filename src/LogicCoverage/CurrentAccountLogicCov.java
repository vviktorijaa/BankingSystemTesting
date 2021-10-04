package LogicCoverage;

import org.junit.Test;
import Bank.CurrentAccount;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CurrentAccountLogicCov {

    @Test
    public void test() throws Exception {
        assertThrows(Exception.class, () -> {
            CurrentAccount ca = new CurrentAccount("AccountName", 4500, "tradeLicense");
        });
    }

    @Test
    public void test2() throws Exception {
        //assert does not throw
    }
}
