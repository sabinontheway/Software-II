import java.util.Scanner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankServiceTest {
    
    public BankServiceTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCustomerLoginInput method, of class BankService.
     */
    @Test
    public void testGetCustomerLoginInput() {
        System.out.println("getCustomerLoginInput");
        Scanner scanner = new Scanner("1");
        int expResult = 1;
        int result = BankService.getCustomerLoginInput(scanner);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (expResult != result)
        fail("The test case is a prototype.");
    }
    /**
     * Test of getNewAccountNumber method, of class BankService.
     */
    @Test
    public void testGetNewAccountNumber() {
        System.out.println("getNewAccountNumber");
        Software bankCustomers = new Software();
        String expResult = "100";
        String result = BankService.getNewAccountNumber(bankCustomers);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (expResult != result)
        fail("The test case is a prototype.");
    }
    
}
