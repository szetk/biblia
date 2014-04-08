package com.mycompany.biblia;

import com.mycompany.domain.Viite;
import com.mycompany.domain.Tallenna;
import java.io.*;
import java.util.*;
import java.util.ArrayList;

/**
 * Read input interactively from stdin/stdout.
 */
public class CommandlineStub
 {

   private static String welcomeMsg = "Biblia testiversio 0.0.0.\n";
   //private static BufferedReader br =
     // new BufferedReader(new InputStreamReader(System.in));

  private ArrayList<String> args;
   // TODO This does not belong here.
   private Collection<String> refTypes;
   private ArrayList<String> prints = new ArrayList();

   // TODO neither does this.
   private Collection<String> refFields;

   // TODO  or this.
   // private BibliaStore;
   

   /**
    *
    */
   public CommandlineStub(ArrayList<String> args) {
      this.args = args;
      this.refTypes = new ArrayList<String>();
      this.refTypes.add("BOOK");
      this.refTypes.add("INPROCEEDINGS");

      this.refFields = new ArrayList<String>();
      this.refFields.add("title");
      this.refFields.add("author");
      this.refFields.add("year");
   }

   /**
    * Main loop.
    */
   public void run() {

      System.out.print(welcomeMsg);

      try {
         while (args.size()>0)
            processAction(getAction());
      } catch (IOException ioe) {
         log("IO exception, exiting.");
         System.exit(1);
      }
   }

   /**
    * Process an action possibly asking for further input.
    */
   private void processAction(char action) throws IOException {
      switch (action) {
         case 'u': talleta(getReference());
                   //System.out.println("Tietokanta ei tuettu"); // TODO biblia.push(^)
                   break;
         case 'l': prints.add("Toiminto ei tuettu");
                   break;
         case 'q': System.exit(0);
         default:  prints.add("Toimintoa ei tunnistettu: " + action);
                   break;
      }
   }

   /**
    * Get reference fields interactively.
    */
   private Viite getReference() throws IOException {
     // String reftype = getOption("referenssin tyyppi", refTypes);

      HashMap<String,String> fields = new HashMap<String,String>();

      for (String field : refFields) {
         fields.put(field, getValue(field + ": "));
      }
      //TODO tarkista että vuosi on int
      return new Viite("aa",fields.get("title"),fields.get("author"),fields.get("year"));

   }

   /**
    * Get an option interactively.
    */
   private char getAction() throws IOException {

      String result = "";

      while (result.length() < 1) {
         System.out.println("Anna toiminto (u Uusi viite, l Listaa viitteet, q Poistu)");
         result = getValue("> ");
      }
      return result.charAt(0);
   }

   /**
    * Get an option from a list of options.
    */
   /*private String getOption(String desc, Collection<String> options) throws IOException {
      int n = 0;
      ArrayList<String> optionsArray = new ArrayList<String>();

      System.out.print("Valitse " + desc + ":");
      for (String option : options) {
         optionsArray.add(option);
         System.out.print(" " + (n++) + " " + option);
      }
      System.out.println();

      // FIXME parsing may fail!
      int chosen = Integer.parseInt(getValue("> "));

      // FIXME Array index may be out of bounds!
      return optionsArray.get(chosen);
   }*/


   /**
    * Get input string interactively.
    */
   private String getValue(String msg) throws IOException {
      System.out.print(msg);
      String next = args.get(0);
      args.remove(0);
       return next;

   }

   /**
    * Logging level messages. NOT input descriptions.
    */
   private void log(String str) {
      System.out.print(str);
   }
   
       private void talleta(Viite ref){
        Tallenna save = new Tallenna(ref.toString());
        save.tallennaTiedostoon("Biblia.bib");
        prints.add("Viitteen luonti onnistui");

}
       public ArrayList<String> tulosteet(){
           return this.prints;
       }
}

