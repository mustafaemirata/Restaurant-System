package restaurant;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;

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
		masa1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		masa1.setBounds(197, 46, 94, 80);
		contentPane.add(masa1);
		
		JButton masa1_1 = new JButton("Maasa 1");
		masa1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		masa1_1.setBounds(348, 259, 94, 80);
		contentPane.add(masa1_1);
		
		JButton masa1_2 = new JButton("Maasa 1");
		masa1_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		masa1_2.setBounds(534, 259, 94, 80);
		contentPane.add(masa1_2);
		
		JButton masa1_3 = new JButton("Maasa 1");
		masa1_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		masa1_3.setBounds(197, 361, 94, 80);
		contentPane.add(masa1_3);
		
		JButton masa3 = new JButton("Maasa 3");
		masa3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		masa3.setBounds(534, 46, 94, 80);
		contentPane.add(masa3);
		
		JButton masa1_5 = new JButton("Maasa 1");
		masa1_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		masa1_5.setBounds(197, 155, 94, 80);
		contentPane.add(masa1_5);
		
		JButton masa1_6 = new JButton("Maasa 1");
		masa1_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
		masa1_6.setBounds(197, 259, 94, 80);
		contentPane.add(masa1_6);
		
		JButton masa1_7 = new JButton("Maasa 1");
		masa1_7.setFont(new Font("Times New Roman", Font.BOLD, 16));
		masa1_7.setBounds(534, 361, 94, 80);
		contentPane.add(masa1_7);
		
		JButton masa2 = new JButton("Maasa 2");
		masa2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		masa2.setBounds(348, 46, 94, 80);
		contentPane.add(masa2);
		
		JButton masa1_9 = new JButton("Maasa 1");
		masa1_9.setFont(new Font("Times New Roman", Font.BOLD, 16));
		masa1_9.setBounds(534, 155, 94, 80);
		contentPane.add(masa1_9);
		
		JButton masa1_10 = new JButton("Maasa 1");
		masa1_10.setFont(new Font("Times New Roman", Font.BOLD, 16));
		masa1_10.setBounds(348, 155, 94, 80);
		contentPane.add(masa1_10);
		
		JButton masa1_11 = new JButton("Maasa 1");
		masa1_11.setFont(new Font("Times New Roman", Font.BOLD, 16));
		masa1_11.setBounds(348, 361, 94, 80);
		contentPane.add(masa1_11);
	}
}
