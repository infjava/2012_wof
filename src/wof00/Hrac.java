/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00;

import java.util.TreeMap;

/**
 *
 * @author janik
 */
class Hrac {

    private final String aMenoHraca;
    private Miestnost aAktualnaMiestnost;
    private TreeMap<String, Predmet> aInventar;

    public Hrac(String paMenoHraca, Miestnost paVstupnaMiestnost) {
        this.aMenoHraca = paMenoHraca;
        this.aAktualnaMiestnost = paVstupnaMiestnost;
        aInventar = new TreeMap<String, Predmet>();
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
    public ChybaVchadzaniaDoMiestnosti chodDoMiestnosti(String paSmer) {
        final Dvere dvereVSmere = aAktualnaMiestnost.dajDvereVSmere(paSmer);

        if (dvereVSmere == null) {
            return ChybaVchadzaniaDoMiestnosti.neexistujuciVychod;
        } else if (dvereVSmere.suZamknute()) {
            return ChybaVchadzaniaDoMiestnosti.zamknute;
        }

        aAktualnaMiestnost = dvereVSmere.dajMiestnost();

        return ChybaVchadzaniaDoMiestnosti.ziadna;
    }

    void zober(String paNazovPredmetu) {
        Predmet predmet = aAktualnaMiestnost.zoberPredmet(paNazovPredmetu);
        if (predmet == null) {
            System.out.println("Predmet som proste nenasiel! Pozeraj lepsie!");
        } else {
            aInventar.put(predmet.dajNazov(), predmet);
            System.out.println("Predmet bol pridany do inventara");
        }
    }

    void vypisInventar() {
        System.out.print("Predmety: ");
        for (String predmet : aInventar.keySet()) {
            System.out.print(predmet + ", ");
        }
        System.out.println();
    }

    void zahodPredmet(String paNazovPredmetu) {
        Predmet predmet = aInventar.remove(paNazovPredmetu);
        if (predmet == null) {
            System.out.println("Takyto predmet som este nezdvihol!");
        } else {
            aAktualnaMiestnost.pridajPredmet(predmet);
            System.out.println("A predmet je uz v miestnosti");
        }
    }

    void preskumaj(String paNazovPredmetu) {
        Predmet predmet = aInventar.get(paNazovPredmetu);
        
        if (predmet == null) {
            System.out.println("Taky predmet nemam!");
        } else {
            System.out.println(predmet.dajPopis());
        }
    }

    Predmet dajPredmet(String paNazovPredmetu) {
        return aInventar.get(paNazovPredmetu);
    }

    boolean pouziPredmet(String paNazovPredmetu, String paParameter) {
        Predmet predmet = aInventar.get(paNazovPredmetu);
        return predmet.pouzi(paParameter, this);
    }
}
