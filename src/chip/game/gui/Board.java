/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chip.game.gui;

import chip.game.element.Chip;
import chip.game.level.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * Kelas Board yang merupakan gui dari Chip Game
 *
 * @author Albert Kamord,Rommy Kurniawan Wijaya
 */
public class Board extends javax.swing.JFrame implements ActionListener {

    /**
     * indikasi apakah awal buka frame, true jika sudah pernah buka, false jika
     * baru saja buka
     */
    public boolean starter = true;

    /**
     * atribut untuk menggambarkan ke dalam canvas/board
     */
    public Graphics g;

    /**
     * Atribut level untuk memulai game dari level 1
     */
    public Level level = new Level1();

    /**
     * Mengambil toolkit(misalnya resolusi) dari komputer yang menjalankan
     * program ini
     */
    public Toolkit tk = Toolkit.getDefaultToolkit();

    /**
     * Atribut resX untuk menentukan lebarnya resolusi
     */
    public int resX = (int) tk.getScreenSize().getWidth(); //game screen width resolution

    /**
     * Atribut resY untuk menentukan tinggingya resolusi
     */
    public int resY = (int) tk.getScreenSize().getHeight(); //game screen height resolution

    /**
     * Atribut untuk menentukan ukuran sisi karakter/player
     */
    public int chipWidth = new Level().besarKotak, chipHeight = new Level().besarKotak;

    /**
     * Atribut untuk mencari lokasi gambar karakter menghadap kiri
     */
    public String chipLeftImgFileName = "images/left.jpg";

    /**
     * Atribut untuk menyimpan gambar karakter menghadap kiri
     */
    public Image chipImgLeft;

    /**
     * Atribut untuk mencari lokasi gambar karakter menghadap kanan
     */
    public String chipRightImgFileName = "images/right.jpg";

    /**
     * Atribut untuk menyimpan gambar karakter menghadap kanan
     */
    public Image chipImgRight;

    /**
     * Atribut untuk mencari lokasi gambar karakter menghadap depan
     */
    public String chipFrontImgFileName = "images/front.jpg";

    /**
     * Atribut untuk menyimpan gambar karakter menghadap depan
     */
    public Image chipImgFront;

    /**
     * Atribut untuk mencari lokasi gambar karakter menghadap belakang
     */
    public String chipBackImgFileName = "images/back.jpg";

    /**
     * Atribut untuk menyimpan gambar karakter menghadap belakang
     */
    public Image chipImgBack;

    /**
     * Atribut untuk mencari lokasi gambar api
     */
    public String fireImgFileName = "images/fire2.jpg";

    /**
     * Atribut untuk menyimpan gambar api
     */
    public Image fireImg;

    /**
     * Atribut untuk mencari lokasi gambar air
     */
    public String waterImgFileName = "images/water.jpg";

    /**
     * Atribut untuk menyimpan gambar air
     */
    public Image waterImg;

    /**
     * Atribut untuk mencari lokasi gambar lantai/floor
     */
    public String floorImgFileName = "images/floor.jpg";

    /**
     * Atribut untuk menyimpan gambar lantai/floor
     */
    public Image floorImg;

    /**
     * Atribut untuk mencari lokasi gambar dinding/wall
     */
    public String wallImgFileName = "images/wall.jpg";

    /**
     * Atribut untuk menyimpan gambar dinding/wall
     */
    public Image wallImg;

    /**
     * Atribut boolean apakah player sudah mendapatkan sepatu anti api/Fire
     * Boots atau belum
     */
    public boolean hasFireBoots = false;

    /**
     * Atribut boolean apakah player sudah mendapatkan sepatu anti air/Water
     * Boots atau belum
     */
    public boolean hasWaterBoots = false;

    /**
     * Atribut untuk mencari lokasi gambar Barrier
     */
    public String barrierImgFileName = "images/barrier.jpg";

    /**
     * Atribut untuk menyimpan gambar Barrier
     */
    public Image barrierImg;

    /**
     * Atribut untuk mencari lokasi gambar IC
     */
    public String ICImgFileName = "images/IC.jpg";

    /**
     * Atribut untuk menyimpan gambar IC
     */
    public Image ICImg;

    /**
     * Atribut untuk mencari lokasi gambar Gate/portal
     */
    public String gateImgFileName = "images/gate.jpg";

