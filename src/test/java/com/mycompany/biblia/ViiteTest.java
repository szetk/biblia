/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.biblia;

import java.util.ArrayList;
import java.util.HashMap;
import junit.framework.TestCase;

public class ViiteTest extends TestCase {
    
    public ViiteTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of Viite method, of class Viite.
     */
    public void testViite() {
        System.out.println("Viite");
        String id = "123";
        String author = "tekija";
        String title = "otsikko";
        String year = "0";
        Viite instance = new Viite(id, author, title, year);
        assertEquals(id, instance.get("id"));
        assertEquals(author, instance.get("author"));
        assertEquals(title, instance.get("title"));
        assertEquals(year, instance.get("year"));
        
    } 
    
    public void testToString(){
        Viite viite = new Viite();
        viite.set("viitetyyppi", "Book");
        viite.set("id", "1");
        viite.set("author", "tekija");
        viite.set("title", "otsikko");
        viite.set("julkaisija", "julkaisija");
        viite.set("year", "1999");
        
        assertEquals("@Book{ \"1\",\n" +
            "author = \"tekija\",\n" +
            "publisher = \"julkaisija\",\n" +
            "title = \"otsikko\",\n" +
            "year = \"1999\"\n" +
            "}\n", viite.toString());
    }

    /**
     * Test of muodostaKenttienHashmap method, of class Viite.
     */
    public void testMuodostaKenttienHashmap() {
        System.out.println("muodostaKenttienHashmap");
        HashMap<String, ArrayList<String>> result = Viite.muodostaKenttienHashmap();
        assertEquals(result.get("article").contains("pages"), true);
    }

}
