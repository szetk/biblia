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

    public Lataa(String tiedostoNimi) {
        this.tiedostoNimi = tiedostoNimi;
    }

    /**
     * Lataa tiedostosta YHDEN viitteen ja parsii sen rivi kerrallaan
     * stringeiksi, joista tokenisoidaan viitteelle annettavat muuttujat.
     *
     * Myöhemmin voidaan lisätä esimerkiksi tyhjyystarkastukset jos on tarvetta.
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public boolean parsiKirja() throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader(tiedostoNimi));
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
        } catch (Exception e) {
            System.out.println("Virhe tiedostoa luettaessa");
            return false;
        }
        
          System.out.println(v.getViitetyyppi());
         System.out.println(v.getId()); System.out.println(v.getAuthor());
        System.out.println(v.getPublisher());
         System.out.println(v.getTitle()); System.out.println(v.getYear());
        return true;

        
         
    }

    public Viite getViite() {
        return this.v;
    }
}
