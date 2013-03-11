/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00;

/**
 *
 * @author janik
 */
class VykonavacChod implements IVykonavac {

    public VykonavacChod() {
    }

    @Override
    public boolean vykonaj(String paParameter, Hrac paHrac) {
        if (paParameter == null) {
            System.out.println("Chod kam?");
            return false;
        }
        if (paHrac.chodDoMiestnosti(paParameter)) {
            paHrac.dajAktualnuMiestnost().infoOMiestnosti();
        } else {
            System.out.println("Tam nie je vychod!");
        }
        
        return false;
    }
    
}
