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
class VykonavacZahod implements IVykonavac {

    public VykonavacZahod() {
    }

    @Override
    public void vykonaj(String paParameter, Hrac paHrac)
            throws ChybaVykonaniaException {
        if (paParameter == null) {
            System.out.println("Co chces zahodit?");
            throw new ChybaVykonaniaException("Nespravny parameter");
        } else {
            try {
                paHrac.zahodPredmet(paParameter);
            } catch (PredmetNieJeVInventariException ex) {
                System.out.println(ex.getMessage());
                throw new ChybaVykonaniaException("Nepodarilo sa zahodit predmet", ex);
            }
        }
    }

    @Override
    public boolean maSaUkladat() {
        return true;
    }
}
