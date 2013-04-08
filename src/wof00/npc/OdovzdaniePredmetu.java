/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.npc;

import wof00.hra.Hrac;
import wof00.veci.IVec;

/**
 *
 * @author janik
 */
public class OdovzdaniePredmetu implements IStavRozhovoru {
    private IVec aPredmet;
    private final String aOdpoved;
    private final IStavRozhovoru aPokracovanie;

    public OdovzdaniePredmetu(IVec paPredmet, String paOdpoved, IStavRozhovoru paPokracovanie) {
        this.aPredmet = paPredmet;
        this.aOdpoved = paOdpoved;
        this.aPokracovanie = paPokracovanie;
        
    }

    @Override
    public String toString() {
        if (aPredmet == null) {
            return "Take nic nemam!";
        } else {
            return this.aOdpoved;
        }
    }

    @Override
    public IStavRozhovoru dajMoznost(int paMoznost) {
        return this.aPokracovanie;
    }

    @Override
    public IStavRozhovoru dajNasledujuciStav() {
        return this.aPokracovanie;
    }

    @Override
    public void vykonajAkciu(Hrac paHrac) {
        if (aPredmet != null) {
            paHrac.zober(aPredmet);
        }
        aPredmet = null;
    }
    
}
