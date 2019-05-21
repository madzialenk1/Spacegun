/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spacegun;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Konrad
 */
public class ACanvasTest {
    
    public ACanvasTest() {
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

    /**
     * Test of drawImage method, of class ACanvas.
     */
    @Test
    public void testDrawImage() {
        System.out.println("drawImage");
        ACanvas instance = null;
        instance.drawImage();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of run method, of class ACanvas.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        ACanvas instance = null;
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ACanvasImpl extends ACanvas {

        public ACanvasImpl() {
            super(0, 0);
        }

        public void drawImage() {
        }
    }
    
}
