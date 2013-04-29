/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package wof00.prikazy;

import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author janik
 */
public class SaveIterator implements Iterator<Prikaz>, Iterable<Prikaz> {
    private final Scanner aVstup;
    private boolean aKoniec;

    public SaveIterator(Scanner paVstup) {
        aVstup = paVstup;
        aKoniec = false;
    }

    @Override
    public boolean hasNext() {
        return !aKoniec;
    }

    @Override
    public Prikaz next() {
        if (aKoniec) {
            return null;
        }
        
        Prikaz dalsi = Prikaz.nacitajZo(aVstup);
        System.out.println("> " + dalsi);
        
        if (!aVstup.hasNextLine()) {
            aKoniec = true;
            aVstup.close();
        }
        
        return dalsi;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Iterator<Prikaz> iterator() {
        return this;
    }
    
}
