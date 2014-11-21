/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chip.game.element;

import java.awt.Point;

/**
 *  Kelas Gate yang mempresentasikan portal untuk lanjut ke level berikutnya
 * 
 * @author Albert Kamord,Rommy Kurniawan Wijaya
 */
public class Gate {
    /**
     * Atribut position bertipe Point untuk menentukan posisi/letak koordinat Gate
     */
    public Point position ;
     /**
     * Atribut sideLength bertipe final int sebagai panjang sisi image
     */
    public final int sideLength = new chip.game.level.Level().besarKotak - 10 ;
    
    /**
     * Konstruktor tanpa paramater
     */
    public Gate()
    {
        
    }
    
     /**
     * Konstruktor untuk mengassign atau mengisi nilai Position dengan Paramater P
     * @param p posisi dari gate bertipe Point
     */
    public Gate(Point p)
    {
        this.position = p;
    }
}
