public class HesapHareketi {
    private String islemTuru;
    private double tutar;
    private String tarih;

    public HesapHareketi(String islemTuru, double tutar, String tarih) {
        this.islemTuru = islemTuru;
        this.tutar = tutar;
        this.tarih = tarih;
    }

    public String getIslemTuru() {
        return islemTuru;
    }

    public double getTutar() {
        return tutar;
    }

    public String getTarih() {
        return tarih;
    }
}
