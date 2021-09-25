package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DAO;

import java.awt.Toolkit;
import java.sql.Connection;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textLogin;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame. Construtor
	 */
	public login() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				// evento disparado quando a janela e ativada
				status();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(login.class.getResource("/img/pc2.png")));
		setResizable(false);
		setTitle("infoX-Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textLogin = new JTextField();
		textLogin.setBounds(82, 29, 265, 20);
		contentPane.add(textLogin);
		textLogin.setColumns(10);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(35, 32, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBounds(35, 68, 36, 14);
		contentPane.add(lblNewLabel_1);

		txtSenha = new JPasswordField();
		txtSenha.setBounds(82, 65, 265, 20);
		contentPane.add(txtSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(43, 154, 76, 23);
		contentPane.add(btnEntrar);

		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(login.class.getResource("/img/erro.png")));
		lblStatus.setBounds(314, 154, 32, 32);
		contentPane.add(lblStatus);
	}// fim do construtor
		// Criar um objeto para conectar com o banco de dados

	DAO dao = new DAO();
	private JLabel lblStatus;
	// Status da conexao
	private void status() {
	try {
	// estabelecer a conexao com o banco
	Connection con = dao.conectar();
	// status da conexao
	if (con == null) {
	// imprimir a mensagem no console
	System.out.println("Erro de conex�o");
	// trocar o icone
	lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/error.png")));
	} else {
	// imprimir a mensagem no console
	System.out.println("Conex�o estabelecida com sucesso");
	// exibir o icone
	lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ok.png")));
	}
	} catch (Exception e) {
	System.out.println(e);
	}
	}
}