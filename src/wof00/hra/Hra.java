package wof00.hra;

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

    private Parser aParser;
    private final Mapa aMapa;
    private final Hrac aHrac;

    /**
     * Create the game and initialise its internal map.
     */
    public Hra(String paMenoHraca) {
        aMapa = new Mapa();
        aParser = new Parser();
        aHrac = new Hrac(paMenoHraca, aMapa.dajVstupnuMiestnost());
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
            jeKoniec = prikaz.vykonajPrikaz(aHrac);
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
}
