package connector;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.SystemColor;

public class book extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table_1;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					book frame = new book();
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
	public book() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 794, 523);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BookNow");
		lblNewLabel.setFont(new Font("Snap ITC", Font.PLAIN, 28));
		lblNewLabel.setBounds(292, 10, 204, 52);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Flight Number");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(179, 64, 130, 30);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(302, 72, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Find Flight");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(302, 119, 106, 21);
		contentPane.add(btnNewButton);
		JTable table = new JTable();
		table.setBackground(SystemColor.control);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBounds(74, 139, 562, 32);
		contentPane.add(table);
		
		JButton btnNewButton_1 = new JButton("LogOut");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(622, 33, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(164, 225, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(256, 224, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Number Of Seats");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(132, 283, 244, 13);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(266, 282, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel();
		lblNewLabel_5.setBounds(132, 372, 487, 13);
		contentPane.add(lblNewLabel_5);
          		
		
		
		
		JButton btnNewButton_2 = new JButton("Caluclate Fare");
		btnNewButton_2.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				
			
				 int number=Integer.parseInt(textField_2.getText());
				 String name = textField_1.getText();
				 String flightnumber = textField.getText();
				 String nos = textField_2.getText();
				 String price = textField_4.getText();
				 try {    
              if (number !=0) {
                
                     
                     lblNewLabel_5.setText("Mr/Ms"+name+"Your have sucessfully booked the ticket");
                     
                     Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/example",
                             "root", "@Cj16724!");
                         
                         PreparedStatement st = (PreparedStatement) connection
                             .prepareStatement("insert into pricelist values(?,?,?,?,?*?)");
                         
                         st.setString(1,name);
                         st.setString(2,flightnumber);
                         st.setString(3, nos);
                         st.setString(4, price);
                         st.setString(5, nos);
                         st.setString(6, price);
                         st.executeUpdate();
                         
                    
              }
          	
				 }
				
                    
                catch(Exception a){
                    JOptionPane.showMessageDialog(null, "Wrong input, must be numeric", "Error",JOptionPane.ERROR_MESSAGE);
                }

            }
        });
		
		btnNewButton_2.setBounds(438, 250, 106, 21);
		contentPane.add(btnNewButton_2);
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				UserLogin p2=new UserLogin();
		    	p2.setVisible(true);
		    	p2.getContentPane().setLayout(null);
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String flightnumber = textField.getText();
                
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/example",
                        "root", "@Cj16724!");
                    DefaultTableModel model = new DefaultTableModel(new String[]{"number", "From_Station","To_Station", " Date","airways","arrival","departure","price"}, 0);
                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select*from flight where flight_designator=?");

                    st.setString(1, flightnumber);
                    
                    ResultSet rs = st.executeQuery();
                 
                    if(rs.next() == false) {
                    	JOptionPane.showMessageDialog(btnNewButton, "No Data found");	
                    	 model.addRow(new Object[]{0,0,0,0,0,0,0,0});
                         table.setModel(model);
                    }
                    do
                    {
                    	
                        String n = rs.getString("flight_designator");
                        String a = rs.getString("From_Station");
                        String d = rs.getString("To_Station");
                        String dd = rs.getString("date");
                        String l = rs.getString("air_line");
                        String ar = rs.getString("arrival");
                        String dep = rs.getString("departure");
                        String pri = rs.getString("price");
                        model.addRow(new Object[]{n,a,d,dd,l,ar,dep,pri});
                        table.setModel(model);
                      
                    }while(rs.next()== true);
                    
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                    
                }
            }
        });
		
		btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String flightnumber = textField.getText();
                
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/example",
                        "root", "@Cj16724!");
                    DefaultTableModel model = new DefaultTableModel(new String[]{"seats", "status"}, 0);
                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select seats,status from seats where flight_no="+flightnumber);

                   
                    
                    ResultSet rs = st.executeQuery();
                 
                    if(rs.next() == false) {
                    	JOptionPane.showMessageDialog(btnNewButton, "No Data found");	
                    	 model.addRow(new Object[]{0,0});
                         table.setModel(model);
                    }
                    do
                    {
                    	
                        String sn = rs.getString("seats");
                        String sta = rs.getString("status");
                        
                        
                        model.addRow(new Object[]{sn,sta});
                        table_1.setModel(model);
                      
                    }while(rs.next()== true);
                    
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                    
                }
            }
        });

		
JButton btnNewButton_4 = new JButton("Book");
btnNewButton_4.setBounds(448, 281, 85, 21);
contentPane.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String no = textField_3.getText();
                String flightname = textField.getText();
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/example",
                        "root", "@Cj16724!");
                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement(" update "+"seats"+  " set status = 'B' where flight_no = ? and  seats=?" );
                    st.setString(1,flightname);
                    st.setString(2, no);
                    
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(btnNewButton, "BOOKED ");
                    
                   
                    
                } catch (SQLException sqlException) {
                	JOptionPane.showMessageDialog(btnNewButton, "Already booked");
                    
                }
            }
        });
		btnNewButton.setBounds(236, 181, 85, 21);
		contentPane.add(btnNewButton);
		
		textField_3 = new JTextField();
		textField_3.setBounds(266, 253, 96, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Seat no");
		lblNewLabel_4.setBounds(164, 260, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		table_1 = new JTable();
		table_1.setBackground(SystemColor.control);
		table_1.setBounds(667, 139, 85, 337);
		contentPane.add(table_1);
		
		JLabel lblNewLabel_6 = new JLabel("Seat Availability");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(667, 116, 113, 13);
		contentPane.add(lblNewLabel_6);
		
		textField_4 = new JTextField();
		textField_4.setBounds(256, 319, 96, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Price");
		lblNewLabel_7.setBounds(164, 325, 45, 13);
		contentPane.add(lblNewLabel_7);
		
		JButton btnNewButton_3 = new JButton("Print Ticket");
		btnNewButton_3.setBounds(317, 431, 85, 21);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() { 
		    public void actionPerformed(ActionEvent e) { 
		    	
		    	ticket p2=new ticket();
		    	p2.setVisible(true);
		    	p2.setLayout(null);
		    	
		    } 
		

            
		
		});	
	}
}
