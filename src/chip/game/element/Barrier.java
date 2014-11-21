package chip.game.element;

import java.awt.Point;

/**
 *  Kelas Barrier yang mempresentasikan Pintu yang menghalangi
 *  untuk menuju Portal yang bisa dibuka dengan mengumpulkan semua IC.
 * 
 * @author Albert Kamord,Rommy Kurniawan Wijaya
 */
public class Barrier extends Element{
    /**
     * Atribut position bertipe Point untuk menentukan posisi/letak koordinat Barrier
     */
    public Point position ;
    /**
     * Atribut sideLength bertipe final int sebagai panjang sisi image
     */
    public final int sideLength = new chip.game.level.Level().besarKotak - 10 ;
    
    /**
     * Konstruktor tanpa paramater
     */
    public Barrier()
    {
        
    }
    
    /**
     * Konstruktor untuk mengassign atau mengisi nilai Position dengan Paramater P
     * @param p posisi dari barrier bertipe Point
     */
    public Barrier(Point p)
    {
        this.position = p;
    }
}
