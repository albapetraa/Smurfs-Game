/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sirinler;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import Sirinler.Algoritma.Dugum;
import Sirinler.Dusmanlar.Azman;
import Sirinler.Dusmanlar.Gargamel;
import Sirinler.Oyuncular.Oyuncu1;
import Sirinler.Oyuncular.Oyuncu2;

/**
 *
 * @author Hp
 */
public class Oyun extends JPanel implements KeyListener, ActionListener {

    Dusman d1 = null;
    Dusman d2 = null;
    Oyuncu o = null;
    Timer timer = new Timer(10, this);

    private int[][] maze;

    private int puan;
    private BufferedImage image;
    private BufferedImage imageDusman1;
    private BufferedImage imageDusman2;
    private BufferedImage imageAltin;
    private BufferedImage imageMantar;
    private int karakterx = 6;
    private int karaktery = 5;
    private int dirkarakterx = 30;
    private int dirkaraktery = 30;
    private int secim;

    private int kapiAy = 0;
    private int kapiAx = 3;
    private int kapiBy = 0;
    private int kapiBx = 10;
    private int kapiCy = 5;
    private int kapiCx = 0;
    private int kapiDy = 10;
    private int kapiDx = 3;
    private int dusman1x;
    private int dusman1y;
    private int dusman2x;
    private int dusman2y;
    private int oyuncuBirim = 0;

    private ArrayList<Lokasyon> dusman1yol;
    private ArrayList<Lokasyon> dusman2yol;
    private ArrayList<Altin> altinListesi = new ArrayList<Altin>();
    private Mantar mantar;

