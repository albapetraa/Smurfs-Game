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
public class Puan extends Oyuncu {

    @Override
    public int puaniGoster() {

        return super.getSkor();
    }

}
