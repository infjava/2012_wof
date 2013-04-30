/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.hra;

import java.util.ArrayList;
import wof00.veci.IVec;
import wof00.prostredie.IDvere;
import wof00.prostredie.Miestnost;
import java.util.TreeMap;
import wof00.vynimky.UkonciHruException;
import wof00.base.IPouzitelny;
import wof00.npc.IStavRozhovoru;
import wof00.npc.NPC;
import wof00.questy.Quest;
import wof00.vynimky.NeznamaNPCException;
import wof00.vynimky.OdpovedMimoRozsahException;
import wof00.vynimky.PredmetNieJeVInventariException;
import wof00.vynimky.PredmetNieJeVMiestnostiException;
import wof00.vynimky.PredmetSaNedaPouzitException;
import wof00.vynimky.ZamknuteDvereException;
import wof00.vynimky.ZiadnyVychodException;

/**
 *
 * @author janik
 */
public class Hrac {

    private final String aMenoHraca;
    private Miestnost aAktualnaMiestnost;
    private TreeMap<String, IVec> aInventar;
    private IStavRozhovoru aAktualnyRozhovor;
    private ArrayList<Quest> aQuesty;
    private final Hra aHra;

    public Hrac(String paMenoHraca, Miestnost paVstupnaMiestnost, Hra paHra) {
        this.aMenoHraca = paMenoHraca;
        this.aAktualnaMiestnost = paVstupnaMiestnost;
        aInventar = new TreeMap<String, IVec>();
        aAktualnyRozhovor = null;
        aQuesty = new ArrayList<Quest>();
        aHra = paHra;
    }
    
    public Hra dajHru() {
        return aHra;
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
    public void chodDoMiestnosti(String paSmer)
            throws ZiadnyVychodException, ZamknuteDvereException {
        final IDvere dvereVSmere = aAktualnaMiestnost.dajDvereVSmere(paSmer);

        if (dvereVSmere == null) {
            throw new ZiadnyVychodException("V smere " + paSmer + " vychod nie je");
        } else if (dvereVSmere.suZamknute()) {
            throw new ZamknuteDvereException("Dvere v smere " + paSmer + " su zamknute");
        }

        aAktualnaMiestnost = dvereVSmere.dajMiestnost();
        dvereVSmere.presielCezVas(this);
        
        for (Quest quest : aQuesty) {
            quest.hracVosielDoMiestnosti(aAktualnaMiestnost);
        }
    }

    public void zober(String paNazovPredmetu)
            throws PredmetNieJeVMiestnostiException {
        IVec predmet = aAktualnaMiestnost.zoberPredmet(paNazovPredmetu);
        if (predmet == null) {
            throw new PredmetNieJeVMiestnostiException("Predmet " + paNazovPredmetu + " sa v miestnosti nenachadza");
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

    public void zahodPredmet(String paNazovPredmetu) throws PredmetNieJeVInventariException {
        IVec predmet = aInventar.remove(paNazovPredmetu);
        if (predmet == null) {
            throw new PredmetNieJeVInventariException("Predmet " + paNazovPredmetu + " nemas v inventari");
        } else {
            aAktualnaMiestnost.pridajPredmet(predmet);
            System.out.println("A predmet je uz v miestnosti");
            for (Quest quest : aQuesty) {
                quest.hracZahodilPredmet(predmet);
            }
        }
    }

    public void preskumaj(String paNazovPredmetu)
            throws PredmetNieJeVInventariException {
        IVec predmet = aInventar.get(paNazovPredmetu);

        if (predmet == null) {
            throw new PredmetNieJeVInventariException("Predmet " + paNazovPredmetu + " nemas v inventari");
        } else {
            System.out.println(predmet.dajPopis(this));
        }
    }

    public IVec dajPredmet(String paNazovPredmetu) {
        return aInventar.get(paNazovPredmetu);
    }

    public void pouzi(String paNazov, String paParameter)
            throws PredmetNieJeVInventariException, PredmetSaNedaPouzitException {
        IVec predmet = aInventar.get(paNazov);

        if (predmet != null) {
            predmet.pouzi(paParameter, this);
        } else if (aAktualnaMiestnost instanceof IPouzitelny
                && paNazov.equals(aAktualnaMiestnost.dajNazov()) ) {
            ((IPouzitelny)aAktualnaMiestnost).pouzi(paParameter, this);
        } else {
            throw new PredmetNieJeVInventariException("Predmet " + paNazov + " nemas v inventari");
        }
    }

    public void oslovNPC(String paMenoNPC)
            throws UkonciHruException, NeznamaNPCException {
        if (aAktualnyRozhovor == null) {
            NPC npc = aAktualnaMiestnost.dajNPC(paMenoNPC);

            if (npc != null) {
                aAktualnyRozhovor = npc.dajRozhovor();
                this.spracujStavRozhovoru();
            } else {
                throw new NeznamaNPCException("Osobu " + paMenoNPC + " som nenasiel");
            }
        }
    }

    public void odpovedzNPC(int paMoznost)
            throws UkonciHruException, OdpovedMimoRozsahException {
        if (aAktualnyRozhovor == null) {
            return;
        }
        
        aAktualnyRozhovor = aAktualnyRozhovor.dajMoznost(paMoznost);
        this.spracujStavRozhovoru();
    }

    private void spracujStavRozhovoru() throws UkonciHruException {
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
        
        for (Quest quest : aQuesty) {
            quest.hracZobralPredmet(paPredmet);
        }
    }

    public void zadajQuest(Quest paQuest) {
        aQuesty.add(paQuest);
        paQuest.aktivujSa(this);
    }

    public void vypisQuesty() {
        System.out.println("Questy:");
        for (Quest quest : aQuesty) {
            System.out.println("- " + quest + " - " + quest.dajStav());
        }
    }

    public void vymazPredmet(String paNazovPredmetu) {
        aInventar.remove(paNazovPredmetu);
    }
}
