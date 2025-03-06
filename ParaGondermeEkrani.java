import javax.swing.*;
import java.awt.*;

public class ParaGondermeEkrani {
    private Hesap hesap;
    private String iban;
    private String isim;

    public ParaGondermeEkrani(Hesap hesap, String iban, String isim) {
        this.hesap = hesap;
        this.iban = iban;
        this.isim = isim;
    }

    public void pencereOlustur() {
        JFrame paraGonderPencere = new JFrame("Para Gönderme");
        paraGonderPencere.setSize(400, 300);
        paraGonderPencere.setLocationRelativeTo(null);
        paraGonderPencere.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel aliciBilgiLabel = new JLabel("Alıcı: " + isim + " (" + iban + ")");
        aliciBilgiLabel.setBounds(20, 20, 350, 30);
        panel.add(aliciBilgiLabel);

        JLabel miktarLabel = new JLabel("Gönderilecek Tutar:");
        miktarLabel.setBounds(20, 70, 150, 30);
        panel.add(miktarLabel);

        JTextField miktarField = new JTextField();
        miktarField.setBounds(180, 70, 150, 30);
        panel.add(miktarField);

        JButton gonderButton = new JButton("Gönder");
        gonderButton.setBounds(50, 150, 300, 40);
        gonderButton.addActionListener(e -> {
            if (!iban.startsWith("TR") || iban.length() < 20) {
                JOptionPane.showMessageDialog(paraGonderPencere, "Geçersiz IBAN! IBAN 'TR' ile başlamalı ve 26 karakter uzunluğunda olmalıdır.", "Hata", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!Character.isUpperCase(isim.charAt(0))) {
                JOptionPane.showMessageDialog(paraGonderPencere, "Geçersiz İsim! İsim ve soyisim büyük harfle başlamalıdır.", "Hata", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String miktarStr = miktarField.getText();
            try {
                double miktar = Double.parseDouble(miktarStr);
                if (miktar <= 0) {
                    JOptionPane.showMessageDialog(paraGonderPencere, "Geçerli bir miktar giriniz!", "Hata", JOptionPane.ERROR_MESSAGE);
                } else if (miktar > hesap.getBakiye()) {
                    JOptionPane.showMessageDialog(paraGonderPencere, "Yetersiz bakiye!", "Hata", JOptionPane.ERROR_MESSAGE);
                } else {
                    hesap.setBakiye(hesap.getBakiye() - miktar);
                    paraGonderPencere.dispose(); // Para gönderme penceresini kapat
                    dekontGoster(miktar); // Dekont göster
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(paraGonderPencere, "Geçerli bir miktar giriniz!", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(gonderButton);

        paraGonderPencere.setContentPane(panel);
        paraGonderPencere.setVisible(true);
    }

    private void dekontGoster(double miktar) {
        JDialog dekontPencere = new JDialog();
        dekontPencere.setTitle("Dekont");
        dekontPencere.setSize(400, 300);
        dekontPencere.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel baslik = new JLabel("Gönderim Dekontu");
        baslik.setFont(new Font("Arial", Font.BOLD, 18));
        baslik.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel aliciBilgi = new JLabel("Alıcı: " + isim + " (" + iban + ")");
        aliciBilgi.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel gonderilenMiktar = new JLabel("Gönderilen Tutar: " + miktar + " TL");
        gonderilenMiktar.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel kalanBakiye = new JLabel("Kalan Bakiye: " + hesap.getBakiye() + " TL");
        kalanBakiye.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton kapatButton = new JButton("Kapat");
        kapatButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        kapatButton.addActionListener(e -> dekontPencere.dispose());

        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(baslik);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(aliciBilgi);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(gonderilenMiktar);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(kalanBakiye);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(kapatButton);

        dekontPencere.setContentPane(panel);
        dekontPencere.setVisible(true);
    }
}