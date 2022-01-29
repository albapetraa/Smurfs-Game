package Sirinler;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class OyunEkrani extends JFrame {

    public OyunEkrani(String title) throws HeadlessException {
        super(title);
    }

    public static void main(String[] args) throws IOException {

        LabirentOkuma l = new LabirentOkuma();

        int dusman_sayi = 0;
        String[] dusmanlar = new String[2];
        String[] dusmanlarKapi = new String[2];
        if (l.dusman1.equals("Gargamel") || l.dusman1.equals("Azman")) {
            dusman_sayi++;
            dusmanlar[0] = l.dusman1;
            dusmanlarKapi[0] = l.kapiDusman1;
        }
        if (l.dusman2.equals("Gargamel") || l.dusman2.equals("Azman")) {
            dusman_sayi++;
            dusmanlar[1] = l.dusman2;
            dusmanlarKapi[1] = l.kapiDusman2;
        }

        OyunEkrani ekran = new OyunEkrani("Labirent");
        ekran.setResizable(false);
        ekran.setFocusable(false);
        ekran.setSize(640, 480);
        ekran.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Object[] options = {"Gözlüklü Şirin",
            "Uykucu Şirin"};
        int n = JOptionPane.showOptionDialog(ekran,
                "Karakterinizi Seçin",
                "Karakter Seçim Ekranı",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        Oyun oyun = new Oyun(n + 1, l.getLabirent(), dusman_sayi, dusmanlar, dusmanlarKapi);
        oyun.requestFocus();
        oyun.addKeyListener(oyun);
        oyun.setFocusable(true);
        oyun.setFocusTraversalKeysEnabled(false);

        JLabel skor = new JLabel("Oyuncu Skoru " + oyun.getPuan());

        ActionListener l1 = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                skor.setText("Oyuncu Skoru: " + oyun.getPuan() + "");
                skor.setFont(new Font("Calibri", Font.BOLD, 25));
                ekran.add(skor, BorderLayout.EAST);
            }
        };
        Timer t1 = new Timer(10, l1);
        t1.start();

        Runnable altinOlusmasi = new Runnable() {
            public void run() {
                oyun.altinOlustur();
            }
        };
        ScheduledExecutorService zamanlayici1 = Executors.newScheduledThreadPool(1);
        zamanlayici1.scheduleAtFixedRate(altinOlusmasi, 0, 5, TimeUnit.SECONDS);

        Runnable mantarOlusmasi = new Runnable() {
            public void run() {
                oyun.mantarOlustur();
            }
        };
        ScheduledExecutorService zamanlayici2 = Executors.newScheduledThreadPool(1);
        zamanlayici2.scheduleAtFixedRate(mantarOlusmasi, 0, 7, TimeUnit.SECONDS);

        ekran.add(oyun);
        ekran.setLocationRelativeTo(null);
        ekran.setVisible(true);
    }

}
