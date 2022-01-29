/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sirinler;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hp
 */
public class LabirentOkuma {

    int[][] labirent = new int[11][13];
    int labirentY = 0;
    ArrayList<String> result = new ArrayList<>();
    String dusman1 = new String();
    String dusman2 = new String();
    String kapiDusman1 = new String();
    String kapiDusman2 = new String();

    public LabirentOkuma() throws IOException {
        try {
            FileReader file = new FileReader("harita.txt");
            StringBuffer sb = new StringBuffer();
            while (file.ready()) {
                char c = (char) file.read();
                if (c == '\n') {
                    result.add(sb.toString());
                    sb = new StringBuffer();
                } else {
                    sb.append(c);
                }
            }
            if (sb.length() > 0) {
                result.add(sb.toString());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LabirentOkuma.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] arr = result.toArray(new String[result.size()]);
        if (arr[1].charAt(0) == 'K') {
            arr[0] = arr[0].replace(":", ",");
            arr[1] = arr[1].replace(":", ",");
            for (int i = 0; i < 13; i++) {
                String[] arr2 = arr[i].split(",");
                if (i == 0) {
                    dusman1 = arr2[1];
                    kapiDusman1 = arr2[3];
                } else if (i == 1) {
                    dusman2 = arr2[1];
                    kapiDusman2 = arr2[3];
                } else {

                    String[] sayiSplit = arr[i].split("\\t");
                    int[] gecicimazeX = arrayCevirme(sayiSplit);
                    for (int j = 0; j < gecicimazeX.length; j++) {
                        int k = gecicimazeX[j];
                        labirent[labirentY][j] = k;
                    }
                    labirentY++;
                }
            }
            String[] split = arr[2].split("\\t");

        } else {
            arr[0] = arr[0].replace(":", ",");
            for (int i = 0; i < 12; i++) {
                if (i == 0) {
                    String[] arr2 = arr[0].split(",");
                    dusman1 = arr2[1];
                    kapiDusman1 = arr2[3];
                } else {
                    String[] sayiSplit = arr[i].split("\\t");
                    int[] gecicimazeX = arrayCevirme(sayiSplit);
                    for (int j = 0; j < gecicimazeX.length; j++) {
                        int k = gecicimazeX[j];
                        labirent[labirentY][j] = k;
                    }
                    labirentY++;
                }

            }

        }
    }

    public int[] arrayCevirme(String[] s) {
        int[] result = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            result[i] = Integer.parseInt(s[i]);
        }
        return result;
    }

    public ArrayList<String> getResult() {
        return result;
    }

    public void setResult(ArrayList<String> result) {
        this.result = result;
    }

    public String getDusman1() {
        return dusman1;
    }

    public void setDusman1(String dusman1) {
        this.dusman1 = dusman1;
    }

    public String getDusman2() {
        return dusman2;
    }

    public void setDusman2(String dusman2) {
        this.dusman2 = dusman2;
    }

    public String getKapiDusman1() {
        return kapiDusman1;
    }

    public void setKapiDusman1(String kapiDusman1) {
        this.kapiDusman1 = kapiDusman1;
    }

    public String getKapiDusman2() {
        return kapiDusman2;
    }

    public void setKapiDusman2(String kapiDusman2) {
        this.kapiDusman2 = kapiDusman2;
    }

    public int[][] getLabirent() {
        return labirent;
    }

    public void setLabirent(int[][] labirent) {
        this.labirent = labirent;
    }

}
