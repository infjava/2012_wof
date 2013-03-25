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
class VykonavacUkonci implements IVykonavac {

    public VykonavacUkonci() {
    }

    @Override
    public boolean vykonaj(String paParameter, Hrac paHrac) {
        if (paParameter == null) {
            return true;
        } else {
            System.out.println("Ukonci co?");
            return false;
        }
    }
    
}
