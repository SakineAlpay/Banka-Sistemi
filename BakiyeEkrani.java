import javax.swing.*;
import java.awt.*;

public class BakiyeEkrani {

    private Image arkaPlanResmi;

    public BakiyeEkrani() {
        try {
            arkaPlanResmi = javax.imageio.ImageIO.read(new java.io.File("C:\\Users\\Lenovo\\Downloads\\gri.jpg"));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    public void pencereOlustur(Hesap hesap) {
        JFrame bakiyePencere = new JFrame("Hesap Bilgisi");
        bakiyePencere.setSize(500, 600);
        bakiyePencere.setLocationRelativeTo(null);
        bakiyePencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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


        JLabel hesapAdiLabel = new JLabel(hesap.getHesapAdi(), SwingConstants.CENTER);
        hesapAdiLabel.setFont(new Font("Arial", Font.BOLD, 20));
        hesapAdiLabel.setBounds(20, 50, 460, 30);
        panel.add(hesapAdiLabel);


        JLabel ibanLabel = new JLabel("IBAN: " + hesap.getIban(), SwingConstants.CENTER);
        ibanLabel.setFont(new Font("Arial",Font.BOLD,18));
        ibanLabel.setBounds(20, 100, 460, 30);
        panel.add(ibanLabel);


        JLabel bakiyeLabel = new JLabel("Bakiye: " + hesap.getBakiye(), SwingConstants.CENTER);
        bakiyeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        bakiyeLabel.setBounds(20, 150, 460, 30);
        panel.add(bakiyeLabel);

        JButton paraTransferiButton = new JButton("Para Transferi");
        paraTransferiButton.setBounds(50, 250, 400, 50);
        paraTransferiButton.setBackground(new Color(204, 0, 0));
        paraTransferiButton.setForeground(Color.WHITE);
        panel.add(paraTransferiButton);

        paraTransferiButton.addActionListener(e -> {
            ParaTransferiEkrani paraTransferiEkrani = new ParaTransferiEkrani(hesap);
            paraTransferiEkrani.pencereOlustur(); // Yeni pencereyi aç
        });

        JButton hesapHareketleriButton = new JButton("Hesap Hareketleri");
        hesapHareketleriButton.setBounds(50, 310, 400, 50);
        hesapHareketleriButton.setBackground(new Color(204, 0, 0));
        hesapHareketleriButton.setForeground(Color.WHITE);
        panel.add(hesapHareketleriButton);

        hesapHareketleriButton.addActionListener(e -> {
            HesapHareketleriEkrani hareketlerEkrani = new HesapHareketleriEkrani();
            hareketlerEkrani.pencereOlustur(hesap);
        });

        JButton menuButton = new JButton("Menü");
        menuButton.setBounds(50, 370, 400, 50);
        menuButton.setBackground(new Color(204, 0, 0));
        menuButton.setForeground(Color.WHITE);
        panel.add(menuButton);

        menuButton.addActionListener(e -> {
            new MenuEkrani();
        });

        JButton cikisButton = new JButton("Çıkış");
        cikisButton.setBounds(50, 430, 400, 50);
        cikisButton.setBackground(new Color(204, 0, 0));
        cikisButton.setForeground(Color.WHITE);
        cikisButton.addActionListener(e -> System.exit(0));
        panel.add(cikisButton);

        bakiyePencere.setContentPane(panel);
        bakiyePencere.setVisible(true);
    }

    public void goster() {
    }
}