    public Oyun(int secim, int[][] labirent, int dusmanSayisi, String[] dusmanlar, String[] dusmanlarKapi) {

        this.maze = labirent;
        if (dusmanSayisi == 1) {
            if (dusmanlar[0].equals("Azman")) {
                d1 = new Azman();
                switch (dusmanlarKapi[0]) {
                    case "A":
                        dusman1x = kapiAx;
                        dusman1y = kapiAy;
                        d1.setGirilenKapi("A");
                        break;
                    case "B":
                        dusman1x = kapiBx;
                        dusman1y = kapiBy;
                        d1.setGirilenKapi("B");
                        break;
                    case "C":
                        dusman1x = kapiCx;
                        dusman1y = kapiCy;
                        d1.setGirilenKapi("C");
                        break;
                    case "D":
                        dusman1x = kapiCx;
                        dusman1y = kapiCy;
                        d1.setGirilenKapi("D");
                        break;
                }
            } else if (dusmanlar[0].equals("Gargamel")) {
                d1 = new Gargamel();
                switch (dusmanlarKapi[0]) {
                    case "A":
                        dusman1x = kapiAx;
                        dusman1y = kapiAy;
                        d1.setGirilenKapi("A");
                        break;
                    case "B":
                        dusman1x = kapiBx;
                        dusman1y = kapiBy;
                        d1.setGirilenKapi("B");
                        break;
                    case "C":
                        dusman1x = kapiCx;
                        dusman1y = kapiCy;
                        d1.setGirilenKapi("C");
                        break;
                    case "D":
                        dusman1x = kapiCx;
                        dusman1y = kapiCy;
                        d1.setGirilenKapi("D");
                        break;
                }
            }
        } else {
            if (dusmanlar[0].equals("Azman")) {
                d1 = new Azman();
                switch (dusmanlarKapi[0]) {
                    case "A":
                        dusman1x = kapiAx;
                        dusman1y = kapiAy;
                        d1.setGirilenKapi("A");
                        break;
                    case "B":
                        dusman1x = kapiBx;
                        dusman1y = kapiBy;
                        d1.setGirilenKapi("B");
                        break;
                    case "C":
                        dusman1x = kapiCx;
                        dusman1y = kapiCy;
                        d1.setGirilenKapi("C");
                        break;
                    case "D":
                        dusman1x = kapiCx;
                        dusman1y = kapiCy;
                        d1.setGirilenKapi("D");
                        break;
                }
            }
            if (dusmanlar[0].equals("Gargamel")) {
                d1 = new Gargamel();
                switch (dusmanlarKapi[0]) {
                    case "A":
                        dusman1x = kapiAx;
                        dusman1y = kapiAy;
                        d1.setGirilenKapi("A");
                        break;
                    case "B":
                        dusman1x = kapiBx;
                        dusman1y = kapiBy;
                        d1.setGirilenKapi("B");
                        break;
                    case "C":
                        dusman1x = kapiCx;
                        dusman1y = kapiCy;
                        d1.setGirilenKapi("C");
                        break;
                    case "D":
                        dusman1x = kapiCx;
                        dusman1y = kapiCy;
                        d1.setGirilenKapi("D");
                        break;
                }
            }
            if (dusmanlar[1].equals("Azman")) {
                d2 = new Azman();
                switch (dusmanlarKapi[1]) {
                    case "A":
                        dusman2x = kapiAx;
                        dusman2y = kapiAy;
                        d2.setGirilenKapi("A");
                        break;
                    case "B":
                        dusman2x = kapiBx;
                        dusman2y = kapiBy;
                        d2.setGirilenKapi("B");
                        break;
                    case "C":
                        dusman2x = kapiCx;
                        dusman2y = kapiCy;
                        d2.setGirilenKapi("C");
                        break;
                    case "D":
                        dusman2x = kapiDx;
                        dusman2y = kapiDy;
                        d2.setGirilenKapi("D");
                        break;
                }
            }
            if (dusmanlar[1].equals("Gargamel")) {
                d2 = new Gargamel();
                switch (dusmanlarKapi[1]) {
                    case "A":
                        dusman2x = kapiAx;
                        dusman2y = kapiAy;
                        d2.setGirilenKapi("A");
                        break;
                    case "B":
                        dusman2x = kapiBx;
                        dusman2y = kapiBy;
                        d2.setGirilenKapi("B");
                        break;
                    case "C":
                        dusman2x = kapiCx;
                        dusman2y = kapiCy;
                        d2.setGirilenKapi("C");
                        break;
                    case "D":
                        dusman2x = kapiCx;
                        dusman2y = kapiCy;
                        d2.setGirilenKapi("D");
                        break;
                }
            }

        }

        if (secim == 1) {
            o = new Oyuncu1();
        }
        if (secim == 2) {
            o = new Oyuncu2();
        }

        try {
            image = ImageIO.read(new FileImageInputStream(new File(o.getKarakterID() + ".png")));
            imageAltin = ImageIO.read(new FileImageInputStream(new File("altin.png")));
            imageMantar = ImageIO.read(new FileImageInputStream(new File("mantar.png")));

            if (dusmanSayisi == 2) {
                imageDusman1 = ImageIO.read(new FileImageInputStream(new File(d1.getDusmanID() + ".png")));
                imageDusman2 = ImageIO.read(new FileImageInputStream(new File(d2.getDusmanID() + ".png")));
            } else {
                imageDusman1 = ImageIO.read(new FileImageInputStream(new File(d1.getDusmanID() + ".png")));
            }
            imageAltin = ImageIO.read(new FileImageInputStream(new File("altin.png")));

        } catch (IOException ex) {
            Logger.getLogger(Oyun.class.getName()).log(Level.SEVERE, null, ex);
        }
        timer.start();

        d1.enKisaYol(labirent, dusman1y, dusman1x, karaktery, karakterx);
        dusman1yol = d1.getPatika();
        d2.enKisaYol(labirent, dusman2y, dusman2x, karaktery, karakterx);
        dusman2yol = d2.getPatika();
    }

