/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chip.game.element;

import java.awt.Point;

/**
 *  Kelas Wall yang mempresentasikan dinding
 * @author Albert Kamord,Rommy Kurniawan Wijaya
 */
public class Wall {
    /**
     * Atribut position bertipe Point untuk menentukan posisi/letak koordinat Wall
     */
    public Point position ;
    /**
     * Atribut sideLength bertipe final int sebagai panjang sisi image
     */
    public final int sideLength = new chip.game.level.Level().besarKotak - 10 ;
    
    /**
     * Konstruktor tanpa paramater
     */
    public Wall()
    {
        
    }
    
    /**
     * Konstruktor untuk mengassign atau mengisi nilai Position dengan Paramater P
     * @param p posisi dari wall bertipe Point
     */
    public Wall(Point p)
    {
        this.position = p;
    }
}
