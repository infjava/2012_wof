/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.prikazy;

import hra.Hrac;

/**
 *
 * @author janik
 */
class VykonavacInventar implements IVykonavac {

    public VykonavacInventar() {
    }

    @Override
    public boolean vykonaj(String paParameter, Hrac paHrac) {
        paHrac.vypisInventar();
        
        return false;
    }
    
}
