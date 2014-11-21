/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chip.game.element;

import java.awt.Point;

/**
 *  Kelas RedKey yang mempresentasikan kunci warna merah untuk membuka 
 *  pintu merah.
 * 
 * @author Albert Kamord,Rommy Kurniawan Wijaya
 */
public class RedKey implements Storable {
    /**
     * Atribut position bertipe Point untuk menentukan posisi/letak koordinat RedKey
     */
    public Point position ;
    /**
     * Atribut sideLength bertipe final int sebagai panjang sisi image
     */
    public final int sideLength = new chip.game.level.Level().besarKotak - 10 ;
    
    /**
     * Konstruktor tanpa paramater
     */
    public RedKey()
    {
        
    }
    
    /**
     * Konstruktor untuk mengassign atau mengisi nilai Position dengan Paramater P
     * @param p posisi dari red key bertipe Point
     */
    public RedKey(Point p)
    {
        this.position = p;
    }
    
}
