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
public abstract class Quest {
    private StavQuestu aStav;
    private Hrac aHrac;

    public Quest() {
        aStav = StavQuestu.nezadany;
        aHrac = null;
    }
    
    @Override
    public abstract String toString();

    public StavQuestu dajStav() {
        return aStav;
    }

    protected void nastavStav(StavQuestu paNovyStav) {
        aStav = paNovyStav;
    }

    protected Hrac dajHraca() {
        return aHrac;
    }

    public void aktivujSa(Hrac paHrac) {
        this.nastavStav(StavQuestu.zadany);
        aHrac = paHrac;
        System.out.println("Ziskal si quest: " + this.toString());
    }

    public void hracVosielDoMiestnosti(Miestnost paMiestnost) {
    }

    public void hracZobralPredmet(IVec paPredmet) {
    }

    public void hracZahodilPredmet(IVec paPredmet) {
    }

    public void skontrolujRiesenie() {
    }

    public void ukonci() {
    }
}
