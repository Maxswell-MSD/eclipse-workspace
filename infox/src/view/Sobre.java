package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Sobre extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sobre dialog = new Sobre();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public Sobre() {
		setModal(true);
		setResizable(false);
		setTitle("InfoX-Sobre");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Sobre.class.getResource("/img/pc2.png")));
		setBounds(100, 100, 508, 323);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("InfoX - Sistema para gest\u00E3o e servi\u00E7os");
		lblNewLabel.setBounds(53, 61, 349, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Autor - Maxswell Sousa Diniz");
		lblNewLabel_1.setBounds(53, 86, 349, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Sobre.class.getResource("/img/gpl.png")));
		lblNewLabel_2.setBounds(377, 61, 64, 64);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Vers\u00E3o 1.0");
		lblNewLabel_1_1.setBounds(53, 198, 64, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Vers\u00E3o 1.0");
		lblNewLabel_1_1_1.setBounds(-94, 240, 349, 14);
		getContentPane().add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Sob a licen\u00E7a GPL");
		lblNewLabel_1_1_2.setBounds(53, 180, 103, 14);
		getContentPane().add(lblNewLabel_1_1_2);
		
		JLabel lblNewLabel_1_1_3 = new JLabel("        www.Infox.com.br");
		lblNewLabel_1_1_3.setBounds(169, 270, 128, 14);
		getContentPane().add(lblNewLabel_1_1_3);

	}
}
