package final_project;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Color;

import javax.swing.border.BevelBorder;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;

public class Menu_customer extends JFrame {

	private JPanel contentPane;
	private JTable table;
     Object data[][]=new Object[50][4]; 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_customer frame = new Menu_customer();
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
	public Menu_customer() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenu = new JLabel("MENU");
		lblMenu.setForeground(Color.BLUE);
		lblMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblMenu.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblMenu.setBounds(294, 26, 85, 27);
		contentPane.add(lblMenu);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(81, 74, 531, 220);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/project","root","nikita");
			Statement st =conn.createStatement();
			ResultSet rs=st.executeQuery("select * from menu");
			int i=0; 
			while(rs.next())
			{
				data[i][0]=rs.getInt(1);
				data[i][1]=rs.getInt(2);
				data[i][2]=rs.getString(3);
				data[i][3]=rs.getInt(4);
				i++;
			}
		}catch(Exception e){e.printStackTrace();}
		
		
		table.setModel(new DefaultTableModel(
			data,
			new String[] {
				"PRODUCT ID", " CATEGORY ID", "PRODUCT NAME", "PRICE"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(89);
		table.getColumnModel().getColumn(2).setPreferredWidth(93);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		
		final JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnBack)
				{
					Menu_options mo=new Menu_options();
					mo.show();
				}
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBack.setBounds(310, 316, 96, 33);
		contentPane.add(btnBack);
	}

}
