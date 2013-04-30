/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.prikazy;

import wof00.vynimky.UkonciHruException;
import wof00.hra.Hrac;
import wof00.vynimky.ChybaVykonaniaException;

/**
 *
 * @author janik
 */
interface IVykonavac {

    public void vykonaj(String paParameter, Hrac paHrac)
            throws UkonciHruException, ChybaVykonaniaException;

    public boolean maSaUkladat();
    
}
