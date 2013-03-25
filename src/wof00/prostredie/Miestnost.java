package wof00.prostredie;

import java.util.HashMap;
import java.util.TreeMap;
import wof00.veci.IVec;

/**
 * Trieda Miestnost realizuje jednu miestnost/priestor v celom priestore hry.
 * Kazda "miestnost" je z inymi miestnostami spojena vychodmi. 
 * Vychody z miestnosti su oznacovane svetovymi stranami.
 * Pre kazdy vychod si miestnost pamata odkaz na susednu miestnost
 * alebo null, ak tym smerom vychod nema.
 *
 * @author  Michael Kolling, David J. Barnes
 * @version 2006.03.30
 * @author  lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
 */
public class Miestnost 
{
    private String aPopisMiestnosti;
    private HashMap<String, IDvere> aVychody;
    private final String aNazov;
    private TreeMap<String, IVec> aPredmety;
    

    /**
     * Vytvori miestnost popis ktorej je v parametrom.
     * Po vytvoreni miestnost nema ziadne vychody. Popis miesnost strucne 
     * charakterizuje.
     * 
     * @param paPopis text popisu miestnosti.
     */
    public Miestnost(String paNazov, String paPopis) {
        aNazov = paNazov;
        this.aPopisMiestnosti = paPopis;
        aVychody = new HashMap<String, IDvere>();
        aPredmety = new TreeMap<String, IVec>();
    }

    /**
     * Nastavi vychody z miestnosti. Kazdy vychod je urceny bud odkazom 
     * na miestnost alebo hodnotou null, ak vychod tym smerom neexistuje.
     * 
     * @param paSmer Smer vychodu
     * @param paMiestnostVSmere Miestnost v danom smere
     */
    public void nastavVychod(IDvere paDvereVSmere, boolean paNastavOpacny) {
        aVychody.put(paDvereVSmere.dajNazov(), paDvereVSmere);
        if (paNastavOpacny) {
            paDvereVSmere
                    .dajMiestnost()
                    .nastavVychod(
                        paDvereVSmere.vytvorPodobne(this),
                        false
                    );
        }
    }
    
    public void nastavVychod(IDvere paDvereVSmere)
    {
        this.nastavVychod(paDvereVSmere, true);
    }

    /**
     * @return textovy popis miestnosti.
     */
    public String dajPopis() {
        return aPopisMiestnosti;
    }
    
    public String dajNazov() {
        return aNazov;
    }

    public void infoOMiestnosti() {
        System.out.println("Teraz si v miestnosti " + this.dajNazov());
        System.out.println(this.dajPopis());
        System.out.print("Vychody: ");
        
        for (String smer : this.aVychody.keySet()) {
            System.out.print(smer + ", ");
        }
        
        System.out.println();
        
        if (!aPredmety.isEmpty()) {
            System.out.print("Predmety: ");
        
            for (String predmet : this.aPredmety.keySet()) {
                System.out.print(predmet + ", ");
            }
            
            System.out.println();
        }
    }

    public Miestnost dajMiestnostVSmere(String paSmer) {
        return aVychody.get(paSmer).dajMiestnost();
    }

    public void pridajPredmet(IVec paPredmet) {
        aPredmety.put(paPredmet.dajNazov(), paPredmet);
    }

    public IVec zoberPredmet(String paNazovPredmetu) {
        return aPredmety.remove(paNazovPredmetu);
    }

    public IDvere dajDvereVSmere(String paSmer) {
        return aVychody.get(paSmer);
    }
}
