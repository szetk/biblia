/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.biblia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author joni
 */
public class Lataa {

    private String tiedostoNimi;
    private Viite v;
    private BufferedReader reader;

    public Lataa(String tiedostoNimi) throws FileNotFoundException, IOException {
        this.tiedostoNimi = tiedostoNimi;
        this.reader = new BufferedReader(new FileReader(tiedostoNimi));

    }

    /**
     * Lataa tiedostosta YHDEN viitteen ja parsii sen rivi kerrallaan
     * stringeiksi, joista tokenisoidaan viitteelle annettavat muuttujat.
     *
     * Myöhemmin voidaan lisätä esimerkiksi tyhjyystarkastukset jos on tarvetta.
     *
     * @return 
     * @throws FileNotFoundException
     * @throws IOException
     */
    public boolean parsiKirja(){
        v = new Viite();
        try {
            String viitetyyppiJaId = reader.readLine();
            String delims = "[@{\"]+";
            String[] tokens = viitetyyppiJaId.split(delims);
            v.setViitetyyppi(tokens[1]);
            v.setId(tokens[3]);
            String author = reader.readLine();
            tokens = author.split(delims);
            v.setAuthor(tokens[1]);
            String publisher = reader.readLine();
            tokens = publisher.split(delims);
            v.setPublisher(tokens[1]);
            String title = reader.readLine();
            tokens = title.split(delims);
            v.setTitle(tokens[1]);
            String year = reader.readLine();
            tokens = year.split(delims);
            v.setYear(tokens[1]);
            String loppushaiba = reader.readLine(); // Jotta voidaan sit lukea seuraava
        } catch (Exception e) {
            System.out.println("Tiedoston luku on päättynyt");
            return false;
        }

        /*  System.out.println(v.getViitetyyppi());
         System.out.println(v.getId()); System.out.println(v.getAuthor());
         System.out.println(v.getPublisher());
         System.out.println(v.getTitle()); System.out.println(v.getYear());*/
        return true;

    }
    
    /**
     * Parsii tiedostosta stringiksi haettavan viitteen tiedot
     *
     * @return haettavan viitteen tiedot stringinä
     */
    public String tulostaHaetunViitteenTiedot(String id) {
        try {
            while(!reader.readLine().contains("{ \"" + id)){
                reader.readLine();
            }
            String seuraavarivi = "";
            while(!seuraavarivi.contains("}")){
                seuraavarivi = reader.readLine();
                System.out.println(seuraavarivi);
            }
        } catch (Exception e) {
            System.out.println("Viitettä ei löytynyt");
        }
        return "Viitettä ei löytynyt";
    }

    public Viite getViite() {
        return this.v;
    }
}
