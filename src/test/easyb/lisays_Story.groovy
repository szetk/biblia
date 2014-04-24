import com.mycompany.biblia.InteractiveCommandlineTest;
import com.mycompany.biblia.App;
import java.util.ArrayList;

description 'Artona haluan lisätä viitteen'

scenario "Syötetään oikeat tiedot", {
    given 'valitaan lisäys', {
        ict = new InteractiveCommandlineTest();

        args = new ArrayList<String>()
        args.add("u")
        args.add("0")
        args.add("author")
        args.add("title")
        args.add("1999")
        args.add("address")
        args.add("publisher")
        args.add("")
        args.add("journal")
        args.add("11")
        args.add("12")
        args.add("q")

        ict.setInput(args);
    }

    when 'lisäyksen tiedot on syötetty oikein', {
       ict.cmdline.run()
    }

    then 'lisäys luodaan', {
       ict.getOutput().shouldHave("Viitteen luonti onnistui")
    }
    
}
scenario "Syötetään vajaat tiedot", {
    given 'valitaan lisäys', {
        ict = new InteractiveCommandlineTest();

        args = new ArrayList<String>()
        args.add("u")
        args.add("0")
        args.add("")
        args.add("title")
        args.add("1999")
        args.add("address")
        args.add("publisher")
        args.add("")
        args.add("journal")
        args.add("11")
        args.add("12")
        args.add("q")

        ict.setInput(args);
    }

    when 'lisäyksen vajaat tiedot on syötetty', {
       ict.cmdline.run()
    }

    then 'lisäys luodaan', {
       ict.getOutput().shouldHave("Viitteen tiedot vajaat")
    }
}
