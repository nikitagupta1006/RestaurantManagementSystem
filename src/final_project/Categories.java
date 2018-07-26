package final_project;

//show database in jtable
//update feature
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.event.MenuListener;
import javax.swing.event.MenuEvent;
import javax.swing.JMenuItem;
import java.awt.Color;

public class Categories extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	Object data[][]=new Object[30][2];
	Object data2[][]=new Object[30][2]; int count=0;Object data3[][]=new Object[30][2];
	int cat_id=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Categories frame = new Categories();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Categories() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 640, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/project","root","nikita");
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select * from category");
		int i=0;
			while(rs.next())
			{
				data[i][0]=rs.getInt(1);
				data[i][1]=rs.getString(2);
				i++;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		final JButton btnInsert = new JButton("INSERT");
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnInsert)
				{
					if(textField.getText().equals(""))
					{
						JOptionPane.showMessageDialog(getContentPane(),"ENTER VALID CATEGORY NAME TO BE ENTERED!!");
					}
				    else
				    {
					try
					{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/project","root","nikita");
					String str="insert into category (category_name) values(?)";
					PreparedStatement pst=conn.prepareStatement(str);
					pst.setString(1,textField.getText());
					if(pst.executeUpdate()==1)
					JOptionPane.showMessageDialog(getContentPane(),"RECORD INSERTED");
					else
						JOptionPane.showMessageDialog(getContentPane(),"RECORD NOT INSERTED");
					Statement st=conn.createStatement();
					String str2="select * from category";
					ResultSet rs=st.executeQuery(str2);
					int i=0;
					while(rs.next())
					{
						data[i][0]=rs.getInt(1);
						data[i][1]=rs.getString(2);
						i++;
					}
					table.setModel(new DefaultTableModel(
							data,
						new String[] {
							"CATEGORY_ID", "CATEGORY_NAME"
						}
					));
					
					}
					catch(Exception ex){ex.printStackTrace();}}
				}
			}
		});
		btnInsert.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnInsert.setBounds(512, 61, 101, 31);
		contentPane.add(btnInsert);
		
		final JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnDelete)
				{
					
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
					    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/project","root","nikita");
					    Statement st=conn.createStatement();
					    int i=table.getSelectedRow();
					    String option =table.getValueAt(i, 1).toString();
					    String str3="select * from category where category_name='"+option+"'";
						ResultSet rs2=st.executeQuery(str3);
						rs2.next();
						int id=rs2.getInt(1);
						System.out.println("CATEGORY ID= "+id);
						String str="delete from category where category_name ='"+option+"'";
						int k=st.executeUpdate(str);
						String str2="delete from menu where category_id="+id;
						st.executeUpdate(str2);
						if(k==1)
							JOptionPane.showMessageDialog(getContentPane(),"DELETED FROM RECORDS ");
						else JOptionPane.showMessageDialog(getContentPane(),"NOT DELETED...ERROR OCCURED");
						String strr2="select * from category";
						Statement st2=conn.createStatement();
						ResultSet rs=st2.executeQuery(strr2);
						int j=0;
						while(rs.next())
						{
							data2[j][0]=rs.getInt(1);
							data2[j][1]=rs.getString(2);
							j++;
						}
						
						table.setModel(new DefaultTableModel(
								data2,
							new String[] {
								"CATEGORY_ID", "CATEGORY_NAME"
							}
						));
					}catch(Exception ex)
					{
						ex.printStackTrace();
					}
					}
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(512, 122, 101, 31);
		contentPane.add(btnDelete);
		
		final JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnUpdate)
				{
				  try
				  {
					Class.forName("com.mysql.jdbc.Driver");
				    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/project","root","nikita");
				    count++;
				    String s=null;
				    Statement st=conn.createStatement();
if(count==1)
{
	int row=table.getSelectedRow();
	textField.setText(table.getValueAt(row, 1).toString());
	s=textField.getText();
	cat_id=Integer.parseInt(table.getValueAt(row,0).toString());
	System.out.println("CATEGORY ID="+cat_id);
	System.out.println("STRING INPUT="+s);
}
else if(count==2)
{
	ResultSet rs=st.executeQuery("select * from category where category_id="+cat_id);
	 rs.next();
	int r2=rs.getInt(1);
	 String s2="update category set category_name='"+textField.getText()+"' where category_id="+r2;
	 int i=st.executeUpdate(s2);
	 if(i==1)
		 JOptionPane.showMessageDialog(getContentPane(),"UPDATE SUCCESSFUL");
	 else 
		 JOptionPane.showMessageDialog(getContentPane(),"UPDATE NOT SUCCESSFUL");
	 count=0;
}
					ResultSet rs=st.executeQuery("select * from category");
					int i=0;
						while(rs.next())
						{
							data3[i][0]=rs.getInt(1);
							data3[i][1]=rs.getString(2);
							i++;
						}
						table.setModel(new DefaultTableModel(
								data3,
							new String[] {
								"CATEGORY_ID", "CATEGORY_NAME"
							}	
						));
						
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
				}
				}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(512, 182, 101, 31);
		contentPane.add(btnUpdate);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 64, 461, 208);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				data,
			new String[] {
				"CATEGORY_ID", "CATEGORY_NAME"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(83);
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		menuBar.setBounds(0, 0, 644, 42);
		contentPane.add(menuBar);
		
		final JMenuItem mntmBack = new JMenuItem("BACK");
		mntmBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==mntmBack)
				{
				View_edit obj=new View_edit();
				obj.show();
				}
			}
		});
		menuBar.add(mntmBack);
		
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
		
		final JMenuItem mntmContactUs = new JMenuItem("CONTACT US");
		mntmContactUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==mntmContactUs )
				{
					ContactUs cu=new ContactUs();
					cu.show();
					
				}
			}
		});
		menuBar.add(mntmContactUs);
		
		JMenuItem mntmExit = new JMenuItem("EXIT");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuBar.add(mntmExit);
		
		JLabel lblCategoryName = new JLabel("CATEGORY NAME");
		lblCategoryName.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategoryName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCategoryName.setBounds(94, 321, 137, 31);
		contentPane.add(lblCategoryName);
		
		textField = new JTextField();
		textField.setBounds(275, 321, 170, 27);
		contentPane.add(textField);
		textField.setColumns(10);
	}

}

/* 
System.out.println("ROW="+row);
int cat_no=Integer.parseInt(table.getValueAt(row,0).toString());
System.out.println("CATEGORY_NUMBER="+cat_no);
String cat_name=table.getValueAt(row, 1).toString();
System.out.println("CATEGORY_NAME="+cat_name);
String str="update category set category_name= '"+ textField.getText()+"' where category_name='"+cat_name +"'";
Statement st=conn.createStatement();
	if(st.executeUpdate(str)==1)
	JOptionPane.showMessageDialog(getContentPane(),"RECORD UPDATED!!");
else
	JOptionPane.showMessageDialog(getContentPane(),"RECORD NOT UPDATED!!");

*/