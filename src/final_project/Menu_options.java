package final_project;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class Menu_options extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_options frame = new Menu_options();
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
	public Menu_options() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 530, 356);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	final	JButton btnNewButton = new JButton("VIEW MENU");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnNewButton)
			{
				Menu_customer menu=new Menu_customer();
				menu.show();
			}
		}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(178, 96, 145, 28);
		contentPane.add(btnNewButton);
		
		final JButton btnNewButton_1 = new JButton("PLACE ORDER");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_1)
				{					
				placeOrder po=new placeOrder();
				po.show();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(178, 149, 145, 28);
		contentPane.add(btnNewButton_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		menuBar.setBounds(0, 0, 514, 42);
		contentPane.add(menuBar);
		
	final 	JMenuItem mntmHome = new JMenuItem("HOME");
		mntmHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==mntmHome){
					frame_1 f1=new frame_1();
					f1.show();
				}
				
			}
		});
		menuBar.add(mntmHome);
		
	final JMenuItem mntmBack = new JMenuItem("BACK");
		mntmBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==mntmBack){
				frame_1 f1=new frame_1();f1.show();
				}			}
		});
		menuBar.add(mntmBack);
		
		JMenuItem mntmExit = new JMenuItem("EXIT");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuBar.add(mntmExit);
		
		final JMenuItem mntmContactUs = new JMenuItem("CONTACT US");
		mntmContactUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(e.getSource()==mntmContactUs)
			{
				ContactUs cu=new ContactUs();
				cu.show();
			}
			}
		});
		menuBar.add(mntmContactUs);
	}
}
