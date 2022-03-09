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

public class StatisticiLocatie extends JPanel {
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	/**
	 * Create the panel.
	 */
	public StatisticiLocatie() {
		setBounds(0, 0, 672, 477);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 87, 652, 81);
		add(scrollPane);
		
		JLabel lblCompanie = new JLabel("companie:");
		lblCompanie.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompanie.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCompanie.setBounds(10, 195, 652, 19);
		add(lblCompanie);
		
		JLabel lblStatisticiAngajat = new JLabel("Statistici Locatie");
		lblStatisticiAngajat.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatisticiAngajat.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblStatisticiAngajat.setBounds(50, 10, 574, 36);
		add(lblStatisticiAngajat);
		
		JLabel lblNewLabel = new JLabel("Numarul de angajati si media salariilor pe care il are fiecare locatie:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 56, 493, 36);
		add(lblNewLabel);
		
		JLabel lblNumeleAngajatuluiCu = new JLabel("Numele locatiilor pentru care media salariilor este mai mare decat media salariilor pe intreaga");
		lblNumeleAngajatuluiCu.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeleAngajatuluiCu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumeleAngajatuluiCu.setBounds(10, 167, 652, 36);
		add(lblNumeleAngajatuluiCu);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 336, 652, 81);
		add(scrollPane_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 220, 652, 81);
		add(scrollPane_1);
		
		JPanel calc = new JPanel();
		calc.addMouseListener(new PanelButtonMouseAdapter(calc) {
			@Override
			public void mouseClicked(MouseEvent e) {
				//pt fiecare locatie afisati numarul de angajati pe care il are
				table_1 = new JTable();
				scrollPane.setViewportView(table_1); 
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String connectionUrl = "jdbc:jtds:sqlserver://ASUSVIVOBOOKS14;instanceName=SQLEXPRESS;databaseName=Companie_Cosmetice_Columbu-George;integratedSecurity=true";
				DefaultTableModel model=new DefaultTableModel();
				model.addColumn("Nume Locatie");
				model.addColumn("Numar Angajati");
				model.addColumn("Medie Salarii");
				//BINE
				try
				{
					Connection con = DriverManager.getConnection(connectionUrl); 
					String query= "SELECT L.Nume as Nume, COUNT(A.ID_Angajat) AS NumarAngajati, AVG(A.Salariu) AS MedieSalarii\r\n"
							+ "FROM Locatie L inner join Angajat A on A.ID_Locatie = L.ID_Locatie\r\n"
							+ "GROUP BY L.Nume";
					java.sql.Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					while(rs.next()){
						model.addRow(new Object[] {
								rs.getString("Nume"),
								rs.getString("NumarAngajati"),
								rs.getString("MedieSalarii"),
						});
					}
					rs.close();
					st.close();
					con.close();
					
					table_1.setModel(model);
					table_1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					table_1.getColumnModel().getColumn(0).setPreferredWidth(80);
					table_1.getColumnModel().getColumn(1).setPreferredWidth(80);
					table_1.getColumnModel().getColumn(2).setPreferredWidth(80);
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
				model1.addColumn("Nume Locatie");
				//BINE
				try
				{
					Connection con1 = DriverManager.getConnection(connectionUrl); 
					String query1= "SELECT L.Nume as Nume\r\n"
							+ "FROM Locatie L inner join Angajat A on A.ID_Locatie = L.ID_Locatie\r\n"
							+ "GROUP BY L.Nume\r\n"
							+ "HAVING AVG(A.Salariu) > (SELECT AVG(A1.Salariu) FROM Angajat A1)";
					java.sql.Statement st1=con1.createStatement();
					ResultSet rs1=st1.executeQuery(query1);
					while(rs1.next()){
						model1.addRow(new Object[] {
								rs1.getString("Nume"),
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
				//top 2 cele mai vizitate locatii
				table_3 = new JTable();
				scrollPane_2.setViewportView(table_3); 
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DefaultTableModel model2=new DefaultTableModel();
				model2.addColumn("Nume Locatie");
				model2.addColumn("Numar Vizite");
				//BINE
				try
				{
					Connection con2 = DriverManager.getConnection(connectionUrl); 
					String query2= "SELECT TOP 2 L.Nume AS Nume, COUNT(F.ID_Client) AS NumarVizite\r\n"
							+ "FROM Locatie L inner join Angajat A on L.ID_Locatie = A.ID_Locatie\r\n"
							+ "			   inner join Factura F on F.ID_Angajat = A.ID_Angajat\r\n"
							+ "GROUP BY L.Nume\r\n"
							+ "ORDER BY COUNT(F.ID_Client) DESC";
					java.sql.Statement st2=con2.createStatement();
					ResultSet rs2=st2.executeQuery(query2);
					while(rs2.next()){
						model2.addRow(new Object[] {
								rs2.getString("Nume"),
								rs2.getString("NumarVizite"),
						});
					}
					rs2.close();
					st2.close();
					con2.close();
					
					table_3.setModel(model2);
					table_3.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					table_3.getColumnModel().getColumn(0).setPreferredWidth(80);
					table_3.getColumnModel().getColumn(1).setPreferredWidth(80);
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
		lblCalculeaza.setBounds(42, 0, 231, 35);
		calc.add(lblCalculeaza);
		lblCalculeaza.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalculeaza.setFont(new Font("Tahoma", Font.BOLD, 23));
		
		
		JLabel lblTopCele = new JLabel("Top 2 cele mai vizitate locatii: ");
		lblTopCele.setHorizontalAlignment(SwingConstants.LEFT);
		lblTopCele.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTopCele.setBounds(10, 301, 493, 36);
		add(lblTopCele);
		
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
