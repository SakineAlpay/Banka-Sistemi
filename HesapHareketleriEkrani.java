import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HesapHareketleriEkrani {
    private Hesap hesap;
    private DefaultListModel<String> hareketlerModel;

    public HesapHareketleriEkrani(Hesap hesap) {
        this.hesap = hesap;
        this.hareketlerModel = new DefaultListModel<>();
    }

    public HesapHareketleriEkrani() {
        this.hareketlerModel = new DefaultListModel<>();
    }

    public void pencereOlustur(Hesap hesap) {
        JFrame hesapHareketleriPencere = new JFrame("Hesap Hareketleri");
        hesapHareketleriPencere.setSize(500, 600);
        hesapHareketleriPencere.setLocationRelativeTo(null);
        hesapHareketleriPencere.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Modern panel tasarımı
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(255, 255, 255));

        // Başlık
        JLabel baslikLabel = new JLabel("Hesap Hareketleri", SwingConstants.CENTER);
        baslikLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        baslikLabel.setForeground(new Color(0, 102, 204));
        baslikLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        panel.add(baslikLabel, BorderLayout.NORTH);

        // Hesap hareketlerini listele
        JList<String> hareketlerListesi = new JList<>(hareketlerModel);
        hareketlerListesi.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        hareketlerListesi.setBackground(new Color(240, 240, 255));
        hareketlerListesi.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        hareketlerListesi.setFixedCellHeight(60);
        hareketlerListesi.setForeground(new Color(50, 50, 50));

        hareketlerListesi.setCellRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                label.setOpaque(true);
                label.setFont(new Font("Segoe UI", Font.PLAIN, 16));
                label.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                if (isSelected) {
                    label.setBackground(new Color(0, 102, 204));
                    label.setForeground(Color.WHITE);
                } else {
                    label.setBackground(index % 2 == 0 ? new Color(245, 245, 245) : Color.WHITE);
                    label.setForeground(new Color(50, 50, 50));
                }
                return label;
            }
        });

        JScrollPane scrollPane = new JScrollPane(hareketlerListesi);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton kapatButton = new JButton("Kapat");
        kapatButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        kapatButton.setBackground(new Color(255, 85, 85));
        kapatButton.setForeground(Color.WHITE);
        kapatButton.setFocusPainted(false);
        kapatButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        kapatButton.setPreferredSize(new Dimension(200, 50));

        kapatButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                kapatButton.setBackground(new Color(255, 60, 60));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                kapatButton.setBackground(new Color(255, 85, 85));
            }
        });

        kapatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hesapHareketleriPencere.dispose();
            }
        });

        JButton hareketEkleButton = new JButton("Hareket Ekle");
        hareketEkleButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        hareketEkleButton.setBackground(new Color(85, 255, 85));
        hareketEkleButton.setForeground(Color.WHITE);
        hareketEkleButton.setFocusPainted(false);
        hareketEkleButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        hareketEkleButton.setPreferredSize(new Dimension(200, 50));

        hareketEkleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String yeniHareket = JOptionPane.showInputDialog(hesapHareketleriPencere, "Yeni hareketi giriniz:");
                if (yeniHareket != null && !yeniHareket.trim().isEmpty()) {
                    hareketlerModel.addElement(yeniHareket);
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(255, 255, 255));
        buttonPanel.add(hareketEkleButton);
        buttonPanel.add(kapatButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        hesapHareketleriPencere.setContentPane(panel);
        hesapHareketleriPencere.setVisible(true);

        hareketleriYukle();
    }

    private void hareketleriYukle() {
        hareketlerModel.addElement("01.12.2024 - Para Yatırma: 500 TL");
        hareketlerModel.addElement("03.12.2024 - Para Gönderme: 200 TL (Ali Veli)");
        hareketlerModel.addElement("05.12.2024 - Para Çekme: 150 TL");
        hareketlerModel.addElement("07.12.2024 - Para Yatırma: 300 TL");
    }
}
