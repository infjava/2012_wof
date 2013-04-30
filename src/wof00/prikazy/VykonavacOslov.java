/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.prikazy;

import wof00.vynimky.UkonciHruException;
import wof00.hra.Hrac;
import wof00.vynimky.ChybaVykonaniaException;
import wof00.vynimky.NeznamaNPCException;

/**
 *
 * @author janik
 */
class VykonavacOslov implements IVykonavac {
    @Override
    public void vykonaj(String paParameter, Hrac paHrac)
            throws UkonciHruException, ChybaVykonaniaException {
        try {
            paHrac.oslovNPC(paParameter);
        } catch (NeznamaNPCException ex) {
            System.out.println(ex.getMessage());
            throw new ChybaVykonaniaException("Nepodarilo sa oslovit NPC", ex);
        }
    }

    @Override
    public boolean maSaUkladat() {
        return true;
    }
}
