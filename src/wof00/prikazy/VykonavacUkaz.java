/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.prikazy;

import wof00.hra.Hrac;
import wof00.vynimky.ChybaVykonaniaException;
import wof00.vynimky.PredmetNieJeVInventariException;

/**
 *
 * @author janik
 */
class VykonavacUkaz implements IVykonavac {

    public VykonavacUkaz() {
    }

    @Override
    public void vykonaj(String paParameter, Hrac paHrac)
            throws ChybaVykonaniaException {
        if (paParameter == null) {
            paHrac.dajAktualnuMiestnost().infoOMiestnosti();
        } else {
            try {
                // Ak bol zadany parameter, kukame na predmet
                paHrac.preskumaj(paParameter);
            } catch (PredmetNieJeVInventariException ex) {
                System.out.println(ex.getMessage());
                throw new ChybaVykonaniaException("Nepodarilo sa preskumat predmet", ex);
            }
        }
    }

    @Override
    public boolean maSaUkladat() {
        return false;
    }
}
