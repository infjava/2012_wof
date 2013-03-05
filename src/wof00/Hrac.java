/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00;

/**
 *
 * @author janik
 */
class Hrac {

    private final String aMenoHraca;
    private Miestnost aAktualnaMiestnost;

    public Hrac(String paMenoHraca, Miestnost paVstupnaMiestnost) {
        this.aMenoHraca = paMenoHraca;
        this.aAktualnaMiestnost = paVstupnaMiestnost;
    }

    public String dajMenoHraca() {
        return aMenoHraca;
    }

    public Miestnost dajAktualnuMiestnost() {
        return aAktualnaMiestnost;
    }

    /**
     * @return True, ak sa podari prejst do miestnosti v danom smere
     */
    public boolean chodDoMiestnosti(String paSmer) {
        final Miestnost miestnostVSmere = aAktualnaMiestnost.dajVychodVSmere(paSmer);

        if (miestnostVSmere == null) {
            return false;
        }

        aAktualnaMiestnost = miestnostVSmere;

        return true;
    }
}
