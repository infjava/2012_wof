/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.npc;

import wof00.vynimky.UkonciHruException;
import wof00.hra.Hrac;
import wof00.vynimky.OdpovedMimoRozsahException;

/**
 *
 * @author janik
 */
public interface IStavRozhovoru {

    public IStavRozhovoru dajMoznost(int paMoznost)
            throws OdpovedMimoRozsahException;

    public IStavRozhovoru dajNasledujuciStav();

    public void vykonajAkciu(Hrac paHrac) throws UkonciHruException;
    
    public boolean jeKoncovy();
}
