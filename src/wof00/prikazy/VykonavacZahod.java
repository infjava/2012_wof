/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.prikazy;

import wof00.hra.Hrac;

/**
 *
 * @author janik
 */
class VykonavacZahod implements IVykonavac {

    public VykonavacZahod() {
    }

    @Override
    public boolean vykonaj(String paParameter, Hrac paHrac) {
        if (paParameter == null) {
            System.out.println("Co chces zahodit?");
        } else {
            paHrac.zahodPredmet(paParameter);
        }
        
        return false;
    }
}
