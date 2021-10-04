package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DAO;

import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.security.Principal;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Usuarios extends JFrame {

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
					Usuarios frame = new Usuarios();
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
	public Usuarios() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				// evento disparado quando a janela e ativada
				status();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Usuarios.class.getResource("/img/carro1.png")));
		setResizable(false);
		setTitle("MW.Oficina");
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
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar();
			}
		});
		btnEntrar.setBounds(43, 154, 76, 23);
		contentPane.add(btnEntrar);

		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(Usuarios.class.getResource("/img/serveroff.png")));
		lblStatus.setBounds(314, 154, 48, 48);
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
	lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/serveroff.png")));
	} else {
	// imprimir a mensagem no console
	System.out.println("Conex�o estabelecida com sucesso");
	// exibir o icone
	lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/serveron.png")));
	}
	//encerrar a conexao
		con.close();
	} catch (Exception e) {
	System.out.println(e);
	}
	}
	// login no sistema
		private void logar() {
		// validacao de campos obrigatorios
		if (textLogin.getText().isEmpty()) {
		// caixa de mensagem
		JOptionPane.showMessageDialog(null, "Preencha o nome do usu�rio");
		// posicionar o cursor na caixa de texto do usuario
		textLogin.requestFocus();
		} else {
		// logica principal do login
		try {
		// query (comando sql)
		String read = "select * from usuarios where usuario=? and senha=md5(?)";
		// abrir a conexao
		Connection con = dao.conectar();
		// Uso do PrepareStatement(JDBC) para substituir as ? pelo conteudo das caixas
		// de texto
		PreparedStatement pst = con.prepareStatement(read);
		// substituir as ? pelo conteudo das caixas de texto
		pst.setString(1, textLogin.getText());
		pst.setString(2, txtSenha.getText());
		//Uso do ResutSet para obter os dados do banco
		ResultSet rs = pst.executeQuery();
		//se existir usuario cadastrado com login e senha
		if (rs.next()) {
		//ativar a tela principal
		Inicial inicial = new Inicial();
		inicial.setVisible(true);
		this.dispose(); //fechar a tela de login
		} else {
		JOptionPane.showMessageDialog(null, "login e/ou senha inv�lido(s)");
		}
		con.close(); //encerrar a conexao
		} catch (Exception e) {
		System.out.println(e);
		}
		}
		}
	}