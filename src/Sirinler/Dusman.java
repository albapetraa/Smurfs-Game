/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sirinler;

import java.util.ArrayList;
import java.util.List;
import Sirinler.Algoritma.DijkstraShortestPath;
import Sirinler.Algoritma.Dugum;
import Sirinler.Algoritma.Kenar;

/**
 *
 * @author Hp
 */
public abstract class Dusman extends Karakter {

    private int dusmanID;
    private String dusmanAdi;
    private int dusmanTur;
    private String girilenKapi;
    public ArrayList<Lokasyon> patika = new ArrayList<Lokasyon>();
    public static Dugum[] dugumlerim = new Dugum[78];

    public abstract int azaltilacakPuanMiktari();

    @Override
    public void enKisaYol(int[][] labirent, int dusmanY, int dusmanX, int oyuncuY, int oyuncuX) {
        dugumlerim = new Dugum[78];
        int[][] maze = labirent;
        patika.clear();
        int sayi = 0;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                if (maze[i][j] == 1) {
                    String s = Integer.toString(sayi);
                    Dugum temp = new Dugum(s, i, j);
                    dugumlerim[sayi] = temp;
                    sayi++;
                }
            }
        }

        for (Dugum d : dugumlerim) {

            if (d.x + 1 < 11 && maze[d.x + 1][d.y] == 1) {
                int id = dugumBul(d.x + 1, d.y, dugumlerim);
                d.komsuEkle(new Kenar(1, d, dugumlerim[id]));
            }
            if (d.x - 1 > 0 && maze[d.x - 1][d.y] == 1) {
                int id = dugumBul(d.x - 1, d.y, dugumlerim);
                d.komsuEkle(new Kenar(1, d, dugumlerim[id]));
            }

            if (d.y + 1 < 13 && maze[d.x][d.y + 1] == 1) {
                int id = dugumBul(d.x, d.y + 1, dugumlerim);
                d.komsuEkle(new Kenar(1, d, dugumlerim[id]));
            }
            if (d.y - 1 > 0 && maze[d.x][d.y - 1] == 1) {
                int id = dugumBul(d.x, d.y - 1, dugumlerim);
                d.komsuEkle(new Kenar(1, d, dugumlerim[id]));
            }
        }
        for (Dugum d : dugumlerim) {
            List<Kenar> q = d.getKomsulukList();
        }
        DijkstraShortestPath shortestPath = new DijkstraShortestPath();
        int dusman = dugumBul(dusmanY, dusmanX, dugumlerim);
        int oyuncu = dugumBul(oyuncuY, oyuncuX, dugumlerim);
        shortestPath.enKisaYolHesapla(dugumlerim[dusman]);
//        System.out.println("En dusuk uzaklik Dusmandan Oyuncuya: " + dugumlerim[oyuncu].getUzaklik());
//        System.out.println("En dusuk yol numaraları Dusmandan Oyuncuya: " + shortestPath.getEnKisaYol(dugumlerim[oyuncu]));
        ArrayList<String> dugumNumaralari = shortestPath.getEnKisaYol(dugumlerim[oyuncu]);
        for (int i = 0; i < dugumNumaralari.size(); i++) {
            int numarasi = Integer.parseInt(dugumNumaralari.get(i));
            Dugum numDugum = numaraBul(numarasi, dugumlerim);
            Lokasyon lok = new Lokasyon(numDugum.y, numDugum.x);
            patika.add(lok);
        }

    }

    public Dugum numaraBul(int numarasi, Dugum[] dugumlerim) {
        for (Dugum d : dugumlerim) {

            if (Integer.parseInt(d.getIsim()) == numarasi) {
                return d;
            }
        }
        return null;
    }

    public int dugumBul(int x, int y, Dugum[] dugumlerim) {
        int arananSayi = 0;
        for (int i = 0; i < dugumlerim.length; i++) {
            Dugum dugum = dugumlerim[i];
            if (dugum.x == x && dugum.y == y) {
                arananSayi = i;
            }

        }
        return arananSayi;
    }

    public Dusman() {
    }

    public Dusman(int dusmanID, String dusmanAdi, int dusmanTur) {
        super(dusmanID, dusmanAdi, dusmanTur);
        this.dusmanID = dusmanID;
        this.dusmanAdi = dusmanAdi;
        this.dusmanTur = dusmanTur;

    }

    public int getDusmanID() {
        return dusmanID;
    }

    public void setDusmanID(int dusmanID) {
        this.dusmanID = dusmanID;
    }

    public String getDusmanAdi() {
        return dusmanAdi;
    }

    public void setDusmanAdi(String dusmanAdi) {
        this.dusmanAdi = dusmanAdi;
    }

    public int getDusmanTur() {
        return dusmanTur;
    }

    public void setDusmanTur(int dusmanTur) {
        this.dusmanTur = dusmanTur;
    }

    public ArrayList<Lokasyon> getPatika() {
        return patika;
    }

    public void setPatika(ArrayList<Lokasyon> patika) {
        this.patika = patika;
    }

    public String getGirilenKapi() {
        return girilenKapi;
    }

    public void setGirilenKapi(String girilenKapi) {
        this.girilenKapi = girilenKapi;
    }

    public Dugum[] getDugumlerim() {
        return dugumlerim;
    }

    public void setDugumlerim(Dugum[] dugumlerim) {
        this.dugumlerim = dugumlerim;
    }

}
