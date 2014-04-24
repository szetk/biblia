import com.mycompany.biblia.InteractiveCommandlineTest;
import com.mycompany.biblia.App;
import java.util.ArrayList;

description 'Artona haluan generoida toimivan bibtex tiedoston'

scenario "Syötetään oikeat tiedot", {
    given 'valitaan lisäys', {
        ict = new InteractiveCommandlineTest();

        args = new ArrayList<String>();
        args.add("r")
        args.add("lataa_testitiedosto.txt")
        args.add("t")
        args.add("tallenna_testitiedosto.txt")
        args.add("q")
        ict.setInput(args);
    }

    when 'generoinnin komennot on annettu oikein', {
       ict.cmdline.run()
    }

    then 'generointi onnistuu', {
       ict.getOutput().shouldHave("Tallennettu")
    }
}

