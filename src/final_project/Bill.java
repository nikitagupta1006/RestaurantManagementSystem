package final_project;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextArea;

public class Bill extends JFrame
{

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JLabel lblCustomerName;
	private JLabel lblMobile;
	private JTextField textField_1;
	private JTextField textField_2;
	Object data[][]=new Object[100][2];
	private JButton btnNewButton;
	private JLabel lblGender;
	private JLabel lblAddress;
	private JTextField textField_3;int sum=0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bill frame = new Bill();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Bill() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 618, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 183, 400, 161);
		contentPane.add(scrollPane);	
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
		data,
			new String[] {
				"PRODUCT_NAME", "PRICE"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(237);
		//table and scrollPane inserted
		try
		{
			//DISPLAY DATA FROM ORDER FINAL TABLE
			Class.forName("com.mysql.jdbc.Driver");
		    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/project","root","nikita");
		    int i=0;
		    Statement st=conn.createStatement();
		   // ResultSet rs=st.executeQuery("select * from order_final where name='"+textField_1.getText()+"' and payment_status='NOT PAID'");
		    ResultSet rs=st.executeQuery("select * from order_final");
		    while(rs.next())
		    {
		    	data[i][0]=rs.getString(2);
                data[i][1]=rs.getInt(3);
		    	i++;
		    }

		    table.setModel(new DefaultTableModel(
		    		data,new String[] { "PRODUCT_NAME", "PRICE"}));
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		//data entered into JTable
		JLabel lblTotalAmount = new JLabel("TOTAL AMOUNT:");
		lblTotalAmount.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalAmount.setBounds(81, 415, 164, 14);
		contentPane.add(lblTotalAmount);
		
		textField = new JTextField(" ");
		textField.setBounds(274, 402, 134, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/project","root","nikita");
			Statement st=conn.createStatement();
			String str="select PRICE from order_final";
			ResultSet rs=st.executeQuery(str);
			while(rs.next())
			{
				sum=sum+Integer.parseInt(rs.getString(1));
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		textField.setText(String.valueOf(sum));
		lblCustomerName = new JLabel("CUSTOMER NAME:");
		lblCustomerName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCustomerName.setBounds(27, 26, 170, 27);
		contentPane.add(lblCustomerName);
		
		lblMobile = new JLabel("MOBILE:");
		lblMobile.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMobile.setBounds(27, 52, 170, 27);
		contentPane.add(lblMobile);
		
		textField_1 = new JTextField();
		textField_1.setBounds(187, 11, 144, 34);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(187, 52, 144, 27);
		contentPane.add(textField_2);
		
		btnNewButton = new JButton("PAY");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnNewButton)
				{
					textField.setText(String.valueOf(sum));
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/project","root","nikita");
						Statement st=conn.createStatement();
						ResultSet rs=st.executeQuery("select customer_id from customer");int i=0;
						while(rs.next())
						{
						 i=rs.getInt(1);	    
						}
						String str="update customer set payment_status='PAID' where customer_id= "+i;
						int j=st.executeUpdate(str);
						if(j==1)
							JOptionPane.showMessageDialog(getContentPane(),"PAYMENT SUCCESSFUL");
						else 
							JOptionPane.showMessageDialog(getContentPane(),"PAYMENT UNSUCCESSFUL");
						
						String str2="delete from order_final";
				/*		int k=st.executeUpdate(str2);
						if(k==1)
							System.out.println("CLEARING OF DATA SUCCESSFUL");
						else
							System.out.println("CLEARING OF DATA UNSUCCESSFUL");*/
					}
					catch(Exception ex )
					{
						ex.printStackTrace();
					}
					
					System.exit(0);
				}
				
			}
		});
		btnNewButton.setBounds(187, 361, 89, 23);
		contentPane.add(btnNewButton);
		
		lblGender = new JLabel("GENDER:");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGender.setBounds(27, 90, 170, 27);
		contentPane.add(lblGender);
		
		lblAddress = new JLabel("ADDRESS:");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddress.setBounds(27, 117, 170, 27);
		contentPane.add(lblAddress);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(187, 90, 144, 27);
		contentPane.add(textField_3);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(187, 128, 144, 49);
		contentPane.add(textArea);
		
		try
		{
			
			Class.forName("com.mysql.jdbc.Driver");
		 	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/project","root","nikita");
			Statement st=conn.createStatement();
		 	ResultSet rs=st.executeQuery("select * from customer");
		 	int i=0;
		 	while(rs.next())
		 	{
		 		i=rs.getInt(1);
		 	}
		 	ResultSet rs2=st.executeQuery("select * from customer where customer_id="+i);
		 	rs2.next();
		 	textField_1.setText(rs2.getString(2));
		 	textField_2.setText(rs2.getString(3));
		 	textField_3.setText(rs2.getString(4));
		 	textArea.setText(rs2.getString(5));
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
}
