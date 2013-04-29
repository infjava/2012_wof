/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.prikazy;

import java.util.concurrent.BrokenBarrierException;
import wof00.hra.Hrac;

/**
 *
 * @author janik
 */
class VykonavacUkonci implements IVykonavac {

    public VykonavacUkonci() {
    }

    @Override
    public void vykonaj(String paParameter, Hrac paHrac) throws BrokenBarrierException {
        if (paParameter == null) {
            throw new BrokenBarrierException();
        } else {
            System.out.println("Ukonci co?");
        }
    }
    
    @Override
    public boolean maSaUkladat() {
        return false;
    }
}
