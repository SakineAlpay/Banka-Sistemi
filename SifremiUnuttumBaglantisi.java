import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class SifremiUnuttumBaglantisi extends JLabel {
    private final Map<String, String> kullaniciSifreHaritasi;

    public SifremiUnuttumBaglantisi(Map<String, String> kullaniciSifreHaritasi) {
        this.kullaniciSifreHaritasi = kullaniciSifreHaritasi;

        setText("<html><a style='color: white;' href=''>Şifremi Unuttum</a></html>");
        setBounds(200, 450, 150, 30); // Bağlantının konumu
        setForeground(Color.BLACK);
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                kullaniciAdiSor();
            }
        });
    }

    private void kullaniciAdiSor() {
        String kullaniciAdi = JOptionPane.showInputDialog(null, "Kullanıcı Adınızı Girin:", "Şifre Yenileme", JOptionPane.QUESTION_MESSAGE);

        if (kullaniciAdi != null && !kullaniciAdi.trim().isEmpty()) {
            if (kullaniciSifreHaritasi.containsKey(kullaniciAdi)) {
                yeniSifreOlustur(kullaniciAdi);
            } else {
                JOptionPane.showMessageDialog(null, "Bu kullanıcı adı bulunamadı!", "Hata", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Kullanıcı adı girmelisiniz!", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void yeniSifreOlustur(String kullaniciAdi) {
        String yeniSifre = JOptionPane.showInputDialog(null, "Yeni Şifrenizi Girin:", "Şifre Yenileme", JOptionPane.QUESTION_MESSAGE);

        if (yeniSifre != null && !yeniSifre.trim().isEmpty()) {
            kullaniciSifreHaritasi.put(kullaniciAdi, yeniSifre);
            JOptionPane.showMessageDialog(null, "Şifreniz başarıyla oluşturuldu!", "Başarılı", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Şifre girmelisiniz!", "Hata", JOptionPane.ERROR_MESSAGE);
        }
    }
}
