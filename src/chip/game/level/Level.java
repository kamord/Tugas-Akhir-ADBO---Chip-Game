/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chip.game.level;

import chip.game.element.*;
import java.awt.Point;

/**
 *  Kelas Level yang merupakan kelas Parent
 * 
 * @author Albert Kamord,Rommy Kurniawan Wijaya
 */
public class Level {
    /**
     * Atribut Player untuk membuat Karakter Player
     */
    public Chip player;
    /**
     * Atribut floor untuk membuat lantai kosong
     */
    public EmptyFloor floor[][];
    /**
     * Atribut Wall untuk membuat dinding
     */
    public Wall wall[][];
    /**
     * Atribut Fire untuk membuat api
     */
    public Fire fire[][];
    /**
     * Atribut water untuk membuat air
     */
    public Water water[][];
    /**
     * Atribut redKey untuk membuat kunci merah
     */
    public RedKey redKey[][];
    /**
     * Atribut yellowKey untuk membuat kunci kuning
     */
    public YellowKey yellowKey[][];
    /**
     * Atribut blueKey untuk membuat kunci biru
     */
    public BlueKey blueKey[][];
    /**
     * Atribut untuk membuat sepatu anti air
     */
    public WaterBoots waterBoots[][];
    /**
     * Atribut untuk membuat sepatu anti api
     */
    public FireBoots fireBoots[][];
    /**
     * Atribut unutk membuat inventory/tas player
     */
    public Inventory bag;
    /**
     * Atribut untuk membuat IC
     */
    public IC ic[][];
    /**
     * Atribut untuk membuat Barrier
     */
    public Barrier barrier[][];
    /**
     * Atribut untuk membuat gate/portal
     */
    public Gate gate[][];
    /**
     * Atribut untuk menghitung berapa IC yang tersisa
     */
    public int icCount;//berapa sisa ic yang diperlukan
    
    /**
     * Atribut koordinat x Board
     */
    public int xAwal = 70;
    
    /**
     * Atribut koordinat y Board
     */
    public int yAwal = 70;
    
    /**
     * Atribut untuk menentukan panjang/besar/sisi image
     */
    public int besarKotak = 60;
   
    /**
     * Atribut untuk menentukan level selanjutnya yang akan dilalui.
     */
    public Level nextLevel;
    
    /**
     * atribut untuk membuat petunjuk
     */
    public Instruction[][] instruction;
    
    /**
     * Kosntuktor level yang menentukan lantai kosong
     */
    public Level()
    {
        floor = new EmptyFloor[9][9];
        this.storeEmptyFloorCoordinate();
    }
    
    /**
     * Method untuk mnentukan koordinat lantai.
     */
    public final void storeEmptyFloorCoordinate() {
        int counter = 0;
        for (int i = yAwal; counter < 9; i += besarKotak + 1) {
            int counter2 = 0;
            for (int j = xAwal; counter2 < 9; j += besarKotak + 1) {
                this.floor[counter][counter2] = new EmptyFloor(new Point(j, i), besarKotak);
                counter2++;
            }
            counter++;
        }
    }
    
    /**
     * Method untuk menentukan koordinat letak api/Fire
     */
    public void storeFireCoordinate(){}
    public void storeWaterCoordinate() {}
    public void storeKeyCoordinate() {}
    public void storeBluKeyCoordinate() {}
    public void storeRedKeyCoordinate() {}
    public void storeYellowKeyCoordinate() {}
    public void storeICCoordinate() {}
    public void storeBarrierCoordinate() {}
    public void storeFireBootsCoordinate() {}
    public void storeWaterBootsCoordinate() {}
    public void storeGateCoordinate() {}
    public void storeInstructionCoordinate() {}
}
