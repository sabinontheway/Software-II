import java.util.LinkedList;
import java.util.Scanner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankCustomerTest {
    
    public BankCustomerTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


@Test
    public void testGetId() {
        System.out.println("getId");
        BankCustomer instance = new BankCustomer("100","Sabin", "Poudel","poud","poud","Texas");
        String expResult = "100";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(expResult != result)
        fail("The test case is a prototype.");
    }
    
    /**
     * Test of getUserName method, of class BankCustomer.
     */
    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        BankCustomer instance = new BankCustomer("100","Sabin", "Poudel","poud","poud","Texas");
        String expResult = "poud";
        String result = instance.getUserName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(expResult != result)
        fail("The test case is a prototype.");
    }
    