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
class VykonavacPomoc implements IVykonavac {
    public VykonavacPomoc() {
    }

    @Override
    public boolean vykonaj(String paParameter, Hrac paHrac) {
        System.out.println("Zabludil si. Si sam. Tulas sa po fakulte.");
        System.out.println();
        System.out.println("Mozes pouzit tieto prikazy:");
        System.out.println("   chod ukonci pomoc");
        return false;
    }
    
}
