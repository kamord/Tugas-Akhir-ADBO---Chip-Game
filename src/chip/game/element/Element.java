/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chip.game.element;

import java.awt.Point;

/**
 *
 * @author Albert Kamord,Rommy Kurniawan Wijaya
 */
public abstract class Element {
    /**
     * Atribut position bertipe Point untuk menentukan posisi/letak koordinat elemen
     */
    public Point position ;
    /**
     * Atribut sideLength bertipe final int sebagai panjang sisi image
     */
    public final int sideLength = new chip.game.level.Level().besarKotak - 10 ;
}
