package final_project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class frame_1 extends JFrame {
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame_1 frame = new frame_1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public frame_1() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcomeToDominos = new JLabel("WELCOME TO DOMINO'S");
		lblWelcomeToDominos.setForeground(Color.RED);
		lblWelcomeToDominos.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblWelcomeToDominos.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToDominos.setBounds(58, 11, 541, 123);
		contentPane.add(lblWelcomeToDominos);
		
		final JButton btnAdmin = new JButton("ADMIN");
		btnAdmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnAdmin)
				{
					Login_page login_page=new Login_page();
					login_page.show();
					
				}
			}
		});
		btnAdmin.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdmin.setBounds(270, 173, 160, 34);
		contentPane.add(btnAdmin);
		
		final JButton btnCustomer = new JButton("CUSTOMER");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnCustomer)
				{
					PersonalDetails pd=new PersonalDetails();
					pd.show();
				}
			}
		});
		btnCustomer.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCustomer.setBounds(270, 247, 160, 34);
		contentPane.add(btnCustomer);
	}
}
