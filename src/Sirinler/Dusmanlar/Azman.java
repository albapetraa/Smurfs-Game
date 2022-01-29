/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sirinler.Dusmanlar;

import Sirinler.Dusman;

/**
 *
 * @author Hp
 */
public class Azman extends Dusman {

    public Azman() {
        super(3, "Azman", 2);
    }

    @Override
    public int azaltilacakPuanMiktari() {

        return 5;

    }

}
