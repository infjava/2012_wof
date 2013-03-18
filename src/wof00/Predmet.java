/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00;

/**
 *
 * @author janik
 */
public class Predmet {
    private final String aNazov;
    private final String aPopis;

    public Predmet(String paNazov, String paPopis) {
        this.aNazov = paNazov;
        this.aPopis = paPopis;
    }

    public String dajNazov() {
        return aNazov;
    }

    public String dajPopis() {
        return aPopis;
    }

    boolean pouzi(String paParameter, Hrac paHrac) {
        System.out.println("Tak to teda nie! " + aNazov + " sa neda pouzit!");
        return false;
    }
}
