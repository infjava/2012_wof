package wof00.prostredie;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import wof00.npc.NPC;
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
    private HashMap<String, NPC> aNPCcka;

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
        aNPCcka = new HashMap<String, NPC>();
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
        
        infoOMiestnostiVychody();
        vypisZoznamKlucov("Predmety", aPredmety);
        vypisZoznamKlucov("NPC", aNPCcka);
    }

    /**
     * Pomocna metoda na vypis NPC, predmetov a vychodov
     * @param paUvod
     * @param paKontainer 
     */
    private void vypisZoznamKlucov(String paUvod, Map<String, ?> paKontainer) {
        if (!paKontainer.isEmpty()) {
            System.out.print(paUvod + ": ");
        
            for (String polozka : paKontainer.keySet()) {
                System.out.print(polozka + ", ");
            }
            
            System.out.println();
        }
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

    void pridajNPC(NPC paNPC) {
        aNPCcka.put(paNPC.dajMeno(), paNPC);
    }

    public NPC dajNPC(String paMenoNPC) {
        return aNPCcka.get(paMenoNPC);
    }

    public IVec dajPredmet(String paNazovPredmetu) {
        return aPredmety.get(paNazovPredmetu);
    }

    protected void infoOMiestnostiVychody() {
        vypisZoznamKlucov("Vychody", aVychody);
    }
}
