package final_project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*; 
public class PersonalDetails extends JFrame  {

	 String choice;
	private JPanel contentPane;
	JRadioButton rdbtnNewRadioButton;
	JRadioButton rdbtnNewRadioButton_1;
	/*public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getItem()==rdbtnNewRadioButton)
			choice=rdbtnNewRadioButton.getActionCommand();
			//System.out.println("CHOICE="+choice);
		if(e.getItem()==rdbtnNewRadioButton_1)
			choice=rdbtnNewRadioButton_1.getActionCommand();//System.out.println("CHOICE="+choice);
			
	}*/

	public JTextField textField;
	public JTextField textField_1;
   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonalDetails frame = new PersonalDetails();
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
	public PersonalDetails() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("PERSONAL DETAILS");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 22));
		label.setBounds(158, 11, 272, 39);
		contentPane.add(label);
		
		JLabel lblName = new JLabel("NAME");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(72, 109, 101, 22);
		contentPane.add(lblName);
		
		JLabel label_3 = new JLabel("MOBILE NO.");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(82, 147, 101, 22);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("GENDER");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(72, 192, 101, 22);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("ADDRESS");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(72, 225, 101, 22);
		contentPane.add(label_5);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(255, 105, 175, 34);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(255, 143, 175, 34);
		contentPane.add(textField_1);
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(255, 226, 175, 69);
		contentPane.add(textArea);
		
		rdbtnNewRadioButton = new JRadioButton("MALE");


		rdbtnNewRadioButton.setBounds(255, 194, 70, 23);
		contentPane.add(rdbtnNewRadioButton);
		
		rdbtnNewRadioButton_1 = new JRadioButton("FEMALE");
		rdbtnNewRadioButton_1.setBounds(343, 194, 126, 23);
		contentPane.add(rdbtnNewRadioButton_1);
		ButtonGroup bg1=new ButtonGroup();
		bg1.add(rdbtnNewRadioButton);bg1.add(rdbtnNewRadioButton_1);
		
		
        final JButton btnSubmit = new JButton("SUBMIT");
        btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnSubmit.setBounds(261, 332, 132, 23);
        contentPane.add(btnSubmit);

        btnSubmit.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		   if(e.getSource()==btnSubmit)
		   {
			   /**/
			   if(rdbtnNewRadioButton_1.isSelected())
			   {
				   choice=rdbtnNewRadioButton_1.getText();
			   }
			   else if(rdbtnNewRadioButton.isSelected())
			   {
				   choice=rdbtnNewRadioButton.getText();
			   }
			   /**/
			   try
			   {
			 	  
			 	Class.forName("com.mysql.jdbc.Driver");
			 	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3307/project","root","nikita");
			 	String str="insert into customer (name,mobile,gender,address) values ('"+textField.getText()+"','"+textField_1.getText()+"','"+choice+"','"+textArea.getText()+"')";
			    Statement st=conn.createStatement();
			    int i=st.executeUpdate(str);
			    if(i==1)
			    {
			 	JOptionPane.showMessageDialog(getContentPane(),"RECORD INSERTED");
			 	}
			    else
			    {JOptionPane.showMessageDialog(getContentPane(),"RECORD NOT INSERTED");
			    }
			   }
			   catch(Exception ex)
			    {
			 	ex.printStackTrace();
			    }
			Menu_options menu_c=new Menu_options();
			menu_c.show();
	       }
	}
});
	}
}
