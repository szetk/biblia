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

    public void assertContains(String merkkijono, String sisaltaa) {
        if (merkkijono.contains(sisaltaa)) {
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }
    
    public void testTyhjaKentta(){
        Viite viite = new Viite("1", "tekija", "otsikko", "1999");
        viite.set("viitetyyppi", "Book");
        viite.set("publisher", "");
        
        assertContains(viite.toString(), "@Book{ 1,\n");
        assertContains(viite.toString(), "author = \"tekija\",\n");
        assertContains(viite.toString(), "title = \"otsikko\",\n");
        assertContains(viite.toString(), "publisher = \"\",\n");
        assertContains(viite.toString(), "year = \"1999\"\n}\n");
        
    }
    

    
    public void testPuuttuvaKentta(){
        Viite viite = new Viite();
        assertEquals("Viitteellä ei ole kaikkia pakollisia kenttiä", viite.toString());
    }
    
    public void testPuuttuvaKentta2(){
        Viite viite = new Viite();
        viite.set("id", "2");
        viite.set("author", "tekija");
        assertEquals("Viitteellä ei ole kaikkia pakollisia kenttiä", viite.toString());
    }
    public void testPuuttuvaKentta3(){
        Viite viite = new Viite("1", "tekija", "otsikko", "1999");
        // huom! ei ole annettu viitetyyppiä
        assertEquals("Viitteellä ei ole kaikkia pakollisia kenttiä", viite.toString());
    }
        public void testPuuttuvaKentta4(){
        Viite viite = new Viite("1", "tekija", "", "1999");
        viite.set("viitetyyppi", "Book");
        assertContains(viite.toString(), "Viitteellä ei ole kaikkia pakollisia kenttiä");
    }

    public void testToString() {
        Viite viite = new Viite();
        viite.set("viitetyyppi", "Book");
        viite.set("id", "1");
        viite.set("author", "tekija");
        viite.set("publisher", "julkaisija");
        viite.set("title", "otsikko");
        viite.set("year", "1999");

        assertContains(viite.toString(), "@Book{ 1,\n");
        assertContains(viite.toString(), "author = \"tekija\",\n");
        assertContains(viite.toString(), "title = \"otsikko\",\n");
        assertContains(viite.toString(), "publisher = \"julkaisija\",\n");
        assertContains(viite.toString(), "year = \"1999\"\n}\n");

        assertEquals("@Book{ 1,\n"
                + "author = \"tekija\",\n"
                + "title = \"otsikko\",\n"
                + "publisher = \"julkaisija\",\n"
                + "year = \"1999\"\n"
                + "}\n", viite.toString());

    }

    public void testSet() {
        Viite v = new Viite();
        v.set("journal", "jallu");
        assertEquals(v.getKentat().get("journal"), "jallu");
    }

    public void testGet() {
        Viite v = new Viite();
        v.getKentat().put("journal", "jallu");
        assertEquals(v.get("journal"), "jallu");
    }

    public void testOnPakollisetKentat() {
        Viite v = new Viite();
        
        assertTrue(!v.onPakollisetKentat());
        v.getKentat().put("id", "2");
        assertTrue(!v.onPakollisetKentat());
        
        v.getKentat().put("author", "kalle");
        assertTrue(!v.onPakollisetKentat());

        v.getKentat().put("title", "n leikkikalut");
        assertTrue(!v.onPakollisetKentat());

        v.getKentat().put("year", "1969");
        assertTrue(!v.onPakollisetKentat());
        
        v.getKentat().put("viitetyyppi", "article");
        assertTrue(v.onPakollisetKentat());

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