    @Override
    public void paint(Graphics g) {

        puan = o.getSkor();
        super.paint(g);
        g.translate(50, 50);
        for (int row = 0; row < maze.length; row++) {
            for (int col = 0; col < maze[0].length; col++) {
                Color color;
                switch (maze[row][col]) {
                    case 1:
                        color = Color.WHITE;
                        break;
                    case 4:
                        color = Color.BLUE;
                        break;
                    case 9:
                        color = Color.RED;
                        break;
                    default:
                        color = Color.GRAY;
                        break;
                }
                if (maze[7][12] == 1 && row == 7 && col == 12) {
                    color = Color.MAGENTA;

                }
                g.drawImage(image, karakterx * dirkarakterx, karaktery * dirkaraktery, this);
                if (d2 != null) {
                    g.drawImage(imageDusman1, dusman1x * dirkarakterx, dusman1y * dirkaraktery, this);
                    g.drawImage(imageDusman2, dusman2x * dirkarakterx, dusman2y * dirkaraktery, this);
                } else {
                    g.drawImage(imageDusman1, dusman1x * dirkarakterx, dusman1y * dirkaraktery, this);
                }

                for (Altin altin : altinListesi) {
                    g.drawImage(imageAltin, altin.getX() * dirkarakterx, altin.getY() * dirkaraktery, this);
                    if (altin.getX() == karakterx && altin.getY() == karaktery) {
                        o.skorYukselt(altin.getAltinPuani());
                        altinListesi.remove(altin);
                    }
                }
                if (mantar != null) {
                    g.drawImage(imageMantar, mantar.getX() * dirkarakterx, mantar.getY() * dirkaraktery, this);
                    if (mantar.getX() == karakterx && mantar.getY() == karaktery) {
                        o.skorYukselt(mantar.getMantarPuani());
                        mantar = null;
                    }
                }
                g.setColor(color);
                g.fillRect(30 * col, 30 * row, 30, 30);
                g.setColor(Color.BLACK);
                g.drawRect(30 * col, 30 * row, 30, 30);
            }

        }
        for (int p = 1; p < dusman1yol.size() - 1; p++) {
            int pathX = dusman1yol.get(p).x;
            int pathY = dusman1yol.get(p).y;

            g.setColor(new Color(0, 0, 102, 150));
            g.fillRect(30 * pathX, 30 * pathY, 30, 30);

        }
        for (int p = 1; p < dusman2yol.size() - 1; p++) {
            int pathX = dusman2yol.get(p).x;
            int pathY = dusman2yol.get(p).y;

            g.setColor(new Color(204, 0, 0, 150));
            g.fillRect(30 * pathX, 30 * pathY, 30, 30);

        }
    }

