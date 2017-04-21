/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sleutelbarricade;

import java.util.UUID;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chris
 */
public class LevelTest {
    
    public LevelTest() {
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
     * Test of main method, of class Level.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Level.main(args);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of generate method, of class Level.
     */
    @Test
    public void testGenerate() {
        System.out.println("generate");
        int win = 1;
        Level.generate(win);
        assertArrayEquals(layout == level2);
        
    }

    /**
     * Test of check method, of class Level.
     */
    @Test
    public void testCheck() {
        System.out.println("check");
        int x = 0;
        int y = 0;
        UUID uuid = null;
        int sleutel = 0;
        int win = 0;
        boolean expResult = false;
        boolean result = Level.check(x, y, uuid, sleutel, win);
        assertEquals( "cant find the other code ", true, result);
        // TODO review the generated test code and remove the default call to fail.
    }
        

  
    
}
