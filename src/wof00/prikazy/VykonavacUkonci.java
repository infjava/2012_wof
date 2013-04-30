/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.prikazy;

import wof00.vynimky.UkonciHruException;
import wof00.hra.Hrac;
import wof00.vynimky.ChybaVykonaniaException;

/**
 *
 * @author janik
 */
class VykonavacUkonci implements IVykonavac {

    public VykonavacUkonci() {
    }

    @Override
    public void vykonaj(String paParameter, Hrac paHrac)
            throws UkonciHruException, ChybaVykonaniaException {
        if (paParameter == null) {
            throw new UkonciHruException("Ukoncil si hru prikazom ukonci");
        } else {
            System.out.println("Ukonci co?");
            throw new ChybaVykonaniaException("Nespravny parameter");
        }
    }
    
    @Override
    public boolean maSaUkladat() {
        return false;
    }
}
