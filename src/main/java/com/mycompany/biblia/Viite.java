/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.biblia;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

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
        this.kentat = new HashMap<String, String>();
        this.kentat.put("id", id);
        this.kentat.put("author", author);
        this.kentat.put("title", title);
        this.kentat.put("year", year);
    }

    /**
     *
     */
    public Viite() {
        this.kentat = new HashMap<String, String>();
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
        kirjanKentat.add("editor");
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
            System.out.println("id");
            return false;
        } else if (this.kentat.get("author") == null && this.kentat.get("editor")==null) {
            System.out.println("auth/edit");
            return false;
        }
        else if (this.kentat.get("title") == null || this.kentat.get("title").length()<2) {
            System.out.println("title");
            return false;
        } else if (this.kentat.get("year") == null || this.kentat.get("year").length()<2) {
            System.out.println("year");
            return false;
        } else if (this.kentat.get("viitetyyppi") == null || this.kentat.get("viitetyyppi").length()==0) {
            System.out.println("viitetyyppi");
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

    @Override
    public String toString() {
        if(!onPakollisetKentat()){
            return "Viitteellä ei ole kaikkia pakollisia kenttiä";
        }
        String inOneString = "@" + get("viitetyyppi") + "{ " + get("id") + ",\n";
        for (Entry<String, String> e : this.kentat.entrySet()) {
            if (!e.getKey().equals("viitetyyppi") && !e.getKey().equals("id") && !e.getKey().equals("year")) {
                String arvo = e.getValue();
                System.out.println(arvo);
                String avain = e.getKey();
                System.out.println(avain);
                if(arvo!=null && !arvo.equals("null")){
                inOneString += avain + " = \"" + arvo + "\",\n";
                }
            }
        }
        // laitetaan aina loppuun vuosi, niin on vähän helpomi testailla, ja muutenkin homma menee nätimmin
        inOneString += "year = \"" + get("year") + "\"\n}\n";

        return inOneString;

    }

    public HashMap<String, String> getKentat() {
        return kentat;
    }

    public void setKentat(HashMap<String, String> kentat) {
        this.kentat = kentat;
    }
    
    

}
