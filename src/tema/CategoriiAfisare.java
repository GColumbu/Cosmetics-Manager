package tema;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class CategoriiAfisare extends JPanel {
	private JTable table_1;
	/**
	 * Create the panel.
	 */
	public CategoriiAfisare() {
		setBounds(0, 0, 672, 477);
		setLayout(null);
		setVisible(true);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 672, 477);
		add(scrollPane);
		
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
		model.addColumn("Denumire");
		model.addColumn("Descriere");
		
		
		try
		{
			Connection con = DriverManager.getConnection(connectionUrl); 
			String query="select * from Categorie";
			java.sql.Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next())
			{
				model.addRow(new Object[] 
						{
								rs.getString("Denumire"),
								rs.getString("Descriere"),
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
		catch(Exception e){
			System.out.println("error"+e);
		}
	
	}

}
