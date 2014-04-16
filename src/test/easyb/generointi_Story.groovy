import com.mycompany.biblia.CommandlineStub;
import com.mycompany.biblia.App;
import java.util.ArrayList;

description 'Artona haluan generoida toimivan bibtex tiedoston'

scenario "Syötetään oikeat tiedot", {
    given 'valitaan lisäys', {
        args = new ArrayList();
        args.add("u")
        args.add("title")
        args.add("author")
        args.add("1999")
        cmd = new CommandlineStub(args)
    }

    when 'lisäyksen tiedot on syötetty oikein', {
       cmd.run()
    }

    then 'lisäys luodaan', {
       cmd.tulosteet().shouldHave("Viitteen luonti onnistui")
    }
}

