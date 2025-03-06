import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class DovizVeAltinEkrani {

    private final Map<String, Double> fiyatlar = new HashMap<>(); // Döviz ve altın fiyatları

    public DovizVeAltinEkrani() {
        fiyatlar.put("Dolar", 27.45);
        fiyatlar.put("Euro", 29.15);
        fiyatlar.put("Gram Altın", 1710.50);
        fiyatlar.put("Çeyrek Altın", 2750.75);
    }

    public void pencereOlustur() {
        JFrame dovizAltinPencere = new JFrame("Döviz ve Altın İşlemleri");
        dovizAltinPencere.setSize(450, 400);
        dovizAltinPencere.setLocationRelativeTo(null);

        JPanel arkaPlanPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, new Color(255, 204, 153), 0, getHeight(), new Color(255, 153, 51));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        arkaPlanPanel.setLayout(new GridLayout(4, 1, 15, 15));//4 satır bir sütun oluşturur ve 15 piksel yatay ve dikey boşluk bırakır
        arkaPlanPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));//panelin etrafına boş sınırlar ekler

        for (String tur : fiyatlar.keySet()) {
            JPanel itemPanel = new JPanel();
            itemPanel.setLayout(new GridLayout(1, 3, 10, 10));
            itemPanel.setBackground(new Color(255, 255, 255, 200));
            itemPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JLabel turLabel = new JLabel(tur);
            turLabel.setFont(new Font("SansSerif", Font.BOLD, 16));

            JLabel fiyatLabel = new JLabel("Fiyat: " + fiyatlar.get(tur) + " TL");
            fiyatLabel.setFont(new Font("SansSerif", Font.PLAIN, 14));

            JButton islemlerButon = new JButton("İşlem Yap");
            islemlerButon.setFont(new Font("SansSerif", Font.BOLD, 14));
            islemlerButon.setBackground(new Color(255, 153, 51));
            islemlerButon.setForeground(Color.WHITE);
            islemlerButon.setCursor(new Cursor(Cursor.HAND_CURSOR));

            islemlerButon.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    islemlerButon.setBackground(new Color(204, 102, 0));
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    islemlerButon.setBackground(new Color(255, 153, 51));
                }
            });

            islemlerButon.addActionListener(e -> dovizAltinIslemEkrani(tur, fiyatlar.get(tur)));

            itemPanel.add(turLabel);
            itemPanel.add(fiyatLabel);
            itemPanel.add(islemlerButon);

            arkaPlanPanel.add(itemPanel);
        }

        dovizAltinPencere.setContentPane(arkaPlanPanel);
        dovizAltinPencere.setVisible(true);
    }

    private void dovizAltinIslemEkrani(String tur, double fiyat) {
        JFrame islemPencere = new JFrame(tur + " İşlemi");
        islemPencere.setSize(350, 250);
        islemPencere.setLocationRelativeTo(null);

        JPanel islemPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g;
                GradientPaint gradient = new GradientPaint(0, 0, new Color(204, 229, 255), 0, getHeight(), new Color(102, 178, 255));
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        islemPanel.setLayout(new GridLayout(4, 1, 10, 10));
        islemPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel miktarLabel = new JLabel("Miktar Giriniz:");
        miktarLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
        miktarLabel.setForeground(Color.DARK_GRAY);

        JTextField miktarField = new JTextField();
        miktarField.setFont(new Font("SansSerif", Font.PLAIN, 14));

        JButton hesaplaButon = new JButton("Hesapla");
        hesaplaButon.setFont(new Font("SansSerif", Font.BOLD, 14));
        hesaplaButon.setBackground(new Color(102, 178, 255));
        hesaplaButon.setForeground(Color.WHITE);
        hesaplaButon.setCursor(new Cursor(Cursor.HAND_CURSOR));

        hesaplaButon.addActionListener(e -> {
            try {
                double miktar = Double.parseDouble(miktarField.getText());
                if (miktar <= 0) {
                    JOptionPane.showMessageDialog(islemPencere, "Geçerli bir miktar giriniz!", "Hata", JOptionPane.ERROR_MESSAGE);
                } else {
                    double toplamTutar = miktar * fiyat;
                    JOptionPane.showMessageDialog(islemPencere, "Toplam Tutar: " + toplamTutar + " TL", "Hesaplama", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(islemPencere, "Lütfen geçerli bir sayı giriniz!", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        });

        islemPanel.add(miktarLabel);
        islemPanel.add(miktarField);
        islemPanel.add(hesaplaButon);

        islemPencere.setContentPane(islemPanel);
        islemPencere.setVisible(true);
    }


}
