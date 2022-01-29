/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sirinler.Algoritma;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hp
 */
public class Dugum implements Comparable<Dugum> {

    private String isim;
    public int x;
    public int y;
    private List<Kenar> komsulukList = new ArrayList<Kenar>();
    private boolean ziyaretEdilmis;
    private Dugum onceki;
    private int uzaklik = Integer.MAX_VALUE;

    public Dugum(String isim, int x, int y) {
        this.isim = isim;
        this.x = x;
        this.y = y;
        this.komsulukList = komsulukList;
    }

    public void komsuEkle(Kenar kenar) {
        this.komsulukList.add(kenar);
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public List<Kenar> getKomsulukList() {
        return komsulukList;
    }

    public void setKomsulukList(List<Kenar> komsulukList) {
        this.komsulukList = komsulukList;
    }

    public boolean isZiyaretEdilmis() {
        return ziyaretEdilmis;
    }

    public void setZiyaretEdilmis(boolean ziyaretEdilmis) {
        this.ziyaretEdilmis = ziyaretEdilmis;
    }

    public Dugum getOnceki() {
        return onceki;
    }

    public void setOnceki(Dugum onceki) {
        this.onceki = onceki;
    }

    public int getUzaklik() {
        return uzaklik;
    }

    public void setUzaklik(int uzaklik) {
        this.uzaklik = uzaklik;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return this.isim;
    }

    @Override
    public int compareTo(Dugum digerDugum) {
        return Double.compare(this.uzaklik, digerDugum.getUzaklik());
    }

}
