/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00;

/**
 *
 * @author janik
 */
public class Mapa {
    private final Miestnost aVstupnaMiestnost;
    
    
    /**
     * Vytvori hru a inicializuje miestnosti - mapu hry.
     */
    public Mapa() {
        Miestnost terasa = new Miestnost("Terasa", "Vstup na fakultu");
        Miestnost vratnica = new Miestnost("Vratnica", "Tu sidli najdolezitejsia osoba na fakulte.");
        Miestnost ic = new Miestnost("IC", "");
        Miestnost chodbaB = new Miestnost("Chodba B", "");
        Miestnost labakB2 = new Miestnost("Laboratorium B2", "");
        Miestnost wc = new Miestnost("WC", "");
        Miestnost chodbaA = new Miestnost("Chodba A", "");
        Miestnost labakA13 = new Miestnost("Laboratorium A13", "");
        Miestnost ucebnaA7 = new Miestnost("Ucebna A7", "");
        Miestnost bufet = new Miestnost("Bufet", "");
        
        terasa.nastavVychod(vratnica);
        
        //vratnica.nastavVychod(terasa);
        vratnica.nastavVychod(ic);
        vratnica.nastavVychod(chodbaB);
        vratnica.nastavVychod(chodbaA);
        
        ic.nastavVychod(vratnica);
        
        chodbaB.nastavVychod(labakB2);
        chodbaB.nastavVychod(wc);
        chodbaB.nastavVychod(vratnica);
        
        labakB2.nastavVychod(chodbaB);
        
        wc.nastavVychod(chodbaB);
        
        chodbaA.nastavVychod(ucebnaA7);
        chodbaA.nastavVychod(bufet);
        chodbaA.nastavVychod(vratnica);
        chodbaA.nastavVychod(labakA13);
        
        labakA13.nastavVychod(chodbaA);

        ucebnaA7.nastavVychod(chodbaA);
        
        bufet.nastavVychod(chodbaA);
        
        aVstupnaMiestnost = terasa;
    }

    public Miestnost dajVstupnuMiestnost() {
        return aVstupnaMiestnost;
    }
}
