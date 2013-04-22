/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.npc;

import java.util.concurrent.BrokenBarrierException;
import wof00.hra.Hrac;

/**
 *
 * @author janik
 */
public class UmrtieVRozhovore implements IStavRozhovoru {

    @Override
    public String toString() {
        return "Umrel si!";
    }

    @Override
    public IStavRozhovoru dajMoznost(int paMoznost) {
        return null;
    }

    @Override
    public IStavRozhovoru dajNasledujuciStav() {
        return null;
    }

    @Override
    public void vykonajAkciu(Hrac paHrac) throws BrokenBarrierException {
        throw new BrokenBarrierException();
    }

    @Override
    public boolean jeKoncovy() {
        return true;
    }
    
}
