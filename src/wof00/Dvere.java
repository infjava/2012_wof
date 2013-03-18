/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00;

/**
 *
 * @author janik
 */
class Dvere {
    private String aNazov;
    private Miestnost aMiestnost;
    private boolean aZamknute;
    
    public Dvere(Miestnost paMiestnost) {
        this(paMiestnost, false);
    }

    public Dvere(Miestnost paMiestnost, boolean paZamknute) {
        this(paMiestnost.dajNazov(), paMiestnost, paZamknute);
    }

    public Dvere(String paNazov, Miestnost paMiestnost) {
        this(paNazov, paMiestnost, false);
    }

    public Dvere(String paNazov, Miestnost paMiestnost, boolean paZamknute) {
        this.aNazov = paNazov;
        this.aMiestnost = paMiestnost;
        aZamknute = paZamknute;
    }

    public String dajNazov() {
        return aNazov;
    }

    public Miestnost dajMiestnost() {
        return aMiestnost;
    }
    
    public boolean suZamknute() {
        return false;
    }

    Dvere vytvorPodobne(Miestnost paMiestnost) {
        return new Dvere(paMiestnost);
    }
}
