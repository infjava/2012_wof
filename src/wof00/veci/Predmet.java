/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.veci;

import wof00.hra.Hrac;

/**
 *
 * @author janik
 */
public class Predmet implements IVec {

    private final String aNazov;
    private final String aPopis;

    public Predmet(String paNazov, String paPopis) {
        this.aNazov = paNazov;
        this.aPopis = paPopis;
    }

    public String dajNazov() {
        return aNazov;
    }

    public String dajPopis(Hrac paHrac) {
        return aPopis;
    }

    public boolean pouzi(String paParameter, Hrac paHrac) {
        System.out.println("Tak to teda nie! " + aNazov + " sa neda pouzit!");
        return false;
    }
}
