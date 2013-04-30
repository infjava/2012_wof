/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.prikazy;

import wof00.hra.Hrac;
import wof00.vynimky.ChybaVykonaniaException;
import wof00.vynimky.PredmetNieJeVMiestnostiException;

/**
 *
 * @author janik
 */
public class VykonavacZober implements IVykonavac {

    @Override
    public void vykonaj(String paParameter, Hrac paHrac)
            throws ChybaVykonaniaException {
        if (paParameter == null) {
            System.out.println("Co chces zobrat?");
            throw new ChybaVykonaniaException("Nespravny parameter");
        } else {
            try {
                paHrac.zober(paParameter);
            } catch (PredmetNieJeVMiestnostiException ex) {
                throw new ChybaVykonaniaException("Nepodarilo sa zobrat predmet", ex);
            }
        }
    }
    
    @Override
    public boolean maSaUkladat() {
        return true;
    }
}
