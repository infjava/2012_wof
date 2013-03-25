/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.prikazy;

import hra.Hrac;

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
        
        switch (paHrac.chodDoMiestnosti(paParameter)) {
            case neexistujuciVychod:
                System.out.println("Tam nie je vychod!");
                break;
            case zamknute:
                System.out.println("Vychod je zamknuty!");
                break;
            case ziadna:
                paHrac.dajAktualnuMiestnost().infoOMiestnosti();
                break;
        }
        
        return false;
    }
    
}
