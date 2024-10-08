package restaurant;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JComboBox;

public class Islemler extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel menuPanel;
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private JPanel siparisPanel;
    private JPanel odemePanel;
    private JPanel ciroPanel;
    static String isim;
    private static JTable table;
    int tavukkucuk = 0;
	int tavukorta = 0;
	int tavukbuyuk = 0;
	int pilavkucuk = 0;
	int pilavorta = 0;
	int pilavbuyuk = 0;
    
	double fiyatTavukKucuk = 0;
	double fiyatTavukOrta = 0;
	double fiyatTavukBuyuk = 0;
	double fiyatPilavKucuk = 0;
	double fiyatPilavOrta = 0;
	double fiyatPilavBuyuk = 0;
   
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
    	
    	
        EventQueue.invokeLater(() -> {
            try {
                Islemler frame = new Islemler("admin"); // Kullanıcı adı örnek olarak "admin"
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     * @param kullaniciadi 
     */
   
    public Islemler(String kullaniciadi) {
    	isim=kullaniciadi;
   

        setTitle("Restoranım");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 920, 565);
        contentPane = new JPanel();
        contentPane.setBackground(SystemColor.activeCaption);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        // Menü paneli
        menuPanel = new JPanel();
        menuPanel.setBounds(0, 67, 200, 487);
        menuPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        menuPanel.setLayout(null);
        contentPane.add(menuPanel);
        
        // Menü başlığı
        JLabel menuTitle = new JLabel("Menü");
        menuTitle.setFont(new Font("Arial", Font.BOLD, 18));
        menuTitle.setBounds(10, 10, 180, 30);
        menuPanel.add(menuTitle);
        
        // Menü düğmeleri
        JButton btnSiparisOlustur = new JButton("Sipariş Oluştur");
        btnSiparisOlustur.setFont(new Font("Arial", Font.PLAIN, 14));
        btnSiparisOlustur.setBackground(new Color(0, 128, 192));
        btnSiparisOlustur.setForeground(Color.WHITE);
        btnSiparisOlustur.setBounds(10, 114, 180, 40);
        btnSiparisOlustur.setFocusPainted(false);
        btnSiparisOlustur.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "siparis");
            }
        });
        menuPanel.add(btnSiparisOlustur);
        
        JButton btnOdemeAl = new JButton("Ödeme Al");
        btnOdemeAl.setFont(new Font("Arial", Font.PLAIN, 14));
        btnOdemeAl.setBackground(new Color(0, 128, 192));
        btnOdemeAl.setForeground(Color.WHITE);
        btnOdemeAl.setBounds(10, 184, 180, 40);
        btnOdemeAl.setFocusPainted(false);
        btnOdemeAl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "odeme");
            }
        });
        menuPanel.add(btnOdemeAl);
        
        JButton btnGunlukCiro = new JButton("Günlük Ciro");
        btnGunlukCiro.setFont(new Font("Arial", Font.PLAIN, 14));
        btnGunlukCiro.setBackground(new Color(0, 128, 192));
        btnGunlukCiro.setForeground(Color.WHITE);
        btnGunlukCiro.setBounds(10, 256, 180, 40);
        btnGunlukCiro.setFocusPainted(false);
        btnGunlukCiro.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "ciro");
            }
        });
        menuPanel.add(btnGunlukCiro);
        
        JButton urun_guncelleme = new JButton("Ürün Bilgileri");
        urun_guncelleme.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 cardLayout.show(mainPanel, "ürün");
        	}
    });
        menuPanel.add(urun_guncelleme);
        urun_guncelleme.setForeground(Color.WHITE);
        urun_guncelleme.setFont(new Font("Arial", Font.PLAIN, 14));
        urun_guncelleme.setFocusPainted(false);
        urun_guncelleme.setBackground(new Color(0, 128, 192));
        urun_guncelleme.setBounds(10, 336, 180, 40);
        menuPanel.add(urun_guncelleme);
        
        JButton MASALAR = new JButton("Masalar");
        MASALAR.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Masalar homePage2 = new Masalar(kullaniciadi);
                homePage2.setVisible(true);
        	}
        });
        MASALAR.setForeground(Color.WHITE);
        MASALAR.setFont(new Font("Arial", Font.PLAIN, 14));
        MASALAR.setFocusPainted(false);
        MASALAR.setBackground(new Color(0, 128, 192));
        MASALAR.setBounds(10, 52, 180, 40);
        menuPanel.add(MASALAR);
        
        
        
        
        // Ana panel ve CardLayout
        mainPanel = new JPanel();
        mainPanel.setBounds(200, 0, 720, 565);
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);
        contentPane.add(mainPanel);

        // Sipariş paneli
        siparisPanel = new JPanel();
        siparisPanel.setBackground(SystemColor.activeCaption);
        siparisPanel.setLayout(null);
        JLabel label = new JLabel("Sipariş Oluşturma Ekranı");
        label.setBounds(260, 5, 208, 30);
        label.setFont(new Font("Times New Roman", Font.BOLD, 17));
        label.setForeground(SystemColor.text);
        siparisPanel.add(label);
        mainPanel.add(siparisPanel, "siparis");
        
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setBounds(10, 105, 680, 405);
        siparisPanel.add(tabbedPane);
        
        JPanel panel = new JPanel();
        tabbedPane.addTab("Yiyecekler", null, panel, null);
        panel.setLayout(null);
        
        // Tavuk döner butonları ve resimleri
        JButton tavuk1 = new JButton("");
        tavuk1.setBounds(20, 43, 109, 87);
        tavuk1.setBorderPainted(false);
        tavuk1.setContentAreaFilled(false);
        tavuk1.setFocusPainted(false);
        ImageIcon tavukIcon1 = new ImageIcon(new ImageIcon("src/restaurant/tavuk_doner.png").getImage().getScaledInstance(tavuk1.getWidth(), tavuk1.getHeight(), Image.SCALE_SMOOTH));
        tavuk1.setIcon(tavukIcon1);
        panel.add(tavuk1);
        
        JLabel lblNewLabel = new JLabel("Tavuk Dürüm (50 gr.)");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel.setBounds(10, 16, 146, 28);
        panel.add(lblNewLabel);
        
        JButton tavuk2 = new JButton("");
        tavuk2.setBounds(231, 43, 109, 87);
        tavuk2.setBorderPainted(false);
        tavuk2.setContentAreaFilled(false);
        tavuk2.setFocusPainted(false);
        ImageIcon tavukIcon2 = new ImageIcon(new ImageIcon("src/restaurant/tavuk_doner.png").getImage().getScaledInstance(tavuk2.getWidth(), tavuk2.getHeight(), Image.SCALE_SMOOTH));
        tavuk2.setIcon(tavukIcon2);
        panel.add(tavuk2);
        
        JLabel lblTavukDrm = new JLabel("Tavuk Dürüm (80 gr.)");
        lblTavukDrm.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblTavukDrm.setBounds(218, 16, 146, 28);
        panel.add(lblTavukDrm);
        
        JButton tavuk3 = new JButton("");
        tavuk3.setBounds(453, 43, 109, 87);
        tavuk3.setBorderPainted(false);
        tavuk3.setContentAreaFilled(false);
        tavuk3.setFocusPainted(false);
        ImageIcon tavukIcon3 = new ImageIcon(new ImageIcon("src/restaurant/tavuk_doner.png").getImage().getScaledInstance(tavuk3.getWidth(), tavuk3.getHeight(), Image.SCALE_SMOOTH));
        tavuk3.setIcon(tavukIcon3);
        panel.add(tavuk3);
        
        JLabel lblTavukDrm_2 = new JLabel("Tavuk Dürüm (120 gr.)");
        lblTavukDrm_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblTavukDrm_2.setBounds(441, 16, 159, 28);
        panel.add(lblTavukDrm_2);
        
        JLabel lblPilavyarm = new JLabel("Pilav (Yarım)");
        lblPilavyarm.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblPilavyarm.setBounds(38, 183, 146, 28);
        panel.add(lblPilavyarm);
        
        // Pilav butonları ve resimleri
        JButton pilav1 = new JButton("");
        pilav1.setBounds(30, 208, 109, 87);
        pilav1.setBorderPainted(false);
        pilav1.setContentAreaFilled(false);
        pilav1.setFocusPainted(false);
        ImageIcon pilavIcon1 = new ImageIcon(new ImageIcon("src/restaurant/pilav.jpg").getImage().getScaledInstance(pilav1.getWidth(), pilav1.getHeight(), Image.SCALE_SMOOTH));
        pilav1.setIcon(pilavIcon1);
        panel.add(pilav1);
        
        JButton pilav2 = new JButton("");
        pilav2.setBounds(231, 208, 109, 87);
        pilav2.setBorderPainted(false);
        pilav2.setContentAreaFilled(false);
        pilav2.setFocusPainted(false);
        ImageIcon pilavIcon2 = new ImageIcon(new ImageIcon("src/restaurant/pilav.jpg").getImage().getScaledInstance(pilav2.getWidth(), pilav2.getHeight(), Image.SCALE_SMOOTH));
        pilav2.setIcon(pilavIcon2);
        panel.add(pilav2);
        
        JLabel lblPilavtam = new JLabel("Pilav (Tam)");
        lblPilavtam.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblPilavtam.setBounds(231, 183, 146, 28);
        panel.add(lblPilavtam);
        
        JButton pilav3 = new JButton("");
        pilav3.setBounds(453, 208, 109, 87);
        pilav3.setBorderPainted(false);
        pilav3.setContentAreaFilled(false);
        pilav3.setFocusPainted(false);
        ImageIcon pilavIcon3 = new ImageIcon(new ImageIcon("src/restaurant/pilav.jpg").getImage().getScaledInstance(pilav3.getWidth(), pilav3.getHeight(), Image.SCALE_SMOOTH));
        pilav3.setIcon(pilavIcon3);
        panel.add(pilav3);
        
        JLabel lblPilav = new JLabel("Pilav (1.5)");
        lblPilav.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblPilav.setBounds(454, 183, 146, 28);
        panel.add(lblPilav);
        
        JButton tavuk1_ekle = new JButton("Ekle");
        tavuk1_ekle.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	
            	tavukkucuk++;
            	System.out.println(tavukkucuk);
                JOptionPane.showMessageDialog(siparisPanel, "Sepete eklendi", "Message", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    
      

        tavuk1_ekle.setForeground(Color.WHITE);
        tavuk1_ekle.setFont(new Font("Times New Roman", Font.BOLD, 15));
        tavuk1_ekle.setBackground(new Color(0, 128, 192));
        tavuk1_ekle.setBounds(23, 140, 106, 27);
        panel.add(tavuk1_ekle);
        
        JButton tavuk2_ekle = new JButton("Ekle");
        tavuk2_ekle.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tavukorta++;
            	
                JOptionPane.showMessageDialog(siparisPanel, "Sepete eklendi", "Message", JOptionPane.INFORMATION_MESSAGE);
        	}
        });
        tavuk2_ekle.setForeground(Color.WHITE);
        tavuk2_ekle.setFont(new Font("Times New Roman", Font.BOLD, 15));
        tavuk2_ekle.setBackground(new Color(0, 128, 192));
        tavuk2_ekle.setBounds(241, 140, 106, 27);
        panel.add(tavuk2_ekle);
        
        JButton tavuk3_ekle = new JButton("Ekle");
        tavuk3_ekle.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		tavukbuyuk++;
            	
                JOptionPane.showMessageDialog(siparisPanel, "Sepete eklendi", "Message", JOptionPane.INFORMATION_MESSAGE);
        	}
        });
        tavuk3_ekle.setForeground(Color.WHITE);
        tavuk3_ekle.setFont(new Font("Times New Roman", Font.BOLD, 15));
        tavuk3_ekle.setBackground(new Color(0, 128, 192));
        tavuk3_ekle.setBounds(463, 140, 106, 27);
        panel.add(tavuk3_ekle);
        
        JButton pilav1_ekle = new JButton("Ekle");
        pilav1_ekle.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		pilavkucuk++;
            	
                JOptionPane.showMessageDialog(siparisPanel, "Sepete eklendi", "Message", JOptionPane.INFORMATION_MESSAGE);
        	}
        });
        pilav1_ekle.setForeground(Color.WHITE);
        pilav1_ekle.setFont(new Font("Times New Roman", Font.BOLD, 15));
        pilav1_ekle.setBackground(new Color(0, 128, 192));
        pilav1_ekle.setBounds(38, 305, 106, 27);
        panel.add(pilav1_ekle);
        
        JButton pilav2_ekle = new JButton("Ekle");
        pilav2_ekle.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		pilavorta++;
            	
                JOptionPane.showMessageDialog(siparisPanel, "Sepete eklendi", "Message", JOptionPane.INFORMATION_MESSAGE);
        	}
        });
        pilav2_ekle.setForeground(Color.WHITE);
        pilav2_ekle.setFont(new Font("Times New Roman", Font.BOLD, 15));
        pilav2_ekle.setBackground(new Color(0, 128, 192));
        pilav2_ekle.setBounds(241, 305, 106, 27);
        panel.add(pilav2_ekle);
        
        JButton pilav3_ekle = new JButton("Ekle");
        pilav3_ekle.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		pilavbuyuk++;
            	
                JOptionPane.showMessageDialog(siparisPanel, "Sepete eklendi", "Message", JOptionPane.INFORMATION_MESSAGE);
        	}
        });
        pilav3_ekle.setForeground(Color.WHITE);
        pilav3_ekle.setFont(new Font("Times New Roman", Font.BOLD, 15));
        pilav3_ekle.setBackground(new Color(0, 128, 192));
        pilav3_ekle.setBounds(456, 305, 106, 27);
        panel.add(pilav3_ekle);
        
        JPanel panel_3 = new JPanel();
        tabbedPane.addTab("İçecekler", null, panel_3, null);
        panel_3.setLayout(null);

        // Kola butonu ve resmi
        JButton kola = new JButton("");
        kola.setFocusPainted(false);
        kola.setContentAreaFilled(false);
        kola.setBorderPainted(false);
        kola.setBounds(20, 43, 109, 87);
        ImageIcon kolaIcon = new ImageIcon(new ImageIcon("src/restaurant/kola.jpg").getImage().getScaledInstance(kola.getWidth(), kola.getHeight(), Image.SCALE_SMOOTH));
        kola.setIcon(kolaIcon);
        panel_3.add(kola);

        JLabel lblKola = new JLabel("Kola");
        lblKola.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblKola.setBounds(50, 16, 146, 28);
        panel_3.add(lblKola);

        // Ayran butonu ve resmi
        JButton ayran = new JButton("");
        ayran.setFocusPainted(false);
        ayran.setContentAreaFilled(false);
        ayran.setBorderPainted(false);
        ayran.setBounds(231, 43, 109, 87);
        ImageIcon ayranIcon = new ImageIcon(new ImageIcon("src/restaurant/ayran.jpg").getImage().getScaledInstance(ayran.getWidth(), ayran.getHeight(), Image.SCALE_SMOOTH));
        ayran.setIcon(ayranIcon);
        panel_3.add(ayran);

        JLabel lblAyran = new JLabel("Ayran");
        lblAyran.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblAyran.setBounds(257, 16, 146, 28);
        panel_3.add(lblAyran);

        // Ice-Tea butonu ve resmi
        JButton iceTea = new JButton("");
        iceTea.setFocusPainted(false);
        iceTea.setContentAreaFilled(false);
        iceTea.setBorderPainted(false);
        iceTea.setBounds(453, 43, 109, 87);
        ImageIcon iceTeaIcon = new ImageIcon(new ImageIcon("src/restaurant/ice-tea.png").getImage().getScaledInstance(iceTea.getWidth(), iceTea.getHeight(), Image.SCALE_SMOOTH));
        iceTea.setIcon(iceTeaIcon);
        panel_3.add(iceTea);

        JLabel lblIceTea = new JLabel("Ice-Tea");
        lblIceTea.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblIceTea.setBounds(483, 16, 159, 28);
        panel_3.add(lblIceTea);

        // Limonata butonu ve resmi
        JButton limonata = new JButton("");
        limonata.setFocusPainted(false);
        limonata.setContentAreaFilled(false);
        limonata.setBorderPainted(false);
        limonata.setBounds(30, 208, 109, 87);
        ImageIcon limonataIcon = new ImageIcon(new ImageIcon("src/restaurant/limonata.jpg").getImage().getScaledInstance(limonata.getWidth(), limonata.getHeight(), Image.SCALE_SMOOTH));
        limonata.setIcon(limonataIcon);
        panel_3.add(limonata);

        JLabel lblLimonata = new JLabel("Limonata");
        lblLimonata.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblLimonata.setBounds(50, 183, 146, 28);
        panel_3.add(lblLimonata);

        // Şalgam butonu ve resmi
        JButton salgam = new JButton("");
        salgam.setFocusPainted(false);
        salgam.setContentAreaFilled(false);
        salgam.setBorderPainted(false);
        salgam.setBounds(231, 208, 109, 87);
        ImageIcon salgamIcon = new ImageIcon(new ImageIcon("src/restaurant/salgam.jpg").getImage().getScaledInstance(salgam.getWidth(), salgam.getHeight(), Image.SCALE_SMOOTH));
        salgam.setIcon(salgamIcon);
        panel_3.add(salgam);

        JLabel lblSalgam = new JLabel("Şalgam");
        lblSalgam.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblSalgam.setBounds(251, 183, 146, 28);
        panel_3.add(lblSalgam);

        // Kola Ekle butonu
        JButton kola_ekle = new JButton("Ekle");
        kola_ekle.setForeground(Color.WHITE);
        kola_ekle.setFont(new Font("Times New Roman", Font.BOLD, 15));
        kola_ekle.setBackground(new Color(0, 128, 192));
        kola_ekle.setBounds(23, 140, 106, 27);
        panel_3.add(kola_ekle);

        // Ayran Ekle butonu
        JButton ayran_ekle = new JButton("Ekle");
        ayran_ekle.setForeground(Color.WHITE);
        ayran_ekle.setFont(new Font("Times New Roman", Font.BOLD, 15));
        ayran_ekle.setBackground(new Color(0, 128, 192));
        ayran_ekle.setBounds(241, 140, 106, 27);
        panel_3.add(ayran_ekle);

        // Ice-Tea Ekle butonu
        JButton icetea_ekle = new JButton("Ekle");
        icetea_ekle.setForeground(Color.WHITE);
        icetea_ekle.setFont(new Font("Times New Roman", Font.BOLD, 15));
        icetea_ekle.setBackground(new Color(0, 128, 192));
        icetea_ekle.setBounds(453, 140, 106, 27);
        panel_3.add(icetea_ekle);

        // Limonata Ekle butonu
        JButton limonata_ekle = new JButton("Ekle");
        limonata_ekle.setForeground(Color.WHITE);
        limonata_ekle.setFont(new Font("Times New Roman", Font.BOLD, 15));
        limonata_ekle.setBackground(new Color(0, 128, 192));
        limonata_ekle.setBounds(38, 305, 106, 27);
        panel_3.add(limonata_ekle);

        // Şalgam Ekle butonu
        JButton salgam_ekle = new JButton("Ekle");
        salgam_ekle.setForeground(Color.WHITE);
        salgam_ekle.setFont(new Font("Times New Roman", Font.BOLD, 15));
        salgam_ekle.setBackground(new Color(0, 128, 192));
        salgam_ekle.setBounds(241, 305, 106, 27);
        panel_3.add(salgam_ekle);

        // Tatlılar paneli
        JPanel panel_2 = new JPanel();
        tabbedPane.addTab("Tatlılar", null, panel_2, null);
        panel_2.setLayout(null);
        
        JPanel panel_3_1 = new JPanel();
        panel_3_1.setLayout(null);
        panel_3_1.setBounds(0, 0, 675, 378);
        panel_2.add(panel_3_1);
        
        JButton kola_1 = new JButton("");
        kola_1.setFocusPainted(false);
        kola_1.setContentAreaFilled(false);
        kola_1.setBorderPainted(false);
        kola_1.setBounds(20, 43, 109, 87);
        panel_3_1.add(kola_1);
        
        JLabel lblBaklava = new JLabel("Baklava");
        lblBaklava.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblBaklava.setBounds(50, 16, 146, 28);
        panel_3_1.add(lblBaklava);
        
        JButton ayran_1 = new JButton("");
        ayran_1.setFocusPainted(false);
        ayran_1.setContentAreaFilled(false);
        ayran_1.setBorderPainted(false);
        ayran_1.setBounds(231, 43, 109, 87);
        panel_3_1.add(ayran_1);
        
        JLabel lblKazandibi = new JLabel("Kazandibi");
        lblKazandibi.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblKazandibi.setBounds(257, 16, 146, 28);
        panel_3_1.add(lblKazandibi);
        
        JButton iceTea_1 = new JButton("");
        iceTea_1.setFocusPainted(false);
        iceTea_1.setContentAreaFilled(false);
        iceTea_1.setBorderPainted(false);
        iceTea_1.setBounds(453, 43, 109, 87);
        panel_3_1.add(iceTea_1);
        
        JLabel lblStla = new JLabel("Sütlaç");
        lblStla.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblStla.setBounds(483, 16, 159, 28);
        panel_3_1.add(lblStla);
        
        JButton limonata_1 = new JButton("");
        limonata_1.setFocusPainted(false);
        limonata_1.setContentAreaFilled(false);
        limonata_1.setBorderPainted(false);
        limonata_1.setBounds(30, 208, 109, 87);
        panel_3_1.add(limonata_1);
        
        JLabel lblPasta = new JLabel("Pasta");
        lblPasta.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblPasta.setBounds(50, 183, 146, 28);
        panel_3_1.add(lblPasta);
        
        JButton salgam_1 = new JButton("");
        salgam_1.setFocusPainted(false);
        salgam_1.setContentAreaFilled(false);
        salgam_1.setBorderPainted(false);
        salgam_1.setBounds(231, 208, 109, 87);
        panel_3_1.add(salgam_1);
        
        JLabel lblPuding = new JLabel("Puding");
        lblPuding.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblPuding.setBounds(251, 183, 146, 28);
        panel_3_1.add(lblPuding);
        
        JButton kola_ekle_1 = new JButton("Ekle");
        kola_ekle_1.setForeground(Color.WHITE);
        kola_ekle_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        kola_ekle_1.setBackground(new Color(0, 128, 192));
        kola_ekle_1.setBounds(23, 140, 106, 27);
        panel_3_1.add(kola_ekle_1);
        
        JButton ayran_ekle_1 = new JButton("Ekle");
        ayran_ekle_1.setForeground(Color.WHITE);
        ayran_ekle_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        ayran_ekle_1.setBackground(new Color(0, 128, 192));
        ayran_ekle_1.setBounds(241, 140, 106, 27);
        panel_3_1.add(ayran_ekle_1);
        
        JButton icetea_ekle_1 = new JButton("Ekle");
        icetea_ekle_1.setForeground(Color.WHITE);
        icetea_ekle_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        icetea_ekle_1.setBackground(new Color(0, 128, 192));
        icetea_ekle_1.setBounds(453, 140, 106, 27);
        panel_3_1.add(icetea_ekle_1);
        
        JButton limonata_ekle_1 = new JButton("Ekle");
        limonata_ekle_1.setForeground(Color.WHITE);
        limonata_ekle_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        limonata_ekle_1.setBackground(new Color(0, 128, 192));
        limonata_ekle_1.setBounds(38, 305, 106, 27);
        panel_3_1.add(limonata_ekle_1);
        
        JButton salgam_ekle_1 = new JButton("Ekle");
        salgam_ekle_1.setForeground(Color.WHITE);
        salgam_ekle_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
        salgam_ekle_1.setBackground(new Color(0, 128, 192));
        salgam_ekle_1.setBounds(241, 305, 106, 27);
        panel_3_1.add(salgam_ekle_1);

        try (Connection conn = createConnection(isim + "_restoran")) {
            if (conn != null) {
                // SQL sorguları
                String query = "SELECT UrunFiyati FROM urunler WHERE UrunAdi=?";

                try (PreparedStatement pstmt = conn.prepareStatement(query)) {
                    // Tavuk Dürüm 50gr fiyatı
                    pstmt.setString(1, "Tavuk Dürüm 50gr");
                    try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next()) {
                            fiyatTavukKucuk = rs.getDouble("UrunFiyati");
                        }
                    }

                    // Tavuk Dürüm 80gr fiyatı
                    pstmt.setString(1, "Tavuk Dürüm 80gr");
                    try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next()) {
                            fiyatTavukOrta = rs.getDouble("UrunFiyati");
                        }
                    }

                    // Tavuk Dürüm 120gr fiyatı
                    pstmt.setString(1, "Tavuk Dürüm 120gr");
                    try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next()) {
                            fiyatTavukBuyuk = rs.getDouble("UrunFiyati");
                        }
                    }

                    // Pilav Yarım Porsiyon fiyatı
                    pstmt.setString(1, "Pilav Yarım Porsiyon");
                    try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next()) {
                            fiyatPilavKucuk = rs.getDouble("UrunFiyati");
                        }
                    }

                    // Pilav Tam Porsiyon fiyatı
                    pstmt.setString(1, "Pilav Tam Porsiyon");
                    try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next()) {
                            fiyatPilavOrta = rs.getDouble("UrunFiyati");
                        }
                    }

                    // Pilav 1.5 Porsiyon fiyatı
                    pstmt.setString(1, "Pilav 1.5 Porsiyon");
                    try (ResultSet rs = pstmt.executeQuery()) {
                        if (rs.next()) {
                            fiyatPilavBuyuk = rs.getDouble("UrunFiyati");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JComboBox masa_combo = new JComboBox();
        masa_combo.setBounds(117, 55, 55, 21);
        siparisPanel.add(masa_combo);
        masa_combo.addItem("1");masa_combo.addItem("2");masa_combo.addItem("3");masa_combo.addItem("4");masa_combo.addItem("5");  masa_combo.addItem("6");  masa_combo.addItem("7");
        masa_combo.addItem("8");  masa_combo.addItem("9");  masa_combo.addItem("10");  masa_combo.addItem("11");  masa_combo.addItem("12");
       

        // Sepet butonu
        JButton sepeti_goruntule = new JButton("Sepet");
        sepeti_goruntule.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new JFrame("Sipariş Onay");

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(300, 300);
                frame.getContentPane().setLayout(new BorderLayout());

                JPanel buttonPanel = new JPanel();
                buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));

                JButton onaylaButton = new JButton("Onayla");
                JButton bosaltButton = new JButton("Boşalt");

                onaylaButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Get the selected table number from the combo box
                        String selectedTable = (String) masa_combo.getSelectedItem(); // Assuming masa_combo is your JComboBox
                        String tableName = "masa" + selectedTable;

                        try {
                            // Establish database connection
                            Connection connection = createDatabaseConnection(); // Assuming createDatabaseConnection() is your method to connect to the database
                            if (connection != null) {
                                PreparedStatement preparedStatement = connection.prepareStatement(
                                    "INSERT INTO " + tableName + " (UrunAdi, Adet, Toplam) VALUES (?, ?,?)");

                                // Add items to the table
                                if (tavukkucuk != 0) {
                                    preparedStatement.setString(1, "Tavuk 50gr");
                                    preparedStatement.setInt(2, tavukkucuk);
                                    preparedStatement.setDouble(3, tavukkucuk * fiyatTavukKucuk); 
                                    preparedStatement.addBatch();
                                }
                                if (tavukorta != 0) {
                                    preparedStatement.setString(1, "Tavuk 80gr");
                                    preparedStatement.setInt(2, tavukorta);
                                    preparedStatement.addBatch();
                                }
                                if (tavukbuyuk != 0) {
                                    preparedStatement.setString(1, "Tavuk 120gr");
                                    preparedStatement.setInt(2, tavukbuyuk);
                                    preparedStatement.addBatch();
                                }
                                if (pilavkucuk != 0) {
                                    preparedStatement.setString(1, "Pilav Yarım Porsiyon");
                                    preparedStatement.setInt(2, pilavkucuk);
                                    preparedStatement.addBatch();
                                }
                                if (pilavorta != 0) {
                                    preparedStatement.setString(1, "Pilav 1 Porsiyon");
                                    preparedStatement.setInt(2, pilavorta);
                                    preparedStatement.addBatch();
                                }
                                if (pilavbuyuk != 0) {
                                    preparedStatement.setString(1, "Pilav 1.5 Porsiyon");
                                    preparedStatement.setInt(2, pilavbuyuk);
                                    preparedStatement.addBatch();
                                }

                                // Execute batch insert
                                preparedStatement.executeBatch();
                                preparedStatement.close();
                                connection.close();
                            }
                            
                            Connection updateConnection = createDatabaseConnection();
                            if (updateConnection != null) {
                                PreparedStatement updateStatement = updateConnection.prepareStatement(
                                    "UPDATE masalar SET Doluluk = 'Dolu' WHERE MasaNo = ?");
                                updateStatement.setString(1, "MASA" + selectedTable);
                                updateStatement.executeUpdate();
                                updateStatement.close();
                                updateConnection.close();
                            }

                            JOptionPane.showMessageDialog(frame, "Siparişiniz onaylandı!");
                            frame.dispose();
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(frame, "Sipariş eklenirken hata oluştfvgbhnu: " + ex.getMessage());
                        }
                    }

                    private Connection createDatabaseConnection() {
                        // Implement your database connection logic here
                        Connection connection = null;
                        try {
                            // Load the database driver
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            // Establish the connection
                            connection = DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/"+isim+"_restoran", // Replace with your database URL
                                "emir", // Replace with your database username
                                "0634"  // Replace with your database password
                            );
                        } catch (ClassNotFoundException | SQLException e) {
                            e.printStackTrace();
                        }
                        return connection;
                    }
                });


                bosaltButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        tavukkucuk = 0;
                        tavukorta = 0;
                        tavukbuyuk = 0;
                        pilavkucuk = 0;
                        pilavorta = 0;
                        pilavbuyuk = 0;
                        JOptionPane.showMessageDialog(frame, "Sepetiniz boşaltıldı!");
                        frame.dispose();
                    }
                });

                buttonPanel.add(onaylaButton);
                buttonPanel.add(bosaltButton);

                JPanel contentPanel = new JPanel();
                contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

                if (tavukkucuk != 0) contentPanel.add(new JLabel("Tavuk 50gr.: " + tavukkucuk + " adet, Fiyat: " + (tavukkucuk * fiyatTavukKucuk) + " TL"));

                if (tavukorta != 0) contentPanel.add(new JLabel("Tavuk 80gr.: " + tavukorta + " adet, Fiyat: " + (tavukorta * fiyatTavukOrta) + " TL"));
                if (tavukbuyuk != 0) contentPanel.add(new JLabel("Tavuk 120gr.: " + tavukbuyuk + " adet, Fiyat: " + (tavukbuyuk * fiyatTavukBuyuk) + " TL"));
                if (pilavkucuk != 0) contentPanel.add(new JLabel("Pilav Yarım: " + pilavkucuk + " adet, Fiyat: " + (pilavkucuk * fiyatPilavKucuk) + " TL"));
                if (pilavorta != 0) contentPanel.add(new JLabel("Pilav 1 Porsiyon: " + pilavorta + " adet, Fiyat: " + (pilavorta * fiyatPilavOrta) + " TL"));
                if (pilavbuyuk != 0) contentPanel.add(new JLabel("Pilav 1.5 Porsiyon: " + pilavbuyuk + " adet, Fiyat: " + (pilavbuyuk * fiyatPilavBuyuk) + " TL"));

                
                
                frame.getContentPane().add(new JLabel("Fişin yazılacağı masa: "+(String) masa_combo.getSelectedItem(), JLabel.CENTER), BorderLayout.NORTH);
                frame.getContentPane().add(contentPanel, BorderLayout.CENTER);
                frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

                frame.setVisible(true);
          
            }
        });

        sepeti_goruntule.setForeground(Color.WHITE);
        sepeti_goruntule.setFont(new Font("Times New Roman", Font.BOLD, 15));
        sepeti_goruntule.setBackground(new Color(0, 128, 192));
        sepeti_goruntule.setBounds(584, 83, 106, 27);
        siparisPanel.add(sepeti_goruntule);
        
        
        
        JLabel lblNewLabel_1 = new JLabel("Masa No: ");
        lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblNewLabel_1.setBounds(10, 59, 77, 13);
        siparisPanel.add(lblNewLabel_1);

        
        
        
       
        
        // Ödeme paneli
        odemePanel = new JPanel();
        odemePanel.setBackground(SystemColor.activeCaption);
        odemePanel.setLayout(null);
        JLabel label_1 = new JLabel("Ödeme Alma Ekranı");
        label_1.setBounds(277, 5, 146, 30);
        label_1.setForeground(SystemColor.text);
        label_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
        odemePanel.add(label_1);
        mainPanel.add(odemePanel, "odeme");
        
        // Günlük ciro paneli
        ciroPanel = new JPanel();
        ciroPanel.setBackground(SystemColor.activeCaption);
        ciroPanel.setLayout(null);
        JLabel label_2 = new JLabel("Günlük Ciro Ekranı");
        label_2.setForeground(SystemColor.text);
        label_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
        label_2.setBounds(282, 10, 155, 21);
        ciroPanel.add(label_2);
        mainPanel.add(ciroPanel, "ciro");
        
        JPanel urunPanel = new JPanel();
        urunPanel.setBackground(SystemColor.activeCaption);
        mainPanel.add(urunPanel, "ürün");
        urunPanel.setLayout(null);
        
        JLabel label_2_1 = new JLabel("Ürün Bilgileri");
        label_2_1.setForeground(SystemColor.text);
        label_2_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
        label_2_1.setBounds(281, 10, 155, 21);
        urunPanel.add(label_2_1);
        
    
        
        JLabel hosgeldin_yazisi = new JLabel("Hoş geldiniz  "+isim);
        hosgeldin_yazisi.setFont(new Font("Tahoma", Font.BOLD, 14));
        hosgeldin_yazisi.setForeground(Color.WHITE);
        hosgeldin_yazisi.setBounds(10, 0, 190, 34);
        contentPane.add(hosgeldin_yazisi);
        
        JLabel TARIHH = new JLabel("");
        TARIHH.setForeground(Color.WHITE);
        TARIHH.setFont(new Font("Times New Roman", Font.BOLD, 14));
        TARIHH.setBounds(20, 44, 145, 13);
        contentPane.add(TARIHH);
        
        
        table = new JTable();
        table.setBounds(31, 60, 627, 347);
        urunPanel.add(table);

        // Veritabanından verileri çek ve tabloya ekle
        loadUrunler();
    }

    private void loadUrunler() {
        Connection connection = createConnection(isim);
        if (connection != null) {
            try {
                String query = "SELECT UrunAdi, UrunFiyati FROM urunler";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                DefaultTableModel model = new DefaultTableModel();
                model.addColumn("Ürün Adı");
                model.addColumn("Ürün Fiyatı");

                while (resultSet.next()) {
                    String urunAdi = resultSet.getString("urunAdi");
                    double urunFiyati = resultSet.getDouble("urunFiyati");
                    model.addRow(new Object[]{urunAdi, urunFiyati});
                }

                table.setModel(model);

                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
        
       
    
    
    private static Connection createConnection(String isim2) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/"+isim+"_restoran";
            String kullaniciAdi = "emir";
            String sifre = "0634";
            return DriverManager.getConnection(url, kullaniciAdi, sifre);
        } catch (Exception e) {
            System.out.println("Veritabanı bağlantısı başarısADSAız: " + e.getMessage());
            return null;
        }
    
   
    
    }
}
    
