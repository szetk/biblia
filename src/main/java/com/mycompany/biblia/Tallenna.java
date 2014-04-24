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
import java.io.Writer;

/**
 *
 * @author joni
 */
public class Tallenna {

    String tallennettava;

    public Tallenna(String tallennaTama) {
        this.tallennettava = tallennaTama;
    }

    public void tallennaTiedostoon(String tiedostonNimi) {
        System.out.println("Tallennetaan tiedostoon " + tiedostonNimi);
        File f = new File(tiedostonNimi);
        try {
            Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f, true)));
            String aatKorvattu = tallennettava.replace("ä", "\\\"{a}");
            String ootkinKorvattu = aatKorvattu.replace("ö", "\\\"{o}");
            writer.append(ootkinKorvattu);
            writer.flush();
            writer.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }

    }
}
