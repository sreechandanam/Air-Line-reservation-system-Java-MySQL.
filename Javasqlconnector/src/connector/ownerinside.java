package connector;

import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.border.CompoundBorder;
import javax.swing.JMenuBar;
import java.awt.Color;



public class ownerinside extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					ownerinside frame = new ownerinside();
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
	public ownerinside() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(450, 190, 795, 527);;
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 204, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBackground(new Color(102, 204, 204));
		table.setFillsViewportHeight(true);
		table.setColumnSelectionAllowed(true);
		table.setCellSelectionEnabled(true);
		table.setBorder(new CompoundBorder());
		table.setBounds(260, 107, 200, 161);
		contentPane.add(table);
		JButton btnNewButton_5 = new JButton("LogOut");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				UserLogin p2=new UserLogin();
		    	p2.setVisible(true);
		    	p2.getContentPane().setLayout(null);
			}
		});
		btnNewButton_5.setBounds(653, 67, 85, 21);
		contentPane.add(btnNewButton_5);
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(90, 20, 574, 22);
		contentPane.add(menuBar);
		
		JButton btnNewButton_1 = new JButton("Show flights");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		menuBar.add(btnNewButton_1);
		
		
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		flightlist frame = new flightlist();
        		frame.setVisible(true);
        		
			    
        		
        	}
        });
		
		JButton btnNewButton_2 = new JButton("Add Flight");
		menuBar.add(btnNewButton_2);

        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                 dispose();        		
        		addflight frame = new addflight();
				frame.setVisible(true);
				
        	}
        });
		
		JButton btnNewButton = new JButton("Show account holders");
		menuBar.add(btnNewButton);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnNewButton_4 = new JButton("Add Seats");
		menuBar.add(btnNewButton_4);
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnNewButton_4.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		addseats frame = new addseats();
        		frame.setVisible(true);
        		
			    
        		
        	}
        });
		JButton btnNewButton_3 = new JButton("Delete Flight");
		menuBar.add(btnNewButton_3);
		
		 btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
	        btnNewButton_3.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		dispose();
	        		deleteflight frame = new deleteflight();
					frame.setVisible(true);
	        		
	        	}
	        });
		
		btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/example",
                        "root", "@Cj16724!");
                    DefaultTableModel model = new DefaultTableModel(new String[]{"name"}, 0);
                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select*from account_holders");

                   
                    ResultSet rs = st.executeQuery();
                 
                    if(rs.next() == false) {
                    	JOptionPane.showMessageDialog(btnNewButton, "No Data found");	
                    	 model.addRow(new Object[]{0});
                         table.setModel(model);
                    }
                    do
                    {
                    	
                        String n = rs.getString("name");
                       
                        model.addRow(new Object[]{n});
                        table.setModel(model);
                      
                    }while(rs.next()== true);
                    
                } catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                    
                }
            }
        });
	}
}
