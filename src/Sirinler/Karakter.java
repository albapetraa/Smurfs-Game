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
public abstract class Karakter {

    private int karakterID;
    private String karakterAd;
    private int karakterTur;

    public abstract void enKisaYol(int[][] labirent, int dusmanY, int dusmanX, int oyuncuY, int oyuncuX);

    public Karakter() {
    }

    public Karakter(int karakterID, String karakterAd, int karakterTür) {
        this.karakterID = karakterID;
        this.karakterAd = karakterAd;
        this.karakterTur = karakterTür;
    }

    public int getKarakterID() {
        return karakterID;
    }

    public void setKarakterID(int karakterID) {
        this.karakterID = karakterID;
    }

    public String getKarakterAd() {
        return karakterAd;
    }

    public void setKarakterAd(String karakterAd) {
        this.karakterAd = karakterAd;
    }

    public int getKarakterTur() {
        return karakterTur;
    }

    public void setKarakterTur(int karakterTur) {
        this.karakterTur = karakterTur;
    }

}
