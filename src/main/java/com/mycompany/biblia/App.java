package com.mycompany.biblia;

import com.mycompany.biblia.InteractiveCommandline;
import java.util.ArrayList;
import java.io.*;

/**
 * Biblia App.
 *
 */
public class App
{
    public static void main( String[] args ) throws UnsupportedEncodingException
    {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
       (new InteractiveCommandline(System.out, br)).run();
    
     /*   try{
        Lataa l = new Lataa("Biblia.bib");
        l.parsiViite();
        }
        catch(Exception e){}*/
    }
}
