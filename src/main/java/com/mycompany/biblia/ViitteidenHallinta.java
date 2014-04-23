/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.biblia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author szetk
 */
public class ViitteidenHallinta {

    private ArrayList<Viite> viitteet;

    public ViitteidenHallinta() {
        this.viitteet = new ArrayList<Viite>();
    }

    public ArrayList<Viite> getViitteet() {
        return viitteet;
    }

    public void lataaViitteetTiedostosta(String tiedostonNimi) throws IOException {
        Lataa lataa = new Lataa(tiedostonNimi);
        while (lataa.parsiViite()) {
            Viite viite = lataa.getViite();
            viitteet.add(viite);
        }

    }

    public void tallennaViitteetTiedostoon(String tiedostonNimi) throws FileNotFoundException {
        PrintWriter kirjoittaja = new PrintWriter(tiedostonNimi);
        kirjoittaja.write(""); // tiedoston tyhjennys
        kirjoittaja.close();
        for (Viite ref : viitteet) {
            Tallenna save = new Tallenna(ref.toString());
            save.tallennaTiedostoon(tiedostonNimi);
        }
    }

    public void talleta(Viite viite) {
        this.viitteet.add(viite);
    }

    public void korvaa(Viite viite) {
        poista(viite);
        this.viitteet.add(viite);
    }

    public void poista(Viite viite) {
        for (int i = 0; i < this.viitteet.size(); i++) {
            if (this.viitteet.get(i).get("id").equals(viite.get("id"))) {
                this.viitteet.remove(i);
                break;
            }
        }
    }

    public Viite hae(String haettavaId) {
        for (Viite viite : this.viitteet) {
            if (viite.get("id").equals(haettavaId)) {
                return viite;
            }
        }
        System.out.println("Viitettä ei löytynyt");
        Viite failed = new Viite();
        failed.setViitetyyppi("failed");
        return failed;
    }

}
