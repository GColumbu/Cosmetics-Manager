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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;


import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class StatisticiClienti extends JPanel {
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	/**
	 * Create the panel.
	 */
	public StatisticiClienti() {
		setBounds(0, 0, 672, 477);
		setLayout(null);
		
		
		JLabel lblStatisticiAngajat = new JLabel("Statistici Client");
		lblStatisticiAngajat.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatisticiAngajat.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblStatisticiAngajat.setBounds(50, 10, 574, 36);
		add(lblStatisticiAngajat);
		
		JLabel lblNewLabel = new JLabel("Numele clientilor care au card de fidelitate si prefera metoda de plata: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 49, 493, 36);
		add(lblNewLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 197, 652, 80);
		add(scrollPane_1);
		
		JLabel lblNumeleSiLocatie = new JLabel("Clientii care au fost serviti de angajatul lunii:");
		lblNumeleSiLocatie.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumeleSiLocatie.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumeleSiLocatie.setBounds(10, 162, 519, 36);
		add(lblNumeleSiLocatie);
		
		JLabel lblNumeleAngajatuluiCu = new JLabel("Clientii care au fost la cea mai vizitata locatie:");
		lblNumeleAngajatuluiCu.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumeleAngajatuluiCu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumeleAngajatuluiCu.setBounds(10, 287, 402, 36);
		add(lblNumeleAngajatuluiCu);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cash", "Card"}));
		comboBox.setBounds(505, 57, 157, 25);
		add(comboBox);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 84, 652, 80);
		add(scrollPane);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 328, 652, 80);
		add(scrollPane_2);
		
		JPanel calc = new JPanel();
		calc.addMouseListener(new PanelButtonMouseAdapter(calc) {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Numele clientilor care au card de fidelitate si prefera metoda de plata (Cash/Card)
				table_1 = new JTable();
				String metoda = (String)comboBox.getSelectedItem();
				scrollPane.setViewportView(table_1); 
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String connectionUrl = "jdbc:jtds:sqlserver://ASUSVIVOBOOKS14;instanceName=SQLEXPRESS;databaseName=Companie_Cosmetice_Columbu-George;integratedSecurity=true";
				DefaultTableModel model=new DefaultTableModel();
				model.addColumn("Nume Client");
				//BINE
				try
				{
					Connection con = DriverManager.getConnection(connectionUrl); 
					String query= "SELECT C.Nume + ' ' + C.Prenume as numeComplet\r\n"
							+ "FROM Client C inner join Factura F on C.ID_Client = F.ID_Client\r\n"
							+ "WHERE C.Card_Fidelitate = 'Y' and F.Metoda_plata = ('" + metoda +"')";
					java.sql.Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					while(rs.next()){
						model.addRow(new Object[] {
								rs.getString("numeComplet"),
						});
					}
					rs.close();
					st.close();
					con.close();
					
					table_1.setModel(model);
					table_1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					table_1.getColumnModel().getColumn(0).setPreferredWidth(80);
				}
				catch(Exception ex){
					System.out.println("error"+e);
				}
				//Clientii care au fost serviti de angajatul lunii:
				table_2 = new JTable();
				scrollPane_1.setViewportView(table_2); 
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DefaultTableModel model1=new DefaultTableModel();
				model1.addColumn("Nume Client");
				//BINE
				try
				{
					Connection con1 = DriverManager.getConnection(connectionUrl); 
					String query1= "SELECT C.Nume + ' ' + C.Prenume as numeComplet\r\n"
							+ "FROM Client C inner join Factura F on F.ID_Client = C.ID_Client\r\n"
							+ "WHERE F.ID_Angajat IN (SELECT TOP 1 A.ID_Angajat\r\n"
							+ "FROM Angajat A inner join Factura F on A.ID_Angajat = F.ID_Angajat\r\n"
							+ "GROUP BY A.ID_Angajat\r\n"
							+ "ORDER BY SUM(F.Pret_total) DESC)";
					java.sql.Statement st1=con1.createStatement();
					ResultSet rs1=st1.executeQuery(query1);
					while(rs1.next()){
						model1.addRow(new Object[] {
								rs1.getString("numeComplet"),
						});
					}
					rs1.close();
					st1.close();
					con1.close();
					
					table_2.setModel(model1);
					table_2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					table_2.getColumnModel().getColumn(0).setPreferredWidth(80);
				}
				catch(Exception ex){
					System.out.println("error"+e);
				}
				//Afisati clientii care au fost la cea mai vizitata locatie
				table_3 = new JTable();
				scrollPane_2.setViewportView(table_3); 
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DefaultTableModel model2=new DefaultTableModel();
				model2.addColumn("Nume Client");
				//BINE
				try
				{
					Connection con2 = DriverManager.getConnection(connectionUrl); 
					String query2= "SELECT C.Nume + ' ' + C.Prenume as numeComplet\r\n"
							+ "FROM Client C inner join Factura F on F.ID_Client = C.ID_Client\r\n"
							+ "			  inner join Angajat A on F.ID_Angajat = A.ID_Angajat\r\n"
							+ "WHERE A.ID_Locatie = (SELECT TOP 1 L.ID_Locatie\r\n"
							+ "FROM Locatie L inner join Angajat A1 on L.ID_Locatie = A1.ID_Locatie\r\n"
							+ "			   inner join Factura F1 on F1.ID_Angajat = A1.ID_Angajat\r\n"
							+ "GROUP BY L.ID_Locatie\r\n"
							+ "ORDER BY COUNT(F1.ID_Client) DESC)";
					java.sql.Statement st2=con2.createStatement();
					ResultSet rs2=st2.executeQuery(query2);
					while(rs2.next()){
						model2.addRow(new Object[] {
								rs2.getString("numeComplet"),
						});
					}
					rs2.close();
					st2.close();
					con2.close();
					
					table_3.setModel(model2);
					table_3.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					table_3.getColumnModel().getColumn(0).setPreferredWidth(80);
				}
				catch(Exception ex){
					System.out.println("error"+e);
				}
			}
		});
		calc.setLayout(null);
		calc.setBounds(177, 431, 308, 36);
		add(calc);
		
		JLabel lblCalculeaza = new JLabel("Calculeaza");
		lblCalculeaza.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalculeaza.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblCalculeaza.setBounds(49, 0, 231, 35);
		calc.add(lblCalculeaza);
		
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
