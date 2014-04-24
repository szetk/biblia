import com.mycompany.biblia.InteractiveCommandlineTest;
import com.mycompany.biblia.App;
import java.util.ArrayList;

description 'Artona haluan muokata ja poistaa viitteita'

scenario "Muokkaus onnistuu", {
    given 'valitaan muokkaus', {
        ict = new InteractiveCommandlineTest();

        args = new ArrayList<String>();
        args.add("r")
        args.add("lataa_testitiedosto.txt")
        args.add("m")
        args.add("a")
        args.add("1")
        args.add("Ville Virtanen")
        args.add("")
        args.add("titteli")
        args.add("2013")
        args.add("")
        args.add("")
        args.add("q")
        
        args.add("q")
        ict.setInput(args);
    }

    when 'viite on olemassa ja muokattu oikein', {
       ict.cmdline.run()
    }

    then 'muokkaus onnistuu', {
       ict.getOutput().shouldHave("Viitteen luonti onnistui")
    }
}
scenario "Poisto onnistuu", {
    given 'valitaan poisto', {
        ict = new InteractiveCommandlineTest();

        args = new ArrayList<String>();
        args.add("r")
        args.add("lataa_testitiedosto.txt")
        args.add("p")
        args.add("a")
        args.add("q")
        ict.setInput(args);
    }

    when 'viite on olemassa ja muokattu oikein', {
       ict.cmdline.run()
    }

    then 'muokkaus onnistuu', {
       ict.getOutput().shouldHave("Poistettu")
    }
}
