import javax.swing.*;
import java.awt.*;

public class Hesaplarim {

    public void pencereOlustur() {
        JFrame hesaplarPencere = new JFrame("Hesaplarım");
        hesaplarPencere.setSize(400, 300);
        hesaplarPencere.setLocationRelativeTo(null);

        JPanel hesaplarPanel = new JPanel();
        hesaplarPanel.setLayout(new GridLayout(3, 1, 10, 10));
        hesaplarPanel.setBackground(new Color(240, 255, 240));

        JButton birinonuButton = new JButton("İnönü Hesabı");
        birinonuButton.setFont(new Font("Arial", Font.PLAIN, 18));
        birinonuButton.setBackground(new Color(173, 216, 230));
        birinonuButton.setForeground(Color.BLACK);
        birinonuButton.addActionListener(e -> {
            hesaplarPencere.dispose();
            İnonuHesabiEkrani();
        });

        JButton darendeButton = new JButton("Darende Hesabı");
        darendeButton.setFont(new Font("Arial", Font.PLAIN, 18));
        darendeButton.setBackground(new Color(152, 251, 152));
        darendeButton.setForeground(Color.BLACK);
        darendeButton.addActionListener(e -> {
            hesaplarPencere.dispose();
            darendeHesabiEkrani();
        });

        JButton kapatButton = new JButton("Kapat");
        kapatButton.setFont(new Font("Arial", Font.PLAIN, 18));
        kapatButton.setBackground(new Color(240, 128, 128)); // Açık kırmızı
        kapatButton.setForeground(Color.WHITE); // Yazı rengi
        kapatButton.addActionListener(e -> hesaplarPencere.dispose());

        hesaplarPanel.add(birinonuButton);
        hesaplarPanel.add(darendeButton);
        hesaplarPanel.add(kapatButton);

        hesaplarPencere.setContentPane(hesaplarPanel);
        hesaplarPencere.setVisible(true);
    }

    private void İnonuHesabiEkrani() {
        JFrame birinonuPencere = new JFrame("İnönü Hesabı");
        birinonuPencere.setSize(400, 300);
        birinonuPencere.setLocationRelativeTo(null);

        JPanel birinonuPanel = new JPanel();
        birinonuPanel.setLayout(new BoxLayout(birinonuPanel, BoxLayout.Y_AXIS)); // Dikey düzen
        birinonuPanel.setBackground(new Color(245, 255, 250)); // Açık yeşil arka plan

        JLabel baslikLabel = new JLabel("İnönü Hesabına Hoş Geldiniz!");
        baslikLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Yazı tipi
        baslikLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Ortaya hizalama
        baslikLabel.setForeground(new Color(34, 139, 34)); // Yeşil renk
        birinonuPanel.add(baslikLabel);
        birinonuPanel.add(Box.createVerticalStrut(20)); // Başlık ile diğer içerik arasına boşluk ekle

        String iban = "TR12 0000 1111 2222 3333 44";
        JLabel ibanLabel = new JLabel("IBAN: " + iban);
        ibanLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Yazı tipi
        ibanLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Ortaya hizalama
        ibanLabel.setForeground(new Color(70, 130, 180)); // Mavi-yeşil tonları
        birinonuPanel.add(ibanLabel);
        birinonuPanel.add(Box.createVerticalStrut(10)); // IBAN ile bakiye arasında boşluk

        double bakiye = 8500.50;
        JLabel bakiyeLabel = new JLabel("Bakiye: " + bakiye + " TL");
        bakiyeLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Yazı tipi
        bakiyeLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Ortaya hizalama
        bakiyeLabel.setForeground(new Color(34, 139, 34)); // Yeşil renk
        birinonuPanel.add(bakiyeLabel);
        birinonuPanel.add(Box.createVerticalStrut(20)); // Bakiye ile alt kısımlar arasında boşluk

        JButton kapatButton = new JButton("Kapat");
        kapatButton.setFont(new Font("Arial", Font.PLAIN, 16));
        kapatButton.setBackground(new Color(240, 128, 128)); // Açık kırmızı
        kapatButton.setForeground(Color.WHITE); // Yazı rengi
        kapatButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Ortaya hizalama
        kapatButton.addActionListener(e -> birinonuPencere.dispose()); // Pencereyi kapatma
        birinonuPanel.add(kapatButton);

        birinonuPencere.setContentPane(birinonuPanel);
        birinonuPencere.setVisible(true);
    }


    private void darendeHesabiEkrani() {
        JFrame darendePencere = new JFrame("Darende Hesabı");
        darendePencere.setSize(400, 300);
        darendePencere.setLocationRelativeTo(null);

        JPanel darendePanel = new JPanel();
        darendePanel.setLayout(new BoxLayout(darendePanel, BoxLayout.Y_AXIS)); // Dikey düzen
        darendePanel.setBackground(new Color(245, 255, 250)); // Açık yeşil arka plan

        JLabel baslikLabel = new JLabel("Darende Hesabına Hoş Geldiniz!");
        baslikLabel.setFont(new Font("Arial", Font.BOLD, 20)); // Yazı tipi
        baslikLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Ortaya hizalama
        baslikLabel.setForeground(new Color(34, 139, 34)); // Yeşil renk
        darendePanel.add(baslikLabel);
        darendePanel.add(Box.createVerticalStrut(20)); // Başlık ile diğer içerik arasına boşluk ekle

        String iban = "TR56 1111 2222 3333 4444 55";
        JLabel ibanLabel = new JLabel("IBAN: " + iban);
        ibanLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Yazı tipi
        ibanLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Ortaya hizalama
        ibanLabel.setForeground(new Color(70, 130, 180)); // Mavi-yeşil tonları
        darendePanel.add(ibanLabel);
        darendePanel.add(Box.createVerticalStrut(10)); // IBAN ile bakiye arasında boşluk

        double bakiye = 12500.75;
        JLabel bakiyeLabel = new JLabel("Bakiye: " + bakiye + " TL");
        bakiyeLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Yazı tipi
        bakiyeLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Ortaya hizalama
        bakiyeLabel.setForeground(new Color(34, 139, 34)); // Yeşil renk
        darendePanel.add(bakiyeLabel);
        darendePanel.add(Box.createVerticalStrut(20)); // Bakiye ile alt kısımlar arasında boşluk

        JButton kapatButton = new JButton("Kapat");
        kapatButton.setFont(new Font("Arial", Font.PLAIN, 16));
        kapatButton.setBackground(new Color(240, 128, 128)); // Açık kırmızı
        kapatButton.setForeground(Color.WHITE); // Yazı rengi
        kapatButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Ortaya hizalama
        kapatButton.addActionListener(e -> darendePencere.dispose()); // Pencereyi kapatma
        darendePanel.add(kapatButton);

        darendePencere.setContentPane(darendePanel);
        darendePencere.setVisible(true);
    }

}
