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
public class Altin {

    private int x;
    private int y;
    private int altinPuani = 5;

    public Altin(int y, int x) {
        this.y = y;
        this.x = x;
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

    public int getAltinPuani() {
        return altinPuani;
    }

    public void setAltinPuani(int altinPuani) {
        this.altinPuani = altinPuani;
    }

}
