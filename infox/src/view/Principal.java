package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Cursor;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/pc2.png")));
		setResizable(false);
		setTitle("Infox-Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 346);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnUsuarios = new JButton("");
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//evento actionPerformed (pressionar o botao)
				//exibir a tela de Usuarios
				Usuario usuario = new Usuario();
				usuario.setVisible(true);
			}
		});
		btnUsuarios.setToolTipText("Usu\u00E1rios");
		btnUsuarios.setIcon(new ImageIcon(Principal.class.getResource("/img/users.png")));
		btnUsuarios.setBounds(26, 0, 128, 128);
		contentPane.add(btnUsuarios);
		
		JButton btnClientes = new JButton("");
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//evento actionPerformed (pressionar o botao)
				//exibir a tela de Clientes
				Cliente cliente = new Cliente();
				cliente.setVisible(true);
				
			}
		});
		btnClientes.setIcon(new ImageIcon(Principal.class.getResource("/img/clientes.png")));
		btnClientes.setToolTipText("Clientes");
		btnClientes.setBounds(164, 0, 128, 128);
		contentPane.add(btnClientes);
		
		JButton btnClientes_1 = new JButton("");
		btnClientes_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClientes_1.setIcon(new ImageIcon(Principal.class.getResource("/img/os.png")));
		btnClientes_1.setToolTipText("OS");
		btnClientes_1.setBounds(26, 168, 128, 128);
		contentPane.add(btnClientes_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/img/x.png")));
		lblNewLabel.setBounds(277, 11, 235, 235);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(325, 61, 235, 235);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(302, 29, 153, 157);
		contentPane.add(lblNewLabel_2);
		
		JButton btnSobre = new JButton("");
		btnSobre.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSobre.setBorder(null);
		btnSobre.setBackground(SystemColor.control);
		btnSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Ativar a janela Sobre
				Sobre sobre = new Sobre();
				sobre.setVisible(true);
			}
		});
		btnSobre.setToolTipText("Sobre");
		btnSobre.setIcon(new ImageIcon(Principal.class.getResource("/img/about.png")));
		btnSobre.setBounds(188, 197, 64, 64);
		contentPane.add(btnSobre);
	}
}
