package wof00.hra;

import java.io.FileNotFoundException;
import wof00.vynimky.UkonciHruException;
import wof00.prostredie.Mapa;
import wof00.prikazy.Prikaz;
import wof00.prikazy.Parser;

/**
 * Trieda Hra je hlavna trieda aplikacie "World of FRI". "World of FRI" je velmi
 * jednoducha textova hra - adventura. Hrac sa moze prechadzat po niektorych
 * priestoroch - miestnostiach fakulty. To je v tejto verzii vsetko. Hru treba
 * skutocne zancne rozsirit, aby bola zaujimava.
 *
 * Ak chcete hrat "World of FRI", vytvorte instanciu triedy Hra (hra) a poslite
 * jej spravu hraj.
 *
 * Hra vytvori a inicializuje vsetky potebne objekty: vytvori vsetky miestnosti,
 * vytvori parser a zacne hru. Hra tiez vyhodnocuje a vykonava prikazy, ktore
 * vrati parser.
 *
 * @author Michael Kolling, David J. Barnes
 * @version 2006.03.30
 * @author lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
 */
public class Hra {

    private final String aMenoHraca;
    
    private final Parser aParser;
    private Mapa aMapa;
    private Hrac aHrac;

    /**
     * Create the game and initialise its internal map.
     */
    public Hra(String paMenoHraca) {
        aMenoHraca = paMenoHraca;
        
        aParser = new Parser();
        
        this.inicializuj();
    }

    /**
     * Hlavna metoda hry. Cyklicky opakuje kroky hry, kym hrac hru neukonci.
     */
    public void hraj() {
        vypisPrivitanie();

        // Vstupny bod hlavneho cyklu.
        // Opakovane nacitava prikazy hraca
        // vykonava ich kym hrac nezada prikaz na ukoncenie hry.

        boolean jeKoniec = false;
        while (!jeKoniec) {
            Prikaz prikaz = aParser.dajPrikaz();
            if (prikaz == null) {
                System.out.println("Nerozumiem, co mas na mysli...");
            } else {
                try {
                    prikaz.vykonajPrikaz(aHrac);
                } catch (UkonciHruException ex) {
                    jeKoniec = true;
                }
            }
        }
        System.out.println("Maj sa fajn!");
    }

    /**
     * Vypise privitanie hraca do terminaloveho okna.
     */
    private void vypisPrivitanie() {
        System.out.println();
        System.out.println(aHrac.dajMenoHraca() + ", vitaj v hre World of FRI!");
        System.out.println("World of FRI je nova, neuveritelne nudna adventura.");
        System.out.println("Zadaj 'pomoc' ak potrebujes pomoc.");
        System.out.println();
        aHrac.dajAktualnuMiestnost().infoOMiestnosti();
    }
    
    public void uloz(String paNazovSuboru) {
        try {
            aParser.uloz(paNazovSuboru);
            System.out.println("Ulozene...");
        } catch (FileNotFoundException ex) {
            System.out.println("Nepodarilo sa zapisat - neznama chyba");
            ex.printStackTrace();
        }
    }
    
    public void nacitaj(String paNazovSuboru) {
        Hrac staryHrac = aHrac;
        Mapa staraMapa = aMapa;
        
        this.inicializuj();
        try {
            for (Prikaz prikaz : aParser.nacitaj(paNazovSuboru)) {
                try {
                    prikaz.vykonajPrikaz(aHrac);
                } catch (Exception ex) {
                    aHrac = staryHrac;
                    aMapa = staraMapa;
                    System.out.println("Nepodarilo sa nacitat subor - neznama chyba");
                    ex.printStackTrace();
                }
            }
        } catch (FileNotFoundException ex) {
            aHrac = staryHrac;
            aMapa = staraMapa;
            System.out.println("Nepodarilo sa nacitat subor - neznama chyba");
            ex.printStackTrace();
        }
        
        System.out.println("Nacitane...");
    }

    private void inicializuj() {
        aMapa = new Mapa();
        aHrac = new Hrac(aMenoHraca, aMapa.dajVstupnuMiestnost(), this);
    }
}
