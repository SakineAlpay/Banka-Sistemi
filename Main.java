import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {


            Map<String, String> kullaniciSifreHaritasi = new HashMap<>();
            kullaniciSifreHaritasi.put("user1", "password1");
            kullaniciSifreHaritasi.put("user2", "password2");

            JFrame bankaPencere = new JFrame("Banka Giriş");
            bankaPencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            bankaPencere.setSize(500, 600);
            bankaPencere.setLocationRelativeTo(null);

            ArkaPlanPaneli arkaPlanPaneli = new ArkaPlanPaneli();
            arkaPlanPaneli.setLayout(null);

            FotoBolgesi fotoBolgesi = new FotoBolgesi();
            arkaPlanPaneli.add(fotoBolgesi);

            FotoDegistirButton fotoDegistirButton = new FotoDegistirButton();
            arkaPlanPaneli.add(fotoDegistirButton);

            BankaBilgileri bankaBilgileri = new BankaBilgileri();
            bankaBilgileri.setBounds(0, 20, 500, 150);
            arkaPlanPaneli.add(bankaBilgileri);


            GirisYapButonu girisYapButonu = new GirisYapButonu(bankaPencere);
            arkaPlanPaneli.add(girisYapButonu);

            SifremiUnuttumBaglantisi sifremiUnuttumBaglantisi = new SifremiUnuttumBaglantisi(kullaniciSifreHaritasi);
            arkaPlanPaneli.add(sifremiUnuttumBaglantisi);

            Hesap gondericiHesap = new Hesap() {
                @Override
                public void hesapBilgileriniYazdir() {

                }
            };

            KayitliKullanicilarEkrani ekran = new KayitliKullanicilarEkrani(gondericiHesap);

            ekran.pencereOlustur();


            bankaPencere.setContentPane(arkaPlanPaneli);
            bankaPencere.setVisible(true);
        });
        new MenuEkrani();



    }
}
