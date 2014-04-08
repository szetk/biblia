package com.mycompany.biblia;

import com.mycompany.biblia.Viite;
import com.mycompany.biblia.Tallenna;
import java.io.*;
import java.io.PrintStream;
import java.util.*;

/**
 * Read input interactively from stdin/stdout.
 */
public class InteractiveCommandline
{

    private static String welcomeMsg = "Biblia testiversio 0.0.0.\n";

    private PrintStream output;
    private BufferedReader input;


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
            while (true)
                processAction(getAction());
        } catch (IOException ioe) {
            output.print("IO exception, exiting.");
            System.exit(1);
        }
    }

    /**
     * Process an action possibly asking for further input.
     */
    private void processAction(char action) throws IOException {
        switch (action) {
            case 'u': talleta(getReference());
                      break;
            case 'l': output.println("Toiminto ei tuettu");
                      break;
            case 'q': System.exit(0);
                      break;
            case 'p': output.println("Toiminto ei tuettu"); // TODO
                      break;
            default:  output.println("Toimintoa ei tunnistettu: " + action);
                      break;
        }
    }

    /**
     * Get reference fields interactively.
     */
    private Viite getReference() throws IOException {
        // TODO should be Viite.muodostakenttienHashmap().keySet()
        ArrayList<String> refTypes = new ArrayList<String>();
        refTypes.add("book");
        refTypes.add("article");
        refTypes.add("inproceedings");

        String refType = getOption("referenssin tyyppi", refTypes);
        // TODO should be Viite.muodostaKenttienHashmap().get(refType)
        ArrayList<String> refFields = new ArrayList<String>();

        Viite viite = new Viite();

        for (String field : refFields) {
            output.println("Asked field (not added): " + getValue(field + ": "));
        }

        return viite;
    }

    /**
     * Get an option interactively.
     */
    private char getAction() throws IOException {

        String result = "";

        while (result.length() < 1) {
            output.println("Anna toiminto (u Uusi viite, l Listaa viitteet, p Liitä viite, q Poistu)");
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

    private void talleta(Viite ref){
        Tallenna save = new Tallenna(ref.toString());
        save.tallennaTiedostoon("Biblia.bib");
        output.println(ref);
    }
}

