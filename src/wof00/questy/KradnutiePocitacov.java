/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.questy;

import wof00.hra.Hrac;
import wof00.prostredie.Miestnost;
import wof00.veci.IVec;

/**
 *
 * @author janik
 */
public class KradnutiePocitacov implements IQuest {
    private final String[] aPocitace = new String[]
    { "pcB2", "pcA13" };
    
    private int aPocetUkradnutych;
    private StavQuestu aStav;
    private Hrac aHrac;
    
    public KradnutiePocitacov() {
        aPocetUkradnutych = 0;
        aStav = StavQuestu.nezadany;
        aHrac = null;
    }

    @Override
    public String toString() {
        return "Ukradni dva pocitace z labakov (" + aPocetUkradnutych + "/2)";
    }

    @Override
    public void hracVosielDoMiestnosti(Miestnost paMiestnost) {
        for (String pc : aPocitace) {
            if (paMiestnost.dajPredmet(pc) != null) {
                System.out.println("Zober " + pc);
            }
        }
    }

    @Override
    public void hracZobralPredmet(IVec paPredmet) {
        for (String pc : aPocitace) {
            if (pc.equals(paPredmet.dajNazov())) {
                aPocetUkradnutych ++;
            }
        }
    }

    @Override
    public void hracZahodilPredmet(IVec paPredmet) {
        for (String pc : aPocitace) {
            if (pc.equals(paPredmet.dajNazov())) {
                aPocetUkradnutych --;
            }
        }
    }

    @Override
    public StavQuestu dajStav() {
        return aStav;
    }

    @Override
    public void aktivujSa(Hrac paHrac) {
        aStav = StavQuestu.zadany;
        aHrac = paHrac;
    }

    @Override
    public void skontrolujRiesenie() {
        if (aPocetUkradnutych == 2) {
            aStav = StavQuestu.splneny;
            
            for (String pc : aPocitace) {
                aHrac.vymazPredmet(pc);
            }
        }
    }

    @Override
    public void ukonci() {
        if (aStav == StavQuestu.splneny) {
            aStav = StavQuestu.ukonceny;
        }
    }
}
