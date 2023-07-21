package connector;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.ImageIcon;

public class owner extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					owner frame = new owner();
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
	public owner() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 761, 549);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Owner login");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(312, 10, 308, 128);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("OwnerId");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(213, 194, 131, 26);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(306, 200, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(225, 255, 71, 26);
		contentPane.add(lblNewLabel_2);
		
		 JButton btnNewButton = new JButton("Login");
	        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
	        btnNewButton.setBounds(312, 356, 102, 50);
	        btnNewButton.addActionListener(new ActionListener() {

	            public void actionPerformed(ActionEvent e) {
	                String id = textField.getText();
	                @SuppressWarnings("deprecation")
					String password = passwordField.getText();
	                try {
	                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/example",
	                        "root", "@Cj16724!");

	                    PreparedStatement st = (PreparedStatement) connection
	                        .prepareStatement("Select id, password from owner where id=? and password=?");

	                    st.setString(1, id);
	                    st.setString(2, password);
	                    ResultSet rs = st.executeQuery();
	                    if (rs.next()) {
	                        dispose();
	                         owner ah = new owner ();
	                        ah.setTitle("Welcome");
	                        ah.setVisible(true);
	                        JOptionPane.showMessageDialog(btnNewButton, "You have successfully logged in");
	                        ah.dispose();
	                        ownerinside frame = new ownerinside();
	    					frame.setVisible(true);
	                    } else  {
	                    	
	                        JOptionPane.showMessageDialog(btnNewButton, "Wrong Username & Password");
	                        
	                    }
	                } catch (SQLException sqlException) {
	                    sqlException.printStackTrace();
	                }
	            }
	        });

	        contentPane.add(btnNewButton);
	        
	        passwordField = new JPasswordField();
	        passwordField.setBounds(312, 261, 96, 19);
	        contentPane.add(passwordField);
	        
	        JLabel lblNewLabel_3 = new JLabel("New label");
	        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Dell\\OneDrive\\Desktop\\fligt.jpg"));
	        lblNewLabel_3.setBounds(-474, 10, 1221, 502);
	        contentPane.add(lblNewLabel_3);
	        
	}
}