    /**
     * Atribut untuk menyimpan gambar gate/portal
     */
    public Image gateImg;

    /**
     * Atribut untuk mencari lokasi gambar Sepatu anti Api/FireBoots
     */
    public String fireBootsImgFileName = "images/red boots.jpg";

    /**
     * Atribut untuk menyimpan gambar FireBoots/Sepatu tahan api
     */
    public Image fireBootsImg;

    /**
     * Atribut untuk mencari lokasi gambar Sepatu anti air/WaterBoots
     */
    public String waterBootsImgFileName = "images/blue boots.jpg";

    /**
     * Atribut untuk menyimpan gambar WaterBoots/Sepatu anti air
     */
    public Image waterBootsImg;

    /**
     * Atribut untuk mencari lokasi gambar Instructions(tanda tanya)
     */
    public String instructionImgFileName = "images/qmark.jpg";

    /**
     * Atribut untuk menyimpan gambar Instructions(tanda tanya)
     */
    public Image instructionImg;

    /**
     * Atribut untuk mencari lokasi gambar Opening
     */
    public String openingImgFileName = "images/opening2.jpg";

    /**
     * Atribut untuk menyimpan gambar Opening
     */
    public Image openingImg;

    /**
     * Atribut untuk display level yang sedang dijalankan
     */
    public int levelNum = 1;

    /**
     * Atribut boolean instructions yang tidak akan muncul bila tidak diinjak.
     */
    public boolean instruction = false;//kalau nginjek tanda tanya true
    /**
     * Atribut untuk indikasi awal menjalankan program, true jika pertama
     * dibuka.
     */
    public boolean opener = true;
    /**
     * Atribut untuk menyimpan format tulisan dari keselurahan game/permainan
     */
    Font font = new Font("Copperplate Gothic Bold", Font.PLAIN, 30);