    @Override
    public void repaint() {
        super.repaint(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        o.skorAzalt(1);
        int c = e.getKeyCode();
        if (o.getOyuncuID() == 1) {
            if (c == KeyEvent.VK_LEFT) {
                if (maze[karaktery][karakterx - 1] != 0) {
                    if (karakterx <= 0) {
                        karakterx = 0;
                    } else {
                        karakterx -= 1;
                    }
                }
                oyuncuBirim += 1;
            } else if (c == KeyEvent.VK_RIGHT) {
                if (maze[karaktery][karakterx + 1] != 0) {
                    if (karakterx >= 12) {
                        karakterx = 12;
                    } else {
                        karakterx += 1;
                    }
                }
                oyuncuBirim += 1;
            } else if (c == KeyEvent.VK_UP) {
                if (maze[karaktery - 1][karakterx] != 0) {
                    if (karaktery <= 0) {
                        karaktery = 0;
                    } else {
                        karaktery -= 1;
                    }
                }
                oyuncuBirim += 1;
            } else if (c == KeyEvent.VK_DOWN) {
                System.out.println("xd");
                if (maze[karaktery + 1][karakterx] != 0) {
                    if (karaktery >= 10) {
                        karaktery = 10;
                    } else {
                        karaktery += 1;
                    }
                }
                oyuncuBirim += 1;
            }

        } else if (o.getOyuncuID() == 2) {
            if (c == KeyEvent.VK_LEFT) {
                if (maze[karaktery][karakterx - 1] != 0) {

                    if (karakterx <= 0) {
                        karakterx = 0;
                    } else {
                        karakterx -= 1;
                    }
                }

            } else if (c == KeyEvent.VK_RIGHT) {
                if (maze[karaktery][karakterx + 1] != 0) {
                    if (karakterx >= 12) {
                        karakterx = 12;
                    } else {
                        karakterx += 1;
                    }
                }

            } else if (c == KeyEvent.VK_DOWN) {
                if (maze[karaktery + 1][karakterx] != 0) {
                    if (karaktery >= 10) {
                        karaktery = 10;
                    } else {
                        karaktery += 1;
                    }
                }

            } else if (c == KeyEvent.VK_UP) {
                if (maze[karaktery - 1][karakterx] != 0) {
                    if (karaktery <= 0) {
                        karaktery = 0;
                    } else {
                        karaktery -= 1;
                    }
                }
            }
        }
        if (karakterx == dusman1x && karaktery == dusman1y) {
            dusman2y = dusman2yol.get(1).y;
            dusman2x = dusman2yol.get(1).x;
            return;
        }
        if (karakterx == dusman2x && karaktery == dusman2y) {
            dusman1y = dusman1yol.get(1).y;
            dusman1x = dusman1yol.get(1).x;
            return;
        }
        System.out.println("oyuncu birim " + oyuncuBirim);
        if (oyuncuBirim == 1) {
            if (oyuncuBirim == 2) {
                dusmanHareketEt();
            }
            return;
        }

        dusmanHareketEt();

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public void dusmanHareketEt() {
        setOyuncuBirim(0);
        System.out.println("d2 " + dusman2yol.size());
        if (d1.getKarakterAd().equals("Gargamel")) {
            if (dusman1yol.size() == 2) {
                int x = dusman1yol.get(1).getX();
                int y = dusman1yol.get(1).getY();
                dusman1x = x;
                dusman1y = y;
                dusman1KonumYenileme();
                o.skorAzalt(d1.azaltilacakPuanMiktari());
            } else if (dusman1yol.size() == 3) {
                int x2 = dusman2yol.get(1).getX();
                int y2 = dusman2yol.get(1).getY();
                if (x2 == karakterx && y2 == karaktery) {
                    dusman2x = x2;
                    dusman2y = y2;
                    return;
                }
                int x = dusman1yol.get(2).getX();
                int y = dusman1yol.get(2).getY();
                dusman1x = x;
                dusman1y = y;
            } else {
                int x = dusman1yol.get(2).getX();
                int y = dusman1yol.get(2).getY();
                dusman1x = x;
                dusman1y = y;
            }
            if (dusman2yol.size() == 2) {
                int x = dusman2yol.get(1).getX();
                int y = dusman2yol.get(1).getY();
                dusman2x = x;
                dusman2y = y;
                dusman2KonumYenileme();
                o.skorAzalt(d2.azaltilacakPuanMiktari());

            } else {
                int x = dusman2yol.get(1).getX();
                int y = dusman2yol.get(1).getY();
                dusman2x = x;
                dusman2y = y;
            }
        } else {
            if (dusman2yol.size() == 2) {
                int x = dusman2yol.get(1).getX();
                int y = dusman2yol.get(1).getY();
                dusman2x = x;
                dusman2y = y;
                dusman2KonumYenileme();
                o.skorAzalt(d2.azaltilacakPuanMiktari());
            } else if (dusman2yol.size() == 3) {
                System.out.println("burdayız dile");
                int x2 = dusman2yol.get(1).getX();
                int y2 = dusman2yol.get(1).getY();
                if (x2 == karakterx && y2 == karaktery) {
                    dusman2x = x2;
                    dusman2y = y2;
                    return;
                }
                int x = dusman2yol.get(2).getX();
                int y = dusman2yol.get(2).getY();
                dusman2x = x;
                dusman2y = y;
            } else {
                int x = dusman2yol.get(2).getX();
                int y = dusman2yol.get(2).getY();
                dusman2x = x;
                dusman2y = y;
            }
            if (dusman2yol.size() == 2) {
                int x = dusman1yol.get(1).getX();
                int y = dusman1yol.get(1).getY();
                dusman1x = x;
                dusman1y = y;
                dusman2KonumYenileme();
                o.skorAzalt(d1.azaltilacakPuanMiktari());

            } else {
                int x = dusman1yol.get(1).getX();
                int y = dusman1yol.get(1).getY();
                dusman1x = x;
                dusman1y = y;
            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        d1.enKisaYol(maze, dusman1y, dusman1x, karaktery, karakterx);
        dusman1yol = d1.getPatika();
        d2.enKisaYol(maze, dusman2y, dusman2x, karaktery, karakterx);
        dusman2yol = d2.getPatika();
        if (o.getSkor() <= 0) {
            JOptionPane.showMessageDialog(null, "Maalesef Şirine'yi kurtaramadın.");
            System.exit(1);
        }
        if (karaktery == 7 && karakterx == 12) {
            JOptionPane.showMessageDialog(null, "Başarıyla Şirine'ye ulaştınız.Tebrikler!");
            System.exit(1);
        }
        if (karakterx == dusman1x) {
            if (karaktery == dusman1y) {
                dusman1KonumYenileme();
                o.skorAzalt(d1.azaltilacakPuanMiktari());
            }
        }
        if (karakterx == dusman2x) {
            if (karaktery == dusman2y) {
                dusman2KonumYenileme();
                o.skorAzalt(d2.azaltilacakPuanMiktari());
            }
        }

        repaint();
    }

    public void dusman1KonumYenileme() {
        switch (d1.getGirilenKapi()) {
            case "A":
                dusman1x = kapiAx;
                dusman1y = kapiAy;
                break;
            case "B":
                dusman1x = kapiBx;
                dusman1y = kapiAy;
                break;
            case "C":
                dusman1x = kapiCx;
                dusman1y = kapiCy;
                break;
            case "D":
                dusman1x = kapiDx;
                dusman1y = kapiDy;
                break;
        }
    }

    public void dusman2KonumYenileme() {
        switch (d2.getGirilenKapi()) {
            case "A":
                dusman2x = kapiAx;
                dusman2y = kapiAy;
                break;
            case "B":
                dusman2x = kapiBx;
                dusman2y = kapiBy;

                break;
            case "C":
                dusman2x = kapiCx;
                dusman2y = kapiCy;
                break;
            case "D":
                dusman2x = kapiDx;
                dusman2y = kapiDy;
                break;
        }

    }

    public void kontrolKaraktervsDusman() {
        if (karaktery == dusman1y && karakterx == dusman1x) {
            o.skorAzalt(d1.azaltilacakPuanMiktari());
            dusman1KonumYenileme();

        } else if (karaktery == dusman2y && karakterx == dusman2x) {
            o.skorAzalt(d2.azaltilacakPuanMiktari());
        }
    }

    public void altinOlustur() {
        altinListesi.clear();
        ArrayList<Integer> numaraListesi = new ArrayList<Integer>();
        for (int i = 0; i < 78; i++) {
            numaraListesi.add(i);
        }
        Collections.shuffle(numaraListesi);
        for (int i = 0; i < 6; i++) {
            if (i == 5) {
                break;
            } else {
                Dugum d = d1.numaraBul(numaraListesi.get(i), d2.dugumlerim);
                Altin a = new Altin(d.getX(), d.getY());
                altinListesi.add(a);
            }
        }

    }

    public void mantarOlustur() {
        mantar = null;
        ArrayList<Integer> numaraListesi = new ArrayList<Integer>();
        for (int i = 0; i < 78; i++) {
            numaraListesi.add(i);
        }
        Collections.shuffle(numaraListesi);
        int numara = numaraListesi.get(14);
        Dugum d = d1.numaraBul(numara, d2.dugumlerim);
        mantar = new Mantar(d.getX(), d.getY());

    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    public int getOyuncuBirim() {
        return oyuncuBirim;
    }

    public void setOyuncuBirim(int oyuncuBirim) {
        this.oyuncuBirim = oyuncuBirim;
    }

}
