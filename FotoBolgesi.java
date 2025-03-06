import javax.swing.*;
import java.awt.*;

public class FotoBolgesi extends JLabel {
    public FotoBolgesi() {
        setBounds(175, 190, 140, 140);
        setOpaque(true);
        setBackground(Color.LIGHT_GRAY);

        setFoto("C:\\Users\\Lenovo\\Downloads\\cocuk2.jpg");
    }

    public void setFoto(String dosyaYolu) {
        ImageIcon foto = new ImageIcon(dosyaYolu);
        setIcon(new ImageIcon(foto.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH)));
    }
}
