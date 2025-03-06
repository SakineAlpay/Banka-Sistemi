import javax.swing.*;
import java.awt.*;

public class BankaBilgileri extends JPanel {

    private JLabel bankaIsmi;
    private JLabel hosGeldinizMesaji;
    private JLabel kullaniciAdi;

    public BankaBilgileri() {
        setLayout(null);

        bankaIsmi = new JLabel("ALBANK ", SwingConstants.CENTER);
        bankaIsmi.setFont(new Font("Arial", Font.BOLD, 24));
        bankaIsmi.setForeground(Color.black);
        bankaIsmi.setBounds(0, 20, 500, 30);

        hosGeldinizMesaji = new JLabel("Albank'a Hoş Geldiniz!", SwingConstants.CENTER);
        hosGeldinizMesaji.setFont(new Font("Arial", Font.BOLD, 20));
        hosGeldinizMesaji.setForeground(Color.BLACK);
        hosGeldinizMesaji.setBounds(0, 60, 500, 30);

        kullaniciAdi = new JLabel("Sakine Alpay", SwingConstants.CENTER);
        kullaniciAdi.setFont(new Font("Arial", Font.BOLD, 18));
        kullaniciAdi.setForeground(Color.BLACK);
        kullaniciAdi.setBounds(0, 100, 500, 30);

        this.add(bankaIsmi);
        this.add(hosGeldinizMesaji);
        this.add(kullaniciAdi);
    }
}
