package wof00.prikazy;

import java.util.HashMap;

/**
 * Trieda NazvyPrikazov udrzuje zoznam nazvov platnych prikazov hry. 
 * Za ulohu ma rozpoznavat platne prikazy.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 * @author  lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
 */

class ZoznamPrikazov
{
    private static ZoznamPrikazov aInstancia = new ZoznamPrikazov();
    
    public static ZoznamPrikazov dajInstanciu()
    {
        return aInstancia;
    }
    
    private final HashMap<String, IVykonavac> aVykonavace;
    
    /**
     * Inicializuje zoznam platnych prikazov.
     */
    private ZoznamPrikazov()
    {
    	aVykonavace = new HashMap<String, IVykonavac>();
        aVykonavace.put("ukonci", new VykonavacUkonci());
        aVykonavace.put("pomoc", new VykonavacPomoc());
        aVykonavace.put("chod", new VykonavacChod());
        aVykonavace.put("zober", new VykonavacZober());
        aVykonavace.put("ukaz", new VykonavacUkaz());
        aVykonavace.put("info", new VykonavacInfo());
        aVykonavace.put("zahod", new VykonavacZahod());
        aVykonavace.put("pouzi", new VykonavacPouzi());
        aVykonavace.put("oslov", new VykonavacOslov());
        aVykonavace.put("odpoved", new VykonavacOdpoved());
        aVykonavace.put("uloz", new VykonavacUloz());
        aVykonavace.put("nacitaj", new VykonavacNacitaj());
    }

    /**
     * Kontroluje, ci nazov v parametri je platny prikaz.
     *  
     * @return true ak je parameter platny prikaz,
     * false inak.
     */
    public boolean jePrikaz(String paNazov)
    {
        return aVykonavace.containsKey(paNazov);
    }
    
    public IVykonavac dajVykonavac(String paNazov)
    {
        return aVykonavace.get(paNazov);
    }
}
