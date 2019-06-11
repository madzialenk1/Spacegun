/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jimp2egzaminylato2015;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel
 */
public class TowarTest {
    
    public TowarTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void testCompareTo() {
        System.out.println("compareTo");
        Towar o = new Towar("a", 10, 20);
        Towar instance = new Towar("b", 10, 20);
        int expResult = 1;
        int result = instance.compareTo(o);
        assertEquals(expResult, result);
    }

    @Test
    public void testEquals() {
        System.out.println("equals");
        Object o = null;
        Towar instance = null;
        boolean expResult = false;
        boolean result = instance.equals(o);
        assertEquals(expResult, result);
    }

    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Towar instance = null;
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
