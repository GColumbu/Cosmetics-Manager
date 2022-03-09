package tema;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class panelAngajati extends JPanel {
	private AngajatiAfisare afisare;
	private InserareAngajati inserare;
	private DeleteAngajati delete;
	private UpdateAngajati update;
	private StatisticiAngajati statistici; 
	/**
	 * Create the panel.
	 */
	public panelAngajati() {
		setBackground(new Color(135, 206, 250));
		setBounds(0, 0, 692, 543);
		setLayout(null);
		
		afisare = new AngajatiAfisare();
		inserare = new InserareAngajati();
		delete = new DeleteAngajati();
		update = new UpdateAngajati();
		statistici = new StatisticiAngajati();
		
		JPanel panelDelete = new JPanel();
		panelDelete.addMouseListener(new PanelButtonMouseAdapter(panelDelete) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(delete);
			}
		});
		panelDelete.setBackground(new Color(128, 0, 128));
		panelDelete.setBounds(282, 10, 126, 36);
		add(panelDelete);
		panelDelete.setLayout(null);
		
		JLabel lblDelete = new JLabel("Delete");
		lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelete.setForeground(Color.WHITE);
		lblDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDelete.setBounds(10, 0, 106, 36);
		panelDelete.add(lblDelete);
		
		JPanel panelInserare = new JPanel();
		panelInserare.addMouseListener(new PanelButtonMouseAdapter(panelInserare) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(inserare);
			}
		});
		panelInserare.setBackground(new Color(128, 0, 128));
		panelInserare.setBounds(146, 10, 126, 36);
		add(panelInserare);
		panelInserare.setLayout(null);
		
		JLabel lblInserare = new JLabel("Inserare");
		lblInserare.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserare.setForeground(Color.WHITE);
		lblInserare.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblInserare.setBounds(10, 0, 106, 36);
		panelInserare.add(lblInserare);
		
		JPanel panelUpdate = new JPanel();
		panelUpdate.addMouseListener(new PanelButtonMouseAdapter(panelUpdate) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(update);
			}
		});
		panelUpdate.setLayout(null);
		panelUpdate.setBackground(new Color(128, 0, 128));
		panelUpdate.setBounds(418, 10, 126, 36);
		add(panelUpdate);
		
		JLabel lblUpdate = new JLabel("Update");
		lblUpdate.setBounds(10, 0, 106, 36);
		panelUpdate.add(lblUpdate);
		lblUpdate.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdate.setForeground(Color.WHITE);
		lblUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JPanel panelAfisare = new JPanel();
		panelAfisare.addMouseListener(new PanelButtonMouseAdapter(panelAfisare) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(afisare);
			}
		});
		panelAfisare.setBackground(new Color(128, 0, 128));
		panelAfisare.setBounds(10, 10, 126, 36);
		add(panelAfisare);
		panelAfisare.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Afisare");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 0, 106, 36);
		panelAfisare.add(lblNewLabel);
		
		JPanel panelStatistici = new JPanel();
		panelStatistici.addMouseListener(new PanelButtonMouseAdapter(panelStatistici) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(statistici);
			}
		});
		panelStatistici.setLayout(null);
		panelStatistici.setBackground(new Color(128, 0, 128));
		panelStatistici.setBounds(556, 10, 126, 36);
		add(panelStatistici);
		
		JLabel lblStatistici = new JLabel("Statistici");
		lblStatistici.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatistici.setForeground(Color.WHITE);
		lblStatistici.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStatistici.setBounds(10, 0, 106, 36);
		panelStatistici.add(lblStatistici);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 56, 672, 477);
		add(panel);
		panel.setLayout(null);
		panel.add(afisare);
		panel.add(inserare);
		panel.add(delete);
		panel.add(update);
		panel.add(statistici);
		
		menuClicked(afisare);
	}
	public void menuClicked(JPanel panel) {
		afisare.setVisible(false);
		inserare.setVisible(false);
		delete.setVisible(false);
		update.setVisible(false);
		statistici.setVisible(false);
		
		panel.setVisible(true);
	}
	private class PanelButtonMouseAdapter extends MouseAdapter{
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(128, 0, 128));
		}
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(60, 179, 113));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
		}
		
	}
}
