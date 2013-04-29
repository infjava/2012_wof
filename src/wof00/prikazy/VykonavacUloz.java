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
class VykonavacUloz implements IVykonavac {
    @Override
    public void vykonaj(String paParameter, Hrac paHrac) throws BrokenBarrierException {
        paHrac.dajHru().uloz(paParameter);
    }

    @Override
    public boolean maSaUkladat() {
        return false;
    }
}
