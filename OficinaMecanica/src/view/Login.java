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
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.border.EtchedBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class Login extends JFrame {

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
					Login frame = new Login();
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
	public Login() {
		setBackground(SystemColor.textHighlight);
		setForeground(SystemColor.activeCaption);
		setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				// evento disparado quando a janela e ativada
				status();
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/img/carro1.png")));
		setResizable(false);
		setTitle("MW.Oficina");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textLogin = new JTextField();
		textLogin.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		textLogin.setBackground(SystemColor.window);
		textLogin.setBounds(82, 29, 265, 20);
		contentPane.add(textLogin);
		textLogin.setColumns(10);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBackground(SystemColor.activeCaption);
		lblNewLabel.setBounds(35, 32, 46, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setBackground(SystemColor.activeCaption);
		lblNewLabel_1.setBounds(35, 68, 36, 14);
		contentPane.add(lblNewLabel_1);

		txtSenha = new JPasswordField();
		txtSenha.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtSenha.setBackground(SystemColor.window);
		txtSenha.setBounds(82, 65, 265, 20);
		contentPane.add(txtSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEntrar.setBackground(SystemColor.window);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logar();
			}
		});
		btnEntrar.setBounds(43, 154, 76, 23);
		contentPane.add(btnEntrar);

		lblStatus = new JLabel("");
		lblStatus.setIcon(new ImageIcon(Login.class.getResource("/img/vermelho.png")));
		lblStatus.setBounds(296, 115, 62, 40);
		contentPane.add(lblStatus);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/img/Cab.png")));
		lblNewLabel_2.setBounds(193, 122, 231, 128);
		contentPane.add(lblNewLabel_2);
	}// fim do construtor
		// Criar um objeto para conectar com o banco de dados

	DAO dao = new DAO();
	private JLabel lblStatus;
	private JLabel lblNewLabel_2;
	// Status da conexao
	private void status() {
	try {
	// estabelecer a conexao com o banco
	Connection con = dao.conectar();
	// status da conexao
	if (con == null) {
	// imprimir a mensagem no console
	System.out.println("Erro de conex?o");
	// trocar o icone
	lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/vermelho.png")));
	} else {
	// imprimir a mensagem no console
	System.out.println("Conex?o estabelecida com sucesso");
	// exibir o icone
	lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/verde.png")));
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
		JOptionPane.showMessageDialog(null, "Preencha o nome do usu?rio");
		// posicionar o cursor na caixa de texto do usuario
		textLogin.requestFocus();
		} else {
		// logica principal do login
		try {
		// query (comando sql)
		String read = "select * from usuarios where login=? and senha=md5(?)";
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
		JOptionPane.showMessageDialog(null, "login e/ou senha inv?lido(s)");
		}
		con.close(); //encerrar a conexao
		} catch (Exception e) {
		System.out.println(e);
		}
		}
		}
	}