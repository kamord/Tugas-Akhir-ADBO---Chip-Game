/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chip.game.element;

import java.awt.Point;

/**
 *  Kelas Water yang mempresentasikan air 
 * 
 * @author Albert Kamord,Rommy Kurniawan Wijaya
 */
public class Water {
    /**
     * Atribut position bertipe Point untuk menentukan posisi/letak koordinat Water
     */
    public Point position ;
     /**
     * Atribut sideLength bertipe final int sebagai panjang sisi image
     */
    public final int sideLength = new chip.game.level.Level().besarKotak - 10 ;
    
    /**
     * Konstruktor tanpa paramater
     */
    public Water()
    {
        
    }
    
    /**
     * Konstruktor untuk mengassign atau mengisi nilai Position dengan Paramater P
     * @param p posisi dari water bertipe Point
     */
    public Water(Point p)
    {
        this.position = p;
    }

}
