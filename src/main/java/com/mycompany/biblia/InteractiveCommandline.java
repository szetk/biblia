package com.mycompany.biblia;

import com.mycompany.biblia.Viite;
import com.mycompany.biblia.Tallenna;
import java.io.*;
import java.io.PrintStream;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Read input interactively from stdin/stdout.
 */
public class InteractiveCommandline {

    private static String welcomeMsg = "Biblia testiversio 0.0.0.\n";
    private PrintStream output;
    private BufferedReader input;
    private boolean doend = false;

    /**
     *
     */
    public InteractiveCommandline(PrintStream output, BufferedReader input) {
        this.output = output;
        this.input = input;
    }

    /**
     * Main loop.
     */
    public void run() {

        output.print(welcomeMsg);

        try {
            do {
                processAction(getAction());
            } while (!doend);
        } catch (IOException ioe) {
            output.print("IO exception! Quitting.");
        }
    }

    public void endLast() {
        this.doend = true;
    }

    /**
     * Process an action possibly asking for further input.
     */
    private void processAction(char action) throws IOException {
        switch (action) {
            case 'u':
                talleta(getReference());
                break;
            case 'l':
                listaa();
                break;
            case 'q':
                endLast();
                break;
            case 'p':
                talleta(getRawReference());
                break;
            case 's':
                haeViite();
                break;
            default:
                output.println("Toimintoa ei tunnistettu: " + action);
                break;
        }
    }

    /**
     * Get reference fields interactively.
     */
    private Viite getReference() throws IOException {
        HashMap<String, ArrayList<String>> dict = (new Viite()).muodostaKenttienHashmap();
        Set<String> refTypes = dict.keySet();

        String refType = getOption("referenssin tyyppi", refTypes);
        ArrayList<String> refFields = dict.get(refType);

        Viite viite = new Viite();
        viite.setViitetyyppi(refType);

        String value;
        for (String field : refFields) {
            value = getValue(field + ": ");

            if (field == "address") {
                viite.setAddress(value);
            } else if (field == "author") {
                viite.setAuthor(value);
            } else if (field == "booktitle") {
                viite.setBooktitle(value);
//            } else if (field == "id") {
//                viite.setId(value);
            } else if (field == "journal") {
                viite.setJournal(value);
            } else if (field == "number") {
                try {
                    viite.setNumber(Integer.parseInt(value)); // TODO may fail!
                } catch (Exception e) {
                }
            } else if (field == "pages") {
                viite.setPages(value);
            } else if (field == "publisher") {
                viite.setPublisher(value);
            } else if (field == "title") {
                viite.setTitle(value);
            } else if (field == "volume") {
                try {
                    viite.setVolume(Integer.parseInt(value)); // TODO may fail
                } catch (Exception e) {
                }
            } else if (field == "year") {
                viite.setYear(value);
            }
        }
        String id = generoiId(viite);
        viite.setId(id);

        return viite;
    }
    
    /**
     * Generoi viitteelle id:n jossa ensin sukunimen 2 ekaa kirjainta ja sitten vuosiluvun 2 viimeistä numeroa.
     *
     * @param viite jolle id generoidaan
     * @return generoitu id
     */
    private String generoiId(Viite viite) {
        String sukunimenEkat = viite.getAuthor().substring(0, 2).toUpperCase();
        String vuosiluvunVikat = viite.getYear().substring(viite.getYear().length()-2);
        return sukunimenEkat + vuosiluvunVikat;
    }

    private Viite getRawReference() throws IOException {
        ArrayList<String> lines = new ArrayList<String>();

        String input;
        for (;;) {
            input = getValue("");
            if (input.length() > 0) {
                lines.add(input);
            } else {
                break;
            }
        }

        return null; // TODO Lue "lines"
    }

    /**
     * Get an option interactively.
     */
    private char getAction() throws IOException {

        String result = "";

        while (result.length() < 1) {
            output.println("Anna toiminto (u Uusi viite, l Listaa viitteet, p Liitä viite, s Hae viite, q Poistu)");
            result = getValue("> ");
        }
        return result.charAt(0);
    }

    /**
     * Get an option from a list of options.
     */
    private String getOption(String desc, Collection<String> options) throws IOException {
        int n = 0;
        ArrayList<String> optionsArray = new ArrayList<String>();

        output.print("Valitse " + desc + ":");
        for (String option : options) {
            optionsArray.add(option);
            output.print(" " + (n++) + " " + option);
        }
        output.println();

        // FIXME parsing may fail!
        int chosen = Integer.parseInt(getValue("> "));

        // FIXME Array index may be out of bounds!
        return optionsArray.get(chosen);
    }

    /**
     * Get input string interactively.
     */
    private String getValue(String msg) throws IOException {
        output.print(msg);
        return input.readLine();
    }

    private void talleta(Viite ref) {
        Tallenna save = new Tallenna(ref.toString());
        save.tallennaTiedostoon("Biblia.bib");
        output.println("Viitteen luonti onnistui");
    }

    private void listaa() {
        try {
            Lataa lataa = new Lataa("Biblia.bib");
            output.println("Listataan Biblian viitteet muodossa: id, viitetyyppi, author, title, year");
            while (lataa.parsiKirja()) {
                Viite viite = lataa.getViite();
                output.println(viite.getId() + ", " + viite.getViitetyyppi()+ ", " + viite.getAuthor() + ", " + viite.getTitle() + ", " + viite.getYear());
            }

        } catch (IOException ex) {
            Logger.getLogger(InteractiveCommandline.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Kutsuu Lataa-luokan toiminnallisuutta joka näyttää haettavan viitteen tiedot.
     *
     * @return haettavan viitteen tiedot
     */
    private String haeViite() {
        String haettavaId = kysyViitteenId();
        try {
            Lataa lataa = new Lataa("Biblia.bib");
            return lataa.tulostaHaetunViitteenTiedot(haettavaId);

        } catch (IOException ex) {
            Logger.getLogger(InteractiveCommandline.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Viitettä ei löytynyt";
    }
    
    /**
     * Kysyy käyttäjältä haettavan viitteen id:n
     *
     * @return käyttäjän antama id
     */
    private String kysyViitteenId() {
        String id = "";
        while (id.length() < 1) {
            output.println("Anna haettavan viitteen id:");
            try {
                id = getValue("> ");
            } catch (IOException ex) {
                Logger.getLogger(InteractiveCommandline.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return id;
    }
}
