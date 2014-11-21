/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chip.game.element;

import java.awt.Point;

/**
 *  Kelas Chip yang mempresentasikan player/pemain 
 * 
 * @author Albert Kamord,Rommy Kurniawan Wijaya
 */
public class Chip {

    /**
     * Atribut position bertipe Point untuk menentukan posisi/letak koordinat Chip/character
     */
    public Point position;
    
    /**
     * Atribut besarKotak bertipe final int sebagai panjang sisi image
     */
    public int besarKotak = new chip.game.level.Level().besarKotak ;
    public int jarak = new chip.game.level.Level().besarKotak + 1;
    public int direction = 6 ; //2-hadap bawah, 4-hadap kiri, 6-hadap kanan

    
     /**
     * Konstruktor tanpa paramater
     */
    public Chip() {
    }

    /**
     * Konstruktor untuk mengassign atau mengisi nilai Position dengan Paramater P
     * @param p posisi dari chip bertipe Point
     */
    public Chip(Point p) {
        this.position = p;
    }

    /**
     * Method move adalah method untuk menggerakkan player/Chip
     * @param direction arah dimana player menghadap
     */
    public void move(int direction) {
        switch (direction) {
            case 2:
                this.position.y += jarak ;
                this.direction = 2;
                break;
            case 4:
                this.position.x -= jarak ;
                this.direction = 4;
                break;
            case 6:
                this.position.x += jarak ;
                this.direction = 6;
                break;
            case 8:
                this.position.y -= jarak ;
                this.direction = 8;
                break;
        }
    }
}
