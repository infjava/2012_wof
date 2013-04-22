/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.prikazy;

import java.util.Scanner;
import java.util.concurrent.BrokenBarrierException;
import wof00.hra.Hrac;

/**
 *
 * @author janik
 */
class VykonavacOdpoved implements IVykonavac {
    @Override
    public void vykonaj(String paParameter, Hrac paHrac)  throws BrokenBarrierException {
        Scanner s = new Scanner(paParameter);
        paHrac.odpovedzNPC(s.nextInt());
    }
    
}
