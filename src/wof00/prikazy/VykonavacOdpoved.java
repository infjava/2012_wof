/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.prikazy;

import java.util.Scanner;
import wof00.hra.Hrac;

/**
 *
 * @author janik
 */
class VykonavacOdpoved implements IVykonavac {
    @Override
    public boolean vykonaj(String paParameter, Hrac paHrac) {
        Scanner s = new Scanner(paParameter);
        paHrac.odpovedzNPC(s.nextInt());
        
        return false;
    }
    
}
