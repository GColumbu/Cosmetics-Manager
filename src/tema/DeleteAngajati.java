
package tema;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
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

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


import javax.swing.JTextField;

public class DeleteAngajati extends JPanel {
	private JTextField textNume;
	private JTextField textPrenume;

	/**
	 * Create the panel.
	 */
	public DeleteAngajati() {
		setBounds(0, 0, 672, 477);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Delete Angajat");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(143, 10, 370, 40);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nume");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(71, 165, 112, 32);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prenume");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBounds(71, 216, 112, 32);
		add(lblNewLabel_1_1);
		
		textNume = new JTextField();
		textNume.setBounds(193, 168, 320, 32);
		add(textNume);
		textNume.setColumns(10);
		
		textPrenume = new JTextField();
		textPrenume.setColumns(10);
		textPrenume.setBounds(193, 216, 320, 32);
		add(textPrenume);
		
		JPanel panelDelete = new JPanel();
		panelDelete.addMouseListener(new PanelButtonMouseAdapter(panelDelete) {
			@Override
			public void mouseClicked(MouseEvent e) {
				String nume = textNume.getText();
				String prenume = textPrenume.getText();
				textNume.setText("");
				textPrenume.setText("");
				//conectare la baza de date
				try {
					Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String connectionUrl = "jdbc:jtds:sqlserver://ASUSVIVOBOOKS14; instanceName=SQLEXPRESS;databaseName=Companie_Cosmetice_Columbu-George;integratedSecurity=true";
				//
				try(Connection con = DriverManager.getConnection(connectionUrl); Statement stmt = con.createStatement();){
					String select = "select A.Nume AS Nume, A.Prenume as Prenume from Angajat A";
					ResultSet rs = stmt.executeQuery(select);
					int aux = 0;
					while(rs.next()) {
						if(nume.equals(rs.getString("Nume"))&&prenume.equals(rs.getString("Prenume"))) {
							aux = 1;
						}
					}
					if(aux == 1) {
						String delete = "delete from Angajat where Nume = ('" + nume +"') and Prenume = ('" + prenume +"')";
						stmt.execute(delete);
						JOptionPane.showMessageDialog(Home.frame, "Client sters cu succes");
					}else {
						JOptionPane.showMessageDialog(Home.frame, "Nume sau prenume invalid!");
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panelDelete.setBounds(182, 427, 320, 40);
		add(panelDelete);
		panelDelete.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("DELETE");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNewLabel_2.setBounds(40, 0, 240, 40);
		panelDelete.add(lblNewLabel_2);
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
			panel.setBackground(new Color(255, 0, 0));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(135, 206, 250));
		}
	}
}

