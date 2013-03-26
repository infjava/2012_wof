/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.prostredie;

import wof00.npc.CastRozhovoru;
import wof00.npc.NPC;
import wof00.veci.ISIC;
import wof00.veci.Kluc;
import wof00.veci.Predmet;

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
        terasa.pridajPredmet(new ISIC());
        
        //vratnica.nastavVychod(terasa);
        vratnica.nastavVychod(new Dvere(ic));
        vratnica.nastavVychod(new Dvere(chodbaB));
        vratnica.nastavVychod(new Dvere(chodbaA));
        
        CastRozhovoru rozhovorSVratnickouKluc = new CastRozhovoru("Tu mas");
        
        CastRozhovoru rozhovorSVratnickou = new CastRozhovoru("Cau vratnicka\nVitam ta putnik\nCo chces?");
        rozhovorSVratnickou.pridajOdpoved("kluc", rozhovorSVratnickouKluc);
        rozhovorSVratnickou.pridajOdpoved("Vdaka nic!", null);
        
        rozhovorSVratnickouKluc.pridajOdpoved("vdaka", rozhovorSVratnickou);
        
        NPC vratnicka = new NPC("vratnicka", rozhovorSVratnickou);
        
        vratnica.pridajNPC(vratnicka);
        
        ic.pridajPredmet(brozurka);
        
        chodbaB.nastavVychod(new DvereISIC(labakB2));
        chodbaB.nastavVychod(new Dvere(wc));
        
        DvereNaKluc dvereDoA7 = new DvereNaKluc(ucebnaA7);
        chodbaA.nastavVychod(dvereDoA7);
        chodbaA.nastavVychod(new DvereISIC(labakA13));
        
        vratnica.pridajPredmet(new Kluc(dvereDoA7));
        
        bufet.nastavVychod(new DvereISIC(chodbaA));
        
        aVstupnaMiestnost = terasa;
    }

    public Miestnost dajVstupnuMiestnost() {
        return aVstupnaMiestnost;
    }
}