/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.domain;

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
    
    public Tallenna(String tallennaTama)  {
        this.tallennettava = tallennaTama;
    }
    
    public void tallennaTiedostoon() {
        File f = new File("Biblia.bib");
        try {
        Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f, true)));
        writer.write(tallennettava);
        writer.flush();
        writer.close();
        } catch (IOException ex) {
        System.out.println(ex);
    }
    
    
    }
}
