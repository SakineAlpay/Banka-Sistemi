import javax.swing.*;
import java.awt.*;

public class ArkaPlanPaneli extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image arkaPlanResmi = new ImageIcon("C:\\Users\\Lenovo\\Downloads\\kırmızı.jpg").getImage();
        g.drawImage(arkaPlanResmi, 0, 0, getWidth(), getHeight(), this);
    }
}