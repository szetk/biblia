/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.biblia;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author kazkaupp
 */
public class Viite {

    private HashMap<String, String> kentat;

    /**
     *
     * @param id
     * @param author
     * @param title
     * @param year
     */
    public Viite(String id, String author, String title, String year) {
        //Muut kuin nämä (pakolliset) asetetaan erikseen

//        this.id = id;
//        this.author = author;
//        this.title = title;
//        this.year = year;
        this.kentat = new HashMap<String, String>();
        this.kentat.put("id", id);
        this.kentat.put("author", id);
        this.kentat.put("title", id);
        this.kentat.put("year", id);
    }

    /**
     *
     */
    public Viite() {
    }

    /**
     * Muodostetaan HashMap jossa jokaiselle viitetyypille ArrayList joka
     * sisältää kyseisen viitetyypin kentät. Mahdolliset viitetyypit (eli keyt):
     * book, article, inproceedings
     *
     * @return HashMap
     */
    public static HashMap<String, ArrayList<String>> muodostaKenttienHashmap() {
        HashMap<String, ArrayList<String>> kentat = new HashMap<String, ArrayList<String>>();

        ArrayList<String> kirjanKentat = new ArrayList<String>();
        //kirjanKentat.add("id");
        kirjanKentat.add("author");
        kirjanKentat.add("title");
        kirjanKentat.add("year");
        kirjanKentat.add("address");
        kirjanKentat.add("publisher");

        ArrayList<String> articlenKentat = new ArrayList<String>();
        // articlenKentat.add("id");
        articlenKentat.add("author");
        articlenKentat.add("title");
        articlenKentat.add("year");
        articlenKentat.add("address");
        articlenKentat.add("publisher");
        articlenKentat.add("pages");
        articlenKentat.add("journal");
        articlenKentat.add("volume");
        articlenKentat.add("number");

        ArrayList<String> inprocKentat = new ArrayList<String>();
        //inprocKentat.add("id");
        inprocKentat.add("author");
        inprocKentat.add("title");
        inprocKentat.add("year");
        inprocKentat.add("address");
        inprocKentat.add("publisher");
        inprocKentat.add("booktitle");
        inprocKentat.add("pages");

        kentat.put("book", kirjanKentat);
        kentat.put("article", articlenKentat);
        kentat.put("inproceedings", inprocKentat);

        return kentat;
    }

    public boolean onPakollisetKentat() {
        if (this.kentat.get("id") == null) {
            return false;
        } else if (this.kentat.get("author") == null) {
            return false;
        } else if (this.kentat.get("title") == null) {
            return false;
        } else if (this.kentat.get("year") == null) {
            return false;
        }
        return true;
    }

    public void set(String avain, String arvo) {
        this.kentat.put(avain, arvo);
    }

    public String get(String avain) {
        return this.kentat.get(avain);
    }

}
