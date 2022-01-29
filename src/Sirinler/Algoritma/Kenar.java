/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sirinler.Algoritma;

/**
 *
 * @author Hp
 */
public class Kenar {

    private int agirlik;
    private Dugum baslangicDugum;
    private Dugum hedefDugum;

    public Kenar(int agirlik, Dugum baslangicDugum, Dugum hedefDugum) {
        this.agirlik = agirlik;
        this.baslangicDugum = baslangicDugum;
        this.hedefDugum = hedefDugum;
    }

    public int getAgirlik() {
        return agirlik;
    }

    public void setAgirlik(int agirlik) {
        this.agirlik = agirlik;
    }

    public Dugum getBaslangicDugum() {
        return baslangicDugum;
    }

    public void setBaslangicDugum(Dugum baslangicDugum) {
        this.baslangicDugum = baslangicDugum;
    }

    public Dugum getHedefDugum() {
        return hedefDugum;
    }

    public void setHedefDugum(Dugum hedefDugum) {
        this.hedefDugum = hedefDugum;
    }

}
