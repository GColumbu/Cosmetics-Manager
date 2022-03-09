package tema;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class UpdateAngajati extends JPanel {
	private JTextField numeSup;
	private JTextField numeLoc;
	private JTextField numeAng;
	private JTextField prenumeAng;
	private JTextField cnpAng;
	private JTextField salariuAng;
	private JTextField dataNasteriiAng;
	private JTextField dataAngajariiAng;
	private JTextField numeCautat;
	private JTextField prenumeCautat;

	/**
	 * Create the panel.
	 */
	public UpdateAngajati() {
		setBounds(0, 0, 672, 477);
		setLayout(null);
		
		JLabel lblUpdateAngajat = new JLabel("Update Angajat");
		lblUpdateAngajat.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateAngajat.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblUpdateAngajat.setBounds(50, 10, 574, 53);
		add(lblUpdateAngajat);
		
		numeSup = new JTextField();
		numeSup.setColumns(10);
		numeSup.setBounds(219, 114, 369, 28);
		add(numeSup);
		
		JLabel lblNewLabel_1 = new JLabel("Nume Supervisor");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(84, 111, 125, 28);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nume Locatie");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(84, 146, 125, 28);
		add(lblNewLabel_1_1);
		
		numeLoc = new JTextField();
		numeLoc.setColumns(10);
		numeLoc.setBounds(219, 146, 369, 28);
		add(numeLoc);
		
		numeAng = new JTextField();
		numeAng.setColumns(10);
		numeAng.setBounds(219, 179, 369, 28);
		add(numeAng);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Nume");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(84, 176, 125, 28);
		add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Prenume");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2.setBounds(84, 212, 125, 28);
		add(lblNewLabel_1_1_2);
		
		prenumeAng = new JTextField();
		prenumeAng.setColumns(10);
		prenumeAng.setBounds(219, 212, 369, 28);
		add(prenumeAng);
		
		cnpAng = new JTextField();
		cnpAng.setColumns(10);
		cnpAng.setBounds(219, 245, 369, 28);
		add(cnpAng);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("CNP");
		lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_1.setBounds(84, 245, 125, 28);
		add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_1_1_2_1_5 = new JLabel("Sex");
		lblNewLabel_1_1_2_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_1_5.setBounds(84, 279, 125, 28);
		add(lblNewLabel_1_1_2_1_5);
		
		JComboBox comboBox = new JComboBox(new Object[]{});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBounds(219, 279, 369, 27);
		add(comboBox);
		
		salariuAng = new JTextField();
		salariuAng.setColumns(10);
		salariuAng.setBounds(219, 312, 369, 28);
		add(salariuAng);
		
		JLabel lblNewLabel_1_1_2_1_6 = new JLabel("Salariu");
		lblNewLabel_1_1_2_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_1_6.setBounds(84, 312, 125, 28);
		add(lblNewLabel_1_1_2_1_6);
		
		JLabel lblNewLabel_1_1_2_1_6_1 = new JLabel("Data Nasterii");
		lblNewLabel_1_1_2_1_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1_6_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_1_6_1.setBounds(84, 345, 125, 28);
		add(lblNewLabel_1_1_2_1_6_1);
		
		dataNasteriiAng = new JTextField();
		dataNasteriiAng.setColumns(10);
		dataNasteriiAng.setBounds(219, 345, 369, 28);
		add(dataNasteriiAng);
		
		dataAngajariiAng = new JTextField();
		dataAngajariiAng.setColumns(10);
		dataAngajariiAng.setBounds(219, 379, 369, 28);
		add(dataAngajariiAng);
		
		JLabel lblNewLabel_1_1_2_1_6_2 = new JLabel("Data Angajarii");
		lblNewLabel_1_1_2_1_6_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1_6_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_1_6_2.setBounds(84, 379, 125, 28);
		add(lblNewLabel_1_1_2_1_6_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Nume");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(39, 73, 81, 28);
		add(lblNewLabel_1_1_1_1);
		
		numeCautat = new JTextField();
		numeCautat.setBounds(130, 73, 184, 28);
		add(numeCautat);
		numeCautat.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Prenume");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1_1.setBounds(324, 73, 81, 28);
		add(lblNewLabel_1_1_1_1_1);
		
		prenumeCautat = new JTextField();
		prenumeCautat.setBounds(415, 73, 209, 28);
		add(prenumeCautat);
		prenumeCautat.setColumns(10);
		
		JPanel update = new JPanel();
		update.addMouseListener(new PanelButtonMouseAdapter(update) {
			@Override
			public void mouseClicked(MouseEvent e) {
				String numeSearch = numeCautat.getText();
				String numeSupervisor = numeSup.getText();
				String numeLocatie = numeLoc.getText();
				String prenumeSearch = prenumeCautat.getText();
				String nume = numeAng.getText();
				String prenume = prenumeAng.getText();
				String cnp = cnpAng.getText();
				String sex = (String) comboBox.getSelectedItem();
				String salariu = salariuAng.getText();
				String dataAng = dataAngajariiAng.getText();
				String dataNas = dataNasteriiAng.getText();
				numeSup.setText("");
				numeLoc.setText("");
				numeAng.setText("");
				prenumeAng.setText("");
				numeCautat.setText("");
				prenumeCautat.setText("");
				cnpAng.setText("");
				dataAngajariiAng.setText("");
				dataNasteriiAng.setText("");
				salariuAng.setText("");
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
					String select = "Select * from Angajat";
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
						//Update ID_Supervisor
						Connection con1 = DriverManager.getConnection(connectionUrl); 
						Statement s1 = con1.createStatement();
						if(!numeSupervisor.isEmpty()) {
							String query = "Update Angajat Set ID_Supervisor = "
											+"(Select S.ID_Angajat from Angajat S where S.Nume = ('" + numeSupervisor +"'))"
											+ "where nume = ('" + numeSearch +"') and prenume = ('" + prenumeSearch +"')";
							s1.executeUpdate(query);
						}
						con1.close();
						s1.close();
						//Update ID_Locatie
						Connection con2 = DriverManager.getConnection(connectionUrl); 
						Statement s2 = con2.createStatement();
						if(!numeLocatie.isEmpty()) {
							String query = "Update Angajat Set ID_Locatie = "
											+"(Select L.ID_Locatie from Locatie L where L.Nume = ('" + numeLocatie +"'))"
											+ "where nume = ('" + numeSearch +"') and prenume = ('" + prenumeSearch +"')";
							s2.executeUpdate(query);
						}
						con2.close();
						s2.close();
						//Update Nume
						Connection con3 = DriverManager.getConnection(connectionUrl); 
						Statement s3 = con3.createStatement();
						if(!nume.isEmpty()) {
							String query = "Update Angajat Set Nume = ('" + nume +"')"
											+ "where nume = ('" + numeSearch +"') and prenume = ('" + prenumeSearch +"')";
							s3.executeUpdate(query);
							numeSearch = nume;
						}
						con3.close();
						s3.close();
						//Update Prenume
						Connection con4 = DriverManager.getConnection(connectionUrl); 
						Statement s4 = con4.createStatement();
						if(!prenume.isEmpty()) {
							String query = "Update Angajat Set Prenume = ('" + prenume +"')"
											+ "where nume = ('" + numeSearch +"') and prenume = ('" + prenumeSearch +"')";
							s4.executeUpdate(query);
							prenumeSearch = prenume;
						}
						con4.close();
						s4.close();
						//Update CNP
						Connection con5 = DriverManager.getConnection(connectionUrl); 
						Statement s5 = con5.createStatement();
						if(!cnp.isEmpty()) {
							String query = "Update Angajat Set CNP = ('" + cnp +"')"
											+ "where nume = ('" + numeSearch +"') and prenume = ('" + prenumeSearch +"')";
							s5.executeUpdate(query);
						}
						con5.close();
						s5.close();
						//Update Salariu
						Connection con6 = DriverManager.getConnection(connectionUrl); 
						Statement s6 = con6.createStatement();
						if(!salariu.isEmpty()) {
							String query = "Update Angajat Set Salariu = ('" + salariu +"')"
											+ "where nume = ('" + numeSearch +"') and prenume = ('" + prenumeSearch +"')";
							s6.executeUpdate(query);
						}
						con6.close();
						s6.close();
						//Update Sex
						Connection con7 = DriverManager.getConnection(connectionUrl); 
						Statement s7 = con7.createStatement();
						if(!sex.isEmpty()) {
							String query = "Update Angajat Set Sex = ('" + sex +"')"
											+ "where nume = ('" + numeSearch +"') and prenume = ('" + prenumeSearch +"')";
							s7.executeUpdate(query);
						}
						con7.close();
						s7.close();
						//Update Data Nasterii
						Connection con8 = DriverManager.getConnection(connectionUrl); 
						Statement s8 = con8.createStatement();
						if(!dataNas.isEmpty()) {
							String query = "Update Angajat Set Data_Nasterii = ('" + dataNas +"')"
											+ "where nume = ('" + numeSearch +"') and prenume = ('" + prenumeSearch +"')";
							s8.executeUpdate(query);
						}
						con8.close();
						s8.close();
						//Update Data Angajarii
						Connection con9 = DriverManager.getConnection(connectionUrl); 
						Statement s9 = con9.createStatement();
						if(!dataAng.isEmpty()) {
							String query = "Update Angajat Set Data_Angajarii = ('" + dataAng +"')"
											+ "where nume = ('" + numeSearch +"') and prenume = ('" + prenumeSearch +"')";
							s9.executeUpdate(query);
						}
						con9.close();
						s9.close();
						JOptionPane.showMessageDialog(Home.frame, "Angajatul cautat a fost actualizat cu succes!");
					}
					//CLIENTUL NU A FOST GASIT
					else {
						JOptionPane.showMessageDialog(Home.frame, "Angajatul cautat nu a fost gasit in baza de date!");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		update.setLayout(null);
		update.setBounds(184, 419, 308, 48);
		add(update);
		
		JLabel lblUpdate = new JLabel("Update");
		lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblUpdate.setBounds(41, 10, 231, 35);
		update.add(lblUpdate);
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