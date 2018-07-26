package final_project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Login_page extends JFrame implements KeyListener
{

	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}

	public void keyTyped(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			if(textField.getText().equals("ADMIN")==false)
			{
			JOptionPane.showMessageDialog(getContentPane(),"INCORRECT USERNAME");	
			}
			else if(passwordField.getText().equals("ADMIN")==false)
			{
				JOptionPane.showMessageDialog(getContentPane(), "PASSWORD DOES NOT MATCH!!");
			}
			else 
			{
				View_edit obj=new View_edit();
				obj.show();
		    }
		}
		
	}

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_page frame = new Login_page();
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
	public Login_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		addKeyListener(this);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setBounds(203, 45, 225, 27);
		contentPane.add(lblLogin);
		
		JLabel lblPleaseEnterThe = new JLabel("Please enter the following details to login.");
		lblPleaseEnterThe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPleaseEnterThe.setHorizontalAlignment(SwingConstants.LEFT);
		lblPleaseEnterThe.setBounds(62, 100, 476, 27);
		contentPane.add(lblPleaseEnterThe);
		
		JLabel lblUsername = new JLabel("USERNAME");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsername.setBounds(118, 175, 148, 27);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPassword.setBounds(118, 233, 148, 27);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(320, 175, 172, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(320, 233, 172, 27);
		contentPane.add(passwordField);
		passwordField.setEchoChar('*');
		
		final JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnSubmit)
			{
				if(textField.getText().equals("ADMIN")==false)
				{
				JOptionPane.showMessageDialog(getContentPane(),"INCORRECT USERNAME");	
				}
				else if(passwordField.getText().equals("ADMIN")==false)
				{
					JOptionPane.showMessageDialog(getContentPane(), "PASSWORD DOES NOT MATCH!!");
				}
				else 
				{
					View_edit obj=new View_edit();
					obj.show();
				}
				
			}
			}
			
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSubmit.setBounds(275, 307, 133, 27);
		contentPane.add(btnSubmit);
		
	}
}
