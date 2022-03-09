package tema;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class InserareFacturi extends JPanel {

	/**
	 * Create the panel.
	 */
	public InserareFacturi() {
		setBounds(0, 0, 672, 477);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TODO...Inserare Facturi");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(50, 159, 558, 124);
		add(lblNewLabel);
	}

}
