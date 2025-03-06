import javax.swing.*;
import java.awt.*;

public class Kartlarim {

    public void pencereOlustur() {
        JFrame kartlarPencere = new JFrame("Kartlarım");
        kartlarPencere.setSize(500, 400);
        kartlarPencere.setLocationRelativeTo(null);
        kartlarPencere.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel kartlarPanel = new JPanel();
        kartlarPanel.setLayout(new GridLayout(3, 1, 10, 10)); // Dikey düzenleme
        kartlarPanel.setBackground(new Color(255, 255, 240)); // Açık sarı arka plan

        String[][] kartBilgileri = {
                {"VISA", "1234 5678 9012 3456", "Bakiye: 5,000 TL"},
                {"MasterCard", "9876 5432 1098 7654", "Bakiye: 3,250 TL"},
                {"AMEX", "1111 2222 3333 4444", "Bakiye: 10,000 TL"}
        };

        for (String[] kart : kartBilgileri) {
            JPanel kartPanel = new JPanel();
            kartPanel.setLayout(new BorderLayout());
            kartPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
            kartPanel.setBackground(Color.WHITE);

            JLabel kartTuru = new JLabel(kart[0], SwingConstants.CENTER);
            kartTuru.setFont(new Font("Arial", Font.BOLD, 18));
            kartTuru.setForeground(new Color(0, 102, 204));

            JLabel kartNumarasi = new JLabel(kart[1], SwingConstants.CENTER);
            kartNumarasi.setFont(new Font("Courier New", Font.PLAIN, 16));
            kartNumarasi.setForeground(Color.DARK_GRAY);

            JLabel kartBakiyesi = new JLabel(kart[2], SwingConstants.CENTER);
            kartBakiyesi.setFont(new Font("Arial", Font.PLAIN, 14));
            kartBakiyesi.setForeground(new Color(34, 139, 34)); // Yeşil renk

            kartPanel.add(kartTuru, BorderLayout.NORTH);
            kartPanel.add(kartNumarasi, BorderLayout.CENTER);
            kartPanel.add(kartBakiyesi, BorderLayout.SOUTH);

            kartlarPanel.add(kartPanel);
        }

        kartlarPencere.setContentPane(kartlarPanel);
        kartlarPencere.setVisible(true);
    }
}
