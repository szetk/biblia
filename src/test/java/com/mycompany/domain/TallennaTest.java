/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.domain;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import junit.framework.TestCase;

/**
 *
 * @author szetk
 */
public class TallennaTest extends TestCase {

    private Tallenna tallenna;

    public TallennaTest(String testName) {
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

    public void testKonstruktori() {
        this.tallenna = new Tallenna("@Book{ \"" + "a3" + "\", \nauthor = \"" + "Pekka" + "\",\n"
                + "publisher  = \"" + "WSOY" + "\", \n"
                + "title  = \"" + "Kissan muistelmat" + "\", \n"
                + "year   = \"" + "2017" + "\"\n }");

        assertEquals(tallenna.tallennettava, "@Book{ \"" + "a3" + "\", \nauthor = \"" + "Pekka" + "\",\n"
                + "publisher  = \"" + "WSOY" + "\", \n"
                + "title  = \"" + "Kissan muistelmat" + "\", \n"
                + "year   = \"" + "2017" + "\"\n }");
    }

    public void testTallennaTiedostoon() throws IOException {
        String tiedostonNimi = "testifile.bib";

        PrintWriter kirjoittaja = new PrintWriter(tiedostonNimi);
        kirjoittaja.write("");
        kirjoittaja.close();

        this.tallenna = new Tallenna("Testiteksti");
        this.tallenna.tallennaTiedostoon(tiedostonNimi);

        Scanner lukija = new Scanner(new File(tiedostonNimi));
        if (lukija.hasNextLine()) {
            assertEquals(lukija.nextLine(), "Testiteksti");
        } else {
            fail("Tiedostoon tallennus ei onnistunut");
        }

        lukija.close();

    }

}
