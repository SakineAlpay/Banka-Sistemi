import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Hesap implements BankaHesap {
    public String hesapAdi;
    public String iban;
    public double bakiye;
    private String bankaAdi;
    private String ad;
    private List<HesapHareketi> hesapHareketleri;

    public Hesap(String hesapAdi, String iban, double bakiye) {
        this.hesapAdi = hesapAdi;
        this.iban = iban;
        this.bakiye = bakiye;
        this.hesapHareketleri = new ArrayList<>();
    }

    public Hesap() {

    }

    public String getHesapAdi() {
        return hesapAdi;
    }

    public String getIban() {
        return iban;
    }

    public double getBakiye() {
        return bakiye;
    }

    public String getBankaAdi() {
        return bankaAdi;
    }

    public void setBakiye(double bakiye) {
        this.bakiye = bakiye;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public void bakiyeAzalt(double miktar) {
        if (miktar > 0 && miktar <= bakiye) {
            bakiye -= miktar;
        } else {
            System.out.println("Yetersiz bakiye veya geçersiz miktar!");
        }
    }

    public void bakiyeEkle(double miktar) {
        this.bakiye += miktar;
    }

    public void islemEkle(String islemTuru, double tutar, String tarih) {
        HesapHareketi yeniIslem = new HesapHareketi(islemTuru, tutar, tarih);
        hesapHareketleri.add(yeniIslem);
    }

    public List<HesapHareketi> getHesapHareketleri() {
        return hesapHareketleri;
    }

    public void hesapBilgileriniYazdir() {
        JFrame hesapBilgileriPenceresi = new JFrame("Hesap Bilgileri");
        hesapBilgileriPenceresi.setSize(400, 300);
        hesapBilgileriPenceresi.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel bankaAdiLabel = new JLabel("Banka Adı: " + bankaAdi);
        JLabel ibanLabel = new JLabel("IBAN: " + iban);
        JLabel bakiyeLabel = new JLabel("Bakiye: " + bakiye);

        panel.add(bankaAdiLabel);
        panel.add(ibanLabel);
        panel.add(bakiyeLabel);

        hesapBilgileriPenceresi.add(panel);
        hesapBilgileriPenceresi.setVisible(true);
    }}
