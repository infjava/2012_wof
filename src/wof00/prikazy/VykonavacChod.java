/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.prikazy;

import wof00.hra.Hrac;
import wof00.vynimky.ChodenieException;
import wof00.vynimky.ChybaVykonaniaException;

/**
 *
 * @author janik
 */
class VykonavacChod implements IVykonavac {

    public VykonavacChod() {
    }

    @Override
    public void vykonaj(String paParameter, Hrac paHrac)
            throws ChybaVykonaniaException {
        if (paParameter == null) {
            System.out.println("Chod kam?");
            throw new ChybaVykonaniaException("Nespravny parameter");
        }
        
        try {
            paHrac.chodDoMiestnosti(paParameter);
        } catch (ChodenieException ex) {
            System.out.println(ex.getMessage());
            throw new ChybaVykonaniaException("Nepodarilo sa vojst do miestnosti", ex);
        }
        
        paHrac.dajAktualnuMiestnost().infoOMiestnosti();
    }

    @Override
    public boolean maSaUkladat() {
        return true;
    }
    
}
