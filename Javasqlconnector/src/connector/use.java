package connector;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
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
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;

public class use extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel lblNewLabel_3;
	
	private JTable table;
	
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					use frame = new use();
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
	public use() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 875, 525);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setForeground(Color.MAGENTA);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("From");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(273, 166, 78, 20);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(325, 169, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("To");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(283, 218, 78, 13);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(325, 217, 96, 19);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(325, 269, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		lblNewLabel_3 = new JLabel("Plan Your Journey");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel_3.setBounds(273, 79, 386, 50);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(523, 206, 119, 34);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(816, 327, -742, 138);
		contentPane.add(scrollPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(735, 443, -561, -89);
		contentPane.add(tabbedPane);
		
		table = new JTable();
		table.setBackground(Color.PINK);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBounds(162, 317, 530, 161);
		contentPane.add(table);
		
		lblNewLabel_2 = new JLabel("Date(yyyy-mm-dd)");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(172, 259, 143, 35);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_5 = new JLabel("number         From              To               date                  airways        arrival             departure      ");
		lblNewLabel_5.setBounds(185, 294, 556, 13);
		contentPane.add(lblNewLabel_5);
		
	
		
		JButton btnNewButton_1 = new JButton("LogOut");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				UserLogin p2=new UserLogin();
		    	p2.setVisible(true);
		    	p2.getContentPane().setLayout(null);
			}
		});
		btnNewButton_1.setBounds(715, 58, 85, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("BookNow");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				book frame = new book();
				frame.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(694, 206, 106, 31);
		contentPane.add(btnNewButton_2);
		
		
		
		btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String arrival = textField.getText();
                String departure = textField_1 .getText();
               String jdate = textField_2.getText();
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/example",
                        "root", "@Cj16724!");
                    DefaultTableModel model = new DefaultTableModel(new String[]{"number", "From_Station","To_Station", " Date","airways","arrival","departure","price"}, 0);
                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select*from flight where From_Station=? and To_Station=? and date=?");

                    st.setString(1, arrival);
                    st.setString(2, departure);
                    st.setString(3, jdate);
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
	}
}
