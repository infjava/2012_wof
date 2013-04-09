/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.npc;

import java.util.Random;
import wof00.hra.Hrac;

/**
 *
 * @author janik
 */
public class TestovaOtazka implements IStavRozhovoru {
    private static Random aNahodneCisla = new Random();
    
    private final String aOtazka;
    private final String[] aOdpovede;
    private final int aSpravna;
    private final IStavRozhovoru aDalsia;
    private final int aPocetBodov;

    public TestovaOtazka(String paOtazka, String[] paOdpovede, int paSpravna, IStavRozhovoru paDalsia) {
        this.aOtazka = paOtazka;
        this.aOdpovede = paOdpovede;
        this.aSpravna = paSpravna;
        this.aDalsia = paDalsia;
        this.aPocetBodov = 0;
    }
    
    TestovaOtazka(TestovaOtazka paOtazka, int paPocetBodov)
    {
        this.aOtazka = paOtazka.aOtazka;
        this.aOdpovede = new String[paOtazka.aOdpovede.length]; //paOtazka.aOdpovede;
        int spravna = 0;
        int i = 1;
        
        for (String odpoved : paOtazka.aOdpovede) {
            int index;
            
            do {
                index = aNahodneCisla.nextInt(aOdpovede.length);
            } while (aOdpovede[index] != null);
            
            aOdpovede[index] = odpoved;
            
            if (i == paOtazka.aSpravna) {
                spravna = index + 1;
            }
            i++;
        }
        
        this.aSpravna = spravna;
        this.aDalsia = paOtazka.aDalsia;
        this.aPocetBodov = paPocetBodov;
    }

    @Override
    public String toString() {
        String ret = aOtazka;
        int i = 1;
        
        for (String odpoved : aOdpovede) {
            ret += "\n" + i + ") " + odpoved;
            i++;
        }
        
        return ret;
    }
    
    @Override
    public IStavRozhovoru dajMoznost(int paMoznost) {
        int body = aPocetBodov;
        if (paMoznost == aSpravna) {
            body++;
        }
        
        if (aDalsia instanceof TestovaOtazka) {
            return new TestovaOtazka((TestovaOtazka)aDalsia, body);
        } else {
            return new KoniecTestu(body, aDalsia);
        }
    }

    @Override
    public IStavRozhovoru dajNasledujuciStav() {
        return null;
    }

    @Override
    public void vykonajAkciu(Hrac paHrac) {
        
    }

    @Override
    public boolean jeKoncovy() {
        return false;
    }
}
