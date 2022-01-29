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
public class Gargamel extends Dusman {

    public Gargamel() {
        super(4, "Gargamel", 2);
    }

    @Override
    public int azaltilacakPuanMiktari() {
        return 15;
    }

}
