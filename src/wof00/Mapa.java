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
        
        Predmet brozurka = new Predmet("brozurka", "Tu si mozem pozriet, kde sa mozem zamestnat");
        
        terasa.nastavVychod(new Dvere(vratnica));
        
        //vratnica.nastavVychod(terasa);
        vratnica.nastavVychod(new Dvere(ic));
        vratnica.nastavVychod(new Dvere(chodbaB));
        vratnica.nastavVychod(new Dvere(chodbaA));
        
        ic.nastavVychod(new Dvere(vratnica));
        ic.pridajPredmet(brozurka);
        
        chodbaB.nastavVychod(new Dvere(labakB2));
        chodbaB.nastavVychod(new Dvere(wc));
        chodbaB.nastavVychod(new Dvere(vratnica));
        
        labakB2.nastavVychod(new Dvere(chodbaB));
        
        wc.nastavVychod(new Dvere(chodbaB));
        
        chodbaA.nastavVychod(new Dvere(ucebnaA7));
        chodbaA.nastavVychod(new Dvere(bufet));
        chodbaA.nastavVychod(new Dvere(vratnica));
        chodbaA.nastavVychod(new Dvere(labakA13));
        
        labakA13.nastavVychod(new Dvere(chodbaA));

        ucebnaA7.nastavVychod(new Dvere(chodbaA));
        
        bufet.nastavVychod(new Dvere(chodbaA));
        
        aVstupnaMiestnost = terasa;
    }

    public Miestnost dajVstupnuMiestnost() {
        return aVstupnaMiestnost;
    }
}
