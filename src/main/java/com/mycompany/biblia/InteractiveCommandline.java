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
    private static String helpText = "Anna toiminto (u Uusi viite, r Lataa viitteet tiedostosta, l Listaa viitteet, c Liitä viite, s Hae viite, m Muokkaa viitettä, p Poista viite, t Tallenna viitteet tiedostoon, q Poistu)";
    private PrintStream output;
    private BufferedReader input;
    private boolean doend = false;
    private ViitteidenHallinta viitteidenHallinta;

    /**
     *
     */
    public InteractiveCommandline(PrintStream output, BufferedReader input) {
        this.output = output;
        this.input = input;
        this.viitteidenHallinta = new ViitteidenHallinta();


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
                Viite tallennettava = getReference();
                if (tallennettava.onPakollisetKentat()) {
                    this.viitteidenHallinta.talleta(tallennettava);
                }
                break;
            case 'l':
                listaa(this.viitteidenHallinta.getViitteet());
                break;
            case 'q':
                endLast();
                break;
            case 'c':
                this.viitteidenHallinta.talleta(getRawReference());
                break;
            case 'm':
                Viite haettu = haeViite();
                if (!haettu.get("viitetyyppi").equals("failed")) {
                    String id = haettu.get("id");
                    Viite vnew = getReference();
                    if (vnew.onPakollisetKentat()) {
                        vnew.set("id", id);
                        this.viitteidenHallinta.korvaa(vnew);
                    }
                }
                break;
            case 'p':
                this.viitteidenHallinta.poista(haeViite());
                break;
            case 's':
                haettu = haeViite();
                if (!haettu.get("viitetyyppi").equals("failed")) {
                    output.println(haettu);
                }
                break;
            case 't':
                String tiedostonimi = getValue("Anna tallennettavan tiedoston nimi \n");
                viitteidenHallinta.tallennaViitteetTiedostoon(tiedostonimi);
                output.println("Tallennettu");
                break;
            case 'r':
                try {
                    this.viitteidenHallinta.lataaViitteetTiedostosta(getValue("Anna ladattavan tiedoston nimi\n"));
                    listaa(this.viitteidenHallinta.getViitteet());
                } catch (IOException ex) {
                    output.println("Virhe tiedostoa luettaessa");
                    //Logger.getLogger(InteractiveCommandline.class.getName()).log(Level.SEVERE, null, ex);
                }
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
        HashMap<String, ArrayList<String>> dict = Viite.muodostaKenttienHashmap();
        Set<String> refTypes = dict.keySet();

        String refType = getOption("referenssin tyyppi", refTypes);
        ArrayList<String> refFields = dict.get(refType);

        Viite viite = new Viite();
        viite.set("viitetyyppi", refType);

        String value;
        for (String field : refFields) {
            value = getValue(field + ": ");
            if (value.equals("")) {
                value = null;
            }
            viite.set(field, value);

            /*
             * if (field == "address") { viite.set("address", value); } else if
             * (field == "author") { String authors = value; /* boolean lisaa =
             * true; while (lisaa) { String viela = getValue("Lisää uusi author?
             * k/e"); if (viela.equals("k")) { authors = authors + " and " +
             * getValue("author: "); } else { lisaa = false; } }
             */
            /*
             * viite.set("author", authors);
             *
             * } else if (field == "editor") { viite.set("editor", value); }
             * else if (field == "booktitle") { viite.set("booktitle", value);
             * // } else if (field == "id") { // viite.setId(value); } else if
             * (field == "journal") { viite.set("journal", value); } else if
             * (field == "number") { try { viite.set("number", value); // TODO
             * may fail! } catch (Exception e) { } } else if (field == "pages")
             * { viite.set("pages", value); } else if (field == "publisher") {
             * viite.set("publisher", value); } else if (field == "title") {
             * viite.set("title", value); } else if (field == "volume") { try {
             * viite.set("volume", value); // TODO may fail } catch (Exception
             * e) { } } else if (field == "year") { viite.set("year", value); }
             */
        }
            String id = generoiId(viite);
            viite.set("id", id);
            if(viite.onPakollisetKentat()){
            output.println(viite);
            output.println("Viitteen luonti onnistui");
            return viite;

        } else {
            output.println("Et syöttänyt tarvittavia kenttiä"); //TODO listaa puuttuvat tarvittavat
            return new Viite();
        }


    }

    /**
     * Generoi viitteelle id:n jossa ensin sukunimen 2 ekaa kirjainta ja sitten
     * vuosiluvun 2 viimeistä numeroa.
     *
     * @param viite jolle id generoidaan
     * @return generoitu id
     */
    private String generoiId(Viite viite) {
        if (viite.get("author") != null && viite.get("year")!=null) {
            if (viite.get("author").length() > 2 && viite.get("year").length() > 2 ) {
                String sukunimenEkat = viite.get("author").substring(0, 2).toUpperCase();
                String vuosiluvunVikat = viite.get("year").substring(viite.get("year").length() - 2);
                return sukunimenEkat + vuosiluvunVikat;

            } else {
                return null;
            }
        } else if (viite.get("editor") != null && viite.get("year")!=null) {
          if (viite.get("editor").length() > 2 && viite.get("year").length() > 2 ) {
            String sukunimenEkat = viite.get("editor").substring(0, 2).toUpperCase();
            String vuosiluvunVikat = viite.get("year").substring(viite.get("year").length() - 2);
            return sukunimenEkat + vuosiluvunVikat;
        } else {
            output.println("Auth/edit ei tarpeeksi pitka");
            return null;
        }
    }
        else return null;

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
            output.println(helpText);
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

//    private void talleta(Viite ref) {
//        Tallenna save = new Tallenna(ref.toString());
//        save.tallennaTiedostoon("Biblia.bib");
//        output.println("Viitteen luonti onnistui");
//    }
    private void listaa(ArrayList<Viite> viitteet) {
        if (viitteet.size() == 0) {
            output.println("Ei viitteitä");
        } else {
            output.println("Listataan Biblian viitteet");
            for (Viite viite : viitteet) {
                output.println(viite);
                //output.println(viite.getId() + ", " + viite.getViitetyyppi() + ", " + viite.getAuthor() + ", " + viite.getTitle() + ", " + viite.getYear());
            }
        }
    }

    /**
     * Hakee Lataa-luokalta viitteen id:n perusteella (ja tulostaa sen tiedot)
     *
     * @return haettava viite
     */
    private Viite haeViite() {
        String haettavaId = kysyViitteenId();
        return this.viitteidenHallinta.hae(haettavaId);
    }

    /**
     * Kysyy käyttäjältä haettavan viitteen id:n
     *
     * @return käyttäjän antama id
     */
    private String kysyViitteenId() {
        String id = "";
        while (id.length() < 1) {
            output.println("Anna viitteen id:");
            try {
                id = getValue("> ");
            



} catch (IOException ex) {
                Logger.getLogger(InteractiveCommandline.class  

.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return id;
    }
}
