/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.biblia;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import junit.framework.TestCase;

/**
 *
 * @author szetk
 */
public class LataaTest extends TestCase {

    private Lataa lataaja;

    public LataaTest(String testName) {
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



    public void testLataaTiedostosta() throws IOException {
       lataaja = new Lataa("lataa_testitiedosto.txt");
        lataaja.parsiKirja();
        Viite v = lataaja.getViite();
        assertEquals(v.getAuthor(),"ville");
        assertEquals(v.getTitle(),"testi");
        assertEquals(v.getYear(),"2014");
    }
     public void testEpaonnistunutLataus() throws Exception{
        lataaja = new Lataa("lataa_vaara_tiedosto.txt");
        assertEquals(lataaja.parsiKirja(),false);
    }

}
