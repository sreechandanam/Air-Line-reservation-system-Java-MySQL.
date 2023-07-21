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

import java.sql.SQLException;

import javax.swing.JButton;

public class addflight extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addflight frame = new addflight();
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
	public addflight() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 484);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(334, 42, 115, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Flight Number");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(187, 41, 137, 20);
		contentPane.add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(334, 102, 115, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("From");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(223, 105, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(340, 163, 96, 19);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("To");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(223, 166, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(340, 267, 96, 19);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Date(yyyy-mm-dd)");
		lblNewLabel_3.setBounds(210, 270, 120, 13);
		contentPane.add(lblNewLabel_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(340, 315, 96, 19);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Air line");
		lblNewLabel_4.setBounds(210, 318, 45, 13);
		contentPane.add(lblNewLabel_4);
		
		textField_5 = new JTextField();
		textField_5.setBounds(340, 365, 96, 19);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Arrival");
		lblNewLabel_5.setBounds(223, 368, 45, 13);
		contentPane.add(lblNewLabel_5);
		
		textField_6 = new JTextField();
		textField_6.setBounds(340, 418, 96, 19);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Departure");
		lblNewLabel_6.setBounds(223, 421, 45, 13);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Add Flight");
		btnNewButton.setBounds(551, 235, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u21AA");
		btnNewButton_1.setBounds(648, 35, 45, 32);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_7 = new JLabel("Price");
		lblNewLabel_7.setBounds(488, 421, 45, 13);
		contentPane.add(lblNewLabel_7);
		
		textField_7 = new JTextField();
		textField_7.setBounds(551, 418, 96, 19);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		btnNewButton_1.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				dispose();
				ownerinside frame = new ownerinside();
				frame.setVisible(true);
				
			}
			
		});

		btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String flight_designator = textField.getText();
                String From = textField_1 .getText();
               String To = textField_2.getText();
               String Date = textField_3.getText();
               String airline = textField_4.getText();
               String arr = textField_5.getText();
               String dep = textField_6.getText();
               String pri = textField_7.getText();
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/example",
                        "root", "@Cj16724!");
                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("insert into  flight values(?,?,?,?,?,?,?,? )");

                    st.setString(1, flight_designator);
                    st.setString(2, From);
                    st.setString(3, To);
                    st.setString(4, Date);
                    st.setString(5, airline);
                    st.setString(6, arr);
                    st.setString(7,dep );
                    st.setString(8, pri);
                    st.executeUpdate();
                    JOptionPane.showMessageDialog(btnNewButton, "Flight added sucessfully ");
                    
                   
                    
                } catch (SQLException sqlException) {
                	sqlException.printStackTrace();

                	JOptionPane.showMessageDialog(btnNewButton, "Flight Number already exists");
                    
                }
            }
        });
	}
	}

