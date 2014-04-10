
package com.mycompany.biblia;

import java.io.*;
import junit.framework.TestCase;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class InteractiveCommandlineTest extends TestCase {

    InteractiveCommandline cmdline;

    ByteArrayOutputStream baos;

    BufferedReader input = mock(BufferedReader.class);

    @Override
    protected void setUp() throws IOException {
        baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        cmdline = new InteractiveCommandline(ps, input);
    }


    public void testViitteenLisäysKentittäin() throws IOException {
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

        assertThat(baos.toString(), containsString("Valitse referenssin tyyppi"));
    }

    public void testViitteidenListaus() throws IOException {
        cmdline.endLast();
        when(input.readLine()).thenReturn("l");
        cmdline.run();

        assertThat(baos.toString(), containsString("Listataan Biblian viitteet"));
    }

    public void testOhjelmastaPoistuminen() throws IOException {
        // This test hangs if endLast is not called by q
        when(input.readLine()).thenReturn("q");
        cmdline.run();
    }

    public void testPasteNonsense() throws IOException {
        cmdline.endLast();
        when(input.readLine())
            .thenReturn("p")
            .thenReturn("nonsense")
            .thenReturn(""); // end
        cmdline.run();

        assertThat(baos.toString(), containsString("nonsense input"));
    }

    public void testNonsense() throws IOException {
        cmdline.endLast();
        when(input.readLine())
            .thenReturn("nonsense");
        cmdline.run();

        assertThat(baos.toString(), containsString("Toimintoa ei tunnistettu"));
    }
}
