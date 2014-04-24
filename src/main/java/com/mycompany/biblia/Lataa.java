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
    public boolean parsiViite() {
        v = new Viite();
        String nextLine = "";
        String[] tokens;
        String delims = "[@{}\"]+";
        try {
            nextLine = reader.readLine();
            nextLine = nextLine.replaceAll("\\s+", "");
            while (!nextLine.contains("@")) { //rivinvaihdot pois
                nextLine = reader.readLine();
            }
               // System.out.println("nextLine: "+nextLine);
                tokens = nextLine.split(delims);
                v.set("viitetyyppi", tokens[1].toLowerCase());
                v.set("id", tokens[2].substring(0, tokens[2].length() - 1)); //pilkku pois
                boolean viimeinenRivi = true;
                while (viimeinenRivi) {
                    nextLine = reader.readLine();
                   //  System.out.println("nextLine: "+nextLine);
                    String loppu = nextLine.replaceAll("\\s+", ""); //kokeillaan onko lopetus, whitespacet pois jolloin ensimmäinen merkki on }
                    if (loppu.charAt(0) == '}') {
                        viimeinenRivi = false;
                    } else {
                        tokens = nextLine.split(delims);
                        String avain = tokens[0].replaceAll("\\s+", "").toLowerCase(); //whitespacet pois ja capsit veks avaimesta
                        avain = avain.substring(0, avain.length() - 1); // '='-merkki pois
                        while (tokens[1].charAt(tokens[1].length() - 1) == ',' || tokens[1].charAt(tokens[1].length() - 1) == '}') { //pilkku ja sulut pois lopusta
                            tokens[1] = tokens[1].substring(0, tokens[1].length() - 1);
                        }
                        v.set(avain, tokens[1]);
                    }

                }
            
          //  System.out.println(v);
            /*
             * String viitetyyppiJaId = reader.readLine();
             *
             * String[] tokens = viitetyyppiJaId.split(delims);
             *
             * v.setViitetyyppi(tokens[1]); v.setId(tokens[3]); String author =
             * reader.readLine(); tokens = author.split(delims);
             * v.setAuthor(tokens[1]); String publisher = reader.readLine();
             * tokens = publisher.split(delims); System.out.println(tokens[0]);
             * v.setPublisher(tokens[1]); String title = reader.readLine();
             * tokens = title.split(delims); v.setTitle(tokens[1]); String year
             * = reader.readLine(); tokens = year.split(delims);
             * v.setYear(tokens[1]); String loppushaiba = reader.readLine(); //
             * Jotta voidaan sit lukea seuraava
             */


        } catch (Exception e) {
            System.out.println("Tiedosto luettu");
            return false;
        }

        /*
         * System.out.println(v.getViitetyyppi());
         * System.out.println(v.getId()); System.out.println(v.getAuthor());
         * System.out.println(v.getPublisher());
         * System.out.println(v.getTitle()); System.out.println(v.getYear());
         */
        return true;

    }

    /**
     * Parsii tiedostosta haettavan viitteen Viite-olioksi
     *
     * Käyttää this.v-oliota...
     */
    /*
     * public void muodostaViite(String id) {
     *
     * try { String rivi = ""; while (true) { if (rivi.contains("{ \"" + id)) {
     * reader.reset(); parsiViite(); this.v.set("id",id); return; }
     * reader.mark(1000); rivi = reader.readLine(); }
     *
     * // String seuraavarivi = ""; // while(!seuraavarivi.contains("}")){ //
     * seuraavarivi = reader.readLine(); // System.out.println(seuraavarivi); //
     * } } catch (Exception e) { System.out.println("Viitettä ei löytynyt"); } }
     */
    public Viite getViite() {
        return this.v;
    }
}
