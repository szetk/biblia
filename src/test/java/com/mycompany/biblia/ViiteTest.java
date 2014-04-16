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
        assertEquals(id, instance.getId());
        assertEquals(author, instance.getAuthor());
        assertEquals(title, instance.getTitle());
        assertEquals(year, instance.getYear());
        
    }

    /**
     * Test of setId method, of class Viite.
     */
    public void testSetId() {
        System.out.println("setId");
        String id = "123";
        Viite instance = new Viite();
        instance.setId(id);
        assertEquals(id, instance.getId());
    }

    /**
     * Test of setAuthor method, of class Viite.
     */
    public void testSetAuthor() {
        System.out.println("setAuthor");
        String author = "";
        Viite instance = new Viite();
        instance.setAuthor(author);
        assertEquals(author, instance.getAuthor());
    }

    /**
     * Test of setTitle method, of class Viite.
     */
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "";
        Viite instance = new Viite();
        instance.setTitle(title);
        assertEquals(title, instance.getTitle());
    }

    /**
     * Test of setYear method, of class Viite.
     */
    public void testSetYear() {
        System.out.println("setYear");
        String year = "0";
        Viite instance = new Viite();
        instance.setYear(year);
        assertEquals(year, instance.getYear());
    }

    /**
     * Test of setAddress method, of class Viite.
     */
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "";
        Viite instance = new Viite();
        instance.setAddress(address);
        assertEquals(address, instance.getAddress());
    }

    /**
     * Test of setPublisher method, of class Viite.
     */
    public void testSetPublisher() {
        System.out.println("setPublisher");
        String publisher = "";
        Viite instance = new Viite();
        instance.setPublisher(publisher);
        assertEquals(publisher, instance.getPublisher());
    }

    /**
     * Test of setJournal method, of class Viite.
     */
    public void testSetJournal() {
        System.out.println("setJournal");
        String journal = "";
        Viite instance = new Viite();
        instance.setJournal(journal);
        assertEquals(journal, instance.getJournal());
    }

    /**
     * Test of setNumber method, of class Viite.
     */
    public void testSetNumber() {
        System.out.println("setNumber");
        int number = 0;
        Viite instance = new Viite();
        instance.setNumber(number);
        assertEquals(number, instance.getNumber());
    }

    /**
     * Test of setVolume method, of class Viite.
     */
    public void testSetVolume() {
        System.out.println("setVolume");
        int volume = 0;
        Viite instance = new Viite();
        instance.setVolume(volume);
        assertEquals(volume, instance.getVolume());
    }

    /**
     * Test of setBooktitle method, of class Viite.
     */
    public void testSetBooktitle() {
        System.out.println("setBooktitle");
        String booktitle = "";
        Viite instance = new Viite();
        instance.setBooktitle(booktitle);
        assertEquals(booktitle, instance.getBooktitle());
    }

    /**
     * Test of setPages method, of class Viite.
     */
    public void testSetPages() {
        System.out.println("setPages");
        String pages = "";
        Viite instance = new Viite();
        instance.setPages(pages);
        assertEquals(pages, instance.getPages());
    }
    
    /**
     * Test of setViitetyyppi method, of class Viite.
     */
    public void testSetViitetyyppi() {
        System.out.println("setViitetyyppi");
        String pages = "";
        Viite instance = new Viite();
        instance.setViitetyyppi(pages);
        assertEquals(pages, instance.getViitetyyppi());
    }    

    /**
     * Test of getId method, of class Viite.
     */
    public void testGetId() {
        System.out.println("getId");
        Viite instance = new Viite();
        String expResult = "123";
        instance.setId(expResult);
        String result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAuthor method, of class Viite.
     */
    public void testGetAuthor() {
        System.out.println("getAuthor");
        Viite instance = new Viite();
        String expResult = "";
        instance.setAuthor(expResult);
        String result = instance.getAuthor();
        assertEquals(expResult, result);
    }

    /**
     * Test of getTitle method, of class Viite.
     */
    public void testGetTitle() {
        System.out.println("getTitle");
        Viite instance = new Viite();
        String expResult = "";
        instance.setTitle(expResult);
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getYear method, of class Viite.
     */
    public void testGetYear() {
        System.out.println("getYear");
        Viite instance = new Viite();
        String expResult = "0";
        instance.setYear(expResult);
        String result = instance.getYear();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAddress method, of class Viite.
     */
    public void testGetAddress() {
        System.out.println("getAddress");
        Viite instance = new Viite();
        String expResult = "";
        instance.setAddress(expResult);
        String result = instance.getAddress();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPublisher method, of class Viite.
     */
    public void testGetPublisher() {
        System.out.println("getPublisher");
        Viite instance = new Viite();
        String expResult = "";
        instance.setPublisher(expResult);
        String result = instance.getPublisher();
        assertEquals(expResult, result);
    }

    /**
     * Test of getJournal method, of class Viite.
     */
    public void testGetJournal() {
        System.out.println("getJournal");
        Viite instance = new Viite();
        String expResult = "";
        instance.setJournal(expResult);
        String result = instance.getJournal();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNumber method, of class Viite.
     */
    public void testGetNumber() {
        System.out.println("getNumber");
        Viite instance = new Viite();
        int expResult = 0;
        instance.setNumber(expResult);
        int result = instance.getNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getVolume method, of class Viite.
     */
    public void testGetVolume() {
        System.out.println("getVolume");
        Viite instance = new Viite();
        int expResult = 0;
        instance.setVolume(expResult);
        int result = instance.getVolume();
        assertEquals(expResult, result);
    }

    /**
     * Test of getBooktitle method, of class Viite.
     */
    public void testGetBooktitle() {
        System.out.println("getBooktitle");
        Viite instance = new Viite();
        String expResult = "";
        instance.setBooktitle(expResult);
        String result = instance.getBooktitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPages method, of class Viite.
     */
    public void testGetPages() {
        System.out.println("getPages");
        Viite instance = new Viite();
        String expResult = "";
        instance.setPages(expResult);
        String result = instance.getPages();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getViitetyyppi method, of class Viite.
     */
    public void testGetViitetyyppi() {
        System.out.println("getViitetyyppi");
        Viite instance = new Viite();
        String expResult = "";
        instance.setViitetyyppi(expResult);
        String result = instance.getViitetyyppi();
        assertEquals(expResult, result);
    }    
    
    public void testToString(){
        Viite viite = new Viite();
        viite.setViitetyyppi("Book");
        viite.setId("1");
        viite.setAuthor("tekija");
        viite.setTitle("otsikko");
        viite.setPublisher("julkaisija");
        viite.setYear("1999");
        
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
        Viite instance = new Viite();
        HashMap<String, ArrayList<String>> result = instance.muodostaKenttienHashmap();
        assertEquals(result.get("book").contains("id"), true);
        assertEquals(result.get("article").contains("pages"), true);
    }

}
