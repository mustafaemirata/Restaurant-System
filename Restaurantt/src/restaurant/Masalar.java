package restaurant;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Masalar extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private static String isim;
    private Connection conn;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Masalar frame = new Masalar("z"); // Örnek kullanıcı adı "z"
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Masalar(String kullaniciadi) {
        isim = kullaniciadi;
        conn = createConnection(isim);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Masalar");
        setBounds(100, 100, 920, 565);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        


        JButton masa1 = new JButton("Masa 1");
        masa1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		acMasaDetay("masa"+"1", masa1);
       
        	}
        });
        masa1.setFont(new Font("Times New Roman", Font.BOLD, 14));
        masa1.setBounds(197, 46, 94, 80);
        contentPane.add(masa1);

        JButton masa2 = new JButton("Masa 2");
        masa2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		acMasaDetay("masa"+"2", masa2);
        	}
        });
        masa2.setFont(new Font("Times New Roman", Font.BOLD, 14));
        masa2.setBounds(348, 46, 94, 80);
        contentPane.add(masa2);

        JButton masa3 = new JButton("Masa 3");
        masa3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		acMasaDetay("masa"+"3", masa3);
        	}
        });
        masa3.setFont(new Font("Times New Roman", Font.BOLD, 14));
        masa3.setBounds(513, 46, 94, 80);
        contentPane.add(masa3);

        JButton masa4 = new JButton("Masa 4");
        masa4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		acMasaDetay("masa"+"4", masa4);
        	}
        });
        masa4.setFont(new Font("Times New Roman", Font.BOLD, 14));
        masa4.setBounds(197, 155, 94, 80);
        contentPane.add(masa4);

        JButton masa5 = new JButton("Masa 5");
        masa5.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		acMasaDetay("masa"+"1", masa5);
        	}
        });
        masa5.setFont(new Font("Times New Roman", Font.BOLD, 14));
        masa5.setBounds(348, 155, 94, 80);
        contentPane.add(masa5);

        JButton masa6 = new JButton("Masa 6");
        masa6.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		acMasaDetay("masa"+"6", masa6);
        	}
        });
        masa6.setFont(new Font("Times New Roman", Font.BOLD, 14));
        masa6.setBounds(513, 155, 94, 80);
        contentPane.add(masa6);

        JButton masa7 = new JButton("Masa 7");
        masa7.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		acMasaDetay("masa"+"7", masa7);
        	}
        });
        masa7.setFont(new Font("Times New Roman", Font.BOLD, 14));
        masa7.setBounds(197, 259, 94, 80);
        contentPane.add(masa7);

        JButton masa8 = new JButton("Masa 8");
        masa8.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		acMasaDetay("masa"+"8", masa8);
        	}
        });
        masa8.setFont(new Font("Times New Roman", Font.BOLD, 14));
        masa8.setBounds(348, 259, 94, 80);
        contentPane.add(masa8);

        JButton masa9 = new JButton("Masa 9");
        masa9.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		acMasaDetay("masa"+"9", masa9);
        	}
        });
        masa9.setFont(new Font("Times New Roman", Font.BOLD, 14));
        masa9.setBounds(513, 259, 94, 80);
        contentPane.add(masa9);

        JButton masa10 = new JButton("Masa 10");
        masa10.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		acMasaDetay("masa"+"10", masa10);
        	}
        });
        masa10.setFont(new Font("Times New Roman", Font.BOLD, 14));
        masa10.setBounds(197, 361, 94, 80);
        contentPane.add(masa10);

        JButton masa11 = new JButton("Masa 11");
        masa11.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		acMasaDetay("masa"+"11", masa11);
        	}
        });
        masa11.setFont(new Font("Times New Roman", Font.BOLD, 14));
        masa11.setBounds(348, 361, 94, 80);
        contentPane.add(masa11);

        JButton masa12 = new JButton("Masa 12");
        masa12.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		acMasaDetay("masa"+"12", masa12);
        	}
        });
        masa12.setFont(new Font("Times New Roman", Font.BOLD, 14));
        masa12.setBounds(513, 361, 94, 80);
        contentPane.add(masa12);

        // Masaların renklerini güncelle
        updateButtonColors(masa1, "MASA1");
        updateButtonColors(masa2, "MASA2");
        updateButtonColors(masa3, "MASA3");
        updateButtonColors(masa4, "MASA4");
        updateButtonColors(masa5, "MASA5");
        updateButtonColors(masa6, "MASA6");
        updateButtonColors(masa7, "MASA7");
        updateButtonColors(masa8, "MASA8");
        updateButtonColors(masa9, "MASA9");
        updateButtonColors(masa10, "MASA10");
        updateButtonColors(masa11, "MASA11");
        updateButtonColors(masa12, "MASA12");
    }
    

    private static Connection createConnection(String isim2) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/" + isim + "_restoran";
            String kullaniciAdi = "emir";
            String sifre = "0634";
            return DriverManager.getConnection(url, kullaniciAdi, sifre);
        } catch (Exception e) {
            System.out.println("Veritabanı bağlantısı başarısız: " + e.getMessage());
            return null;
        }
    }

    private void updateButtonColors(JButton button, String masaNo) {
        if (conn != null) {
            try {
                String query = "SELECT Doluluk FROM masalar WHERE MasaNo = ?";
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setString(1, masaNo);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    String doluluk = rs.getString("Doluluk");
                    if ("BOS".equalsIgnoreCase(doluluk)) {
                        button.setBackground(Color.GREEN);
                    } else if ("DOLU".equalsIgnoreCase(doluluk)) {
                        button.setBackground(Color.RED);
                    }
                }
                rs.close();
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void acMasaDetay(String masaAdi, JButton masaButton) {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Ürün Adı");
        model.addColumn("Adet");
        model.addColumn("Toplam"); // Toplam sütununu da ekliyoruz

        double toplamTutar = 0.0; // Toplam tutarı saklamak için değişken

        // Tabloyu veritabanı verisiyle doldur
        String query = "SELECT UrunAdi, Adet, Toplam FROM " + masaAdi;
        try (PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String urunAdi = rs.getString("UrunAdi");
                int adet = rs.getInt("Adet");
                double toplam = rs.getDouble("Toplam");
                model.addRow(new Object[] { urunAdi, adet, toplam });
                toplamTutar += toplam; // Toplam tutarı güncelle
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Verileri yüklerken hata: " + e.getMessage());
            return;
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Toplam tutarı içeren bir JLabel oluştur
        JLabel toplamLabel = new JLabel("Toplam Tutar: " + String.format("%.2f", toplamTutar));

        // Panel oluştur ve hem tabloyu hem de toplam tutarı ekle
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(toplamLabel);
        panel.add(scrollPane);

        // "Ödemeyi Al" ve "İptal" butonlarını içeren bir seçenek penceresi oluştur
        Object[] options = {"Ödemeyi Al", "İptal"};
        int result = JOptionPane.showOptionDialog(null, panel, masaAdi + " Detayları",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[1]);

        // Seçilen butona göre işlem yap
        if (result == 0) { // "Ödemeyi Al" butonuna tıklandı
            int response = JOptionPane.showConfirmDialog(null, "Ödemeyi almak istediğinizden emin misiniz?", "Ödeme Onayı", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                try {
                    // Ödeme alındı mesajını göster
                    JOptionPane.showMessageDialog(null, "Ödeme alındı. Blgiler Excel tablonuza yazıldı.");

                    // Masanın doluluk durumunu güncelle
                    String updateQuery = "UPDATE masalar SET Doluluk = 'BOS' WHERE MasaNo = ?";
                    PreparedStatement pst = conn.prepareStatement(updateQuery);
                    pst.setString(1, masaAdi.toUpperCase());
                    pst.executeUpdate();
                    pst.close();

                    // Buton rengini güncelle
                    updateButtonColors(masaButton, masaAdi);

                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ödeme işlemi sırasında bir hata oluştu: " + ex.getMessage());
                }
            }
        }
    }
}
