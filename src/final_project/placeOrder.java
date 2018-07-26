package final_project;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Choice;
import java.awt.Color;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import java.awt.List;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.DriverManager;
import java.sql.*;
public class placeOrder extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	String ch,order;int cost,list_1;
	final JComboBox comboBox; 

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					placeOrder frame = new placeOrder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		public placeOrder() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 606);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlaceOrder = new JLabel("ORDERS");
		lblPlaceOrder.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlaceOrder.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPlaceOrder.setBounds(179, 11, 349, 28);
		contentPane.add(lblPlaceOrder);
		
		JLabel lblChooseFromThe = new JLabel("Choose from the categories mentioned below.");
		lblChooseFromThe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChooseFromThe.setBounds(64, 67, 399, 17);
		contentPane.add(lblChooseFromThe);
		
		final Choice choice = new Choice();
		choice.setBackground(Color.PINK);
		choice.setBounds(64, 106, 209, 55);
		contentPane.add(choice);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/project","root","nikita");
			String str="select category_name from category";
			Statement st=conn.createStatement(); 
			ResultSet rs=st.executeQuery(str);
			while(rs.next())
			{
				choice.addItem(rs.getString(1));
			}
		}
		//added categories in choice
		catch(Exception exc){exc.printStackTrace();}
		comboBox= new JComboBox();
		comboBox.setBounds(64, 191, 147, 37);
		contentPane.add(comboBox);	
		
		JLabel lblChooseFromThe_1 = new JLabel("Choose from the menu items mentioned below.");
		lblChooseFromThe_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblChooseFromThe_1.setBounds(64, 153, 399, 17);
		contentPane.add(lblChooseFromThe_1);
	
		final JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnOk)
				{
					 ch=choice.getSelectedItem();
					 int var=0;
						try
						{
							Class.forName("com.mysql.jdbc.Driver");
							Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/project","root","nikita");
							Statement st=conn.createStatement();	
						ResultSet rs2=st.executeQuery("select * from category where category_name='"+ch+"'");
						rs2.next();
						var=rs2.getInt(1);//1st column category_id
						System.out.println(var);
						ResultSet rs3=st.executeQuery("select PRODUCT_NAME from menu where CATEGORY_ID="+var);
						while(rs3.next())
						{
							comboBox.addItem(rs3.getString(1));
						}
			
						}
						catch(Exception ex)
						{
							System.out.println(ex);
						}
					
				}
			}
		});	

		btnOk.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnOk.setBounds(392, 103, 89, 23);
		contentPane.add(btnOk);
		textField = new JTextField();
		textField.setBounds(227, 275, 187, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		final JButton button = new JButton("OK");
		button.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
				if(e.getSource()==button)
				{
				Object order_item=comboBox.getItemAt(comboBox.getSelectedIndex());
				order=order_item.toString();//check 
				textField.setText(order);//set name of the selected menu item				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/project","root","nikita");
					Statement st=conn.createStatement();
					ResultSet rs4=st.executeQuery("select price from menu where product_name='"+textField.getText()+"'");
					rs4.next();
					textField_3.setText(String.valueOf(rs4.getInt(1)));
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				}		 
			}
		});
	
		button.setFont(new Font("Tahoma", Font.BOLD, 14));
		button.setBounds(392, 198, 89, 23);
		contentPane.add(button);
		
		JLabel lblSelectedItem = new JLabel("SELECTED ITEM:\r\n");
		lblSelectedItem.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSelectedItem.setBounds(59, 281, 129, 14);
		contentPane.add(lblSelectedItem);
		
		JLabel lblQuantity = new JLabel("QUANTITY:");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblQuantity.setBounds(59, 323, 129, 14);
		contentPane.add(lblQuantity);
		
		JLabel lblAmount = new JLabel("TOTAL AMOUNT :");
		lblAmount.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAmount.setBounds(184, 442, 129, 14);
		contentPane.add(lblAmount);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(347, 430, 155, 42);
		contentPane.add(textField_1);
		
	final List list = new List();
		list.setBounds(227, 309, 76, 28);
		contentPane.add(list);
		for(int i=0;i<10;i++)
			list.addItem(String.valueOf(i+1));
		
	final	JButton btnDone = new JButton("DONE");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==btnDone)
				{
					list_1=(list.getSelectedIndex()+1);
					textField_1.setText(String.valueOf(list_1*Integer.parseInt(textField_3.getText())));
				}
			}
		});
		btnDone.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDone.setBounds(288, 374, 111, 23);
		contentPane.add(btnDone);

		
		
		//OK
			
		
		
		
		
		
		
	/**/
	    final	JButton btnPlaceOrder = new JButton("PLACE ORDER");  
		btnPlaceOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				if(e.getSource()==btnPlaceOrder)
				{
				try
				{		
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/project","root","nikita");
					Statement st=conn.createStatement();
						int i=st.executeUpdate("insert into order_final (PRODUCT_NAME,PRICE) values ('"+order+"','"+Integer.parseInt(textField_1.getText())+"')");				
                    	if(i==1)
                    		JOptionPane.showMessageDialog(getContentPane(),"ORDER PLACED");	
                    	else 
                    		JOptionPane.showMessageDialog(getContentPane(),"ORDER NOT PLACED");
						
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				//for multiple orders
				int input=JOptionPane.showOptionDialog(getContentPane(),"WANT TO ORDER MORE?","ORDERS",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null, null,null);
				if(input==JOptionPane.YES_OPTION)
				{
					placeOrder po2=new placeOrder();
					po2.show();
				}
				if(input==JOptionPane.NO_OPTION)
				{
					//THEN DISPLAY THE BILL
					Bill bill=new Bill();
					bill.show();
				}
				}
			}
		});
		
		btnPlaceOrder.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnPlaceOrder.setBounds(268, 518, 146, 23);
		contentPane.add(btnPlaceOrder);
		
		JLabel lblPriceone = new JLabel("PRICE(ONE):");
		lblPriceone.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPriceone.setBounds(373, 314, 129, 14);
		contentPane.add(lblPriceone);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(476, 309, 89, 28);
		contentPane.add(textField_3);
	
     
	}
}

//DO CHANGES IN UPDATION 