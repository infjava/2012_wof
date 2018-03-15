package wof00;

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

    /**
     * Vytvori citac na citanie vstupov z terminaloveho okna.
     */
    public Parser() 
    {
        aPrikazy = ZoznamPrikazov.dajInstanciu();
        aCitac = new Scanner(System.in);
    }

    /**
     * @return prikaz zadany hracom
     */
    public Prikaz dajPrikaz() 
    {
        String vstupnyRiadok;   // riadok textu napisany hracom
        String prikaz = null;
        String parameter = null;

        System.out.print("> ");     // vyzva pre hraca na zadanie prikazu

        vstupnyRiadok = aCitac.nextLine();

        // najde prve dve slova v riadku 
        Scanner tokenizer = new Scanner(vstupnyRiadok);
        if(tokenizer.hasNext()) {
            prikaz = tokenizer.next();      // prve slovo
            if(tokenizer.hasNext()) {
                parameter = tokenizer.nextLine().trim();      // druhe slovo
                // vsimnite si, ze zbytok textu sa ignoruje
            }
        }

        // kontrola platnosti prikazu
        if(aPrikazy.jePrikaz(prikaz)) {
            // vytvori platny prikaz
            return new Prikaz(prikaz, parameter);
        } else {
            // vytvori neplatny - "neznamy" prikaz
            return new Prikaz(null, parameter); 
        }
    }
}
