package tema;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class InserareProduse extends JPanel {

	/**
	 * Create the panel.
	 */
	public InserareProduse() {
		setBounds(0, 0, 672, 477);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TODO...Inserare Produse");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(43, 159, 572, 117);
		add(lblNewLabel);
	}

}
