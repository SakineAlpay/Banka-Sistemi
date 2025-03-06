import javax.swing.*;
import java.awt.*;

public class KayitliKullanicilarEkrani {
    private Hesap gondericiHesap;
    private Hesap hesap;

    public KayitliKullanicilarEkrani(Hesap hesap) {
        this.gondericiHesap = hesap;
    }

    public void pencereOlustur() {
        JFrame kayitliKullanicilarPencere = new JFrame("Kayıtlı Kullanıcılar");
        kayitliKullanicilarPencere.setSize(500, 600);
        kayitliKullanicilarPencere.setLocationRelativeTo(null);
        kayitliKullanicilarPencere.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel baslikLabel = new JLabel("Kayıtlı Kullanıcılar", SwingConstants.CENTER);
        baslikLabel.setFont(new Font("Arial", Font.BOLD, 20));
        baslikLabel.setBounds(20, 20, 460, 30);
        panel.add(baslikLabel);

        String[][] kullanicilar = {
                {"Ahmet Yılmaz", "Garanti Bankası", "TR12 0000 1111 2222 3333 44"},
                {"Ayşe Demir", "Ziraat Bankası", "TR56 1111 2222 3333 4444 55"},
                {"Mehmet Kaya", "Halkbank", "TR98 2222 3333 4444 5555 66"},
                {"Fatma Aksoy", "İş Bankası", "TR65 3333 4444 5555 6666 77"}
        };

        int yPosition = 80;
        for (String[] kullanici : kullanicilar) {
            JButton kullaniciButton = new JButton(kullanici[0] + " - " + kullanici[1]);
            kullaniciButton.setBounds(50, yPosition, 400, 50);
            kullaniciButton.addActionListener(e -> paraGonderimPenceresi(kullanici));
            panel.add(kullaniciButton);
            yPosition += 70;
        }

        JButton geriDonButton = new JButton("Geri Dön");
        geriDonButton.setBounds(50, 500, 400, 50);
        geriDonButton.addActionListener(e -> kayitliKullanicilarPencere.dispose());
        panel.add(geriDonButton);

        kayitliKullanicilarPencere.setContentPane(panel);
        kayitliKullanicilarPencere.setVisible(true);
    }

    private void paraGonderimPenceresi(String[] kullanici) {
        JFrame paraGonderimPencere = new JFrame("Para Gönderimi");
        paraGonderimPencere.setSize(400, 300);
        paraGonderimPencere.setLocationRelativeTo(null);
        paraGonderimPencere.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel aliciBilgiLabel = new JLabel("Alıcı: " + kullanici[0] + " (" + kullanici[1] + ")");
        aliciBilgiLabel.setBounds(20, 20, 360, 20);
        panel.add(aliciBilgiLabel);

        JLabel miktarLabel = new JLabel("Gönderilecek Tutar:");
        miktarLabel.setBounds(20, 60, 150, 20);
        panel.add(miktarLabel);

        JTextField miktarField = new JTextField();
        miktarField.setBounds(180, 60, 150, 20);
        panel.add(miktarField);

        JLabel aciklamaLabel = new JLabel("Açıklama:");
        aciklamaLabel.setBounds(20, 100, 150, 20);
        panel.add(aciklamaLabel);

        JTextField aciklamaField = new JTextField();
        aciklamaField.setBounds(180, 100, 150, 20);
        panel.add(aciklamaField);

        JButton gonderButton = new JButton("Gönder");
        gonderButton.setBounds(100, 180, 200, 30);
        gonderButton.addActionListener(e -> {
            try {
                if (gondericiHesap == null) {
                    JOptionPane.showMessageDialog(paraGonderimPencere, "Hesap bilgileri eksik!", "Hata", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                else {
                    System.out.println("Gönderici Hesap: " + gondericiHesap.getAd() + ", Bakiye: " + gondericiHesap.getBakiye());
                }

                double miktar = Double.parseDouble(miktarField.getText());
                String aciklama = aciklamaField.getText();
                String aliciBanka = kullanici[1];

                double kesinti = aliciBanka.equals(gondericiHesap.getBankaAdi()) ? 0 : miktar * 0.02;
                double toplamGonderim = miktar + kesinti;

                if (toplamGonderim > gondericiHesap.getBakiye()) {
                    JOptionPane.showMessageDialog(paraGonderimPencere, "Yetersiz bakiye!", "Hata", JOptionPane.ERROR_MESSAGE);
                } else {
                    gondericiHesap.bakiyeAzalt(toplamGonderim);
                    JOptionPane.showMessageDialog(paraGonderimPencere, "Para gönderimi başarılı!\nKesinti: " + kesinti + " TL\nAçıklama: " + aciklama);
                    paraGonderimPencere.dispose();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(paraGonderimPencere, "Lütfen geçerli bir miktar girin!", "Hata", JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(paraGonderimPencere, "Bir hata oluştu: " + ex.getMessage(), "Hata", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(gonderButton);

        paraGonderimPencere.setContentPane(panel);
        paraGonderimPencere.setVisible(true);
    }
}
