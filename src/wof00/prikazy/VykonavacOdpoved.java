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
class VykonavacOdpoved implements IVykonavac {
    @Override
    public boolean vykonaj(String paParameter, Hrac paHrac) {
        paHrac.odpovedzNPC(Integer.parseInt(paParameter));
        
        return false;
    }
    
}