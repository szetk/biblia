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
    
    HashMap <String, ArrayList<String>> kentat; // viitetyypeillä lista kyseisen viitetyypin mahdollisista kentistä
    private String viitetyyppi; // book, article tai inproceedings
    
    //Nämä kaikilla viitteillä
    private String id;
    private String author;
    private String title;
    private String year;
    
    //Nämä kaikilla viitteillä (vapaaehtoisia)
    private String address;
    private String publisher;
    
    //Nämä vain article-viitteillä (vapaaehtoisia)
    private String journal;
    private int number;
    private int volume;
    
    //Nämä vain inproceedings-viitteillä (vapaaehtoisia)
    private String booktitle;
    
    //Tämä article- ja inproceedings-viitteillä (vapaaehtoinen)
    private String pages;
    
    /**
     *
     * @param id
     * @param author
     * @param title
     * @param year
     */
    public Viite(String id, String author, String title, String year){
        //Muut kuin nämä (pakolliset) asetetaan erikseen
        this.id = id;
        this.author = author;
        this.title = title;
        this.year = year;
    }

    /**
     *
     */
    public Viite(){}
   
    /**
     * Muodostetaan HashMap jossa jokaiselle viitetyypille ArrayList joka sisältää kyseisen viitetyypin kentät.
     * Mahdolliset viitetyypit (eli keyt): book, article, inproceedings
     * 
     * @return kentat
     */
    public HashMap<String, ArrayList<String>> muodostaKenttienHashmap() {
        this.kentat = new HashMap<String, ArrayList<String>>();
        
        ArrayList<String> kirjanKentat = new ArrayList<String>();
        kirjanKentat.add("id");
        kirjanKentat.add("author");
        kirjanKentat.add("title");
        kirjanKentat.add("year");
        kirjanKentat.add("address");
        kirjanKentat.add("publisher");
        
        ArrayList<String> articlenKentat = new ArrayList<String>();
        articlenKentat.add("id");
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
        inprocKentat.add("id");
        inprocKentat.add("author");
        inprocKentat.add("title");
        inprocKentat.add("year");
        inprocKentat.add("address");
        inprocKentat.add("publisher");
        inprocKentat.add("booktitle");
        inprocKentat.add("pages");
        
        this.kentat.put("book", kirjanKentat);
        this.kentat.put("article", articlenKentat);
        this.kentat.put("inproceedings", inprocKentat);
        
        return this.kentat;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @param year
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     *
     * @param publisher
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     *
     * @param journal
     */
    public void setJournal(String journal) {
        this.journal = journal;
    }

    /**
     *
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     *
     * @param volume
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     *
     * @param booktitle
     */
    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    /**
     *
     * @param pages
     */
    public void setPages(String pages) {
        this.pages = pages;
    }

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @return
     */
    public String getAuthor() {
        return author;
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @return
     */
    public String getYear() {
        return year;
    }

    /**
     *
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     *
     * @return
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     *
     * @return
     */
    public String getJournal() {
        return journal;
    }

    /**
     *
     * @return
     */
    public int getNumber() {
        return number;
    }

    /**
     *
     * @return
     */
    public int getVolume() {
        return volume;
    }

    /**
     *
     * @return
     */
    public String getBooktitle() {
        return booktitle;
    }

    /**
     *
     * @return
     */
    public String getPages() {
        return pages;
    }
    
    /**
     * Aika suoraviivainen metodi, tällä saadaan siis bibtext muotoon kirjaviite
     * 
     * @return
     */
        @Override
    public String toString() {
        String inOneString = "@" + viitetyyppi + "{ \""+ id + "\", \nauthor = \"" + author + "\",\n" +
                "publisher  = \"" + publisher + "\", \n" +
                "title  = \"" + title + "\", \n" +
                "year   = \"" + year + "\"\n }\n";
        
        return inOneString;
    }

    /**
     *
     * @return
     */
    public HashMap<String, ArrayList<String>> getKentat() {
        return kentat;
    }

    /**
     *
     * @return
     */
    public String getViitetyyppi() {
        return viitetyyppi;
    }

    /**
     *
     * @param kentat
     */
    public void setKentat(HashMap<String, ArrayList<String>> kentat) {
        this.kentat = kentat;
    }

    /**
     *
     * @param viitetyyppi
     */
    public void setViitetyyppi(String viitetyyppi) {
        this.viitetyyppi = viitetyyppi;
    }

}
