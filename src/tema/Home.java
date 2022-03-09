package tema;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Home {

	public static JFrame frame;
	private panelAngajati panelAngajati;
	private panelCategorii panelCategorii;
	private panelClienti panelClienti;
	private panelFacturi panelFacturi;
	private panelLocatii panelLocatii;
	private panelProduse panelProduse;
	private panelExit panelExit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					Home.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(135, 206, 250));
		frame.getContentPane().setLayout(null);
		
		panelAngajati = new panelAngajati();
		panelCategorii = new panelCategorii();
		panelClienti = new panelClienti();
		panelFacturi = new panelFacturi();
		panelLocatii = new panelLocatii();
		panelProduse = new panelProduse();
		panelExit = new panelExit();
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(106, 90, 205));
		panelMenu.setBounds(0, 0, 274, 563);
		frame.getContentPane().add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel mainLogo = new JLabel("");
		mainLogo.setHorizontalAlignment(SwingConstants.CENTER);
		Image img = new ImageIcon(this.getClass().getResource("/file-info-icon.png")).getImage().getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		mainLogo.setIcon(new ImageIcon(img));
		mainLogo.setBounds(10, 10, 254, 123);
		panelMenu.add(mainLogo);
		
		JPanel Angajati = new JPanel();
		Angajati.addMouseListener(new PanelButtonMouseAdapter(Angajati) {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelClicked(panelAngajati);
			}
		});
		Angajati.setBackground(new Color(128, 0, 128));
		Angajati.setBounds(0, 158, 274, 43);
		panelMenu.add(Angajati);
		Angajati.setLayout(null);
		
		JLabel LabelAngajati = new JLabel("Angajati");
		LabelAngajati.setForeground(new Color(255, 255, 255));
		LabelAngajati.setHorizontalAlignment(SwingConstants.CENTER);
		LabelAngajati.setFont(new Font("Tahoma", Font.BOLD, 18));
		LabelAngajati.setBounds(58, 10, 131, 23);
		Angajati.add(LabelAngajati);
		
		JLabel logoAngajati = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/angajati-icon.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		logoAngajati.setIcon(new ImageIcon(img1));
		logoAngajati.setBounds(20, 0, 54, 41);
		Angajati.add(logoAngajati);
		
		JPanel Categorii = new JPanel();
		Categorii.addMouseListener(new PanelButtonMouseAdapter(Categorii) {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelClicked(panelCategorii);
			}
		});
		Categorii.setBackground(new Color(128, 0, 128));
		Categorii.setBounds(0, 209, 274, 43);
		panelMenu.add(Categorii);
		Categorii.setLayout(null);
		
		JLabel lblCategorii = new JLabel("Categorii");
		lblCategorii.setHorizontalAlignment(SwingConstants.CENTER);
		lblCategorii.setForeground(Color.WHITE);
		lblCategorii.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCategorii.setBounds(61, 10, 131, 23);
		Categorii.add(lblCategorii);
		
		JLabel logoCategorii = new JLabel("");
		Image img2 = new ImageIcon(this.getClass().getResource("/folder-icon.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		logoCategorii.setIcon(new ImageIcon(img2));
		logoCategorii.setBounds(21, 0, 54, 41);
		Categorii.add(logoCategorii);
		
		JPanel Clienti = new JPanel();
		Clienti.addMouseListener(new PanelButtonMouseAdapter(Clienti) {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelClicked(panelClienti);
			}
		});
		Clienti.setBackground(new Color(128, 0, 128));
		Clienti.setBounds(0, 261, 274, 43);
		panelMenu.add(Clienti);
		Clienti.setLayout(null);
		
		JLabel lblClienti = new JLabel("Clienti");
		lblClienti.setHorizontalAlignment(SwingConstants.CENTER);
		lblClienti.setForeground(Color.WHITE);
		lblClienti.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblClienti.setBounds(47, 10, 131, 23);
		Clienti.add(lblClienti);
		
		JLabel logoClienti = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/clients-icon.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		logoClienti.setIcon(new ImageIcon(img3));
		logoClienti.setBounds(21, 0, 54, 41);
		Clienti.add(logoClienti);
		
		JPanel Facturi = new JPanel();
		Facturi.addMouseListener(new PanelButtonMouseAdapter(Facturi) {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelClicked(panelFacturi);
			}
		});
		Facturi.setBackground(new Color(128, 0, 128));
		Facturi.setBounds(0, 315, 274, 43);
		panelMenu.add(Facturi);
		Facturi.setLayout(null);
		
		JLabel lblFacturi = new JLabel("Facturi");
		lblFacturi.setHorizontalAlignment(SwingConstants.CENTER);
		lblFacturi.setForeground(Color.WHITE);
		lblFacturi.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblFacturi.setBounds(50, 10, 131, 23);
		Facturi.add(lblFacturi);
		
		JLabel logoFacturi = new JLabel("");
		Image img4 = new ImageIcon(this.getClass().getResource("/bill-icon.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		logoFacturi.setIcon(new ImageIcon(img4));
		logoFacturi.setBounds(23, 0, 54, 41);
		Facturi.add(logoFacturi);
		
		JPanel Locatii = new JPanel();
		Locatii.addMouseListener(new PanelButtonMouseAdapter(Locatii) {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelClicked(panelLocatii);
			}
		});
		Locatii.setBackground(new Color(128, 0, 128));
		Locatii.setBounds(0, 368, 274, 43);
		panelMenu.add(Locatii);
		Locatii.setLayout(null);
		
		JLabel lblLocatii = new JLabel("Locatii");
		lblLocatii.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocatii.setForeground(Color.WHITE);
		lblLocatii.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLocatii.setBounds(51, 10, 131, 23);
		Locatii.add(lblLocatii);
		
		JLabel logoLocatii = new JLabel("");
		Image img5 = new ImageIcon(this.getClass().getResource("/location-icon.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		logoLocatii.setIcon(new ImageIcon(img5));
		logoLocatii.setBounds(22, 0, 54, 41);
		Locatii.add(logoLocatii);
		
		JPanel Produse = new JPanel();
		Produse.addMouseListener(new PanelButtonMouseAdapter(Produse) {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelClicked(panelProduse);
			}
		});
		Produse.setBackground(new Color(128, 0, 128));
		Produse.setBounds(0, 421, 274, 43);
		panelMenu.add(Produse);
		Produse.setLayout(null);
		
		JLabel LabelAngajati_4_1 = new JLabel("Produse");
		LabelAngajati_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		LabelAngajati_4_1.setForeground(Color.WHITE);
		LabelAngajati_4_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		LabelAngajati_4_1.setBounds(55, 10, 131, 23);
		Produse.add(LabelAngajati_4_1);
		
		JLabel logoProduse = new JLabel("");
		Image img6 = new ImageIcon(this.getClass().getResource("/product-icon.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		logoProduse.setIcon(new ImageIcon(img6));
		logoProduse.setBounds(21, 0, 54, 41);
		Produse.add(logoProduse);
		
		JPanel Exit = new JPanel();
		Exit.addMouseListener(new PanelButtonMouseAdapter(Exit) {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelClicked(panelExit);
				if(JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?")==0) {
					LoginPage login = new LoginPage();
					login.frame.setVisible(true);
					Home.frame.setVisible(false);
				}
			}
		});
		Exit.setLayout(null);
		Exit.setBackground(new Color(128, 0, 128));
		Exit.setBounds(10, 503, 254, 43);
		panelMenu.add(Exit);
		
		JLabel LabelAngajati_4_1_1 = new JLabel("EXIT");
		LabelAngajati_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		LabelAngajati_4_1_1.setForeground(Color.WHITE);
		LabelAngajati_4_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		LabelAngajati_4_1_1.setBounds(65, 10, 131, 23);
		Exit.add(LabelAngajati_4_1_1);
		
		JLabel logoExit = new JLabel("");
		Image img7 = new ImageIcon(this.getClass().getResource("/exit-icon.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		logoExit.setIcon(new ImageIcon(img7));;
		logoExit.setBounds(36, 0, 54, 41);
		Exit.add(logoExit);
		
		JPanel panelMainContent = new JPanel();
		panelMainContent.setBounds(284, 10, 692, 543);
		frame.getContentPane().add(panelMainContent);
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelMainContent.setLayout(null);
		
		panelMainContent.add(panelAngajati);
		panelMainContent.add(panelCategorii);
		panelMainContent.add(panelClienti);
		panelMainContent.add(panelFacturi);
		panelMainContent.add(panelLocatii);
		panelMainContent.add(panelProduse);
		panelMainContent.add(panelExit);
		
		panelClicked(panelAngajati);

	}
	
	public void panelClicked(JPanel panel) {
		panelAngajati.setVisible(false);
		panelCategorii.setVisible(false);
		panelClienti.setVisible(false);
		panelFacturi.setVisible(false);
		panelLocatii.setVisible(false);
		panelProduse.setVisible(false);
		panelExit.setVisible(false);
		
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
