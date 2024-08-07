package restaurant;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class Masalar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Masalar frame = new Masalar("e");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param kullaniciadi 
	 */
	public Masalar(String kullaniciadi) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Masalar");
		setBounds(100, 100, 920, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton masa1 = new JButton("Maasa 1");
		masa1.setBackground(Color.WHITE);
		masa1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		masa1.setBounds(197, 46, 94, 80);
		contentPane.add(masa1);
		
		JButton masa8 = new JButton("Maasa 8");
		masa8.setFont(new Font("Times New Roman", Font.BOLD, 14));
		masa8.setBounds(348, 259, 94, 80);
		contentPane.add(masa8);
		
		JButton masa9 = new JButton("Maasa 9");
		masa9.setFont(new Font("Times New Roman", Font.BOLD, 14));
		masa9.setBounds(513, 259, 94, 80);
		contentPane.add(masa9);
		
		JButton masa10 = new JButton("Maasa 10");
		masa10.setFont(new Font("Times New Roman", Font.BOLD, 14));
		masa10.setBounds(197, 361, 94, 80);
		contentPane.add(masa10);
		
		JButton masa3 = new JButton("Maasa 3");
		masa3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		masa3.setBounds(513, 46, 94, 80);
		contentPane.add(masa3);
		
		JButton masa4 = new JButton("Maasa 4");
		masa4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		masa4.setBounds(197, 155, 94, 80);
		contentPane.add(masa4);
		
		JButton masa7 = new JButton("Maasa 7");
		masa7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		masa7.setBounds(197, 259, 94, 80);
		contentPane.add(masa7);
		
		JButton masa12 = new JButton("Maasa 12");
		masa12.setFont(new Font("Times New Roman", Font.BOLD, 14));
		masa12.setBounds(513, 361, 94, 80);
		contentPane.add(masa12);
		
		JButton masa2 = new JButton("Maasa 2");
		masa2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		masa2.setBounds(348, 46, 94, 80);
		contentPane.add(masa2);
		
		JButton masa6 = new JButton("Maasa 6");
		masa6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		masa6.setBounds(513, 155, 94, 80);
		contentPane.add(masa6);
		
		JButton masa5 = new JButton("Maasa 5");
		masa5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		masa5.setBounds(348, 155, 94, 80);
		contentPane.add(masa5);
		
		JButton masa11 = new JButton("Maasa 11");
		masa11.setFont(new Font("Times New Roman", Font.BOLD, 14));
		masa11.setBounds(348, 361, 94, 80);
		contentPane.add(masa11);
	}
}
