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

public class StatisticiAngajati extends JPanel {
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTextField numeAng1;
	private JTextField numeAng2;
	/**
	 * Create the panel.
	 */
	public StatisticiAngajati() {
		setBounds(0, 0, 672, 477);
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 92, 652, 37);
		add(scrollPane);
		
		
		JLabel lblStatisticiAngajat = new JLabel("Statistici Angajat");
		lblStatisticiAngajat.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatisticiAngajat.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblStatisticiAngajat.setBounds(50, 10, 574, 36);
		add(lblStatisticiAngajat);
		
		JLabel lblNewLabel = new JLabel("Cati subordonati are angajatul cu numele:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 49, 295, 36);
		add(lblNewLabel);
		
		numeAng1 = new JTextField();
		numeAng1.setBounds(301, 55, 204, 27);
		add(numeAng1);
		numeAng1.setColumns(10);
		
		numeAng2 = new JTextField();
		numeAng2.setColumns(10);
		numeAng2.setBounds(530, 151, 132, 27);
		add(numeAng2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 186, 652, 114);
		add(scrollPane_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 358, 652, 37);
		add(scrollPane_2);
		
		JPanel calc = new JPanel();
		calc.addMouseListener(new PanelButtonMouseAdapter(calc) {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Cati subordonati are angajatul cu numele 
				String nume = numeAng1.getText();
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
				model.addColumn("Nume Angajat");
				model.addColumn("Numar Subordonati");
				//BINE
				try
				{
					Connection con = DriverManager.getConnection(connectionUrl); 
					String query= "SELECT S.Nume as Nume, COUNT(A.ID_Angajat) as Nr\r\n"
							+ "FROM Angajat S inner join Angajat A on S.ID_Angajat = A.ID_Supervisor\r\n"
							+ "WHERE S.Nume = ('" + nume +"')"
							+ "GROUP BY S.Nume";
					java.sql.Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					while(rs.next()){
						model.addRow(new Object[] {
								rs.getString("Nume"),
								rs.getString("Nr"),
						});
					}
					rs.close();
					st.close();
					con.close();
					
					table_1.setModel(model);
					table_1.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					table_1.getColumnModel().getColumn(0).setPreferredWidth(80);
					table_1.getColumnModel().getColumn(1).setPreferredWidth(80);
				}
				catch(Exception ex){
					System.out.println("error"+e);
				}
				//Afisati numele si locatia angajatilor care ii sunt subordonati angajatului cu numele
				String nume1 = numeAng2.getText();
				table_2 = new JTable();
				scrollPane_1.setViewportView(table_2); 
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DefaultTableModel model1=new DefaultTableModel();
				model1.addColumn("Nume Angajat");
				model1.addColumn("Nume Locatie");
				//BINE
				try
				{
					Connection con1 = DriverManager.getConnection(connectionUrl); 
					String query1= "SELECT A.Nume + ' ' + A.Prenume as numeComplet, L.Nume as numeLoc\r\n"
							+ "FROM Angajat A inner join Locatie L ON A.ID_Locatie = L.ID_Locatie\r\n"
							+ "WHERE A.ID_Supervisor =(SELECT A1.ID_Angajat FROM Angajat A1 WHERE A1.Nume = ('" + nume1 +"'))";
					java.sql.Statement st1=con1.createStatement();
					ResultSet rs1=st1.executeQuery(query1);
					while(rs1.next()){
						model1.addRow(new Object[] {
								rs1.getString("numeComplet"),
								rs1.getString("numeLoc"),
						});
					}
					rs1.close();
					st1.close();
					con1.close();
					
					table_2.setModel(model1);
					table_2.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
					table_2.getColumnModel().getColumn(0).setPreferredWidth(80);
					table_2.getColumnModel().getColumn(1).setPreferredWidth(80);
				}
				catch(Exception ex){
					System.out.println("error"+e);
				}
				//Numele angajatului cu cele mai multe incasari
				table_3 = new JTable();
				scrollPane_2.setViewportView(table_3); 
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DefaultTableModel model2=new DefaultTableModel();
				model2.addColumn("Nume Angajat");
				model2.addColumn("Incasari");
				//BINE
				try
				{
					Connection con2 = DriverManager.getConnection(connectionUrl); 
					String query2= "SELECT TOP 1 A.Nume AS Nume, SUM(F.Pret_total) AS Incasari\r\n"
							+ "FROM Angajat A inner join Factura F on A.ID_Angajat = F.ID_Angajat\r\n"
							+ "GROUP BY A.Nume\r\n"
							+ "ORDER BY SUM(F.Pret_total) DESC";
					java.sql.Statement st2=con2.createStatement();
					ResultSet rs2=st2.executeQuery(query2);
					while(rs2.next()){
						model2.addRow(new Object[] {
								rs2.getString("Nume"),
								rs2.getString("Incasari"),
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
		lblCalculeaza.setHorizontalAlignment(SwingConstants.CENTER);
		lblCalculeaza.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblCalculeaza.setBounds(49, 0, 231, 35);
		calc.add(lblCalculeaza);
		
		JLabel lblNumeleSiLocatie = new JLabel("Numele si Locatia angajatilor care ii sunt subordonati angajatului cu numele: ");
		lblNumeleSiLocatie.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumeleSiLocatie.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumeleSiLocatie.setBounds(10, 144, 519, 36);
		add(lblNumeleSiLocatie);
		
		JLabel lblNumeleAngajatuluiCu = new JLabel("Numele angajatului cu cele mai multe incasari (RON): ");
		lblNumeleAngajatuluiCu.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumeleAngajatuluiCu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNumeleAngajatuluiCu.setBounds(10, 310, 402, 36);
		add(lblNumeleAngajatuluiCu);
		
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
