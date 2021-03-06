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
import java.awt.SystemColor;
import java.awt.Cursor;

public class Usuario extends JDialog {
	private JTextField txtId;
	private JTextField txtUsuario;
	private JTextField txtLogin;
	private JPasswordField txtSenha;
	private JButton btnAdicionar;
	private JButton btnPesquisar;
	private JButton btnEditar;
	private JButton btnExcluir;

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
		getContentPane().setBackground(SystemColor.window);
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
		
		btnPesquisar = new JButton("");
		btnPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPesquisar.setBorder(null);
		btnPesquisar.setContentAreaFilled(false);
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisarUsuario();
				
			
			
			
							}
		});
		btnPesquisar.setToolTipText("Pesquisar usu\u00E1rio");
		btnPesquisar.setIcon(new ImageIcon(Usuario.class.getResource("/img/pesquisar.png")));
		btnPesquisar.setBounds(201, 212, 80, 80);
		getContentPane().add(btnPesquisar);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(206, 173, 224, 20);
		getContentPane().add(txtSenha);
		
		btnAdicionar = new JButton("");
		btnAdicionar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionar.setBorder(null);
		btnAdicionar.setContentAreaFilled(false);
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionarUsuario();
			}
		});
		btnAdicionar.setEnabled(false);
		btnAdicionar.setToolTipText("Adicionar usu\u00E1rio");
		btnAdicionar.setIcon(new ImageIcon(Usuario.class.getResource("/img/create.png")));
		btnAdicionar.setBounds(98, 212, 94, 80);
		getContentPane().add(btnAdicionar);
		
		btnEditar = new JButton("");
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.setBorder(null);
		btnEditar.setContentAreaFilled(false);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editarUsuario();
			}
		});
		btnEditar.setEnabled(false);
		btnEditar.setToolTipText("Editar usu\u00E1rio");
		btnEditar.setIcon(new ImageIcon(Usuario.class.getResource("/img/update.png")));
		btnEditar.setBounds(290, 212, 80, 80);
		getContentPane().add(btnEditar);
		
		btnExcluir = new JButton("");
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.setBorder(null);
		btnExcluir.setContentAreaFilled(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirUsuario();
			}
		});
		btnExcluir.setEnabled(false);
		btnExcluir.setToolTipText("Excluir usu\u00E1rio");
		btnExcluir.setIcon(new ImageIcon(Usuario.class.getResource("/img/delete.png")));
		btnExcluir.setBounds(385, 212, 80, 80);
		getContentPane().add(btnExcluir);
		
		JLabel lblCamposObrigatrios = new JLabel("* Campos Obrigat\u00F3rios");
		lblCamposObrigatrios.setBounds(206, 11, 164, 14);
		getContentPane().add(lblCamposObrigatrios);
	}
	// fim do construtor importe a classe DAO crtl + shift + o
		DAO dao = new DAO();
		
		
	

		// pesquisar usuario (CRUD READ) Esse metodo sempre come?a com a valida?ao dos
		// campos e ele entra na logica principal
		private void pesquisarUsuario() {
			// validacao
			// se o campo txtId estiver vazio
			if (txtId.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o ID");
				txtId.requestFocus();
			} else {
				// logica principal Instru??o sql para pesquisar um usu?rio. esse comando ? dado
				// no Mysql para essa integra??o de verificar
				// pelo id se existe um usu?rio cadastrado com esse Id
				String read = "select * from usuarios where id=?";
				// tratamento de excecoes(ex: servidor indisponivel o try catch ele avisa e
				// mostra onde est? dando erro )
				try {
					// estabelecer uma conexao atraves da classe DAO que ? respons?vel pela liga??o
					// do sql abrindo a conex?o
					Connection con = dao.conectar();
					// preparar a instru??o sql PreparedStatement vai substituir (?) pelo conte?do
					// cadastrado no sql
					PreparedStatement pst = con.prepareStatement(read);
					// substituir parametros (?)
					pst.setString(1, txtId.getText());
					// resultado (executar a query que ? a instru??o do banco de dados mysql para
					// obter os dados)
					ResultSet rs = pst.executeQuery();
					// Criando condi??es se existir este usuario no banco execute
					if (rs.next()) {
						// setar campos do usu?rio se existir usu?rio cadastrado observe no sql os nomes
						// das colunas
						// essas numera??es equivale ao sql a ordem da coluna j? que o id ? da pesquisa
						// ele n?o se aplica aqui por ser 1
						txtUsuario.setText(rs.getString(2));
						txtLogin.setText(rs.getString(3));
						txtSenha.setText(rs.getString(4));
						// gerenciar botoes para acesso as determinadas modifica??es(UX)
						btnPesquisar.setEnabled(false);
						btnEditar.setEnabled(true);
						btnExcluir.setEnabled(true);
						// desativar o txtId quando gera um usu?rio cadastrado
						txtId.setEnabled(false);

						// sen?o existir usu?rio cadastrado mostre a seguinte mensagem
					} else {
						JOptionPane.showMessageDialog(null, "Usu?rio inexistente");
						// limpar o campo ID
						txtId.setText(null);
						// gerenciar os botoes
						btnAdicionar.setEnabled(true);
						btnPesquisar.setEnabled(false);
						btnEditar.setEnabled(false);
						btnExcluir.setEnabled(false);
						// desabilitar o txtId e posicionar o cursor no usuario
						txtId.setEnabled(false);
						txtUsuario.requestFocus();
					}
				} catch (Exception e) {
					// caso ocorra algum problema, mostre na tela o erro que est? relacionado na
					// infraestrutura
					System.out.println(e);
				}
			}
		}

		// adicionar usuario (CRUD Create) Cria??o de usu?rio pela janela interativa
		// Java
		private void adicionarUsuario() {
			// validacao dos campos obrigatorios
			if (txtUsuario.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o Usu?rio");
				txtUsuario.requestFocus();
			} else if (txtLogin.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o Login");
				txtLogin.requestFocus();
			} else {
				// instrucao sql para inserir um usuario o mesmo comando que damos no sql para
				// criar um usu?rio
				String create = "insert into usuarios(usuario,login,senha) values (?,?,md5(?))";
				// Bloco aula 10 linha copiada no bloco de cima
				try {
					// estabelecer uma conexao atraves da classe DAO que ? respons?vel pela liga??o
					// do sql abrindo a conex?o
					Connection con = dao.conectar();
					// preparar a instru??o sql PreparedStatement vai substituir (?) pelo conte?do
					// cadastrado no sql cada
					PreparedStatement pst = con.prepareStatement(create);
					// substituir parametros setamos o 2 de acordo com a posi??o de cadastro de
					// usu?rio no sql (?)
					pst.setString(1, txtUsuario.getText());
					pst.setString(2, txtLogin.getText());
					pst.setString(3, txtSenha.getText());
					// exibir uma caixa de mensagem mostrando que foi feito o cadastro com sucesso.
					int confirma = pst.executeUpdate();
					if (confirma == 1) {
						JOptionPane.showMessageDialog(null, "Usu?rio adicionado com Sucesso");
					}
					// criando acao limpar caixa de texto quando os dados forem cadastrado
					limpar();
					con.close();
					// a linha abaixo trata o problema do campo unique no login, devolvendo uma mensagem amigavel ao usuario se o login ja existir
				} catch (java.sql.SQLIntegrityConstraintViolationException ex) {
					JOptionPane.showMessageDialog(null, "Login j? existente\nCadastre outro login");
					txtLogin.setText(null);
					txtLogin.requestFocus();
					}
					
				
				catch (Exception e) {
					System.out.println(e);
				}
			}

		}
		// FIM DO BLOCO AULA 10

		// Editar usuario (CRUD Update) Cria??o de usu?rio pela janela interativa Java
		private void editarUsuario() {
			// validacao dos campos obrigatorios
			if (txtUsuario.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o Usu?rio");
				txtUsuario.requestFocus();
			} else if (txtLogin.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o Login");
				txtLogin.requestFocus();
			} else {
				// instrucao sql para Editar usuario o mesmo comando que damos no sql para
				// Editar um usu?rio
				String update = "update usuarios set usuario=?,login=?,senha=md5(?) where id=?";
				try {
					// estabelecer uma conexao atraves da classe DAO que ? respons?vel pela liga??o
					// do sql abrindo a conex?o
					Connection con = dao.conectar();
					// preparar a instru??o sql PreparedStatement vai substituir (?) pelo conte?do
					// cadastrado no sql cada
					PreparedStatement pst = con.prepareStatement(update);
					// substituir parametros setamos o 2 de acordo com a posi??o de cadastro de
					// usu?rio no sql (?)
					pst.setString(1, txtUsuario.getText());
					pst.setString(2, txtLogin.getText());
					pst.setString(3, txtSenha.getText());
					pst.setString(4, txtId.getText());
					// exibir uma caixa de mensagem mostrando que o usu?rio foi editado com sucesso.
					int confirma = pst.executeUpdate();
					if (confirma == 1) {
						JOptionPane.showMessageDialog(null, "Dados do usu?rio alterado com Sucesso");
					}
					// criando acao limpar caixa de texto quando os dados forem cadastrado
					limpar();
					con.close();
					
				} catch (Exception e) {
					System.out.println(e);
				}
			}

		}

		// Exluir usuario (CRUD Delete) excluir um usu?rio pela janela interativa Java
		private void excluirUsuario() {
			// validacao dos campos obrigatorios
			//confirmar a exclusao do usuario
			int confirma = JOptionPane.showConfirmDialog(null, "Deseja realmente Excluir o usu?rio?", "Aten??o!", JOptionPane.YES_NO_OPTION);
			if(confirma ==JOptionPane.YES_OPTION) {
				// instrucao sql para deletar usuario o mesmo comando que damos no sql para
				// Editar um usu?rio
				String delete = "delete from usuarios where id=?";
				try {
					// estabelecer uma conexao atraves da classe DAO que ? respons?vel pela liga??o
					// do sql abrindo a conex?o
					Connection con = dao.conectar();
					// preparar a instru??o sql PreparedStatement vai substituir (?) pelo conte?do
					// cadastrado no sql cada
					PreparedStatement pst = con.prepareStatement(delete);
					// substituir parametros setamos o 2 de acordo com a posi??o de cadastro de
					// usu?rio no sql (?)
					pst.setString(1, txtId.getText());
					// exibir uma caixa de mensagem mostrando que o usu?rio foi excluido  com sucesso.
					int verifica = pst.executeUpdate();
					if (verifica == 1) {
						JOptionPane.showMessageDialog(null, "Dados do Usu?rio Deletado com Sucesso");
					}
					// criando acao limpar caixa de texto quando os dados forem cadastrado
					limpar();
					con.close();
					
					
				} catch (Exception e) {
					System.out.println(e);
				}
			}

		}

		// Anota??o Aula 10 Limpar campos e gerenciar os botoes
		// assim limpamos a caixa de texto apos criar um usu?rio para n?o duplicar o
		// cadastro
		private void limpar() {
			// habilitar a pesquisa por id
			txtId.setEnabled(true);
			// posicionar o cursor na caixa ID
			txtId.requestFocus();
			// Limpar as caixas de texto
			txtId.setText(null);
			txtUsuario.setText(null);
			txtLogin.setText(null);
			txtSenha.setText(null);
			// ativar o botao de pesquisa
			btnPesquisar.setEnabled(true);
			// desativar os demais botoes
			btnAdicionar.setEnabled(false);
			btnEditar.setEnabled(false);
			btnExcluir.setEnabled(false);
		}
}

