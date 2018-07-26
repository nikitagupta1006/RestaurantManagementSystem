package final_project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;
import javax.swing.JMenuItem;

public class View_edit extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View_edit frame = new View_edit();
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
	public View_edit() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 570, 428);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUserAdmin = new JLabel("USER : ADMIN");
		lblUserAdmin.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUserAdmin.setBounds(39, 87, 121, 34);
		contentPane.add(lblUserAdmin);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 684, 34);
		contentPane.add(menuBar);
		
	final	JMenuItem mntmContactUs = new JMenuItem("CONTACT US");
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
		
		final JMenuItem mntmHome = new JMenuItem("HOME");
		mntmHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==mntmHome)
				{
					frame_1 f1=new frame_1();
					f1.show();
				}
			}
		});
		menuBar.add(mntmHome);
		
		JMenuItem mntmExit = new JMenuItem("EXIT");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuBar.add(mntmExit);
		
		JButton btnEdit = new JButton("EDIT MENU");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Menu menu=new Menu();
				menu.show();
			}
		});
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEdit.setBounds(195, 230, 171, 34);
		contentPane.add(btnEdit);
		
		JButton btnEditCategories = new JButton("EDIT CATEGORIES");
		btnEditCategories.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Categories category=new Categories();
				category.show();
			}
		});
		btnEditCategories.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEditCategories.setBounds(195, 161, 171, 34);
		contentPane.add(btnEditCategories);
	}
}
//ADD MENU LISTENER