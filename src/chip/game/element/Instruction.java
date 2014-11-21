/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chip.game.element;

import java.awt.Point;

/**
 *  Kelas Instruction yang mempresentasikan petunjuk permainan
 * @author Albert Kamord,Rommy Kurniawan Wijaya
 */
public class Instruction {
    /**
     * Atribut position bertipe Point untuk menentukan posisi/letak koordinat Instruction
     */
    public Point position ;
    /**
     * Atribut sideLength bertipe final int sebagai panjang sisi image
     */
    public final int sideLength = new chip.game.level.Level().besarKotak - 10 ;
    
    /**
     * Konstruktor tanpa paramater
     */
    public Instruction()
    {
        
    }
    /**
     * Konstruktor untuk mengassign atau mengisi nilai Position dengan Paramater P
     * @param p posisi dari instruction(tanda tanya) bertipe Point
     */
    public Instruction(Point p)
    {
        this.position = p;
    }
}
