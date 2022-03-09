package tema;

import java.awt.EventQueue;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.sql.*;

public class LoginPage{

	public static JFrame frame;
	private JTextField user;
	private JTextField textField_1;
	private JPasswordField pass;
	private static String password;
	private static String username;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.setBounds(100, 100, 700, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel Titlu = new JLabel("Aplicatie produse cosmetice");
		Titlu.setHorizontalTextPosition(SwingConstants.CENTER);
		Titlu.setHorizontalAlignment(SwingConstants.CENTER);
		Titlu.setFont(new Font("Verdana", Font.BOLD, 31));
		Titlu.setBounds(93, 22, 494, 57);
		frame.getContentPane().add(Titlu);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(118, 351, 94, 29);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(117, 401, 92, 29);
		frame.getContentPane().add(lblNewLabel_1);
		
		user = new JTextField();
		user.setBackground(new Color(211, 211, 211));
		user.setHorizontalAlignment(SwingConstants.LEFT);
		user.setFont(new Font("Tahoma", Font.PLAIN, 15));
		user.setBounds(222, 351, 305, 29);
		frame.getContentPane().add(user);
		user.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBounds(117, 287, 149, -7);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				username = user.getText();
				password = pass.getText();
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String connectionUrl = "jdbc:jtds:sqlserver://ASUSVIVOBOOKS14; instanceName=SQLEXPRESS;databaseName=Companie_Cosmetice_Columbu-George;integratedSecurity=true";
				try(Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();){
					String select = "select * from Utilizator";
					ResultSet rs = stmt.executeQuery(select);
					int aux = 0;
					while(rs.next()) {
						if(username.equals(rs.getString("userID")) && password.equals(rs.getString("password"))) {
							aux = 1;
							break;
						}
					}
					if(aux == 1) {
						Home paginaPrincipala = new Home();
						paginaPrincipala.frame.setVisible(true);
						LoginPage.frame.setVisible(false);
					}else {
						JOptionPane.showMessageDialog(frame, "Username or password invalid!");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(117, 455, 158, 34);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Refresh");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.setText("");
				pass.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_1.setBounds(370, 455, 157, 34);
		frame.getContentPane().add(btnNewButton_1);
		
		pass = new JPasswordField();
		pass.setBackground(new Color(211, 211, 211));
		pass.setHorizontalAlignment(SwingConstants.LEFT);
		pass.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pass.setBounds(222, 405, 305, 25);
		frame.getContentPane().add(pass);
		
		JLabel lblNewLabel_2 = new JLabel("Sign In");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 27));
		lblNewLabel_2.setBounds(250, 289, 167, 39);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel signInLogo = new JLabel("");
		signInLogo.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/person-icon.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		signInLogo.setIcon(new ImageIcon(img));
		signInLogo.setBounds(250, 175, 167, 124);
		frame.getContentPane().add(signInLogo);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(80, 122, 515, 483);
		frame.getContentPane().add(panel);
	}
}
