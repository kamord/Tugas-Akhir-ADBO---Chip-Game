/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chip.game.element;

import java.awt.Point;

/**
 *  Kelas YellowKey yang mempresentasikan kunci warna kuning untuk membuka 
 *  pintu kuning
 * 
 * @author Albert Kamord,Rommy Kurniawan Wijaya
 */
public class YellowKey implements Storable {
    /**
     * Atribut position bertipe Point untuk menentukan posisi/letak koordinat YellowKey
     */
    public Point position ;
     /**
     * Atribut sideLength bertipe final int sebagai panjang sisi image
     */
    public final int sideLength = new chip.game.level.Level().besarKotak - 10 ;
    
    /**
     * Konstruktor tanpa paramater
     */
    public YellowKey()
    {
        
    }
    
    /**
     * Konstruktor untuk mengassign atau mengisi nilai Position dengan Paramater P
     * @param p posisi dari yellow key bertipe Point
     */
    public YellowKey(Point p)
    {
        this.position = p;
    }
    
}
