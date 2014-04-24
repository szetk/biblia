/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.biblia;

import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.fail;
import junit.framework.TestCase;

/**
 *
 * @author szetk
 */
public class ViitteidenHallintaTest extends TestCase {

    public ViitteidenHallintaTest(String testName) {
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

    public void testTrue() {
        assertEquals(3, 3);
    }

    public void testTallennaTiedostoon() {
        ViitteidenHallinta v = new ViitteidenHallinta();
        Viite viite = new Viite("aa", "Pekka", "Kala", "1923");
        Viite viite2 = new Viite("bb", "B-pekka", "Kala", "2013");
        viite.set("viitetyyppi", "Book");
        viite2.set("viitetyyppi", "article");
        v.getViitteet().add(viite);
        v.getViitteet().add(viite2);
        try {
            String tiedostonNimi = "testifile.bib";

            PrintWriter kirjoittaja = new PrintWriter(tiedostonNimi);
            kirjoittaja.write("");
            kirjoittaja.close();

            v.tallennaViitteetTiedostoon(tiedostonNimi);

            Scanner lukija = new Scanner(new File(tiedostonNimi));
            if (lukija.hasNextLine()) {
                assertEquals(lukija.nextLine(), "@Book{ aa,");
                assertEquals(lukija.nextLine(), "author = \"Pekka\",");
                assertEquals(lukija.nextLine(), "title = \"Kala\",");
                assertEquals(lukija.nextLine(), "year = \"1923\"");
                assertEquals(lukija.nextLine(), "}");
                assertEquals(lukija.nextLine(), "@article{ bb,");
            } else {
                fail("Tiedostoon tallennus ei onnistunut");
            }

            lukija.close();
        } catch (FileNotFoundException ex) {
        }

    }

    public void testLataaTiedostosta() throws IOException {
        ViitteidenHallinta v = new ViitteidenHallinta();

        v.lataaViitteetTiedostosta("lataa_testitiedosto.txt");

        Viite viite = v.getViitteet().get(0);
        assertEquals(viite.get("viitetyyppi"), "book");
        assertEquals(viite.get("author"), "ville");
        assertEquals(viite.get("title"), "testi");
        assertEquals(viite.get("year"), "2014");
        assertEquals(viite.get("publisher"), "null");

    }

    public ViitteidenHallinta generoiViitteidenHallinta() {
        ViitteidenHallinta v = new ViitteidenHallinta();
        Viite viite = new Viite("aa", "Pekka", "Kala", "1923");
        v.getViitteet().add(viite);
        return v;
    }

    public void testTalleta() {
        ViitteidenHallinta v = new ViitteidenHallinta();
        Viite viite = new Viite("aa", "Pekka", "Kala", "1923");
        v.talleta(viite);
        assertEquals(v.getViitteet().get(0), viite);
    }

    public void testMuokkaa() {
        ViitteidenHallinta v = generoiViitteidenHallinta();
        Viite viite = new Viite("aa", "Koski", "Kossu", "1923");
        v.korvaa(viite);
        assertEquals(v.getViitteet().get(0), viite);
    }

    public void testPoista() {
        ViitteidenHallinta v = generoiViitteidenHallinta();
        Viite viite = new Viite("aa", "Katri Helena", "Kala", "1923");
        v.poista(viite);
        assertEquals(v.getViitteet().size(), 0);
    }

    public void testHae() {
        ViitteidenHallinta v = new ViitteidenHallinta();
        Viite viite = new Viite("aa", "Pekka", "Kala", "1923");
        v.getViitteet().add(viite);
        Viite viite2 = v.hae("aa");
        assertEquals(viite, viite2);
    }
}
