
package chip.game.element;

import java.awt.Point;

/**
 *  Kelas BlueKey yang mempresentasikan kunci warna biru untuk membuka 
 *  pintu biru.
 * 
 * @author Albert Kamord,Rommy Kurniawan Wijaya
 */
public class BlueKey extends Element implements Storable {
    /**
     * Atribut position bertipe Point untuk menentukan posisi/letak koordinat BlueKey
     */
    public Point position ;
     /**
     * Atribut sideLength bertipe final int sebagai panjang sisi image
     */
    public final int sideLength = new chip.game.level.Level().besarKotak - 10 ;
    
    /**
     * Konstruktor tanpa paramater
     */
    public BlueKey()
    {
        
    }
    
    /**
     * Konstruktor untuk mengassign atau mengisi nilai Position dengan Paramater P
     * @param p posisi dari blue key bertipe Point
     */
    public BlueKey(Point p)
    {
        this.position = p;
    }
}
