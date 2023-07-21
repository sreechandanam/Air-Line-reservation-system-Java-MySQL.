package connector;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;

public class deleteflight extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteflight frame = new deleteflight();
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
	public deleteflight() {
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 751, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(340, 97, 115, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Flight Number");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(210, 100, 137, 16);
		contentPane.add(lblNewLabel);
		JButton btnNewButton_1 = new JButton("\u21AA");
		btnNewButton_1.setBounds(648, 35, 45, 32);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				dispose();
				ownerinside frame = new ownerinside();
				frame.setVisible(true);
				
			}
			
		});
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setBounds(356, 170, 85, 21);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String flight_designator = textField.getText();
                
                

                
                try {
                    
                	Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/example",
                            "root", "@Cj16724!");
                	PreparedStatement sql = (PreparedStatement) connection
                            .prepareStatement("Select* from flight where flight_designator=?");
                	sql.setString(1, flight_designator);
                	ResultSet rs = sql.executeQuery();
                	
                	if(rs.next()) {
                		
                	
                    PreparedStatement st = (PreparedStatement) connection
                            .prepareStatement("delete from   flight where flight_designator=?");
                        st.setString(1,flight_designator );
                    
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(btnNewButton, "Flight deleted sucessfully ");
                    
                    
                        
                    }
                	else {
                		JOptionPane.showMessageDialog(btnNewButton, "No flight found ");
                	}
                    
                }
                    
                 catch (SQLException sqlException) {
                	
                	
                    
                }
            }
        });
	}


	
	}

