/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chip.game.level;

import chip.game.element.*;
import java.awt.Point;
import java.util.ArrayList;

/**
 *  Kelas Level3 adalah level ketiga dalam game.
 * 
 * @author Albert Kamord,Rommy Kurniawan Wijaya
 */
public class Level3 extends Level {

      /**
     * Konstruktor untuk kelas Level3
     */
    public Level3() {
        super();
        int playerGridX = 4;
        int playerGridY = 4;
        player = new Chip(new Point(xAwal + playerGridX * (besarKotak + 1), yAwal + playerGridY * (besarKotak + 1)));
        wall = new Wall[9][9];
        this.storeWallCoordinate();
        fire = new Fire[9][9];
        this.storeFireCoordinate();
        water = new Water[9][9];
        this.storeWaterCoordinate();
        redKey = new RedKey[9][9];
        blueKey = new BlueKey[9][9];
        yellowKey = new YellowKey[9][9];
        this.storeKeyCoordinate();
        this.icCount = 4; //ic required to complete level
        ic = new IC[9][9];
        this.storeICCoordinate();
        this.barrier = new Barrier[9][9];
        this.storeBarrierCoordinate();
        this.fireBoots = new FireBoots[9][9];
        this.storeFireBootsCoordinate();
        this.waterBoots = new WaterBoots[9][9];
        this.storeWaterBootsCoordinate();
        this.gate = new Gate[9][9];
        this.storeGateCoordinate();
        this.instruction = new Instruction[9][9];
        this.storeInstructionCoordinate();
        this.nextLevel = null;
    }

