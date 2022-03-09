package tema;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class UpdateClienti extends JPanel {
	private JTextField numeAng;
	private JTextField prenumeAng;
	private JTextField cnpAng;
	private JTextField numeCautat;
	private JTextField prenumeCautat;

	/**
	 * Create the panel.
	 */
	public UpdateClienti() {
		setBounds(0, 0, 672, 477);
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nume");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(53, 125, 152, 29);
		add(lblNewLabel_1);
		
		numeAng = new JTextField();
		numeAng.setColumns(10);
		numeAng.setBounds(208, 125, 239, 29);
		add(numeAng);
		
		JLabel lblNewLabel_2 = new JLabel("Prenume");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(53, 164, 152, 29);
		add(lblNewLabel_2);
		
		prenumeAng = new JTextField();
		prenumeAng.setColumns(10);
		prenumeAng.setBounds(208, 164, 239, 29);
		add(prenumeAng);
		
		JLabel lblNewLabel_3 = new JLabel("CNP");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(53, 203, 152, 29);
		add(lblNewLabel_3);
		
		cnpAng = new JTextField();
		cnpAng.setColumns(10);
		cnpAng.setBounds(208, 203, 239, 29);
		add(cnpAng);
		
		JLabel lblNewLabel_4 = new JLabel("Sex");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(53, 242, 152, 29);
		add(lblNewLabel_4);
		
		JComboBox comboBox_Sex = new JComboBox();
		comboBox_Sex.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		comboBox_Sex.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_Sex.setBounds(208, 242, 239, 29);
		add(comboBox_Sex);
		
		JLabel lblNewLabel_5 = new JLabel("Card Fidelitate");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(53, 281, 152, 35);
		add(lblNewLabel_5);
		
		JComboBox comboBox_CF = new JComboBox();
		comboBox_CF.setModel(new DefaultComboBoxModel(new String[] {"Y", "N"}));
		comboBox_CF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_CF.setBounds(208, 281, 239, 29);
		add(comboBox_CF);
		
		JPanel update = new JPanel();
		update.addMouseListener(new PanelButtonMouseAdapter(update) {
			@Override
			public void mouseClicked(MouseEvent e) {
				String numeSearch = numeCautat.getText();
				String prenumeSearch = prenumeCautat.getText();
				String nume = numeAng.getText();
				String prenume = prenumeAng.getText();
				String cnp = cnpAng.getText();
				String sex = (String) comboBox_Sex.getSelectedItem();
				String cardFidelitate = (String) comboBox_CF.getSelectedItem();
				numeAng.setText("");
				prenumeAng.setText("");
				numeCautat.setText("");
				prenumeCautat.setText("");
				cnpAng.setText("");
				//conectare la baza de date
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String connectionUrl = "jdbc:jtds:sqlserver://ASUSVIVOBOOKS14; instanceName=SQLEXPRESS;databaseName=Companie_Cosmetice_Columbu-George;integratedSecurity=true";
				try{
					//Conexiune pentru cautare
					Connection con = DriverManager.getConnection(connectionUrl); 
					Statement stmt = con.createStatement();
					String select = "Select * from Client";
					ResultSet rs = stmt.executeQuery(select);
					int aux = 0;
					while(rs.next()) {
						if(numeSearch.equals(rs.getString("Nume"))&&prenumeSearch.equals(rs.getString("Prenume"))) {
							aux = 1;
						}
					}
					con.close();
					//CLIENT GASIT
					if(aux == 1) {
						//Update Nume
						Connection con1 = DriverManager.getConnection(connectionUrl); 
						Statement s1 = con1.createStatement();
						if(!nume.isEmpty()) {
							String query = "Update Client Set Nume = ('" + nume +"')"
											+ "where nume = ('" + numeSearch +"') and prenume = ('" + prenumeSearch +"')";
							s1.executeUpdate(query);
							numeSearch = nume;
						}
						con1.close();
						s1.close();
						//Update Prenume
						Connection con2 = DriverManager.getConnection(connectionUrl); 
						Statement s2 = con2.createStatement();
						if(!prenume.isEmpty()) {
							String query = "Update Client Set Prenume = ('" + prenume +"')"
											+ "where nume = ('" + numeSearch +"') and prenume = ('" + prenumeSearch +"')";
							s2.executeUpdate(query);
							prenumeSearch = prenume;
						}
						con2.close();
						s2.close();
						//Update CNP
						Connection con3 = DriverManager.getConnection(connectionUrl); 
						Statement s3 = con3.createStatement();
						if(!cnp.isEmpty()) {
							String query = "Update Client Set CNP = ('" + cnp +"')"
											+ "where nume = ('" + numeSearch +"') and prenume = ('" + prenumeSearch +"')";
							s3.executeUpdate(query);
						}
						con3.close();
						s3.close();
						//Update Sex
						Connection con4 = DriverManager.getConnection(connectionUrl); 
						Statement s4 = con4.createStatement();
						if(!sex.isEmpty()) {
							String query = "Update Client Set Sex = ('" + sex +"')"
											+ "where nume = ('" + numeSearch +"') and prenume = ('" + prenumeSearch +"')";
							s4.executeUpdate(query);
						}
						con4.close();
						s4.close();
						//Update card fidelitate
						Connection con5 = DriverManager.getConnection(connectionUrl); 
						Statement s5 = con5.createStatement();
						if(!cardFidelitate.isEmpty()) {
							String query = "Update Client Set Card_Fidelitate = ('" + cardFidelitate +"')"
											+ "where nume = ('" + numeSearch +"') and prenume = ('" + prenumeSearch +"')";
							s5.executeUpdate(query);
						}
						con5.close();
						s5.close();
						JOptionPane.showMessageDialog(Home.frame, "Clientul cautat a fost actualizat cu succes!");
					}
					//CLIENTUL NU A FOST GASIT
					else {
						JOptionPane.showMessageDialog(Home.frame, "Clientul cautat nu a fost gasit in baza de date!");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		update.setLayout(null);
		update.setBounds(174, 419, 308, 48);
		add(update);
		
		JLabel lblUpdate = new JLabel("Update");
		lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblUpdate.setBounds(41, 10, 231, 35);
		update.add(lblUpdate);
		
		JLabel lblUpdateClient = new JLabel("Update Client");
		lblUpdateClient.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateClient.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblUpdateClient.setBounds(49, 10, 574, 53);
		add(lblUpdateClient);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Nume");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(38, 73, 81, 28);
		add(lblNewLabel_1_1_1_1);
		
		numeCautat = new JTextField();
		numeCautat.setColumns(10);
		numeCautat.setBounds(129, 73, 184, 28);
		add(numeCautat);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Prenume");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1.setBounds(323, 73, 81, 28);
		add(lblNewLabel_1_1_1_1_1);
		
		prenumeCautat = new JTextField();
		prenumeCautat.setColumns(10);
		prenumeCautat.setBounds(414, 73, 209, 28);
		add(prenumeCautat);
	}
	private class PanelButtonMouseAdapter extends MouseAdapter{
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(135, 206, 250));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(240, 240, 240));
		}
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(60, 179, 113));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(135, 206, 250));
		}
	}
}