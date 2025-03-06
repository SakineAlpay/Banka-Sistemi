import javax.swing.*;
import java.awt.*;

public class MenuEkrani {

    public MenuEkrani() {
        JFrame menuPencere = new JFrame("Ana Menü");
        menuPencere.setSize(450, 600);
        menuPencere.setLocationRelativeTo(null);

        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(7, 1)); // Butonları dikey sıraya koyar
        menuPanel.setBackground(new Color(240, 240, 240)); // Panel arka planı için açık gri renk

        String[] menu = {"Hesaplarım", "Para Transferleri", "Kartlarım", "Ödemeler",
                "Döviz ve Altın", "QR İşlemleri", "Çıkış"};

        String[] ikonlar= {
                "C:\\Users\\Lenovo\\Downloads\\briefcase.png",
                "C:\\Users\\Lenovo\\Downloads\\flow.png",
                "C:\\Users\\Lenovo\\Downloads\\credit-card (1).png",
                "C:\\Users\\Lenovo\\Downloads\\pay.png",
                "C:\\Users\\Lenovo\\Downloads\\money.png",
                "C:\\Users\\Lenovo\\Downloads\\qr-code.png",
                "C:\\Users\\Lenovo\\Downloads\\power-off.png"
        };

        for (int i = 0; i < menu.length; i++) {
            String item = menu[i];
            String ikon = ikonlar[i];



            JButton itemButton = new JButton(item) {
                @Override
                protected void paintComponent(Graphics g) {
                    if (getModel().isPressed()) {
                        g.setColor(new Color(150, 150, 150)); // Butona basıldığında koyu gri
                        g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10); // Köşeleri yuvarlatma
                    } else {
                        Graphics2D g2d = (Graphics2D) g;
                        GradientPaint gradient = new GradientPaint(0, 0, new Color(200, 200, 200), 0, getHeight(), new Color(100, 100, 100));
                        g2d.setPaint(gradient); // Üstten alta gri geçiş
                        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10); // Köşeleri yuvarlatma
                    }
                    super.paintComponent(g);
                }
            };

            ImageIcon icon = new ImageIcon(ikon);
            itemButton.setIcon(icon);


            if (item.equals("Hesaplarım")) {
                itemButton.addActionListener(e -> new Hesaplarim().pencereOlustur());
            }

            if (item.equals("Para Transferleri")) {
                itemButton.addActionListener(e -> {
                    Hesap hesap = new Hesap() {

                        @Override
                        public void hesapBilgileriniYazdir() {

                        }
                    };
                    ParaTransferiEkrani paraTransferiEkrani = new ParaTransferiEkrani(hesap);
                    paraTransferiEkrani.pencereOlustur();
                });
            }

            if (item.equals("Ödemeler")) {
                itemButton.addActionListener(e -> {
                    OdemelerEkrani odemelerEkrani = new OdemelerEkrani();
                    odemelerEkrani.pencereOlustur();
                });
            }

            if (item.equals("Kartlarım")) {
                itemButton.addActionListener(e -> {
                    Kartlarim kartlarim = new Kartlarim();
                    kartlarim.pencereOlustur();
                });
            }

            if (item.equals("Döviz ve Altın")) {
                itemButton.addActionListener(e -> {
                    DovizVeAltinEkrani dovizVeAltinEkrani = new DovizVeAltinEkrani();
                    dovizVeAltinEkrani.pencereOlustur();
                });
            }

            if (item.equals("QR İşlemleri")) {
                itemButton.addActionListener(e -> {
                    QRIslemleriEkrani qrIslemleriEkrani = new QRIslemleriEkrani();
                    qrIslemleriEkrani.pencereOlustur();
                });
            }


            if (item.equals("Çıkış")) {
                itemButton.addActionListener(e -> System.exit(0));
            }

            menuPanel.add(itemButton);
        }

        menuPencere.setContentPane(menuPanel);
        menuPencere.setVisible(true);
    }
}
