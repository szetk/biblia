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
            nextLine = reader.readLine().replaceAll("\\s+", "");
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
                tokens = nextLine.split("[=]+");
                String avain = tokens[0].replaceAll("\\s+", "").toLowerCase(); //whitespacet pois ja capsit veks avaimesta

                String arvo = tokens[1];
                while (arvo.charAt(arvo.length() - 1) == ',' || arvo.charAt(arvo.length() - 1) == '}') { //pilkku ja sulut pois lopusta
                    arvo = arvo.substring(0, arvo.length() - 1);
                }
                arvo = arvo
                    .replaceAll("^\\s*[\"{]", "")
                    .replaceAll("[}\"]\\s*$", "")
                    .replaceAll("\\\\\"[{]o[}]", "ö")
                    .replaceAll("\\\\\"[{]a[}]", "ä");
                v.set(avain, arvo);
            }

        }


    } catch (Exception e) {
        System.out.println("Tiedosto luettu");
        return false;
    }

    return true;

}

    /**
     * Parsii tiedostosta haettavan viitteen Viite-olioksi
     *
     * Käyttää this.v-oliota...
     */
    public Viite getViite() {
        return this.v;
    }
}
