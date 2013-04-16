/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.prostredie;

import wof00.npc.ZadanieQuestu;
import wof00.questy.KradnutiePocitacov;
import wof00.npc.Meeting;
import wof00.npc.OdovzdaniePredmetu;
import wof00.npc.CastRozhovoru;
import wof00.npc.IStavRozhovoru;
import wof00.npc.NPC;
import wof00.npc.Test;
import wof00.npc.TestovaOtazka;
import wof00.questy.ZiskanieKluca;
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
        
        ic.pridajPredmet(brozurka);
        
        chodbaB.nastavVychod(new DvereISIC(labakB2));
        chodbaB.nastavVychod(new Dvere(wc));
        
        DvereNaKluc dvereDoA7 = new DvereNaKluc(ucebnaA7);
        chodbaA.nastavVychod(dvereDoA7);
        chodbaA.nastavVychod(new DvereISIC(labakA13));
        
        //vratnica.pridajPredmet(new Kluc(dvereDoA7));
        
        bufet.nastavVychod(new DvereISIC(chodbaA));
        
        //CastRozhovoru rozhovorSVratnickouKluc = new CastRozhovoru("Tu mas");
        
        CastRozhovoru rozhovorSVratnickou = new CastRozhovoru("Co chces?");
        Meeting meetingSVratnickou = new Meeting("Cau vratnicka\nVitam ta putnik", rozhovorSVratnickou);
        OdovzdaniePredmetu rozhovorSVratnickouKluc = new OdovzdaniePredmetu(
                new Kluc(dvereDoA7), "tu mas!", rozhovorSVratnickou
            );
        IStavRozhovoru rozhovorSVratnickouUloha = new ZadanieQuestu(
                new KradnutiePocitacov(), "tu mas!", rozhovorSVratnickou
            );
        
        rozhovorSVratnickou.pridajOdpoved("kluc", rozhovorSVratnickouKluc);
        rozhovorSVratnickou.pridajOdpoved("ulohu", rozhovorSVratnickouUloha);
        rozhovorSVratnickou.pridajOdpoved("Vdaka nic!", null);
        
        labakA13.pridajPredmet(new Predmet("pcA13", "Pocitac z labaku A13"));
        labakB2.pridajPredmet(new Predmet("pcB2", "Pocitac z labaku B2"));
        
        NPC vratnicka = new NPC("vratnicka", meetingSVratnickou);
        
        vratnica.pridajNPC(vratnicka);
        
        IStavRozhovoru ucitelTest = new Test(
                    "Odpovedaj:",
                    new TestovaOtazka(
                        "Ako sa mas?",
                        new String[]{
                            "dobre",
                            "zle",
                            "neviem",
                            "co? ako?"
                        },
                        1,
                        new TestovaOtazka(
                            "Kolko je 1+2",
                            new String[]{
                                "1",
                                "2",
                                "3",
                                "to je co?"
                            },
                            3,
                            new TestovaOtazka(
                                "Co je to polymorfizmus?",
                                new String[]{
                                    "schopnost programu nadobudat rozne tvary",
                                    "na jednu spravu reaguje objekt roznymi sposobmi",
                                    "nic zaujimave",
                                    "konstrukcia interface"
                                },
                                2,
                                null
                            )
                        )
                    )
                );
        
        terasa.pridajNPC(
            new NPC(
                "ucitel",
                new ZadanieQuestu(new ZiskanieKluca(), "tu mas", ucitelTest)
            )
        );
        
        aVstupnaMiestnost = terasa;
    }

    public Miestnost dajVstupnuMiestnost() {
        return aVstupnaMiestnost;
    }
}
