package tema;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class AngajatiAfisare extends JPanel {
	private JTable table_1;
	/**
	 * Create the panel.
	 */
	public AngajatiAfisare() {
		setBounds(0, 0, 672, 477);
		setLayout(null);
		setVisible(true);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 672, 425);
		add(scrollPane);
		
		JPanel refresh = new JPanel();
		refresh.addMouseListener(new PanelButtonMouseAdapter(refresh) {
			@Override
			public void mouseClicked(MouseEvent e) {
				
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
				model.addColumn("Nume Supervisor");
				model.addColumn("Nume Locatie");
				model.addColumn("Nume");
				model.addColumn("Prenume");
				model.addColumn("CNP");
				model.addColumn("Sex");
				model.addColumn("Data Nasterii");
				model.addColumn("Data Angajarii");
				model.addColumn("Salariu");
				
				
				try
				{
					Connection con = DriverManager.getConnection(connectionUrl); 
					String query="select *, S.Nume as SNume, L.Nume as LNume from Angajat A inner join Angajat S on S.ID_Angajat = A.ID_Supervisor"
																				+ " inner join Locatie L on L.ID_Locatie = A.ID_Locatie";
					java.sql.Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(query);
					while(rs.next())
					{
						model.addRow(new Object[] 
								{
								rs.getString("SNume"),
								rs.getString("LNume"),
								rs.getString("Nume"),
								rs.getString("Prenume"),
								rs.getString("CNP"),
								rs.getString("Sex"),
								rs.getString("Data_Nasterii"),
								rs.getString("Data_Angajarii"),
								rs.getString("Salariu"),
						});
					}
					rs.close();
					st.close();
					con.close();
					
					table_1.setModel(model);
					table_1.setAutoResizeMode(0);
					table_1.getColumnModel().getColumn(0).setPreferredWidth(80);
					table_1.getColumnModel().getColumn(1).setPreferredWidth(80);
					table_1.getColumnModel().getColumn(2).setPreferredWidth(80);
					table_1.getColumnModel().getColumn(3).setPreferredWidth(80);
					table_1.getColumnModel().getColumn(4).setPreferredWidth(80);
					table_1.getColumnModel().getColumn(5).setPreferredWidth(80);
					table_1.getColumnModel().getColumn(6).setPreferredWidth(80);
					table_1.getColumnModel().getColumn(7).setPreferredWidth(80);
					table_1.getColumnModel().getColumn(8).setPreferredWidth(80);
				}
				catch(Exception ex){
					System.out.println("error"+e);
				}
			}
		});
		refresh.setBounds(152, 433, 375, 34);
		add(refresh);
		refresh.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REFRESH");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(32, 0, 305, 33);
		refresh.add(lblNewLabel);
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
