
package com.mycompany.biblia;

import java.io.*;
import java.util.ArrayList;
import junit.framework.TestCase;
import org.mockito.stubbing.OngoingStubbing;
import static org.mockito.Mockito.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class InteractiveCommandlineTest extends TestCase {

    InteractiveCommandline cmdline;

    ByteArrayOutputStream baos;

    BufferedReader input = mock(BufferedReader.class);

    public void setInput(ArrayList<String> args) throws IOException {
        setUp();
        cmdline.endLast();
        OngoingStubbing<String> a = when(input.readLine());
        for (String arg : args) {
                a = a.thenReturn(arg);
        }
    }

    public String[] getOutput() throws IOException {
        return baos.toString().split("\\n");
    }

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

        assertThat(baos.toString(), containsString(""));
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
            .thenReturn("c")
            .thenReturn("nonsense")
            .thenReturn(""); // end
        cmdline.run();
    }

    public void testNonsense() throws IOException {
        cmdline.endLast();
        when(input.readLine())
            .thenReturn("nonsense");
        cmdline.run();

        assertThat(baos.toString(), containsString("Toimintoa ei tunnistettu"));
    }

    public void testMuokkaus() throws IOException {
        cmdline.endLast();
        when(input.readLine())
            .thenReturn("m")
            .thenReturn("aa1")
            .thenReturn("0")
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
    }

    public void testHae() throws IOException {
        cmdline.endLast();
        when(input.readLine())
            .thenReturn("s")
            .thenReturn("aa1");

        cmdline.run();

        assertThat(baos.toString(), containsString("Book"));
    }

    public void testPoista() throws IOException {
        cmdline.endLast();
        when(input.readLine())
            .thenReturn("p")
            .thenReturn("non-existing");

        cmdline.run();
        // fixme what could be asserted here?
    }

}
