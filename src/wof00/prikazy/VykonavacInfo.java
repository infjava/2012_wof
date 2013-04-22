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
class VykonavacInfo implements IVykonavac {

    public VykonavacInfo() {
    }

    @Override
    public void vykonaj(String paParameter, Hrac paHrac) {
        paHrac.vypisInventar();
        paHrac.vypisQuesty();
    }
    
}
