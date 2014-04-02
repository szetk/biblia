
package com.mycompany.biblia;

import junit.framework.TestCase;
import static org.junit.Assert.*;



public class InteractiveCommandlineTest extends TestCase {
    InteractiveCommandline cmd;
   
    @Override
    public void setUp() throws Exception {
        cmd = new InteractiveCommandline();
    }
    
    public void valitaanLisays(){
        
    }
    

    /**
     * Test of run method, of class InteractiveCommandline.
     */
    public void testRun() {
        System.out.println("run");
        InteractiveCommandline instance = new InteractiveCommandline();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
