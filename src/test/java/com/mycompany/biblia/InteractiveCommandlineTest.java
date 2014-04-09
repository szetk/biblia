
package com.mycompany.biblia;

import java.io.*;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;

public class InteractiveCommandlineTest extends TestCase {

    InteractiveCommandline cmdline;
    BufferedReader printout;
    BufferedReader input = mock(BufferedReader.class);

    @Override
    protected void setUp() throws IOException {

        PipedInputStream pipeInput = new PipedInputStream();
        printout = new BufferedReader(new InputStreamReader(pipeInput));
        BufferedOutputStream out = new BufferedOutputStream(new PipedOutputStream(pipeInput));

        cmdline = new InteractiveCommandline(new PrintStream(out), input);
    }


    public void testViitteenLisäysKentittäin() throws IOException {
        /*
         * This could in theory maybe work.
        cmdline.endLast();
        when(input.readLine())
            .thenReturn("u")
            .thenReturn("0")
            .thenReturn("theId")
            .thenReturn("author")
            .thenReturn("title")
            .thenReturn("2000")
            .thenReturn("address")
            .thenReturn("publisher")
            .thenReturn("pages")
            .thenReturn("journal")
            .thenReturn("11")
            .thenReturn("12");
        cmdline.run();
        assertEquals("Anna toiminto", printout.readLine());
        */
    }
}
