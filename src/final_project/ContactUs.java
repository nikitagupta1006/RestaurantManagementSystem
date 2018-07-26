package final_project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class ContactUs extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactUs frame = new ContactUs();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ContactUs() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 889, 301);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("G:\\Java Practice\\Project\\Contact2.png"));
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(603, -35, 300, 330);
		contentPane.add(label);
	
	

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setIcon(new ImageIcon("G:\\Java Practice\\Project\\D.png"));
		lblNewLabel.setBounds(0, 0, 801, 265);
		contentPane.add(lblNewLabel);
		
	}
	

}
