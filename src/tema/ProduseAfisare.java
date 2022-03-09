package tema;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.awt.event.ActionEvent;

public class ProduseAfisare extends JPanel {
	private JTable table_1;
	/**
	 * Create the panel.
	 */
	public ProduseAfisare() {
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
		model.addColumn("Categoria");
		model.addColumn("Denumire");
		model.addColumn("Pret");
		model.addColumn("Culoare");	
		try
		{
			Connection con = DriverManager.getConnection(connectionUrl); 
			String query="select *, C.Denumire as Categoria from Produs P inner join Categorie C on P.ID_Categorie = C.ID_Categorie";
			java.sql.Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(query);
			while(rs.next())
			{
				model.addRow(new Object[] 
						{
						rs.getString("Categoria"),
						rs.getString("Denumire"),
						rs.getString("Pret"),
						rs.getString("Culoare"),
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
			
		}
		catch(Exception e){
			System.out.println("error"+e);
		}
	}
}
