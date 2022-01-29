/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sirinler.Oyuncular;

import Sirinler.Oyuncu;

/**
 *
 * @author Hp
 */
public class Oyuncu1 extends Oyuncu {

    public Oyuncu1() {
        super(1, "Gözlüklü Şirin", 1);

    }

    @Override
    public int puaniGoster() {
        Puan p = new Puan();
        int skor = p.puaniGoster();
        return skor;
    }

}
