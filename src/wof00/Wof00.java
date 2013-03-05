package wof00;

import java.util.Scanner;

/**
 * Hlavna trieda hry WoF s metodou main - spustanie v NB
 * 
 * @author Lubomir Sadlon
 * @version 21.2.2012
 */
public class Wof00 {

    /**
     * @param args parametre programu
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Zadaj svoje ctene meno: ");
        Hra hra = new Hra(s.nextLine());
        hra.hraj();
    }
}
