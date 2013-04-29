package wof00.prikazy;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Trieda Parser cita vstup zadany hracom do terminaloveho okna a pokusi sa
 * interpretovat ho ako prikaz hry. Kazda sprava dajPrikaz sposobi, ze parser
 * precita jeden riadok z terminaloveho okna a vyberie z neho prve dve slova.
 * Tie dve slova pouzije ako parametre v sprave new triede Prikaz.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 * @author  lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
 */
public class Parser 
{
    private ZoznamPrikazov aPrikazy;  // odkaz na pripustne nazvy prikazov
    private Scanner aCitac;         // zdroj vstupov od hraca
    private ArrayList<Prikaz> aZoznamVykonanychPrikazov;

    /**
     * Vytvori citac na citanie vstupov z terminaloveho okna.
     */
    public Parser() 
    {
        aPrikazy = ZoznamPrikazov.dajInstanciu();
        aCitac = new Scanner(System.in);
        aZoznamVykonanychPrikazov = new ArrayList<Prikaz>();
    }

    /**
     * @return prikaz zadany hracom
     */
    public Prikaz dajPrikaz() 
    {
        System.out.print("> ");     // vyzva pre hraca na zadanie prikazu
        Prikaz prikazInstance = Prikaz.nacitajZo(aCitac);

        if(prikazInstance != null) {
            aZoznamVykonanychPrikazov.add(prikazInstance);
        }
        
        return prikazInstance; 
    }
    
    public void uloz(String paNazovSuboru) throws FileNotFoundException {
        final File file = new File(paNazovSuboru + ".sav");

        final PrintWriter out = new PrintWriter(file);

        for (Prikaz prikaz : aZoznamVykonanychPrikazov) {
            if (prikaz.maSaUkladat()) {
                prikaz.zapisDo(out);
            }
        }
        out.close();
    }

    public Iterable<Prikaz> nacitaj(String paNazovSuboru) throws FileNotFoundException {
        final File file = new File(paNazovSuboru + ".sav");
        final Scanner in = new Scanner(file);
        
        return new SaveIterator(in);
    }
}
