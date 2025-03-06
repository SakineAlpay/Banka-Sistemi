public interface BankaHesap {
   String getHesapAdi();
    String getIban();
    double getBakiye();
    String getBankaAdi();
    void bakiyeAzalt(double miktar);
    String getAd();
    void setBakiye(double bakiye);
    void bakiyeEkle(double miktar);
}
