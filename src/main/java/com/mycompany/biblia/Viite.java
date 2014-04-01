/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.biblia;

public class Viite {
    //Nämä kaikilla viitteillä
    private String id;
    private String author;
    private String title;
    private int year;
    
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
    
    public void Viite(String id, String author, String title, int year){
        //Muut kuin nämä (pakolliset) asetetaan erikseen
        this.id = id;
        this.author = author;
        this.title = title;
        this.year = year;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public String getAddress() {
        return address;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getJournal() {
        return journal;
    }

    public int getNumber() {
        return number;
    }

    public int getVolume() {
        return volume;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public String getPages() {
        return pages;
    }
    

}
