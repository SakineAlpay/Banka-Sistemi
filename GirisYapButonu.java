import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GirisYapButonu extends JButton {

    private Hesap hesap1 = new Hesap("İnönü Üniversitesi/Malatya Şubesi", "TR12 0000 1111 2222 3333 44", 8500.50) {
        @Override
        public void hesapBilgileriniYazdir() {

        }
    };
    private Hesap hesap2 = new Hesap("Darende Şubesi", "TR56 1111 2222 3333 4444 55", 12500.75) {
        @Override
        public void hesapBilgileriniYazdir() {

        }
    };

    private String sifre1 = "12345";
    private String sifre2 = "54321";

    public GirisYapButonu(JFrame bankaPencere) {
        setText("Giriş Yap");
        setBounds(165, 400, 160, 40);
        setBackground(Color.white);
        setForeground(Color.BLACK);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame sifrePencere = new JFrame("Şifre Girişi");
                sifrePencere.setSize(400, 300);
                sifrePencere.setLocationRelativeTo(bankaPencere);

                JPanel sifrePaneli = new JPanel();
                sifrePaneli.setLayout(null);
                sifrePaneli.setBackground(Color.DARK_GRAY);

                JLabel baslik = new JLabel("Sakine Alpay");
                baslik.setForeground(Color.WHITE);
                baslik.setFont(new Font("Arial", Font.BOLD, 20));
                baslik.setBounds(140, 20, 150, 30);
                sifrePaneli.add(baslik);

                JLabel sifreYazisi = new JLabel("Şifre Girin:");
                sifreYazisi.setForeground(Color.WHITE);
                sifreYazisi.setBounds(100, 70, 200, 30);
                sifrePaneli.add(sifreYazisi);

                JPasswordField sifreAlani = new JPasswordField();
                sifreAlani.setBounds(100, 100, 200, 30);
                sifreAlani.setBackground(Color.LIGHT_GRAY);
                sifreAlani.setForeground(Color.BLACK);
                sifrePaneli.add(sifreAlani);

                JButton sifreGonderButonu = new JButton("Giriş");
                sifreGonderButonu.setBounds(125, 150, 150, 30);
                sifreGonderButonu.setBackground(Color.white);
                sifreGonderButonu.setForeground(Color.BLACK);

                sifreGonderButonu.addActionListener(event -> {
                    String sifre = new String(sifreAlani.getPassword());
                    Hesap girilenHesap = null;

                    if (sifre.equals(sifre1)) {
                        girilenHesap = hesap1;
                    } else if (sifre.equals(sifre2)) {
                        girilenHesap = hesap2;
                    }

                    if (girilenHesap != null) {
                        BakiyeEkrani bakiyeEkrani = new BakiyeEkrani();
                        bakiyeEkrani.pencereOlustur(girilenHesap);
                        bakiyeEkrani.goster();

                        sifrePencere.dispose();
                        bankaPencere.dispose();
                    } else {
                        JOptionPane.showMessageDialog(sifrePencere, "Yanlış şifre! Tekrar deneyin.", "Hata", JOptionPane.ERROR_MESSAGE);
                    }
                });

                JButton sifreDegistirButonu = new JButton("Şifreyi Değiştir");
                sifreDegistirButonu.setBounds(125, 200, 150, 30);
                sifreDegistirButonu.setBackground(Color.white);
                sifreDegistirButonu.setForeground(Color.BLACK);

                sifreDegistirButonu.addActionListener(event -> {
                    String[] hesapSecenekleri = {"İnönü Üniversitesi/Malatya Şubesi", "Darende Şubesi"};
                    String secilenHesap = (String) JOptionPane.showInputDialog(
                            sifrePencere,
                            "Hangi hesabın şifresini değiştirmek istersiniz?",
                            "Hesap Seç",
                            JOptionPane.PLAIN_MESSAGE,
                            null,
                            hesapSecenekleri,
                            hesapSecenekleri[0]
                    );

                    if (secilenHesap != null) {
                        String yeniSifre = JOptionPane.showInputDialog(sifrePencere, "Yeni şifreyi girin:");

                        if (yeniSifre != null && !yeniSifre.isEmpty()) {
                            if (secilenHesap.equals("İnönü Üniversitesi/Malatya Şubesi")) {
                                sifre1 = yeniSifre;
                            } else if (secilenHesap.equals("Darende Şubesi")) {
                                sifre2 = yeniSifre;
                            }
                            JOptionPane.showMessageDialog(sifrePencere, "Şifre başarıyla değiştirildi.", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                });

                sifrePaneli.add(sifreGonderButonu);
                sifrePaneli.add(sifreDegistirButonu);

                sifrePencere.setContentPane(sifrePaneli);
                sifrePencere.setVisible(true);
            }
        });
    }
}
