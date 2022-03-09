package tema;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class panelCategorii extends JPanel {
	private CategoriiAfisare afisare;
	private InserareCategorii inserare;
	private DeleteCategorii delete;
	private StatisticiCategorie statistici;
	/**
	 * Create the panel.
	 */
	public panelCategorii() {
		setBackground(new Color(135, 206, 250));
		setBounds(0, 0, 692, 543);
		setLayout(null);
		
		afisare = new CategoriiAfisare();
		inserare = new InserareCategorii();
		delete = new DeleteCategorii();
		statistici = new StatisticiCategorie();
		
		JPanel panelStatistici = new JPanel();
		panelStatistici.addMouseListener(new PanelButtonMouseAdapter(panelStatistici) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(statistici);
			}
		});
		panelStatistici.setLayout(null);
		panelStatistici.setBackground(new Color(128, 0, 128));
		panelStatistici.setBounds(524, 10, 158, 36);
		add(panelStatistici);
		
		JLabel lblStatistici = new JLabel("Statistici");
		lblStatistici.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatistici.setForeground(Color.WHITE);
		lblStatistici.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblStatistici.setBounds(10, 0, 138, 36);
		panelStatistici.add(lblStatistici);
		
		JPanel panelDelete = new JPanel();
		panelDelete.addMouseListener(new PanelButtonMouseAdapter(panelDelete) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(delete);
			}
		});
		panelDelete.setBackground(new Color(128, 0, 128));
		panelDelete.setBounds(356, 10, 158, 36);
		add(panelDelete);
		panelDelete.setLayout(null);
		
		JLabel lblDelete = new JLabel("Delete");
		lblDelete.setHorizontalAlignment(SwingConstants.CENTER);
		lblDelete.setForeground(Color.WHITE);
		lblDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDelete.setBounds(10, 0, 138, 36);
		panelDelete.add(lblDelete);
		
		JPanel panelInserare = new JPanel();
		panelInserare.addMouseListener(new PanelButtonMouseAdapter(panelInserare) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(inserare);
			}
		});
		panelInserare.setBackground(new Color(128, 0, 128));
		panelInserare.setBounds(178, 10, 158, 36);
		add(panelInserare);
		panelInserare.setLayout(null);
		
		JLabel lblInserare = new JLabel("Inserare");
		lblInserare.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserare.setForeground(Color.WHITE);
		lblInserare.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblInserare.setBounds(10, 0, 138, 36);
		panelInserare.add(lblInserare);
		
		JPanel panelAfisare = new JPanel();
		panelAfisare.addMouseListener(new PanelButtonMouseAdapter(panelAfisare) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(afisare);
			}
		});
		panelAfisare.setBackground(new Color(128, 0, 128));
		panelAfisare.setBounds(10, 10, 158, 36);
		add(panelAfisare);
		panelAfisare.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Afisare");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(10, 0, 138, 36);
		panelAfisare.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 56, 672, 477);
		add(panel);
		panel.setLayout(null);
		panel.add(afisare);
		panel.add(inserare);
		panel.add(delete);
		panel.add(statistici);
		
		menuClicked(afisare);
	}
	public void menuClicked(JPanel panel) {
		afisare.setVisible(false);
		inserare.setVisible(false);
		delete.setVisible(false);
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
