import javax.swing.*;
import java.awt.*;

public class YeniAliciEkrani {
    private Hesap hesap;

    public YeniAliciEkrani(Hesap hesap) {
        this.hesap = hesap;
    }

    public void pencereOlustur() {
        JFrame yeniAliciPencere = new JFrame("Yeni Alıcı");
        yeniAliciPencere.setSize(400, 300);
        yeniAliciPencere.setLocationRelativeTo(null);
        yeniAliciPencere.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel ibanLabel = new JLabel("IBAN:");
        ibanLabel.setBounds(20, 20, 100, 30);
        panel.add(ibanLabel);

        JTextField ibanField = new JTextField();
        ibanField.setBounds(150, 20, 200, 30);
        panel.add(ibanField);

        JLabel isimLabel = new JLabel("Ad Soyad:");
        isimLabel.setBounds(20, 70, 100, 30);
        panel.add(isimLabel);

        JTextField isimField = new JTextField();
        isimField.setBounds(150, 70, 200, 30);
        panel.add(isimField);

        JButton devamButton = new JButton("Devam");
        devamButton.setBounds(50, 150, 300, 40);
        devamButton.addActionListener(e -> {
            String iban = ibanField.getText();
            String isim = isimField.getText();

            if (iban.isEmpty() || isim.isEmpty()) {
                JOptionPane.showMessageDialog(yeniAliciPencere, "Tüm alanları doldurunuz!", "Hata", JOptionPane.ERROR_MESSAGE);
            } else {
                yeniAliciPencere.dispose(); // Bu pencereyi kapat
                ParaGondermeEkrani paraGondermeEkrani = new ParaGondermeEkrani(hesap, iban, isim);
                paraGondermeEkrani.pencereOlustur();
            }
        });
        panel.add(devamButton);

        yeniAliciPencere.setContentPane(panel);
        yeniAliciPencere.setVisible(true);
    }
}
