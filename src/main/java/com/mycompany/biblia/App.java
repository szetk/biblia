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
    public static void main( String[] args )
    {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       (new InteractiveCommandline(System.out, br)).run();
    }
}
