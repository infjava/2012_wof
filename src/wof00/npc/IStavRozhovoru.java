/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.npc;

import java.util.concurrent.BrokenBarrierException;
import wof00.hra.Hrac;

/**
 *
 * @author janik
 */
public interface IStavRozhovoru {

    public IStavRozhovoru dajMoznost(int paMoznost);

    public IStavRozhovoru dajNasledujuciStav();

    public void vykonajAkciu(Hrac paHrac) throws BrokenBarrierException;
    
    public boolean jeKoncovy();
}
