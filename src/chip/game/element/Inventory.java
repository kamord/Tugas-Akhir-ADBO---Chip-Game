/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chip.game.element;

import java.util.ArrayList;

/**
 *  Kelas Inventory yang mempresentasikan tas/inventory Chip
 * @author Albert Kamord,Rommy Kurniawan Wijaya
 */
public class Inventory {
    /**
     * Atribut inven bertipe ArrayList
     */
    public ArrayList<Storable> inven ;
    
    /**
     * Konstruktor tanpa paramater
     */
    public Inventory(){
        
    }
    
    /**
     * Method add untuk menambah/memasukkan item ke dalam tas/inventory
     * @param element elemen yang disimpan
     */
    public void add(Storable element) {
        this.inven.add(element);
    }
    
    /**
     * Method remove untuk membuang/mengurangi item di dalam tas/inventory
     * @param element element yang dikeluarkan
     */
    public void remove(Storable element)
    {
        this.inven.remove(element);
    }
}
