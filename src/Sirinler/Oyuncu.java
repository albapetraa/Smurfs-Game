/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sirinler;

/**
 *
 * @author Hp
 */
public abstract class Oyuncu extends Karakter {

    private int oyuncuID;
    private String oyuncuAdi;
    private int oyuncuTur;
    private int skor;

    public abstract int puaniGoster();

    @Override
    public void enKisaYol(int[][] labirent, int dusmanY, int dusmanX, int oyuncuY, int oyuncuX) {

    }

    public Oyuncu() {
    }

    public Oyuncu(int oyuncuID, String oyuncuAdi, int oyuncuTur) {
        super(oyuncuID, oyuncuAdi, oyuncuTur);
        this.skor = 20;
        this.oyuncuAdi = oyuncuAdi;
        this.oyuncuID = oyuncuID;
        this.oyuncuTur = oyuncuTur;
    }

    public int getOyuncuID() {
        return oyuncuID;
    }

    public void setOyuncuID(int oyuncuID) {
        this.oyuncuID = oyuncuID;
    }

    public String getOyuncuAdi() {
        return oyuncuAdi;
    }

    public void setOyuncuAdi(String oyuncuAdi) {
        this.oyuncuAdi = oyuncuAdi;
    }

    public int getOyuncuTur() {
        return oyuncuTur;
    }

    public void setOyuncuTur(int oyuncuTur) {
        this.oyuncuTur = oyuncuTur;
    }

    public int getSkor() {
        return skor;
    }

    public void setSkor(int skor) {
        this.skor = skor;
    }

    public int skorYukselt(int q) {
        this.skor += q;
        return this.skor;
    }

    public int skorAzalt(int q) {
        this.skor -= q;
        return this.skor;
    }

}
