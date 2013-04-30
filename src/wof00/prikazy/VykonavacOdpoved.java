/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.prikazy;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import wof00.vynimky.UkonciHruException;
import wof00.hra.Hrac;
import wof00.vynimky.ChybaVykonaniaException;
import wof00.vynimky.OdpovedMimoRozsahException;

/**
 *
 * @author janik
 */
class VykonavacOdpoved implements IVykonavac {
    @Override
    public void vykonaj(String paParameter, Hrac paHrac)
            throws UkonciHruException, ChybaVykonaniaException {
        int odpoved;
        
        try {
            odpoved = Integer.parseInt(paParameter);
        } catch (NumberFormatException ex) {
            System.out.println("Nespravny parameter!");
            throw new ChybaVykonaniaException("Nespravny format parametra", ex);
        }
        try {
            paHrac.odpovedzNPC(odpoved);
        } catch (OdpovedMimoRozsahException ex) {
            System.out.println(ex.getMessage());
            throw new ChybaVykonaniaException("Odpoved mimo rozsah", ex);
        }
    }
    

    @Override
    public boolean maSaUkladat() {
        return true;
    }
}
