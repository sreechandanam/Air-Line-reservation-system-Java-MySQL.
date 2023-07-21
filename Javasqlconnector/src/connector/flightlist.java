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
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class flightlist extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					flightlist frame = new flightlist();
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
	public flightlist() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 846, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Flights");
		btnNewButton.setBounds(374, 10, 85, 21);
		contentPane.add(btnNewButton);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(791, 62, 17, 48);
		contentPane.add(scrollBar);
		JButton btnNewButton_1 = new JButton("\u21AA");
		btnNewButton_1.setBounds(721, 13, 45, 32);
		contentPane.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(84, 61, 580, 364);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		btnNewButton_1.addActionListener(new ActionListener() {

			
			public void actionPerformed(ActionEvent e) {
				dispose();
				ownerinside frame = new ownerinside();
				frame.setVisible(true);
				
			}
			
		});
		
		btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                
                try {
                    Connection connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/example",
                        "root", "@Cj16724!");
                    DefaultTableModel model = new DefaultTableModel(new String[]{"number", "From_Station","To_Station", " Date","airways","arrival","departure","price"}, 0);
                    PreparedStatement st = (PreparedStatement) connection
                        .prepareStatement("Select*from flight ");

                    
                    
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
