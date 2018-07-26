package final_project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.MatteBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JMenuItem;
public class Menu extends JFrame {
    Connection conn=null;
    
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	int count=0;
	String name_2;
	Object row[][]=new Object[100][4];
	Object row2[][]=new Object[100][4];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 644, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 668, 36);
		contentPane.add(menuBar);
		
		JMenuItem mntmExit = new JMenuItem("EXIT");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		menuBar.add(mntmExit);
		
		final JMenuItem mntmHome = new JMenuItem("HOME");
		mntmHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==mntmHome)
				{
					frame_1 f=new frame_1();f.show();
				}
			}
		});
		menuBar.add(mntmHome);
		
		final JMenuItem mntmBack = new JMenuItem("BACK");
		mntmBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(e.getSource()==mntmBack)
				{
					View_edit ve=new View_edit();ve.show(); 
				}
			}
		});
		menuBar.add(mntmBack);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 47, 441, 207);
		contentPane.add(scrollPane);
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/project","root","nikita");
			String str="select * from menu";
			PreparedStatement pst=conn.prepareStatement(str);
			ResultSet rs=pst.executeQuery();
			int i=0;
			while(rs.next())
			{
				int j=0;
				row[i][j]=rs.getInt(1);
				j++;
				row[i][j]=rs.getInt(2);
				j++;
				row[i][j]=rs.getString(3);
				j++;
				row[i][j]=rs.getInt(4);
				j++;
				i++;
				
			}
			
		}catch(Exception ex )
		{
			ex.printStackTrace();
		}
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(0, 0, 0)));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setModel(new DefaultTableModel(
			row,
			new   String[] {
				"PRODUCT ID", "CATEGORY ID", "PRODUCT NAME", "PRICE"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(81);
		table.getColumnModel().getColumn(2).setPreferredWidth(110);
	
		final JButton btnNewButton = new JButton("INSERT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton)
				{
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/project","root","nikita");
					String str="insert into menu (category_id,product_name,price) values(?,?,?)";
					PreparedStatement pst=conn.prepareStatement(str);
					pst.setInt(1,Integer.parseInt(textField_1.getText()));
					pst.setString(2,textField.getText());
					pst.setInt(3,Integer.parseInt(textField_2.getText()));
					if(pst.executeUpdate()==1)
					JOptionPane.showMessageDialog(getContentPane(),"RECORD INSERTED");
					else
					JOptionPane.showMessageDialog(getContentPane(),"RECORD NOT INSERTED!!");
					/**/
					Statement st=conn.createStatement(); 
					String str2="select * from menu";
					ResultSet rs2=st.executeQuery(str2);int i=0;
					while(rs2.next())
					{
						int j=0;
						row[i][j]=rs2.getInt(1);
						j++;
						row[i][j]=rs2.getInt(2);
						j++;
						row[i][j]=rs2.getString(3);
						j++;
						row[i][j]=rs2.getInt(4);
						j++;
						i++;
					}
					table.setModel(new DefaultTableModel(
							row,
							new   String[] {
								"PRODUCT ID", "CATEGORY ID", "PRODUCT NAME", "PRICE"
							}
						));
					/**/
					
					
					
					
					
					
				}catch(Exception ex )
				{
					ex.printStackTrace();
				}
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(488, 71, 105, 30);
		contentPane.add(btnNewButton);
		
	final JButton btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnNewButton_1)
			{	
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/project","root","nikita");
			int k=table.getSelectedRow();
			String option=table.getValueAt(k,2).toString();
			String str="delete from menu where product_name ='"+ option+"'";
			
			Statement st=conn.createStatement();
			if(st.executeUpdate(str)==1)
				JOptionPane.showMessageDialog(getContentPane(),"RECORD DELETED");
			else
				JOptionPane.showMessageDialog(getContentPane(),"RECORD NOT DELETED");
			Statement st2=conn.createStatement(); 
			String str2="select * from menu";
			ResultSet rs2=st2.executeQuery(str2);int i=0;
			while(rs2.next())
			{
				int j=0;
				row2[i][j]=rs2.getInt(1);
				j++;
				row2[i][j]=rs2.getInt(2);
				j++;
				row2[i][j]=rs2.getString(3);
				j++;
				row2[i][j]=rs2.getInt(4);
				j++;
				i++;
			}
			table.setModel(new DefaultTableModel(
					row2,
					new   String[] {
						"PRODUCT ID", "CATEGORY ID", "PRODUCT NAME", "PRICE"
					}
				));
			
			}
			catch(Exception ex)
			{
			ex.printStackTrace();
			}
		
			}
		}});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(492, 130, 105, 30);
		contentPane.add(btnNewButton_1);		 
		
		final JButton btnNewButton_2 = new JButton("UPDATE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton_2)
				{
					++count;
					if(count==1)
					{
						
						int i=table.getSelectedRow();
						int c_id=Integer.parseInt(table.getValueAt(i, 1).toString());
						String Name=table.getValueAt(i, 2).toString(); 
						int price=Integer.parseInt(table.getValueAt(i, 3).toString());
						textField.setText(Name);//PRODUCT NAME
						textField_1.setText(String.valueOf(c_id));//PRODUCT CATEGORY(CATEGORY_ID)
						textField_2.setText(String.valueOf(price));//PRICE
						 name_2=textField.getText();
						 
					}
					else if(count==2)
					{
						try	
						{
					Class.forName("com.mysql.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/project","root","nikita");	
					String str2="update  menu set category_id="+Integer.parseInt(textField_1.getText())+",product_name='"+textField.getText()+"',price="+Integer.parseInt(textField_2.getText())+" where product_name='"+name_2+"'";
				Statement st=conn.createStatement();
				if(st.executeUpdate(str2)==1)
					JOptionPane.showMessageDialog(null,"UPDATE SUCCESSFUL");
				else JOptionPane.showMessageDialog(null,"UPDATE UNSUCCESSFUL");
				Statement st2=conn.createStatement(); 
				String str3="select * from menu";
				ResultSet rs2=st2.executeQuery(str3);int i=0;
				while(rs2.next())
				{
					int j=0;
					row[i][j]=rs2.getInt(1);
					j++;
					row[i][j]=rs2.getInt(2);
					j++;
					row[i][j]=rs2.getString(3);
					j++;
					row[i][j]=rs2.getInt(4);
					j++;
					i++;
				}
				table.setModel(new DefaultTableModel(
						row,
						new   String[] {
							"PRODUCT ID", "CATEGORY ID", "PRODUCT NAME", "PRICE"
						}
					));
						}
						catch(Exception ex){ex.printStackTrace();}
					}
				
					}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(492, 194, 102, 30);
		contentPane.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(172, 289, 153, 30);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblProductyName = new JLabel("PRODUCT  NAME");
		lblProductyName.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductyName.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProductyName.setBounds(10, 292, 136, 22);
		contentPane.add(lblProductyName);
		
		JLabel lblProductCategory = new JLabel("PRODUCT  CATEGORY");
		lblProductCategory.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductCategory.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblProductCategory.setBounds(10, 341, 136, 22);
		contentPane.add(lblProductCategory);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(172, 343, 153, 30);
		contentPane.add(textField_1);
		
		JLabel lblPrice = new JLabel("PRICE");
		lblPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPrice.setBounds(358, 292, 136, 22);
		contentPane.add(lblPrice);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(466, 289, 153, 30);
		contentPane.add(textField_2);
		
	}
}
 