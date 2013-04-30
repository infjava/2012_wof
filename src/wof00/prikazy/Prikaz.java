package wof00.prikazy;

import java.io.PrintWriter;
import java.util.Scanner;
import wof00.vynimky.UkonciHruException;
import wof00.hra.Hrac;
import wof00.vynimky.ChybaVykonaniaException;

/**
 * Trieda prikaz implemntuje casti prikazu, ktore moze hrac zadat.
 * V tejto verzii prikaz tvoria dve slova: nazov prikazu a druhe slovo.
 * Napriklad prikaz "chod juh" tvoria dva retazce "chod" ako nazov prikazu a
 * "juh" ako oznacenie smeru.
 * 
 * Predpoklada sa, ze prikaz je skontrolovany, t.j., ze nazov prikazu je znamy.
 * Pre neznamy prikaz je jeho nazov nastaveny na hodnotu <null>.
 *
 * Ak prikaz nema parameter, potom ma druhe slovo hodnotu <null>.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 * @author  lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
 */

public class Prikaz
{

    static Prikaz nacitajZo(Scanner in) {
        String vstupnyRiadok = in.nextLine();

        // najde prve dve slova v riadku 
        Scanner tokenizer = new Scanner(vstupnyRiadok);
        
        if(! tokenizer.hasNext()) {
            return null;
        }
        
        String prikaz = tokenizer.next();      // prve slovo
        String parameter;
        if(tokenizer.hasNext()) {
            parameter = tokenizer.nextLine().trim();      // druhe slovo
        } else {
            parameter = null;
        }

        // kontrola platnosti prikazu
        if(ZoznamPrikazov.dajInstanciu().jePrikaz(prikaz)) {
            // vytvori platny prikaz
            return new Prikaz(prikaz, parameter);
        }
        
        return null;
    }
    
    private String aNazovPrikazu;
    private String aParameter;
    private boolean aVykonany;

    /**
     * Inicializuje slova prikazu dvomi zadanymi parametrami. Jeden alebo oba
     * parametre mozu mat hodnotu <null>.

     * @param paNazovPrikazu prve slovo - nazov prikazu, 
     *                       null, ak je prikaz neznamy.
     * @param paParameter druhe slovo prikazu.
     */
    public Prikaz(String paNazovPrikazu, String paParameter)
    {
        aNazovPrikazu = paNazovPrikazu;
        aParameter = paParameter;
        aVykonany = false;
    }

    /**
     * @return prve slovo - nazov prikazu.
     */
    public String dajNazov()
    {
        return aNazovPrikazu;
    }

    /**
     * @return druhe slovo - parameter prikazu.
     */
    public String dajParameter()
    {
        return aParameter;
    }

    /**
     * @return true, ak prikaz ma parameter.
     */
    public boolean maParameter()
    {
        return (aParameter != null);
    }

    /**
     * Prevezne prikaz a vykona ho.
     *
     * @param paPrikaz prikaz, ktory ma byt vykonany.
     * @return true ak prikaz ukonci hru, inak vrati false.
     */
    public void vykonajPrikaz(Hrac paHrac) throws UkonciHruException {
        String nazovPrikazu = this.dajNazov();
        IVykonavac vykonavac = ZoznamPrikazov.dajInstanciu().dajVykonavac(nazovPrikazu);
        try {
            vykonavac.vykonaj(this.dajParameter(), paHrac);
            aVykonany = true;
        } catch (ChybaVykonaniaException ex) {
            aVykonany = false;
        }
    }

    public void zapisDo(PrintWriter out) {
        out.println(this);
    }

    public boolean maSaUkladat() {
        if (!aVykonany) {
            return false;
        }
        String nazovPrikazu = this.dajNazov();
        IVykonavac vykonavac = ZoznamPrikazov.dajInstanciu().dajVykonavac(nazovPrikazu);
        
        return vykonavac.maSaUkladat();
    }

    @Override
    public String toString() {
        if (this.maParameter()) {
            return aNazovPrikazu + " " + aParameter;
        } else {
            return aNazovPrikazu;
        }
    }
}