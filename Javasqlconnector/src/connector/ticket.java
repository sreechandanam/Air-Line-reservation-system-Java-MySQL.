package connector;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;

public class ticket extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel;
	private JButton btnNewButton_1;
	private JTextField textField_1;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ticket frame = new ticket();
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
	public ticket() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 417);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Print");
		btnNewButton.setBounds(150, 25, 85, 21);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(49, 26, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblNewLabel = new JLabel("Name      Flightnumber   nuberofseats    price/ticket      totalprice");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblNewLabel.setBounds(72, 56, 345, 13);
		contentPane.add(lblNewLabel);
		
		btnNewButton_1 = new JButton("Get Details");
		btnNewButton_1.setBounds(167, 147, 85, 21);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String flightnumber = textField_1.getText();
                
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
                         table_1.setModel(model);
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
                        table_1.setModel(model);
                      
                    }while(rs.next()== true);
                    
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                    
                }
            }
        });
		textField_1 = new JTextField();
		textField_1.setBounds(60, 148, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Passenger Name");
		lblNewLabel_1.setBounds(49, 10, 96, 13);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Flight number");
		lblNewLabel_2.setBounds(53, 125, 92, 13);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 71, 279, 44);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(49, 181, 509, 44);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		btnNewButton.addActionListener(new ActionListener() {
			 
            
            	public void actionPerformed(ActionEvent e) {
                    String name = textField.getText();
                    
                    try {
                        Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/example",
                            "root", "@Cj16724!");
                        DefaultTableModel model = new DefaultTableModel(new String[]{"name", "flight_no","seats", " price","totalfare"}, 0);
                        PreparedStatement st = (PreparedStatement) connection
                            .prepareStatement("Select*from pricelist where name=?");

                        st.setString(1, name);
                        
                        ResultSet rs = st.executeQuery();
                     
                        if(rs.next() == false) {
                        	JOptionPane.showMessageDialog(btnNewButton, "No Data found");	
                        	 model.addRow(new Object[]{0,0,0,0,0});
                             table.setModel(model);
                        }
                        do
                        {
                        	
                            String n = rs.getString("name");
                            String a = rs.getString("flight_no");
                            String d = rs.getString("seats");
                            String dd = rs.getString("price");
                          
                            String ar = rs.getString("totalfare");
                            
                            
                            model.addRow(new Object[]{n,a,d,dd,ar});
                            table.setModel(model);
                          
                        }while(rs.next()== true);
                        
                    } catch (SQLException sqlException) {
                        sqlException.printStackTrace();
                        
                    }
                }
            });
            }
	}


