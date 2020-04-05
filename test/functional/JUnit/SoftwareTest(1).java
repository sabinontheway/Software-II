import java.util.LinkedList;
import java.util.Scanner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class SoftwareTest {
    
    public SoftwareTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of getCustomerById method, of class Software.
     */
    @Test
    public void testGetCustomerById() {
        System.out.println("getCustomerById");
        String id = "100";
        Software instance = new Software();
        BankCustomer expResult = null;
        BankCustomer result = instance.getCustomerById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(expResult != result)
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerByUserPassword method, of class Software.
     */
    @Test
    public void testGetCustomerByUserPassword() {
        System.out.println("getCustomerByUserPassword");
        String user = "";
        String password = "";
        Software instance = new Software();
        BankCustomer expResult = null;
        BankCustomer result = instance.getCustomerByUserPassword(user, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
         if(expResult != result)
        fail("The test case is a prototype.");
    }


    /**
     * Test of hasAccountNumber method, of class Software.
     */
    @Test
    public void testHasAccountNumber() {
        System.out.println("hasAccountNumber");
        String accountNumber = "";
        Software instance = new Software();
        boolean expResult = false;
        boolean result = instance.hasAccountNumber(accountNumber);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(expResult != result)
        fail("The test case is a prototype.");
    }
    
}
