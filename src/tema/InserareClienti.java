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

public class InserareClienti extends JPanel {
	private JTextField numeClient;
	private JTextField prenumeClient;
	private JTextField cnpClient;

	/**
	 * Create the panel.
	 */
	public InserareClienti() {
		setBounds(0, 0, 672, 477);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inserare Client");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(106, 10, 485, 35);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nume");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 125, 152, 29);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Prenume");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 164, 152, 29);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("CNP");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 203, 152, 29);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Sex");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(10, 242, 152, 29);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Card Fidelitate");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(10, 281, 152, 35);
		add(lblNewLabel_5);
		
		numeClient = new JTextField();
		numeClient.setBounds(165, 125, 239, 29);
		add(numeClient);
		numeClient.setColumns(10);
		
		prenumeClient = new JTextField();
		prenumeClient.setBounds(165, 164, 239, 29);
		add(prenumeClient);
		prenumeClient.setColumns(10);
		
		cnpClient = new JTextField();
		cnpClient.setColumns(10);
		cnpClient.setBounds(165, 203, 239, 29);
		add(cnpClient);
		
		JComboBox comboBox_Sex = new JComboBox();
		comboBox_Sex.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_Sex.setModel(new DefaultComboBoxModel(new String[] {"M", "F"}));
		comboBox_Sex.setBounds(165, 242, 239, 29);
		add(comboBox_Sex);
		
		JComboBox comboBox_CF = new JComboBox();
		comboBox_CF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_CF.setModel(new DefaultComboBoxModel(new String[] {"Y", "N"}));
		comboBox_CF.setBounds(165, 281, 239, 29);
		add(comboBox_CF);
		
		JPanel insereaza = new JPanel();
		insereaza.addMouseListener(new PanelButtonMouseAdapter(insereaza) {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nume = numeClient.getText();
				String prenume = prenumeClient.getText();
				String cnp = cnpClient.getText();
				String sex = (String) comboBox_Sex.getSelectedItem();
				String cardFidelitate = (String) comboBox_CF.getSelectedItem();
				numeClient.setText("");
				prenumeClient.setText("");
				cnpClient.setText("");
				//conectare la baza de date
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String connectionUrl = "jdbc:jtds:sqlserver://ASUSVIVOBOOKS14; instanceName=SQLEXPRESS;databaseName=Companie_Cosmetice_Columbu-George;integratedSecurity=true";
				try(Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();){
					String select = "Select * from Client";
					ResultSet rs = stmt.executeQuery(select);
					int aux = 0;
					while(rs.next()) {
						if(nume.equals(rs.getString("Nume"))&&prenume.equals(rs.getString("Prenume"))&&cnp.equals(rs.getString("CNP"))&&sex.equals(rs.getString("Sex"))&&cardFidelitate.equals(rs.getString("Card_Fidelitate"))) {
							aux = 1;
						}
					}
					if(aux == 1) {
						JOptionPane.showMessageDialog(Home.frame, "Client deja adaugat in baza de date!");
					}else {
						String insert = "Insert into Client Values(('" + nume + "'),('" + prenume + "'),('" + cnp + "'), ('" + sex + "'), ('" + cardFidelitate + "'))";
						stmt.execute(insert);
						JOptionPane.showMessageDialog(Home.frame, "Client adaugat cu succes!");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		insereaza.setBounds(185, 419, 308, 48);
		add(insereaza);
		insereaza.setLayout(null);
		
		JLabel Insereaza = new JLabel("INSEREAZA");
		Insereaza.setBounds(45, 10, 231, 35);
		insereaza.add(Insereaza);
		Insereaza.setHorizontalAlignment(SwingConstants.CENTER);
		Insereaza.setFont(new Font("Tahoma", Font.BOLD, 23));
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
