/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.npc;

import java.util.ArrayList;
import wof00.hra.Hrac;

/**
 *
 * @author janik
 */
public class CastRozhovoru implements IStavRozhovoru {
    private final String aUvod;
    private final ArrayList<Odpoved> aOdpovede;

    public CastRozhovoru(String paUvod) {
        this.aUvod = paUvod;
        aOdpovede = new ArrayList<Odpoved>();
    }

    @Override
    public String toString() {
        String ret = aUvod + "\n";
        int i = 1;
        
        for (Odpoved odpoved : aOdpovede) {
            ret += i + ": " + odpoved + "\n";
            i++;
        }
        
        return ret;
    }

    public void pridajOdpoved(String paOdpoved, IStavRozhovoru paCastRozhovoru) {
        aOdpovede.add(new Odpoved(paOdpoved, paCastRozhovoru));
    }

    public IStavRozhovoru dajMoznost(int paMoznost) {
        if (paMoznost < 1 || paMoznost > aOdpovede.size()) {
            return this;
        }
        return aOdpovede.get(paMoznost - 1).dajRozhovor();
    }

    @Override
    public IStavRozhovoru dajNasledujuciStav() {
        return null;
    }

    @Override
    public void vykonajAkciu(Hrac paHrac) {
        
    }
}
