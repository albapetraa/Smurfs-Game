/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sirinler.Algoritma;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 *
 * @author Hp
 */
public class DijkstraShortestPath {
    
    public void enKisaYolHesapla(Dugum kaynakDugum) {
        kaynakDugum.setUzaklik(0);
        PriorityQueue<Dugum> oncelikKuyrugu = new PriorityQueue<>();
        oncelikKuyrugu.add(kaynakDugum);
        kaynakDugum.setZiyaretEdilmis(true);
        
        while (!oncelikKuyrugu.isEmpty()) {
            Dugum suankiDugum = oncelikKuyrugu.poll();
            
            for (Kenar kenar : suankiDugum.getKomsulukList()) {
                Dugum d = kenar.getHedefDugum();
                if (!d.isZiyaretEdilmis()) {
                    int yeniUzaklik = suankiDugum.getUzaklik() + kenar.getAgirlik();
                    
                    if (yeniUzaklik < d.getUzaklik()) {
                        oncelikKuyrugu.remove(d);
                        d.setUzaklik(yeniUzaklik);
                        d.setOnceki(suankiDugum);
                        oncelikKuyrugu.add(d);
                    }
                }
            }
            suankiDugum.setZiyaretEdilmis(true);
        }
        oncelikKuyrugu.removeAll(oncelikKuyrugu);
        
    }
    
    public ArrayList<String> getEnKisaYol(Dugum hedefDugum) {
        ArrayList<String> yol = new ArrayList<>();
        for (Dugum dugum = hedefDugum; dugum != null; dugum = dugum.getOnceki()) {
            yol.add(dugum.getIsim());
        }
        Collections.reverse(yol);
        return yol;
    }
    
}
