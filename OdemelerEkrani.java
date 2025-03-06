import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class OdemelerEkrani {

    private double bakiye = 1000.0; // Genel bakiye
    private final Map<String, String> faturaKodlari = new HashMap<>();

    public OdemelerEkrani() {
        faturaKodlari.put("Su Faturası", "SU123");
        faturaKodlari.put("Elektrik Faturası", "ELK456");
        faturaKodlari.put("Doğalgaz Faturası", "DOG789");
        faturaKodlari.put("Telefon Faturası", "TEL012");
    }

    public void pencereOlustur() {
        JFrame odemePencere = new JFrame("Ödemeler");
        odemePencere.setSize(400, 350);
        odemePencere.setLocationRelativeTo(null);

        JPanel arkaPlanPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, new Color(85, 153, 255), 0, getHeight(), new Color(0, 102, 204));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        arkaPlanPanel.setLayout(new GridLayout(4, 1, 15, 15));
        arkaPlanPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        for (String fatura : faturaKodlari.keySet()) {
            JButton faturaButon = new JButton(fatura);
            faturaButon.setFont(new Font("SansSerif", Font.BOLD, 16));
            faturaButon.setForeground(Color.WHITE);
            faturaButon.setFocusPainted(false);
            faturaButon.setBackground(new Color(0, 153, 255));
            faturaButon.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
            faturaButon.setCursor(new Cursor(Cursor.HAND_CURSOR));

            faturaButon.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    faturaButon.setBackground(new Color(0, 102, 204));
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    faturaButon.setBackground(new Color(0, 153, 255));
                }
            });

            faturaButon.addActionListener(e -> faturaOdemeEkrani(fatura));

            arkaPlanPanel.add(faturaButon);
        }

        odemePencere.setContentPane(arkaPlanPanel);
        odemePencere.setVisible(true);
    }

    private void faturaOdemeEkrani(String faturaTuru) {
        JFrame faturaPencere = new JFrame(faturaTuru + " Ödeme");
        faturaPencere.setSize(350, 300);
        faturaPencere.setLocationRelativeTo(null);

        JPanel faturaPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, new Color(255, 153, 102), 0, getHeight(), new Color(255, 94, 77));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        faturaPanel.setLayout(new GridLayout(5, 1, 10, 10));
        faturaPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel kodLabel = new JLabel("Fatura Kodunu Giriniz:");
        kodLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        kodLabel.setForeground(Color.WHITE);

        JTextField kodField = new JTextField();
        kodField.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JLabel miktarLabel = new JLabel("Ödenecek Tutarı Giriniz:");
        miktarLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        miktarLabel.setForeground(Color.WHITE);

        JTextField miktarField = new JTextField();
        miktarField.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JButton odemeButon = new JButton("Ödeme Yap");
        odemeButon.setFont(new Font("SansSerif", Font.BOLD, 16));
        odemeButon.setForeground(Color.WHITE);
        odemeButon.setBackground(new Color(255, 94, 77));
        odemeButon.setCursor(new Cursor(Cursor.HAND_CURSOR));

        odemeButon.addActionListener(e -> {
            String girilenKod = kodField.getText();
            String dogruKod = faturaKodlari.get(faturaTuru);

            try {
                double miktar = Double.parseDouble(miktarField.getText());
                if (!girilenKod.equals(dogruKod)) {
                    JOptionPane.showMessageDialog(faturaPencere, "Hatalı fatura kodu!", "Hata", JOptionPane.ERROR_MESSAGE);
                } else if (miktar <= 0) {
                    JOptionPane.showMessageDialog(faturaPencere, "Geçerli bir miktar giriniz!", "Hata", JOptionPane.ERROR_MESSAGE);
                } else if (miktar > bakiye) {
                    JOptionPane.showMessageDialog(faturaPencere, "Yetersiz bakiye!", "Hata", JOptionPane.ERROR_MESSAGE);
                } else {
                    bakiye -= miktar;
                    JOptionPane.showMessageDialog(faturaPencere, "Ödeme Başarılı! Kalan Bakiye: " + bakiye, "Başarılı", JOptionPane.INFORMATION_MESSAGE);
                    faturaPencere.dispose();
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(faturaPencere, "Lütfen geçerli bir sayı giriniz!", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        });

        faturaPanel.add(kodLabel);
        faturaPanel.add(kodField);
        faturaPanel.add(miktarLabel);
        faturaPanel.add(miktarField);
        faturaPanel.add(odemeButon);

        faturaPencere.setContentPane(faturaPanel);
        faturaPencere.setVisible(true);
    }
}
