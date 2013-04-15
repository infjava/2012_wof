/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.hra;

import java.util.ArrayList;
import wof00.veci.IVec;
import wof00.prostredie.IDvere;
import wof00.prostredie.ChybaVchadzaniaDoMiestnosti;
import wof00.prostredie.Miestnost;
import java.util.TreeMap;
import wof00.npc.IStavRozhovoru;
import wof00.npc.NPC;
import wof00.questy.IQuest;

/**
 *
 * @author janik
 */
public class Hrac {

    private final String aMenoHraca;
    private Miestnost aAktualnaMiestnost;
    private TreeMap<String, IVec> aInventar;
    private IStavRozhovoru aAktualnyRozhovor;
    private ArrayList<IQuest> aQuesty;

    public Hrac(String paMenoHraca, Miestnost paVstupnaMiestnost) {
        this.aMenoHraca = paMenoHraca;
        this.aAktualnaMiestnost = paVstupnaMiestnost;
        aInventar = new TreeMap<String, IVec>();
        aAktualnyRozhovor = null;
        aQuesty = new ArrayList<IQuest>();
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
        
        for (IQuest quest : aQuesty) {
            quest.hracVosielDoMiestnosti(aAktualnaMiestnost);
        }

        return ChybaVchadzaniaDoMiestnosti.ziadna;
    }

    public void zober(String paNazovPredmetu) {
        IVec predmet = aAktualnaMiestnost.zoberPredmet(paNazovPredmetu);
        if (predmet == null) {
            System.out.println("Predmet som proste nenasiel! Pozeraj lepsie!");
        } else {
            System.out.println("Predmet bol pridany do inventara");
            this.zober(predmet);
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
            for (IQuest quest : aQuesty) {
                quest.hracZahodilPredmet(predmet);
            }
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
                break;
            }
            
            aAktualnyRozhovor.vykonajAkciu(this);
            
            dalsi = aAktualnyRozhovor.dajNasledujuciStav();
            
            if (dalsi == null) {
                break;
            }
            
            aAktualnyRozhovor = dalsi;
        }
        
        if (aAktualnyRozhovor != null && aAktualnyRozhovor.jeKoncovy()) {
            aAktualnyRozhovor = null;
        }
        
        if (aAktualnyRozhovor == null) {
            aAktualnaMiestnost.infoOMiestnosti();
        }
    }

    public void zober(IVec paPredmet) {
        aInventar.put(paPredmet.dajNazov(), paPredmet);
        
        for (IQuest quest : aQuesty) {
            quest.hracZobralPredmet(paPredmet);
        }
    }

    public void zadajQuest(IQuest paQuest) {
        aQuesty.add(paQuest);
        paQuest.aktivujSa(this);
    }

    public void vypisQuesty() {
        System.out.println("Questy:");
        for (IQuest quest : aQuesty) {
            System.out.println("- " + quest + " - " + quest.dajStav());
        }
    }

    public void vymazPredmet(String paNazovPredmetu) {
        aInventar.remove(paNazovPredmetu);
    }
}
