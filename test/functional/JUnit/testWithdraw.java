import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class AccountTest {
    
    public AccountTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of withdraw method, of class Account.
     */
    @Test
    public void testWithdraw() {
        System.out.println("withdraw");
        float amount = 0.0F;
        Account instance = new Account("100",2000);
        boolean expResult = true;
        boolean result = instance.withdraw(20);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if (expResult != result)
        fail("The test case is a prototype.");
    }


    /**
     * Test of getType method, of class Account.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Account instance = new Account("100",2000);
        String expResult = "";
        String result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        if(expResult != result)
        fail("The test case is a prototype.");
    }

}
