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
class VykonavacUkaz implements IVykonavac {

    public VykonavacUkaz() {
    }

    @Override
    public void vykonaj(String paParameter, Hrac paHrac) {
        if (paParameter == null) {
            paHrac.dajAktualnuMiestnost().infoOMiestnosti();
        } else {
            // Ak bol zadany parameter, kukame na predmet
            paHrac.preskumaj(paParameter);
        }
    }
}
