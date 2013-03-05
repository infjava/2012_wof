package wof00;

import java.util.HashMap;

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
    private HashMap<String, Miestnost> aVychody;
    private final String aNazov;
    

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
        aVychody = new HashMap<String, Miestnost>();
    }

    /**
     * Nastavi vychody z miestnosti. Kazdy vychod je urceny bud odkazom 
     * na miestnost alebo hodnotou null, ak vychod tym smerom neexistuje.
     * 
     * @param paSmer Smer vychodu
     * @param paMiestnostVSmere Miestnost v danom smere
     */
    public void nastavVychod(Miestnost paMiestnostVSmere, boolean paNastavOpacny) {
        aVychody.put(paMiestnostVSmere.dajNazov(), paMiestnostVSmere);
        if (paNastavOpacny) {
            paMiestnostVSmere.nastavVychod(this, false);
        }
    }
    
    public void nastavVychod(Miestnost paMiestnostVSmere)
    {
        this.nastavVychod(paMiestnostVSmere, true);
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
            System.out.print(smer + " ");
        }
        
        System.out.println();
    }

    Miestnost dajVychodVSmere(String smer) {
        return aVychody.get(smer);
    }
}
