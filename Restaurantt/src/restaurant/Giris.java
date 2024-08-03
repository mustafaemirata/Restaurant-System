package restaurant;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Giris extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField kullaniciadi_textbox;
    private JTextField sifre_textbox;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Giris frame = new Giris();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public Giris() {
        setTitle("Restaurant Otomasyon Sistemi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 920, 565);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.info);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Kullanıcı Adı");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel.setBounds(210, 214, 121, 13);
        contentPane.add(lblNewLabel);
        
        kullaniciadi_textbox = new JTextField();
        kullaniciadi_textbox.setForeground(new Color(0, 0, 0));
        kullaniciadi_textbox.setFont(new Font("Times New Roman", Font.BOLD, 15));
        kullaniciadi_textbox.setBounds(364, 210, 130, 19);
        contentPane.add(kullaniciadi_textbox);
        kullaniciadi_textbox.setColumns(10);
        
        JLabel lblifre = new JLabel("Şifre");
        lblifre.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblifre.setBounds(210, 275, 121, 13);
        contentPane.add(lblifre);
        
        sifre_textbox = new JTextField();
        sifre_textbox.setColumns(10);
        sifre_textbox.setBounds(364, 273, 130, 19);
        contentPane.add(sifre_textbox);
        
        JButton giris_btn = new JButton("Giriş Yap");
        giris_btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String kullaniciadi = kullaniciadi_textbox.getText();
                String sifre = sifre_textbox.getText();

                Connection baglanti = null;
                PreparedStatement statement = null;
                ResultSet sonuc = null;

                try {
                    baglanti = createConnection();
                    String sorgu = "SELECT COUNT(*) AS giris FROM hesap WHERE username = ? AND password = ?";
                    statement = baglanti.prepareStatement(sorgu);
                    statement.setString(1, kullaniciadi);
                    statement.setString(2, sifre);
                    sonuc = statement.executeQuery();
                    if (sonuc.next()) {
                        int girisSayisi = sonuc.getInt("giris");
                        if (girisSayisi > 0) {
                            // Kullanıcı adı ve şifre doğrulandı
                            createDatabaseAndTable(kullaniciadi); // Veritabanı ve tablo oluşturma
                            setVisible(false);

                            Islemler homePage = new Islemler(kullaniciadi);
                            homePage.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Kullanıcı adı veya şifre yanlış!");
                        }
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Veritabanı hatası: " + ex.getMessage());
                    ex.printStackTrace();
                } finally {
                    try {
                        if (sonuc != null) sonuc.close();
                        if (statement != null) statement.close();
                        if (baglanti != null) baglanti.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        giris_btn.setForeground(Color.WHITE);
        giris_btn.setFont(new Font("Times New Roman", Font.BOLD, 15));
        giris_btn.setBackground(new Color(0, 128, 192));
        giris_btn.setBounds(334, 327, 106, 27);
        contentPane.add(giris_btn);

        JButton resim = new JButton();
        resim.setBounds(364, 49, 150, 129);
        resim.setBorderPainted(false);
        resim.setContentAreaFilled(false);
        resim.setFocusPainted(false);

        String imagePath = "src/restaurant/restaurant-building.png";
        ImageIcon originalIcon = new ImageIcon(imagePath);
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(resim.getWidth(), resim.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        resim.setIcon(resizedIcon);
        contentPane.add(resim);
        
        JLabel lblNewLabel_1 = new JLabel("ADMİN GİRİŞİ");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblNewLabel_1.setBounds(364, 10, 253, 27);
        contentPane.add(lblNewLabel_1);
    }

    // Veritabanı bağlantısını oluşturan metod
    private static Connection createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/restoranmudur";
            String kullaniciAdi = "emir";
            String sifre = "0634";
            return DriverManager.getConnection(url, kullaniciAdi, sifre);
        } catch (Exception e) {
            System.out.println("Veritabanı bağlantısı başarısız: " + e.getMessage());
            return null;
        }
    }

    // Veritabanı ve tablo oluşturma
    private void createDatabaseAndTable(String kullaniciadi) {
        Connection baglanti = null;
        Statement statement = null;

        try {
            // Veritabanı bağlantısını oluştur
            baglanti = createConnection();
            statement = baglanti.createStatement();

            // Veritabanı adı oluştur
            String databaseName = kullaniciadi + "_restoran";

            // Veritabanını oluştur
            String createDatabaseQuery = "CREATE DATABASE IF NOT EXISTS " + databaseName;
            statement.executeUpdate(createDatabaseQuery);
            System.out.println("Veritabanı oluşturuldu veya zaten mevcut: " + databaseName);

            // Yeni veritabanına bağlan
            String newDatabaseUrl = "jdbc:mysql://localhost:3306/" + databaseName;
            Connection yeniBaglanti = DriverManager.getConnection(newDatabaseUrl, "root", "1187");
            Statement yeniStatement = yeniBaglanti.createStatement();

            // Tabloyu oluştur
            String createTableQuery = "CREATE TABLE IF NOT EXISTS urunler (" +
                                      "UrunAdi VARCHAR(100), " +
                                      "UrunFiyati DECIMAL(10, 2) DEFAULT 0)";
            yeniStatement.executeUpdate(createTableQuery);
            System.out.println("Tablo oluşturuldu veya zaten mevcut: urunler");

            // Örnek ürünleri ekle
            String[] urunler = {"Tavuk1", "Tavuk2", "Tavuk3", "Pilav1", "Pilav2", "Pilav3", "Ayran", "Kola", "IceTea", "Salgam", "Limonata"};
            String insertQuery = "INSERT IGNORE INTO urunler (UrunAdi) VALUES (?)";
            PreparedStatement insertStatement = yeniBaglanti.prepareStatement(insertQuery);
            for (String urun : urunler) {
                insertStatement.setString(1, urun);
                insertStatement.executeUpdate();
            }
            insertStatement.close();
            yeniStatement.close();
            yeniBaglanti.close();
            System.out.println("Örnek ürünler başarıyla eklendi.");
        } catch (SQLException e) {
            System.out.println("Veritabanı veya tablo oluşturma hatası: " + e.getMessage());
        } finally {
            try {
                if (statement != null) statement.close();
                if (baglanti != null) baglanti.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private Connection createConnection1() throws SQLException {
        String url = "jdbc:mysql://localhost:3306";
        String user = "root";
        String password = "1187";
        return DriverManager.getConnection(url, user, password);
    }

}
