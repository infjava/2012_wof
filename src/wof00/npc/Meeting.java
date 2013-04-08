/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.npc;

import wof00.hra.Hrac;

/**
 *
 * @author janik
 */
public class Meeting implements IStavRozhovoru {
    private final String aOslovenie;
    private final CastRozhovoru aPokracovanie;
    
    public Meeting(String paOslovenie, CastRozhovoru paPokracovanie) {
        this.aOslovenie = paOslovenie;
        this.aPokracovanie = paPokracovanie;
    }

    @Override
    public String toString() {
        return aOslovenie;
    }

    @Override
    public IStavRozhovoru dajMoznost(int paMoznost) {
        return aPokracovanie;
    }

    @Override
    public IStavRozhovoru dajNasledujuciStav() {
        return aPokracovanie;
    }

    @Override
    public void vykonajAkciu(Hrac paHrac) {
        
    }
    
}
