/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chip.game.element;

import java.awt.Point;

/**
 * Kelas EmptyFloor yang mempresentasikan lantai yang bisa dilalui oleh Chip
 *
 *
 * @author Albert Kamord,Rommy Kurniawan Wijaya
 */
public class EmptyFloor {

    /**
     * Atribut position bertipe Point untuk menentukan posisi/letak koordinat
     * EmptyFloor
     */
    public Point position;
    /**
     * Atribut sideLength bertipe int sebagai panjang sisi image
     */
    public int sideLength;

    /**
     * Konstruktor tanpa paramater
     */
    public EmptyFloor() {

    }

    /**
     * Konstruktor untuk mengassign atau mengisi nilai Position dengan Paramater
     * P dan mengisi nilai dari atribut sideLength dengan Paramater sideLength
     *
     * @param position posisi dari lantai bertipe Point
     * @param sideLength ukuran sisi dari gambar lantai
     */
    public EmptyFloor(Point position, int sideLength) {
        this.position = position;
        this.sideLength = sideLength;
    }

}
