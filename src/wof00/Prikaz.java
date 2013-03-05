package wof00;

/**
 * Trieda prikaz implemntuje casti prikazu, ktore moze hrac zadat.
 * V tejto verzii prikaz tvoria dve slova: nazov prikazu a druhe slovo.
 * Napriklad prikaz "chod juh" tvoria dva retazce "chod" ako nazov prikazu a
 * "juh" ako oznacenie smeru.
 * 
 * Predpoklada sa, ze prikaz je skontrolovany, t.j., ze nazov prikazu je znamy.
 * Pre neznamy prikaz je jeho nazov nastaveny na hodnotu <null>.
 *
 * Ak prikaz nema parameter, potom ma druhe slovo hodnotu <null>.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 * @author  lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
 */

public class Prikaz
{
    private String aNazovPrikazu;
    private String aParameter;

    /**
     * Inicializuje slova prikazu dvomi zadanymi parametrami. Jeden alebo oba
     * parametre mozu mat hodnotu <null>.

     * @param paNazovPrikazu prve slovo - nazov prikazu, 
     *                       null, ak je prikaz neznamy.
     * @param paParameter druhe slovo prikazu.
     */
    public Prikaz(String paNazovPrikazu, String paParameter)
    {
        aNazovPrikazu = paNazovPrikazu;
        aParameter = paParameter;
    }

    /**
     * @return prve slovo - nazov prikazu.
     */
    public String dajNazov()
    {
        return aNazovPrikazu;
    }

    /**
     * @return druhe slovo - parameter prikazu.
     */
    public String dajParameter()
    {
        return aParameter;
    }

    /**
     * @return true, ak je prikaz neznamy.
     */
    public boolean jeNeznamy()
    {
        return (aNazovPrikazu == null);
    }

    /**
     * @return true, ak prikaz ma parameter.
     */
    public boolean maParameter()
    {
        return (aParameter != null);
    }

    // implementacie prikazov:
    /**
     * Vypise text pomocnika do terminaloveho okna. Text obsahuje zoznam moznych
     * prikazov.
     */
    private void vypisNapovedu() {
        System.out.println("Zabludil si. Si sam. Tulas sa po fakulte.");
        System.out.println();
        System.out.println("Mozes pouzit tieto prikazy:");
        System.out.println("   chod ukonci pomoc");
    }

    /** 
     * Vykona pokus o prechod do miestnosti urcenej danym smerom.
     * Ak je tym smerom vychod, hrac prejde do novej miestnosti.
     * Inak sa vypise chybova sprava do terminaloveho okna.
     */
    private void chodDoMiestnosti(Hrac paHrac) {
        if (!this.maParameter()) {
            System.out.println("Chod kam?");
            return;
        }
        String smer = this.dajParameter();
        if (paHrac.chodDoMiestnosti(smer)) {
            paHrac.dajAktualnuMiestnost().infoOMiestnosti();
        } else {
            System.out.println("Tam nie je vychod!");
        }
    }

    /**
     * Ukonci hru. Skotroluje cely prikaz a zisti, ci je naozaj koniec hry.
     * Prikaz ukoncenia nema parameter.
     *
     * @return true, if this command quits the game, false otherwise.
     * @return true, ak prikaz konci hru, inak false.
     */
    private boolean ukonciHru() {
        if (this.maParameter()) {
            System.out.println("Ukonci, co?");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Prevezne prikaz a vykona ho.
     *
     * @param paPrikaz prikaz, ktory ma byt vykonany.
     * @return true ak prikaz ukonci hru, inak vrati false.
     */
    boolean vykonajPrikaz(Hrac paHrac) {
        boolean jeKoniec = false;
        if (this.jeNeznamy()) {
            System.out.println("Nerozumiem, co mas na mysli...");
            return false;
        }
        String nazovPrikazu = this.dajNazov();
        if (nazovPrikazu.equals("pomoc")) {
            vypisNapovedu();
        } else if (nazovPrikazu.equals("chod")) {
            chodDoMiestnosti(paHrac);
        } else if (nazovPrikazu.equals("ukonci")) {
            jeKoniec = ukonciHru();
        }
        return jeKoniec;
    }
}