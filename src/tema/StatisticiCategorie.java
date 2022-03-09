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

public class StatisticiCategorie extends JPanel {
	private JTable table_1;
	/**
	 * Create the panel.
	 */
	public StatisticiCategorie() {
		setBounds(0, 0, 672, 477);
		setLayout(null);
		
		JLabel lblStatisticiAngajat = new JLabel("Statistici Categorie");
		lblStatisticiAngajat.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatisticiAngajat.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblStatisticiAngajat.setBounds(50, 10, 574, 36);
		add(lblStatisticiAngajat);
		
		JLabel lblNewLabel = new JLabel("Categoria cu cele mai scumpe produse:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(98, 136, 493, 36);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 173, 652, 109);
		add(scrollPane);
		
		JPanel calc = new JPanel();
		calc.addMouseListener(new PanelButtonMouseAdapter(calc) {
			@Override
			public void mouseClicked(MouseEvent e) {
				//categoria cu cele mai scumpe produse
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
				model.addColumn("Denumire Categorie");
				model.addColumn("Pret Mediu");
				//BINE
				try
				{
					Connection con = DriverManager.getConnection(connectionUrl); 
					String query= "SELECT TOP 1 C.Denumire as Nume, AVG(P.Pret) as Pret\r\n"
							+ "FROM Categorie C inner join Produs P on P.ID_Categorie = C.ID_Categorie\r\n"
							+ "GROUP BY C.Denumire\r\n"
							+ "ORDER BY AVG(P.Pret) DESC";
					java.sql.Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					while(rs.next()){
						model.addRow(new Object[] {
								rs.getString("Nume"),
								rs.getString("Pret"),
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
