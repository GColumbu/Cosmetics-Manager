package tema;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JComboBox;

public class InserareAngajati extends JPanel {
	private JTextField numeSupervisor;
	private JTextField numeLocatie;
	private JTextField numeAngajat;
	private JTextField prenumeAngajat;
	private JTextField cnpAngajat;
	private JTextField salariuAngajat;
	private JTextField dataNasterii;
	private JTextField dataAngajarii;

	/**
	 * Create the panel.
	 */
	public InserareAngajati() {
		setBounds(0, 0, 672, 477);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inserare Angajat");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(47, 10, 574, 53);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nume Supervisor");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 65, 125, 28);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nume Locatie");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 100, 125, 28);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Nume");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(10, 130, 125, 28);
		add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Prenume");
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2.setBounds(10, 166, 125, 28);
		add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_2_1 = new JLabel("CNP");
		lblNewLabel_1_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_1.setBounds(10, 199, 125, 28);
		add(lblNewLabel_1_1_2_1);
		
		JLabel lblNewLabel_1_1_2_1_5 = new JLabel("Sex");
		lblNewLabel_1_1_2_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_1_5.setBounds(10, 233, 125, 28);
		add(lblNewLabel_1_1_2_1_5);
		
		JLabel lblNewLabel_1_1_2_1_6 = new JLabel("Salariu");
		lblNewLabel_1_1_2_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_1_6.setBounds(10, 266, 125, 28);
		add(lblNewLabel_1_1_2_1_6);
		
		numeSupervisor = new JTextField();
		numeSupervisor.setBounds(145, 68, 369, 28);
		add(numeSupervisor);
		numeSupervisor.setColumns(10);
		
		numeLocatie = new JTextField();
		numeLocatie.setColumns(10);
		numeLocatie.setBounds(145, 100, 369, 28);
		add(numeLocatie);
		
		numeAngajat = new JTextField();
		numeAngajat.setColumns(10);
		numeAngajat.setBounds(145, 133, 369, 28);
		add(numeAngajat);
		
		prenumeAngajat = new JTextField();
		prenumeAngajat.setColumns(10);
		prenumeAngajat.setBounds(145, 166, 369, 28);
		add(prenumeAngajat);
		
		cnpAngajat = new JTextField();
		cnpAngajat.setColumns(10);
		cnpAngajat.setBounds(145, 199, 369, 28);
		add(cnpAngajat);
		
		salariuAngajat = new JTextField();
		salariuAngajat.setColumns(10);
		salariuAngajat.setBounds(145, 266, 369, 28);
		add(salariuAngajat);
		
		dataNasterii = new JTextField();
		dataNasterii.setColumns(10);
		dataNasterii.setBounds(145, 299, 369, 28);
		add(dataNasterii);
		
		dataAngajarii = new JTextField();
		dataAngajarii.setColumns(10);
		dataAngajarii.setBounds(145, 333, 369, 28);
		add(dataAngajarii);
		
		JLabel lblNewLabel_1_1_2_1_6_1 = new JLabel("Data Nasterii");
		lblNewLabel_1_1_2_1_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1_6_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_1_6_1.setBounds(10, 299, 125, 28);
		add(lblNewLabel_1_1_2_1_6_1);
		
		JLabel lblNewLabel_1_1_2_1_6_2 = new JLabel("Data Angajarii");
		lblNewLabel_1_1_2_1_6_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2_1_6_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_2_1_6_2.setBounds(10, 333, 125, 28);
		add(lblNewLabel_1_1_2_1_6_2);
		
		String[] disp = {"M", "F"};
		JComboBox comboBox = new JComboBox(disp);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBounds(145, 233, 369, 27);
		add(comboBox);
		
		
		JPanel insereaza = new JPanel();
		insereaza.addMouseListener(new PanelButtonMouseAdapter(insereaza) {
			@Override
			public void mouseClicked(MouseEvent e) {
				String numeSup = numeSupervisor.getText();
				String numeLoc = numeLocatie.getText();
				String nume = numeAngajat.getText();
				String prenume = prenumeAngajat.getText();
				String cnp = cnpAngajat.getText();
				String sex = (String) comboBox.getSelectedItem();
				String salariu = salariuAngajat.getText();
				String dataAng = dataAngajarii.getText();
				String dataNas = dataNasterii.getText();
				numeSupervisor.setText("");
				numeLocatie.setText("");
				numeAngajat.setText("");
				prenumeAngajat.setText("");
				cnpAngajat.setText("");
				dataAngajarii.setText("");
				dataNasterii.setText("");
				salariuAngajat.setText("");
				//conectare la baza de date
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String connectionUrl = "jdbc:jtds:sqlserver://ASUSVIVOBOOKS14; instanceName=SQLEXPRESS;databaseName=Companie_Cosmetice_Columbu-George;integratedSecurity=true";
				try(Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();){
					String select = "Select * from Angajat";
					ResultSet rs = stmt.executeQuery(select);
					int aux = 0;
					while(rs.next()) {
						if(nume.equals(rs.getString("Nume"))&&prenume.equals(rs.getString("Prenume"))&&cnp.equals(rs.getString("CNP"))&&sex.equals(rs.getString("Sex"))&&salariu.equals(rs.getString("Salariu"))&&dataAng.equals(rs.getString("Data_Angajarii"))&&dataNas.equals(rs.getString("Data_Nasterii"))) {
							aux = 1;
						}
					}
					if(aux == 1) {
						JOptionPane.showMessageDialog(Home.frame, "Client deja adaugat in baza de date!");
					}else {
						String insert = "Insert into Angajat Values((select S.ID_Angajat from Angajat S where S.Nume =('" + numeSup + "')),(select L.ID_Locatie from Locatie L where L.Nume = ('" + numeLoc + "')),('" + nume + "'), ('" + prenume + "'), ('" + cnp + "'), ('" + sex + "'), ('" + dataNas + "'), ('" + dataAng + "'), ('" + salariu + "'))";
						stmt.execute(insert);
						JOptionPane.showMessageDialog(Home.frame, "Client adaugat cu succes!");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		insereaza.setLayout(null);
		insereaza.setBounds(173, 419, 308, 48);
		add(insereaza);
		
		JLabel Insereaza = new JLabel("INSEREAZA");
		Insereaza.setHorizontalAlignment(SwingConstants.CENTER);
		Insereaza.setFont(new Font("Tahoma", Font.BOLD, 23));
		Insereaza.setBounds(45, 10, 231, 35);
		insereaza.add(Insereaza);
		
		JLabel lblNewLabel_2 = new JLabel("YYYY-MM-DD");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(521, 306, 141, 39);
		add(lblNewLabel_2);
		
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
