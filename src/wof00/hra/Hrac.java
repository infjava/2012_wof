/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.hra;

import wof00.veci.IVec;
import wof00.prostredie.IDvere;
import wof00.prostredie.ChybaVchadzaniaDoMiestnosti;
import wof00.prostredie.Miestnost;
import java.util.TreeMap;
import wof00.npc.IStavRozhovoru;
import wof00.npc.NPC;

/**
 *
 * @author janik
 */
public class Hrac {

    private final String aMenoHraca;
    private Miestnost aAktualnaMiestnost;
    private TreeMap<String, IVec> aInventar;
    private IStavRozhovoru aAktualnyRozhovor;

    public Hrac(String paMenoHraca, Miestnost paVstupnaMiestnost) {
        this.aMenoHraca = paMenoHraca;
        this.aAktualnaMiestnost = paVstupnaMiestnost;
        aInventar = new TreeMap<String, IVec>();
        aAktualnyRozhovor = null;
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
        final IDvere dvereVSmere = aAktualnaMiestnost.dajDvereVSmere(paSmer);

        if (dvereVSmere == null) {
            return ChybaVchadzaniaDoMiestnosti.neexistujuciVychod;
        } else if (dvereVSmere.suZamknute()) {
            return ChybaVchadzaniaDoMiestnosti.zamknute;
        }

        aAktualnaMiestnost = dvereVSmere.dajMiestnost();
        dvereVSmere.presielCezVas(this);

        return ChybaVchadzaniaDoMiestnosti.ziadna;
    }

    public void zober(String paNazovPredmetu) {
        IVec predmet = aAktualnaMiestnost.zoberPredmet(paNazovPredmetu);
        if (predmet == null) {
            System.out.println("Predmet som proste nenasiel! Pozeraj lepsie!");
        } else {
            aInventar.put(predmet.dajNazov(), predmet);
            System.out.println("Predmet bol pridany do inventara");
        }
    }

    public void vypisInventar() {
        System.out.print("Predmety: ");
        for (String predmet : aInventar.keySet()) {
            System.out.print(predmet + ", ");
        }
        System.out.println();
    }

    public void zahodPredmet(String paNazovPredmetu) {
        IVec predmet = aInventar.remove(paNazovPredmetu);
        if (predmet == null) {
            System.out.println("Takyto predmet som este nezdvihol!");
        } else {
            aAktualnaMiestnost.pridajPredmet(predmet);
            System.out.println("A predmet je uz v miestnosti");
        }
    }

    public void preskumaj(String paNazovPredmetu) {
        IVec predmet = aInventar.get(paNazovPredmetu);

        if (predmet == null) {
            System.out.println("Taky predmet nemam!");
        } else {
            System.out.println(predmet.dajPopis(this));
        }
    }

    public IVec dajPredmet(String paNazovPredmetu) {
        return aInventar.get(paNazovPredmetu);
    }

    public boolean pouziPredmet(String paNazovPredmetu, String paParameter) {
        IVec predmet = aInventar.get(paNazovPredmetu);

        if (predmet != null) {
            return predmet.pouzi(paParameter, this);
        } else {
            System.out.println("Nenasiel sa predmet s danym nazvom");
            return false;
        }
    }

    public void oslovNPC(String paMenoNPC) {
        if (aAktualnyRozhovor == null) {
            NPC npc = aAktualnaMiestnost.dajNPC(paMenoNPC);

            if (npc != null) {
                aAktualnyRozhovor = npc.dajRozhovor();
                this.spracujStavRozhovoru();
            } else {
                System.out.println("Take NPC nevidim!");
            }
        }
    }

    public void odpovedzNPC(int paMoznost) {
        if (aAktualnyRozhovor == null) {
            return;
        }
        
        aAktualnyRozhovor = aAktualnyRozhovor.dajMoznost(paMoznost);
        this.spracujStavRozhovoru();
    }

    private void spracujStavRozhovoru() {
        IStavRozhovoru dalsi;

        while (true) {
            if (aAktualnyRozhovor != null) {
                System.out.println(aAktualnyRozhovor);
            } else {
                aAktualnaMiestnost.infoOMiestnosti();
                break;
            }
            
            aAktualnyRozhovor.vykonajAkciu(this);
            
            dalsi = aAktualnyRozhovor.dajNasledujuciStav();
            
            if (dalsi == null) {
                break;
            }
            
            aAktualnyRozhovor = dalsi;
        }
    }

    public void zober(IVec paPredmet) {
        aInventar.put(paPredmet.dajNazov(), paPredmet);
    }
}
