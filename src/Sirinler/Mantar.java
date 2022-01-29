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
public class Mantar {

    private int x;
    private int y;
    private int mantarPuani = 20;

    public Mantar(int y, int x) {
        this.x = x;
        this.y = y;
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

    public int getMantarPuani() {
        return mantarPuani;
    }

    public void setMantarPuani(int mantarPuani) {
        this.mantarPuani = mantarPuani;
    }

}
