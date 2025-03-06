import javax.swing.*;
import java.awt.*;

public class QRIslemleriEkrani {

    public void pencereOlustur() {

        JFrame qrPencere = new JFrame("QR İşlemleri");
        qrPencere.setSize(400, 300);
        qrPencere.setLocationRelativeTo(null);

        JPanel qrPanel = new JPanel();
        qrPanel.setLayout(new GridLayout(2, 1, 10, 10)); // 2x1 düzen

        JButton qrPaylasButon = new JButton("QR Paylaş");
        qrPaylasButon.addActionListener(e -> qrPaylasEkrani()); // QR Paylaş ekranını aç

        JButton qrTaraButon = new JButton("QR Tara");
        qrTaraButon.addActionListener(e -> qrTaraEkrani()); // QR Tara ekranını aç

        qrPanel.add(qrPaylasButon);
        qrPanel.add(qrTaraButon);

        qrPencere.setContentPane(qrPanel);
        qrPencere.setVisible(true);
    }

    private void qrPaylasEkrani() {
        JFrame paylasPencere = new JFrame("QR Paylaş");
        paylasPencere.setSize(300, 300);
        paylasPencere.setLocationRelativeTo(null);

        JPanel paylasPanel = new JPanel();
        paylasPanel.setLayout(new BorderLayout());

        JLabel qrGorsel = new JLabel();
        qrGorsel.setHorizontalAlignment(SwingConstants.CENTER);
        qrGorsel.setIcon(new ImageIcon("C:\\Users\\Lenovo\\Downloads\\qr-code (1).png")); // Örnek QR kod dosya yolu

        paylasPanel.add(qrGorsel, BorderLayout.CENTER);

        paylasPencere.setContentPane(paylasPanel);
        paylasPencere.setVisible(true);
    }

    private void qrTaraEkrani() {
        JFrame taraPencere = new JFrame("QR Tara");
        taraPencere.setSize(300, 300);
        taraPencere.setLocationRelativeTo(null);

        JPanel taraPanel = new JPanel();
        taraPanel.setLayout(new BorderLayout());

        JLabel kameraGorsel = new JLabel("QR KODUNU ORTALAYIN");
        kameraGorsel.setHorizontalAlignment(SwingConstants.CENTER);
        kameraGorsel.setFont(new Font("Arial", Font.BOLD, 16));
        kameraGorsel.setForeground(Color.GRAY);

        JPanel kameraCerceve = new JPanel();
        kameraCerceve.setBackground(Color.BLACK);
        kameraCerceve.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
        kameraCerceve.setLayout(new BorderLayout());
        kameraCerceve.add(kameraGorsel, BorderLayout.CENTER);

        taraPanel.add(kameraCerceve, BorderLayout.CENTER);

        taraPencere.setContentPane(taraPanel);
        taraPencere.setVisible(true);
    }
}
