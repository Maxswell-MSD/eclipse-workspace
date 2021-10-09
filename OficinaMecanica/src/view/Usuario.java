package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.DAO;

import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class Usuario extends JDialog {
	private JTextField txtId;
	private JTextField txtUsuario;
	private JTextField txtLogin;
	private JPasswordField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Usuario dialog = new Usuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Usuario() {
		setResizable(false);
		setTitle("MW.Mec\u00E2nica - Usu\u00E1rios");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Usuario.class.getResource("/img/carro1.png")));
		setModal(true);
		setBounds(100, 100, 626, 410);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 338, 610, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(140, 80, 31, 14);
		getContentPane().add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.setBounds(206, 77, 61, 20);
		getContentPane().add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNome = new JLabel("* Usu\u00E1rio");
		lblNome.setBounds(130, 114, 64, 14);
		getContentPane().add(lblNome);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(204, 108, 226, 20);
		getContentPane().add(txtUsuario);
		
		JLabel lblUsurio = new JLabel("* Login");
		lblUsurio.setBounds(130, 145, 46, 14);
		getContentPane().add(lblUsurio);
		
		txtLogin = new JTextField();
		txtLogin.setColumns(10);
		txtLogin.setBounds(204, 139, 226, 20);
		getContentPane().add(txtLogin);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(130, 176, 46, 14);
		getContentPane().add(lblSenha);
		
		JButton btnPesquisar = new JButton("");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
							}
		});
		btnPesquisar.setToolTipText("Pesquisar usu\u00E1rio");
		btnPesquisar.setIcon(new ImageIcon(Usuario.class.getResource("/img/read.png")));
		btnPesquisar.setBounds(201, 212, 80, 80);
		getContentPane().add(btnPesquisar);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(206, 173, 224, 20);
		getContentPane().add(txtSenha);
		
		JButton btnAdicionar = new JButton("");
		btnAdicionar.setEnabled(false);
		btnAdicionar.setToolTipText("Adicionar usu\u00E1rio");
		btnAdicionar.setIcon(new ImageIcon(Usuario.class.getResource("/img/create.png")));
		btnAdicionar.setBounds(98, 212, 94, 80);
		getContentPane().add(btnAdicionar);
		
		JButton btnEditar = new JButton("");
		btnEditar.setEnabled(false);
		btnEditar.setToolTipText("Editar usu\u00E1rio");
		btnEditar.setIcon(new ImageIcon(Usuario.class.getResource("/img/update.png")));
		btnEditar.setBounds(290, 212, 80, 80);
		getContentPane().add(btnEditar);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setEnabled(false);
		btnExcluir.setToolTipText("Excluir usu\u00E1rio");
		btnExcluir.setIcon(new ImageIcon(Usuario.class.getResource("/img/delete.png")));
		btnExcluir.setBounds(385, 212, 80, 80);
		getContentPane().add(btnExcluir);
		
		JLabel lblCamposObrigatrios = new JLabel("* Campos Obrigat\u00F3rios");
		lblCamposObrigatrios.setBounds(206, 11, 164, 14);
		getContentPane().add(lblCamposObrigatrios);
	}
	// adicionar usuario (CRUD Create) Cria��o de usu�rio pela janela interativa Java
		private void adicionarUsuario() {
			// validacao dos campos obrigatorios
			if (txtUsuario.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o Usu�rio");
				txtUsuario.requestFocus();
			} else if (txtLogin.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o Login");
				txtLogin.requestFocus();
			} else {
				// instrucao sql para inserir um usuario o mesmo comando que damos no sql para criar um usu�rio 
			String create = "insert into usuarios(usuario,login,senha) values (?,?,md5(?))";
			}
			
		}
		
		
		// Editar usuario (CRUD Update) Cria��o de usu�rio pela janela interativa Java
			private void editarUsuario() {
				// validacao dos campos obrigatorios
				if (txtUsuario.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o Usu�rio");
					txtUsuario.requestFocus();
				} else if (txtLogin.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o Login");
					txtLogin.requestFocus();
				} else {
					// instrucao sql para Editar usuario o mesmo comando que damos no sql para Editar um usu�rio 
				String update = "update usuarios set usuario=?,login=?,senha=md5(?) where id=?";
				}
				
			}
			// Exluir usuario (CRUD Delete) excluir um  usu�rio pela janela interativa Java
					private void excluirUsuario() {
						// validacao dos campos obrigatorios
						if (txtUsuario.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Preencha o Usu�rio");
							txtUsuario.requestFocus();
						} else if (txtLogin.getText().isEmpty()) {
							JOptionPane.showMessageDialog(null, "Preencha o Login");
							txtLogin.requestFocus();
						} else {
							// instrucao sql para deletar usuario o mesmo comando que damos no sql para Editar um usu�rio 
						String delete = "delete from usuarios where id=?";
						}
						
					}
	}