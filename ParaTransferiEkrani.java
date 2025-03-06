import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ParaTransferiEkrani {
    private Hesap hesap; // Hesap türü değişti
    private Image arkaPlanResmi;

    public ParaTransferiEkrani(Hesap hesap) {
        this.hesap = hesap;

        try {
            arkaPlanResmi = ImageIO.read(new File("C:\\Users\\Lenovo\\Downloads\\duvar2.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void pencereOlustur() {
        JFrame paraTransferiPencere = new JFrame("Para Transferi");
        paraTransferiPencere.setSize(500, 600);
        paraTransferiPencere.setLocationRelativeTo(null);
        paraTransferiPencere.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);

                if (arkaPlanResmi != null) {
                    g.drawImage(arkaPlanResmi, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        panel.setLayout(null);

        JLabel baslikLabel = new JLabel("Para Transferi", SwingConstants.CENTER);
        baslikLabel.setFont(new Font("Arial", Font.BOLD, 24));
        baslikLabel.setBounds(20, 30, 460, 40);
        baslikLabel.setForeground(Color.BLACK);
        panel.add(baslikLabel);

        JButton kayitliKullanicilarButton = new JButton("Kayıtlı Kullanıcılar");
        kayitliKullanicilarButton.setBounds(50, 100, 400, 50);
        kayitliKullanicilarButton.setBackground(new Color(0, 153, 76));
        kayitliKullanicilarButton.setForeground(Color.WHITE);
        kayitliKullanicilarButton.setFont(new Font("Arial", Font.PLAIN, 18));
        kayitliKullanicilarButton.addActionListener(e -> {
            KayitliKullanicilarEkrani kayitliKullanicilarEkrani = new KayitliKullanicilarEkrani(hesap);
            kayitliKullanicilarEkrani.pencereOlustur();
        });
        panel.add(kayitliKullanicilarButton);

        JButton yeniAliciButton = new JButton("Yeni Alıcı");
        yeniAliciButton.setBounds(50, 200, 400, 50);
        yeniAliciButton.setBackground(new Color(0, 102, 204));
        yeniAliciButton.setForeground(Color.WHITE);
        yeniAliciButton.setFont(new Font("Arial", Font.PLAIN, 18));
        yeniAliciButton.addActionListener(e -> {
            YeniAliciEkrani yeniAliciEkrani = new YeniAliciEkrani(hesap);
            yeniAliciEkrani.pencereOlustur();
        });
        panel.add(yeniAliciButton);

        JButton geriDonButton = new JButton("Geri Dön");
        geriDonButton.setBounds(50, 400, 400, 50);
        geriDonButton.setBackground(new Color(204, 0, 0));
        geriDonButton.setForeground(Color.WHITE);
        geriDonButton.setFont(new Font("Arial", Font.PLAIN, 18));
        geriDonButton.addActionListener(e -> {
            paraTransferiPencere.setVisible(false);
            BakiyeEkrani bakiyeEkrani = new BakiyeEkrani();
            bakiyeEkrani.pencereOlustur(hesap);
        });
        panel.add(geriDonButton);

        paraTransferiPencere.setContentPane(panel);
        paraTransferiPencere.setVisible(true);
    }
}