    /**
     * Konstruktur kelas Board
     */
    public Board() {
        initComponents();

        //games resolution
        this.setSize(new Dimension(this.resX, this.resY));
        this.loadAllImage();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 576, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Method untuk menggambar isi dari board
     *
     * @param g grafik penggambar ke kanvas
     */
    @Override
    public void paint(Graphics g) {
        this.g = g;

        //starting screen animation
        if (starter == false) {
            startingScreen();
            this.starter = true;
        } else {
            if (opener == true) {
                this.drawOpening();
            } else {
                if (this.level == null) {
                    this.comingSoon();
                } else {

                    //draw all element in the game
                    this.drawAllElement();

                    //dead condition
                    if (isDead()) {
                        hasWaterBoots = false;
                        hasFireBoots = false;
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                        }
                        this.gameOver();
                    }
                    if (isComplete()) {
                        this.levelNum++;
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                        }
                        this.nextLevel();
                    }
                }
            }
        }
    }

    /**
     * Method untuk menggambar semua elemen
     */
    public void drawAllElement() {
        //drawing background
//        this.drawBG();
        this.g.setColor(Color.black);
        this.g.fillRect(0, 0, resX, resY);

        //drawing scoreboard
        this.scoreBoard();

        //drawing empty floor
        this.drawEmptyFloor();

        //drawing wall
        this.drawWall();

        //drawing fire
        this.drawFire();

        //drawing fire boots
        this.drawFireBoots();

        //drawing water
        this.drawWater();

        //drawing water boots
        this.drawWaterBoots();

        //drawing integrated circuit
        this.drawIC();

        //drawing barrier
        this.drawBarrier();

        //drawing gate
        this.drawGate();

        //drawing instruction
        this.drawInstruction();

        //drawing chip(player)
        this.drawPlayer();
    }
    //tampilan pertama game

    /**
     * Method untuk membuat Starting Screen / Intro
     */
    public void startingScreen() {
        this.g.setColor(Color.black);
        this.g.fillRect(0, 0, this.resX, this.resY);

        Color fontColorAppear = Color.white;
        Color fontColorFade = Color.black;
        //kamord games
        this.g.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 50));
        this.g.setColor(fontColorAppear);
        this.g.drawString("A R    Games", 470, 400);
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        this.g.setColor(fontColorFade);
        this.g.drawString("A R    Games", 470, 400);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //present you
        this.g.setColor(fontColorAppear);
        this.g.drawString("Present  you", 500, 400);
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        this.g.setColor(fontColorFade);
        this.g.drawString("Present  you", 500, 400);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        //21st Century Games
        this.g.setColor(fontColorAppear);
        this.g.drawString("2oth  Century  Games", 450, 400);
        try {
            Thread.sleep(2500);
        } catch (InterruptedException ex) {
            Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        this.g.setColor(fontColorFade);
        this.g.drawString("2oth  Century  Games", 450, 400);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Level.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    /**
     * Method sebagai pemroses tombol yang ditekan
     *
     * @param evt
     */
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:

        boolean valid = this.checkMoveValidity(evt.getKeyCode());
        if (this.opener == true) {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                this.opener = false;
                repaint();
            }
        } else {
            if (isDead()) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    this.level = checkCurrentLevel(this.level);
                    repaint();
                } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    this.dispose();
                }
            }
            if (valid == true) {
                switch (evt.getKeyCode()) {
                    case KeyEvent.VK_DOWN:
                        //gerak ke bawah
                        this.level.player.move(2);
                        break;
                    case KeyEvent.VK_LEFT:
                        //gerak ke kiri
                        this.level.player.move(4);
                        break;
                    case KeyEvent.VK_RIGHT:
                        //gerak ke kanan
                        this.level.player.move(6);
                        break;
                    case KeyEvent.VK_UP:
                        //gerak ke atas
                        this.level.player.move(8);
                        break;
                }
                checkFloor();
                if (isComplete()) {
                    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                        this.level = this.level.nextLevel;
                        repaint();
                    } else if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {
                        this.dispose();
                    }
                }
                repaint();
            }
        }

    }//GEN-LAST:event_formKeyPressed

    /**
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Board().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    /**
     * Method untuk membuka/meload gambar Opening
     */
    //opening image
    public void drawOpening() {
        this.g.drawImage(openingImg, 0, 0, resX, resY, null);
    }

    /**
     * Method untuk menggambar Background
     */
    //background
    public void drawBG() {
        this.g.fillRect(0, 0, this.resX, this.resY);
        this.g.setFont(font);
        this.g.setColor(Color.white);
        for (int i = 0; i < 570; i += 100) {
            for (int j = 20; j < 570; j += 30) {
                this.g.drawString("Chip", i, j);
            }
        }
    }

    /**
     * Method untuk menggambar lantai kosong atau Floor
     */
    public void drawEmptyFloor() {
        this.g.setColor(Color.blue);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int x = this.level.floor[i][j].position.x;
                int y = this.level.floor[i][j].position.y;
                int side = this.level.floor[i][j].sideLength;
                this.g.drawImage(floorImg, x, y, side, side, null);
            }
        }
    }

    /**
     * Method untuk menggambar ScoreBoard
     */
    public void scoreBoard() {
        int positionX = this.level.floor[0][this.level.floor[0].length - 1].position.x + 100;
        int positionY = this.level.floor[0][this.level.floor[0].length - 1].position.y + 50;
        this.g.setFont(font);
        this.g.setColor(Color.white);
        this.g.drawString("LEVEL : " + levelNum + "", positionX, positionY);
        positionY += 50;
        this.g.drawString("Chips Left : " + this.level.icCount + "", positionX, positionY);
        if (instruction == true) {
            positionY += 200;
            String a = level.getClass().getName();
            int pos = a.indexOf("Level");
            a = a.substring(16);
            if (a.equals("Level1")) {
                this.g.drawString("Collect all Chips - ", positionX, positionY);
                positionX += 360;
                int side = this.level.ic[0][0].sideLength;
                this.g.drawImage(ICImg, positionX, positionY - 50, side, side, null);

                positionY += 52;
                positionX -= 360;
                this.g.drawString("to open barrier - ", positionX, positionY);
                positionX += 325;
                side = this.level.barrier[0][0].sideLength;
                this.g.drawImage(barrierImg, positionX, positionY - 50, side, side, null);
            } else if (a.equals("Level2")) {
                this.g.drawString("Avoid -        - and - ", positionX, positionY);
                positionX += 138;
                int side = this.level.fire[0][0].sideLength;
                this.g.drawImage(fireImg, positionX, positionY - 50, side, side, null);

                positionX += 180;
                side = this.level.water[0][0].sideLength;
                this.g.drawImage(waterImg, positionX, positionY - 50, side, side, null);
            } else if (a.equals("Level3")) {
                int side = this.level.fireBoots[0][0].sideLength;
                this.g.drawImage(fireBootsImg, positionX, positionY - 50, side, side, null);
                this.g.drawString("- Take this to walk on Fire", positionX + 55, positionY);

                positionY += 52;
                side = this.level.waterBoots[0][0].sideLength;
                this.g.drawImage(waterBootsImg, positionX, positionY - 50, side, side, null);
                this.g.drawString("- Take this to walk on Water", positionX + 55, positionY);
            }
        }
    }

    /**
     * Method untuk menggambar letak gambar pemain
     */
    public void drawPlayer() {
        int chipPositionX = this.level.player.position.x;
        int chipPositionY = this.level.player.position.y;
        if (!isDead()) {
            this.g.setColor(Color.green);//player color
        } else if (isFireDead()) {
            this.g.setColor(Color.black);//player color if step on fire
        } else if (isWaterDead()) {
            this.g.setColor(Color.blue);//player color if step on water
        }
        Image chipImage;
        //player image
        if (this.level.player.direction == 6) { //right
            chipImage = chipImgRight;
        } else if (this.level.player.direction == 4) { //left
            chipImage = chipImgLeft;
        } else if (this.level.player.direction == 2) { //front
            chipImage = chipImgFront;
        } else { //back
            chipImage = chipImgBack;
        }

        this.g.drawImage(chipImage, chipPositionX, chipPositionY, chipWidth, chipHeight, null);

    }

    /**
     * Method untuk menggambar letak gambar Dinding/Wall
     */
    public void drawWall() {
        this.g.setColor(Color.yellow);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.level.wall[i][j].position != null) {
                    int x = this.level.wall[i][j].position.x + 5;
                    int y = this.level.wall[i][j].position.y + 5;
                    int side = this.level.wall[i][j].sideLength;
                    this.g.drawImage(wallImg, x, y, side, side, null);
                }
            }
        }
    }

    /**
     * Method untuk menggambar letak gambar Sepatu Anti Api /Fire Boots
     */
    public void drawFireBoots() {
        this.g.setColor(Color.yellow);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.level.fireBoots[i][j].position != null) {
                    int x = this.level.fireBoots[i][j].position.x + 5;
                    int y = this.level.fireBoots[i][j].position.y + 5;
                    int side = this.level.fireBoots[i][j].sideLength;
                    this.g.drawImage(waterBootsImg, x, y, side, side, null);
                }
            }
        }
    }

    /**
     * Method untuk menggambar letak gambar Sepatu anti air /Water Boots
     */
    public void drawWaterBoots() {
        this.g.setColor(Color.yellow);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.level.waterBoots[i][j].position != null) {
                    int x = this.level.waterBoots[i][j].position.x + 5;
                    int y = this.level.waterBoots[i][j].position.y + 5;
                    int side = this.level.waterBoots[i][j].sideLength;
                    this.g.drawImage(fireBootsImg, x, y, side, side, null);
                }
            }
        }
    }

    /**
     * Method untuk menggambar letak gambar Gate/Portal
     */
    public void drawGate() {
        this.g.setColor(Color.yellow);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.level.gate[i][j].position != null) {
                    int x = this.level.gate[i][j].position.x + 5;
                    int y = this.level.gate[i][j].position.y + 5;
                    int side = this.level.gate[i][j].sideLength;
                    this.g.drawImage(gateImg, x, y, side, side, null);
                }
            }
        }
    }

    /**
     * Method untuk menggambar letak gambar instructions
     */
    public void drawInstruction() {
        this.g.setColor(Color.yellow);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.level.instruction[i][j].position != null) {
                    int x = this.level.instruction[i][j].position.x + 5;
                    int y = this.level.instruction[i][j].position.y + 5;
                    int side = this.level.instruction[i][j].sideLength;
                    this.g.drawImage(instructionImg, x, y, side, side, null);
                }
            }
        }
    }

    /**
     * Method untuk menggambar letak gambar IC
     */
    public void drawIC() {
        this.g.setColor(Color.yellow);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.level.ic[i][j].position != null) {
                    int x = this.level.ic[i][j].position.x + 5;
                    int y = this.level.ic[i][j].position.y + 5;
                    int side = this.level.ic[i][j].sideLength;
                    this.g.drawImage(ICImg, x, y, side, side, null);
                }
            }
        }
    }

    /**
     * Method untuk menggambar letak gambar Barrier
     */
    public void drawBarrier() {
        this.g.setColor(Color.yellow);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.level.barrier[i][j].position != null) {
                    int x = this.level.barrier[i][j].position.x + 5;
                    int y = this.level.barrier[i][j].position.y + 5;
                    int side = this.level.barrier[i][j].sideLength;
                    this.g.drawImage(barrierImg, x, y, side, side, null);
                }
            }
        }
    }

    /**
     * Method untuk menggambar letak gambar api
     */
    public void drawFire() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.level.fire[i][j].position != null) {
                    int x = this.level.fire[i][j].position.x + 5;
                    int y = this.level.fire[i][j].position.y + 5;
                    int side = this.level.fire[i][j].sideLength;
                    this.g.drawImage(fireImg, y, x, side, side, null);
                }
            }
        }
    }

    /**
     * Method untuk menggambar letak gambar air
     */
    public void drawWater() {
        this.g.setColor(Color.cyan);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (this.level.water[i][j].position != null) {
                    int x = this.level.water[i][j].position.x + 5;
                    int y = this.level.water[i][j].position.y + 5;
                    int side = this.level.water[i][j].sideLength;
                    this.g.drawImage(waterImg, y, x, side, side, null);
                }
            }
        }
    }

    /**
     * Method untuk meload tulisan Game Over
     */
    public void gameOver() {
        this.g.setColor(Color.black);
        this.g.fillRect(0, 0, resX, resY);
        Font font = new Font("Copperplate Gothic Bold", Font.PLAIN, 30);
        this.g.setFont(font);
        this.g.setColor(Color.white);
        this.g.drawString("Game Over !", resX / 2 - resX / 12, resY / 2);
        this.g.drawString("[ENTER] Replay / [ESC] Exit", resX / 2 - resX / 5, resY / 2 + 50);
    }

    /**
     * Method untuk meload tulisan Coming Soon
     */
    public void comingSoon() {
        this.g.setColor(Color.black);
        this.g.fillRect(0, 0, resX, resY);
        this.g.setFont(font);
        this.g.setColor(Color.white);
        this.g.drawString("Coming Soon !", resX / 2 - resX / 12, resY / 2);
        this.g.drawString("Exit in 3", resX / 2 - resX / 12, resY / 2 + 50);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        this.g.setColor(Color.black);
        this.g.fillRect(0, 0, resX, resY);
        this.g.setFont(font);
        this.g.setColor(Color.white);
        this.g.drawString("Coming Soon !", resX / 2 - resX / 12, resY / 2);
        this.g.drawString("Exit in 2", resX / 2 - resX / 12, resY / 2 + 50);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        this.g.setColor(Color.black);
        this.g.fillRect(0, 0, resX, resY);
        this.g.setFont(font);
        this.g.setColor(Color.white);
        this.g.drawString("Coming Soon !", resX / 2 - resX / 12, resY / 2);
        this.g.drawString("Exit in 1", resX / 2 - resX / 12, resY / 2 + 50);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        dispose();
    }

    /**
     * Method untuk meload tulisan Next Level
     */
    public void nextLevel() {
        this.g.setColor(Color.black);
        this.g.fillRect(0, 0, resX, resY);
        this.g.setFont(font);
        this.g.setColor(Color.white);
        this.g.drawString("Level Complete!", resX / 2 - resX / 12, resY / 2);
        this.g.drawString("[ENTER] Next Level / [ESC] Exit", resX / 2 - resX / 5, resY / 2 + 50);
    }

    /**
     * Method boleean apakah player bisa bergerak karena mati, limit board,
     * menabrak tembok, barrier,
     *
     * @param c nilai bertipe integer dari tombol yang ditekan
     * @return true-boleh gerak, false-tidak boleh gerak
     */
    public boolean checkMoveValidity(int c) {
        //out of board checking
        if (isDead()) {
            return false;
        }
        if (checkOutOfBoard(c) == false) {
            return false;
        }

        if (checkHitWall(c) == false) {
            return false;
        }
        if (checkHitBarrier(c) == false) {
            return false;
        }

        return true;
    }

    /**
     * Method boolean untuk player agar tidak keluar dari board games
     *
     * @param c nilai bertipe integer dari tombol yang ditekan
     * @return true-keluar dari papan permainan, false-tidak keluar dari papan
     * permainan
     */
    public boolean checkOutOfBoard(int c) {
        if (c == KeyEvent.VK_DOWN) {
            if (this.level.player.position.y == this.level.floor[8][8].position.y) {
                return false;
            }
        } else if (c == KeyEvent.VK_LEFT) {
            if (this.level.player.position.x == this.level.floor[0][0].position.x) {
                return false;
            }
        } else if (c == KeyEvent.VK_RIGHT) {
            if (this.level.player.position.x == this.level.floor[8][8].position.x) {
                return false;
            }
        } else if (c == KeyEvent.VK_UP) {
            if (this.level.player.position.y == this.level.floor[0][0].position.y) {
                return false;
            }
        }
        return true;
    }

    /**
     * Method boolean untuk player agar tidak bisa melewati tembok/wall
     *
     * @param c nilai bertipe integer dari tombol yang ditekan
     * @return true-membentur dinding, false-tidak membentur dinding
     */
    public boolean checkHitWall(int c) {

        int gridX = (this.level.player.position.x - this.level.besarKotak) / (this.level.besarKotak + 1);
        int gridY = (this.level.player.position.y - this.level.besarKotak) / (this.level.besarKotak + 1);

        if (c == KeyEvent.VK_DOWN) {
            if (this.level.wall[gridY + 1][gridX].position != null) {
                return false;
            }
        } else if (c == KeyEvent.VK_LEFT) {
            if (this.level.wall[gridY][gridX - 1].position != null) {
                return false;
            }
        } else if (c == KeyEvent.VK_RIGHT) {
            if (this.level.wall[gridY][gridX + 1].position != null) {
                return false;
            }
        } else if (c == KeyEvent.VK_UP) {
            if (this.level.wall[gridY - 1][gridX].position != null) {
                return false;
            }
        }

        return true;
    }

    /**
     * Method boolean untuk mengecek apakah Player mati
     *
     * @return true-mati, false-tidak mati
     */
    public boolean isDead() {
        if (isFireDead()) {
            return true;
        }
        if (isWaterDead()) {
            return true;
        }

        return false;
    }

    /**
     * Method boolean untuk player mati jika terkena api
     *
     * @return true-mati, false-tidak mati
     */
    public boolean isFireDead() {

        if (hasFireBoots == true) {
            return false;
        }

        int gridX = (this.level.player.position.x - this.level.besarKotak) / (this.level.besarKotak + 1);
        int gridY = (this.level.player.position.y - this.level.besarKotak) / (this.level.besarKotak + 1);

        if (this.level.fire[gridX][gridY].position != null) {
            return true;
        }

        return false;
    }

    /**
     * Method boolean untuk player mati jika terkena air
     *
     * @return true-mati, false-tidak mati
     */
    public boolean isWaterDead() {

        if (hasWaterBoots == true) {
            return false;
        }

        int gridX = (this.level.player.position.x - this.level.besarKotak) / (this.level.besarKotak + 1);
        int gridY = (this.level.player.position.y - this.level.besarKotak) / (this.level.besarKotak + 1);

        if (this.level.water[gridX][gridY].position != null) {
            return true;
        }

        return false;
    }

    /**
     * Method untuk meload gambar api
     */
    public void loadFireImage() {
        URL imgUrl = getClass().getClassLoader().getResource(fireImgFileName);
        if (imgUrl == null) {
            System.err.println("Couldn't find file : " + fireImgFileName);
        } else {
            try {
                fireImg = ImageIO.read(imgUrl);

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } //end fire image loader
    }

    /**
     * Method untuk meload gambar karakter Chip
     */
    public void loadChipImage() {
        //player left image loader
        URL imgUrl = getClass().getClassLoader().getResource(chipLeftImgFileName);
        if (imgUrl == null) {
            System.err.println("Couldn't find file : " + chipLeftImgFileName);
        } else {
            try {
                chipImgLeft = ImageIO.read(imgUrl);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        //player right image loader
        imgUrl = getClass().getClassLoader().getResource(chipRightImgFileName);
        if (imgUrl == null) {
            System.err.println("Couldn't find file : " + chipRightImgFileName);
        } else {
            try {
                chipImgRight = ImageIO.read(imgUrl);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        //player front image loader
        imgUrl = getClass().getClassLoader().getResource(chipFrontImgFileName);
        if (imgUrl == null) {
            System.err.println("Couldn't find file : " + chipFrontImgFileName);
        } else {
            try {
                chipImgFront = ImageIO.read(imgUrl);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        //player back image loader
        imgUrl = getClass().getClassLoader().getResource(chipBackImgFileName);
        if (imgUrl == null) {
            System.err.println("Couldn't find file : " + chipBackImgFileName);
        } else {
            try {
                chipImgBack = ImageIO.read(imgUrl);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Method untuk meload gambar air
     */
    public void loadWaterImage() {
        URL imgUrl = getClass().getClassLoader().getResource(waterImgFileName);
        if (imgUrl == null) {
            System.err.println("Couldn't find file : " + waterImgFileName);
        } else {
            try {
                waterImg = ImageIO.read(imgUrl);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Method untuk meload gambar lantai kosong
     */
    public void loadEmptyFloorImage() {
        URL imgUrl = getClass().getClassLoader().getResource(floorImgFileName);
        if (imgUrl == null) {
            System.err.println("Couldn't find file : " + floorImgFileName);
        } else {
            try {
                floorImg = ImageIO.read(imgUrl);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Method untuk meload gambar Dinding
     */
    public void loadWallImage() {
        URL imgUrl = getClass().getClassLoader().getResource(wallImgFileName);
        if (imgUrl == null) {
            System.err.println("Couldn't find file : " + wallImgFileName);
        } else {
            try {
                wallImg = ImageIO.read(imgUrl);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Method untuk meload gambar Barrier
     */
    public void loadBarrierImage() {
        URL imgUrl = getClass().getClassLoader().getResource(barrierImgFileName);
        if (imgUrl == null) {
            System.err.println("Couldn't find file : " + barrierImgFileName);
        } else {
            try {
                barrierImg = ImageIO.read(imgUrl);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Method untuk meload gambar IC
     *
     */
    public void loadICImage() {
        URL imgUrl = getClass().getClassLoader().getResource(ICImgFileName);
        if (imgUrl == null) {
            System.err.println("Couldn't find file : " + ICImgFileName);
        } else {
            try {
                ICImg = ImageIO.read(imgUrl);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Method untuk meload gambar Gate atau Portal
     */
    public void loadGateImage() {
        URL imgUrl = getClass().getClassLoader().getResource(gateImgFileName);
        if (imgUrl == null) {
            System.err.println("Couldn't find file : " + gateImgFileName);
        } else {
            try {
                gateImg = ImageIO.read(imgUrl);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Method untuk meload gambar sepatu anti api / FireBoots
     */
    public void loadFireBootsImage() {
        URL imgUrl = getClass().getClassLoader().getResource(fireBootsImgFileName);
        if (imgUrl == null) {
            System.err.println("Couldn't find file : " + fireBootsImgFileName);
        } else {
            try {
                fireBootsImg = ImageIO.read(imgUrl);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Method untuk meload gambar sepatu anti air /WaterBoots
     */
    public void loadWaterBootsImage() {
        URL imgUrl = getClass().getClassLoader().getResource(waterBootsImgFileName);
        if (imgUrl == null) {
            System.err.println("Couldn't find file : " + waterBootsImgFileName);
        } else {
            try {
                waterBootsImg = ImageIO.read(imgUrl);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Method untuk meload gambar Instructions
     */
    public void loadInstructionImage() {
        URL imgUrl = getClass().getClassLoader().getResource(instructionImgFileName);
        if (imgUrl == null) {
            System.err.println("Couldn't find file : " + instructionImgFileName);
        } else {
            try {
                instructionImg = ImageIO.read(imgUrl);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Method untuk meload gambar Background Opening
     */
    public void loadOpeningImage() {
        URL imgUrl = getClass().getClassLoader().getResource(openingImgFileName);
        if (imgUrl == null) {
            System.err.println("Couldn't find file : " + openingImgFileName);
        } else {
            try {
                openingImg = ImageIO.read(imgUrl);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Method untuk meload semua gambar
     */
    public void loadAllImage() {
        loadFireImage();
        loadChipImage();
        loadWaterImage();
        loadEmptyFloorImage();
        loadWallImage();
        loadICImage();
        loadBarrierImage();
        loadGateImage();
        loadFireBootsImage();
        loadWaterBootsImage();
        loadInstructionImage();
        loadOpeningImage();
    }

    /**
     * Method untuk merubah lantai yang ada element menjadi lantai kosong
     * kembali
     */
    public void checkFloor() {
        this.instruction = false;
        int gridY = (this.level.player.position.x - this.level.besarKotak) / (this.level.besarKotak + 1);
        int gridX = (this.level.player.position.y - this.level.besarKotak) / (this.level.besarKotak + 1);

        if (this.level.ic[gridX][gridY].position != null) {
            this.level.icCount--;
            this.level.ic[gridX][gridY].position = null;
        }
        if (this.level.fireBoots[gridX][gridY].position != null) {
            hasWaterBoots = true;
            this.level.fireBoots[gridX][gridY].position = null;
        }
        if (this.level.waterBoots[gridX][gridY].position != null) {
            hasFireBoots = true;
            this.level.waterBoots[gridX][gridY].position = null;
        }
        if (this.level.instruction[gridX][gridY].position != null) {
            instruction = true;
        }
    }

    /**
     * Method untuk player tidak bisa menembus barrier jika belum mengambil
     * semua ic
     *
     * @param c nilai bertipe integer dari tombol yang ditekan
     * @return true-bisa membuka pintu barrier, false-membentur barrier
     */
    //true bisa gerak, false gak bisa gerak
    public boolean checkHitBarrier(int c) {

        int gridX = (this.level.player.position.x - this.level.besarKotak) / (this.level.besarKotak + 1);
        int gridY = (this.level.player.position.y - this.level.besarKotak) / (this.level.besarKotak + 1);

        if (c == KeyEvent.VK_DOWN) {
            if (this.level.barrier[gridY + 1][gridX].position != null && this.level.icCount != 0) {
                return false;
            }
            this.level.barrier[gridY + 1][gridX].position = null;
        } else if (c == KeyEvent.VK_LEFT) {
            if (this.level.barrier[gridY][gridX - 1].position != null && this.level.icCount != 0) {
                return false;
            }
            this.level.barrier[gridY][gridX - 1].position = null;
        } else if (c == KeyEvent.VK_RIGHT) {
            if (this.level.barrier[gridY][gridX + 1].position != null && this.level.icCount != 0) {
                return false;
            }
            this.level.barrier[gridY][gridX + 1].position = null;
        } else if (c == KeyEvent.VK_UP) {
            if (this.level.barrier[gridY - 1][gridX].position != null && this.level.icCount != 0) {
                return false;
            }
            this.level.barrier[gridY - 1][gridX].position = null;
        }

        return true;
    }

    /**
     * Method untuk mencek apakah level yang sedang dimainkan sudah selesai atau
     * belum(apakah sudah menginjak gate/portal atau belum)
     *
     * @return true-sudah selesai, false-belum selesai
     */
    public boolean isComplete() {
        int gridY = (this.level.player.position.x - this.level.besarKotak) / (this.level.besarKotak + 1);
        int gridX = (this.level.player.position.y - this.level.besarKotak) / (this.level.besarKotak + 1);

        if (this.level.gate[gridX][gridY].position != null) {
            return true;
        }
        return false;
    }

    /**
     * Method untuk mencek level berapakah saat ini.
     *
     * @param level level yang akan dicek
     * @return level yang sedang dimainkan
     */
    public Level checkCurrentLevel(Level level) {
        String a = level.getClass().getName();
        int pos = a.indexOf("Level");
        a = a.substring(16);
        if (a.equals("Level1")) {
            return new Level1();
        } else if (a.equals("Level2")) {
            return new Level2();
        } else if (a.equals("Level3")) {
            return new Level3();
        } else {
            return null;
        }
    }
}
