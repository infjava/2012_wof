/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00;

/**
 *
 * @author janik
 */
class VykonavacUkaz implements IVykonavac {

    public VykonavacUkaz() {
    }

    @Override
    public boolean vykonaj(String paParameter, Hrac paHrac) {
        if (paParameter == null) {
            paHrac.dajAktualnuMiestnost().infoOMiestnosti();
        } else {
            // Ak bol zadany parameter, kukame na predmet
            paHrac.preskumaj(paParameter);
        }
        
        return false;
    }
}