    /**
     * Method untuk menentukan koordinat letak dinding/Wall
     */
    public final void storeWallCoordinate() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.wall[i][j] = new Wall();
            }
        }
        int x = 2;
        int y = 0;
        this.wall[x][y] = new Wall(new Point(xAwal + y * (besarKotak + 1), yAwal + x * (besarKotak + 1)));
        x = 2;
        y = 1;
        this.wall[x][y] = new Wall(new Point(xAwal + y * (besarKotak + 1), yAwal + x * (besarKotak + 1)));
        x = 2;
        y = 7;
        this.wall[x][y] = new Wall(new Point(xAwal + y * (besarKotak + 1), yAwal + x * (besarKotak + 1)));
        x = 2;
        y = 8;
        this.wall[x][y] = new Wall(new Point(xAwal + y * (besarKotak + 1), yAwal + x * (besarKotak + 1)));

        for (int i = 4; i <= 6; i++) {
            y = 0;
            this.wall[i][y] = new Wall(new Point(xAwal + y * (besarKotak + 1), yAwal + i * (besarKotak + 1)));
            y = 8;
            this.wall[i][y] = new Wall(new Point(xAwal + y * (besarKotak + 1), yAwal + i * (besarKotak + 1)));
        }

        x = 6;
        y = 1;
        this.wall[x][y] = new Wall(new Point(xAwal + y * (besarKotak + 1), yAwal + x * (besarKotak + 1)));
        x = 6;
        y = 7;
        this.wall[x][y] = new Wall(new Point(xAwal + y * (besarKotak + 1), yAwal + x * (besarKotak + 1)));
    }

    /**
     * Method untuk menentukan koordinat letak api/Fire
     */
    public void storeFireCoordinate() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.fire[i][j] = new Fire();
            }
        }
        int x = 1;
        for (int i = 2; i <= 6; i++) {
            this.fire[i][x] = new Fire(new Point(xAwal + x * (besarKotak + 1), yAwal + i * (besarKotak + 1)));
        }
        x = 0;
        for (int i = 2; i <= 6; i += 2) {
            this.fire[i][x] = new Fire(new Point(xAwal + x * (besarKotak + 1), yAwal + i * (besarKotak + 1)));
        }
    }

     /**
     * Method untuk menentukan koordinat letak air/Water
     */
    public void storeWaterCoordinate() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.water[i][j] = new Water();
            }
        }
        int x = 7;
        for (int i = 2; i <= 6; i++) {
            this.water[i][x] = new Water(new Point(xAwal + x * (besarKotak + 1), yAwal + i * (besarKotak + 1)));
        }
        x = 8;
        for (int i = 2; i <= 6; i += 2) {
            this.water[i][x] = new Water(new Point(xAwal + x * (besarKotak + 1), yAwal + i * (besarKotak + 1)));
        }
    }

    /**
     * Method untuk menentukan koordinat letak kunci/Key
     */
    public void storeKeyCoordinate() {
        storeBluKeyCoordinate();
        storeRedKeyCoordinate();
        storeYellowKeyCoordinate();
    }

    /**
     * Method untuk menentukan koordinat letak kunci biru/Blue Key
     */
    public void storeBluKeyCoordinate() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.blueKey[i][j] = new BlueKey();
            }
        }
    }

    /**
     * Method untuk menentukan koordinat letak kunci merah/Red Key
     */
    public void storeRedKeyCoordinate() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.redKey[i][j] = new RedKey();
            }
        }
    }

    /**
     * Method untuk menentukan koordinat letak kunci kuning/Yellow Key
     */
    public void storeYellowKeyCoordinate() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.yellowKey[i][j] = new YellowKey();
            }
        }
    }

    /**
     * Method untuk menentukan koordinat letak IC
     */
    public void storeICCoordinate() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.ic[i][j] = new IC();
            }
        }
        int x = 0;
        int y = 3;
        this.ic[x][y] = new IC(new Point(xAwal + y * (besarKotak + 1), yAwal + x * (besarKotak + 1)));
        x = 0;
        y = 5;
        this.ic[x][y] = new IC(new Point(xAwal + y * (besarKotak + 1), yAwal + x * (besarKotak + 1)));
        x = 3;
        y = 8;
        this.ic[x][y] = new IC(new Point(xAwal + y * (besarKotak + 1), yAwal + x * (besarKotak + 1)));
        x = 8;
        y = 5;
        this.ic[x][y] = new IC(new Point(xAwal + y * (besarKotak + 1), yAwal + x * (besarKotak + 1)));
    }

    /**
     * Method untuk menentukan koordinat letak Barrier
     */
    public void storeBarrierCoordinate() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.barrier[i][j] = new Barrier();
            }
        }
        int x = 3;
        int y = 1;
        this.barrier[x][y] = new Barrier(new Point(xAwal + y * (besarKotak + 1), yAwal + x * (besarKotak + 1)));
    }

    /**
     * Method untuk menentukan koordinat letak sepatu anti api/Fire boots
     */
    public void storeFireBootsCoordinate() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.fireBoots[i][j] = new FireBoots();
            }
        }
        int x = 5;
        int y = 4;
        this.fireBoots[x][y] = new FireBoots(new Point(xAwal + y * (besarKotak + 1), yAwal + x * (besarKotak + 1)));
    }

    /**
     * Method untuk menentukan koordinat letak sepatu anti air/Water boots
     */
    public void storeWaterBootsCoordinate() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.waterBoots[i][j] = new WaterBoots();
            }
        }
        int x = 8;
        int y = 3;
        this.waterBoots[x][y] = new WaterBoots(new Point(xAwal + y * (besarKotak + 1), yAwal + x * (besarKotak + 1)));
    }

    /**
     * Method untuk menentukan koordinat letak gate/portal
     */
    public void storeGateCoordinate() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.gate[i][j] = new Gate();
            }
        }
        int x = 3;
        int y = 0;
        this.gate[x][y] = new Gate(new Point(xAwal + y * (besarKotak + 1), yAwal + x * (besarKotak + 1)));
    }

    public void storeInstructionCoordinate() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.instruction[i][j] = new Instruction();
            }
        }
        int x = 3;
        int y = 4;
        this.instruction[x][y] = new Instruction(new Point(xAwal + y * (besarKotak + 1), yAwal + x * (besarKotak + 1)));
    }
}
