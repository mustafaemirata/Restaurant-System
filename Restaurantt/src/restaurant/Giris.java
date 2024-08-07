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
     * Uygulamayı başlat.
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
     * Çerçeveyi oluştur.
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
        
        JLabel lblKullaniciAdi = new JLabel("Kullanıcı Adı");
        lblKullaniciAdi.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblKullaniciAdi.setBounds(210, 214, 121, 13);
        contentPane.add(lblKullaniciAdi);
        
        kullaniciadi_textbox = new JTextField();
        kullaniciadi_textbox.setForeground(Color.BLACK);
        kullaniciadi_textbox.setFont(new Font("Times New Roman", Font.BOLD, 15));
        kullaniciadi_textbox.setBounds(364, 210, 130, 19);
        contentPane.add(kullaniciadi_textbox);
        kullaniciadi_textbox.setColumns(10);
        
        JLabel lblSifre = new JLabel("Şifre");
        lblSifre.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblSifre.setBounds(210, 275, 121, 13);
        contentPane.add(lblSifre);
        
        sifre_textbox = new JTextField();
        sifre_textbox.setColumns(10);
        sifre_textbox.setBounds(364, 273, 130, 19);
        contentPane.add(sifre_textbox);
        
        JButton btnGirisYap = new JButton("Giriş Yap");
        btnGirisYap.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });
        btnGirisYap.setForeground(Color.WHITE);
        btnGirisYap.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnGirisYap.setBackground(new Color(0, 128, 192));
        btnGirisYap.setBounds(334, 327, 106, 27);
        contentPane.add(btnGirisYap);

        JLabel lblAdminGirisi = new JLabel("ADMİN GİRİŞİ");
        lblAdminGirisi.setFont(new Font("Times New Roman", Font.BOLD, 18));
        lblAdminGirisi.setBounds(364, 10, 253, 27);
        contentPane.add(lblAdminGirisi);
    }

    private void performLogin() {
        String kullaniciadi = kullaniciadi_textbox.getText();
        String sifre = sifre_textbox.getText();
        if (authenticateUser(kullaniciadi, sifre)) {
            createDatabaseAndTable(kullaniciadi);
            Islemler homePage = new Islemler(kullaniciadi);
            homePage.setVisible(true);
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Kullanıcı adı veya şifre yanlış!");
        }
    }

    private boolean authenticateUser(String username, String password) {
        // Burada veritabanı doğrulama mantığı yer almalı
        return true; // örnek amaçlı doğrulama geçildi
    }

    private void createDatabaseAndTable(String kullaniciadi) {
        try (Connection connection = createConnection();
             Statement statement = connection.createStatement()) {

            String databaseName = kullaniciadi + "_restoran";
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + databaseName);
            System.out.println("Veritabanı oluşturuldu veya zaten var: " + databaseName);

            setupTables(databaseName, kullaniciadi);
        } catch (SQLException e) {
            System.out.println("Veritabanı veya tablo oluşturma hatası: " + e.getMessage());
        }
    }

    private void setupTables(String databaseName, String kullaniciadi) throws SQLException {
        String connectionString = "jdbc:mysql://localhost:3306/" + databaseName;
        try (Connection newConnection = DriverManager.getConnection(connectionString, "root", "1187");
             Statement newStatement = newConnection.createStatement()) {

            // Her masa için bir tablo oluşturuluyor
            for (int i = 1; i <= 10; i++) {
                String masaAdi = "masa" + i;
                newStatement.executeUpdate("CREATE TABLE IF NOT EXISTS " + masaAdi + " (UrunAdi VARCHAR(255), Adet INT)");
                System.out.println(masaAdi + " tablosu oluşturuldu veya zaten var.");
            }
        }
    }

    private static Connection createConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/restoranmudur";
            return DriverManager.getConnection(url, "emir", "0634");
        } catch (Exception e) {
            System.out.println("Veritabanı bağlantısı başarısız: " + e.getMessage());
            return null;
        }
    }
}
