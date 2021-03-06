package view;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.DAO;
import net.proteanit.sql.DbUtils;

public class Cliente extends JDialog {
	private JTextField txtIdCli;
	private JTextField txtCliente;
	private JTextField txtFoneCli;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente dialog = new Cliente();
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
	public Cliente() {
		setTitle("InfoX - Clientes");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cliente.class.getResource("/img/pc2.png")));
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 626, 374);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Telefone");
		lblNewLabel.setBounds(350, 220, 67, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(62, 183, 46, 14);
		getContentPane().add(lblId);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome");
		lblNewLabel_1_1.setBounds(62, 220, 46, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		txtIdCli = new JTextField();
		txtIdCli.setEnabled(false);
		txtIdCli.setBounds(118, 180, 86, 20);
		getContentPane().add(txtIdCli);
		txtIdCli.setColumns(10);
		
		txtCliente = new JTextField();
		txtCliente.setColumns(10);
		txtCliente.setBounds(118, 217, 188, 20);
		getContentPane().add(txtCliente);
		
		txtFoneCli = new JTextField();
		txtFoneCli.setColumns(10);
		txtFoneCli.setBounds(427, 217, 109, 20);
		getContentPane().add(txtFoneCli);
		
		btnAdicionarCliente = new JButton("Adicionar");
		btnAdicionarCliente.setIcon(new ImageIcon(Cliente.class.getResource("/img/create.png")));
		btnAdicionarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 adicionarCliente();
				
			}
		});
		btnAdicionarCliente.setBounds(128, 248, 64, 72);
		getContentPane().add(btnAdicionarCliente);
		
		txtPesquisar = new JTextField();
		txtPesquisar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				//evento de pesquisa do google de sugestoes de nomes de forma automatica
				pesquisarCliente();
			}
		});
		txtPesquisar.setBounds(20, 23, 197, 20);
		getContentPane().add(txtPesquisar);
		txtPesquisar.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Cliente.class.getResource("/img/pesquisar.png")));
		btnNewButton.setBounds(233, 11, 32, 32);
		getContentPane().add(btnNewButton);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(46, 67, 532, 108);
		getContentPane().add(desktopPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 532, 108);
		desktopPane.add(scrollPane);
		
		tableCliente = new JTable();
		tableCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Gerando evento em cursor do mouser ser direcionado para lista de cadastrados e fara o preenchiemto dos campos
				setarCampos();
			}
		});
		scrollPane.setViewportView(tableCliente);
		
		btnEditarCliente = new JButton("Editar");
		btnEditarCliente.setIcon(new ImageIcon(Cliente.class.getResource("/img/update.png")));
		btnEditarCliente.setEnabled(false);
		btnEditarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Criando evento de editar cliente
				editarCliente();
			}
		});
		btnEditarCliente.setBounds(251, 252, 64, 64);
		getContentPane().add(btnEditarCliente);
		
		btnExcluirCliente = new JButton("Excluir");
		btnExcluirCliente.setIcon(new ImageIcon(Cliente.class.getResource("/img/delete.png")));
		btnExcluirCliente.setEnabled(false);
		btnExcluirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// deletando cliente cadastrado
				excluirCliente();			}
		});
		btnExcluirCliente.setBounds(380, 252, 64, 64);
		getContentPane().add(btnExcluirCliente);

	}
	// fim do construtor importe a classe DAO crtl + shift + o


	// criar objeto para reutilizar a classe DAO(Conexao com o banco)
	DAO dao = new DAO();
	private JTextField txtPesquisar;
	private JTable tableCliente;
	private JButton btnEditarCliente;
	private JButton btnExcluirCliente;
	private JButton btnAdicionarCliente;
	//metodo para inserir um novo cliente
	private void adicionarCliente() {
	//validacao dos campos obrigatorios
	if (txtCliente.getText().isEmpty()) {
	JOptionPane.showMessageDialog(null, "Preencha o nome do cliente ");
	txtCliente.requestFocus();
	} else if (txtFoneCli.getText().isEmpty()) {
	JOptionPane.showMessageDialog(null, "Preencha o fone do cliente ");
	txtFoneCli.requestFocus();
	} else {
	// logica principal
	// String (query) SQL
	String create = "insert into clientes (nome,fone) values(?,?)";
	try {
	//abrir a conexao com o banco
	Connection con = dao.conectar();
	//preparar a conexao com a instrucao sql(query)
	PreparedStatement pst = con.prepareStatement(create);
	//substituir os parametros(?,?) pelo conteudo das caixas texto
	pst.setString(1, txtCliente.getText());
	pst.setString(2, txtFoneCli.getText());
	//executar a query confirmando a inclusao do cliente
	int confirma = pst.executeUpdate();
	if (confirma == 1) {
	JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso.");
	}
	//encerrar a conexao
	con.close();
	//limpar os campos
	limpar();
	
	
	
	} catch (Exception e) {
	System.out.println(e);
	}
	}
	}
	
	// Pesquisa avan?ada de clientes usando abiblioteca rs2xml
	
	private void pesquisarCliente() {

		String read = "select * from clientes where nome like ? order by nome";
		try {
		//abrir a conexao com o banco
		Connection con = dao.conectar();
		//preparar a query(instrucao sql) para pesquisar no banco
		PreparedStatement pst = con.prepareStatement(read);
		//substituir o parametro(?) Atencao ao % para completar a query
		pst.setString(1, txtPesquisar.getText() + "%");
		//obter os dados do banco (resultado)
		ResultSet rs = pst.executeQuery();
		//popular(preencher) a tabela com os dados do banco
		tableCliente.setModel(DbUtils.resultSetToTableModel(rs));
		
	} catch (Exception e) {
		System.out.println(e);
		}
	}
	// setar os campos do formulario com o conteudo da tabela assim que colocar o cursor do mouse sobre o id ele vai preencher os campos
	private void setarCampos() {
	int setar = tableCliente.getSelectedRow();
	//(setar, 0) 0 -> 1? campo da tabela | 1 -> 2? campo da tabela ...
	txtIdCli.setText(tableCliente.getModel().getValueAt(setar, 0).toString());
	txtCliente.setText(tableCliente.getModel().getValueAt(setar, 1).toString());
	txtFoneCli.setText(tableCliente.getModel().getValueAt(setar, 2).toString());
	btnEditarCliente.setEnabled(true);
	btnExcluirCliente.setEnabled(true);
	btnAdicionarCliente.setEnabled(false);
	}

	// EDITAR CLIENTE (CRUD Update) EDITAR CLIENTE CADASTRADO
		private void editarCliente() {
			
			//confirmar a exclusao do usuario
			int editar = JOptionPane.showConfirmDialog(null, "Deseja realmente Editar o usu?rio?", "Aten??o!", JOptionPane.YES_NO_OPTION);
			if(editar ==JOptionPane.YES_OPTION)
			// validacao dos campos obrigatorios
			if (txtCliente.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o nome do Cliente");
				txtCliente.requestFocus();
			} else if (txtFoneCli.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o Login");
				txtFoneCli.requestFocus();
			} else {
				// instrucao sql para Editar usuario o mesmo comando que damos no sql para
				// Editar um usu?rio
				String update = "update clientes set nome=?,fone=? where idCli=?";
				try {
					// estabelecer uma conexao atraves da classe DAO que ? respons?vel pela liga??o
					// do sql abrindo a conex?o
					Connection con = dao.conectar();
					// preparar a instru??o sql PreparedStatement vai substituir (?) pelo conte?do
					// cadastrado no sql cada
					PreparedStatement pst = con.prepareStatement(update);
					// substituir parametros setamos o 2 de acordo com a posi??o de cadastro de
					// usu?rio no sql (?)
					
					pst.setString(1, txtCliente.getText());
					pst.setString(2, txtFoneCli.getText());
					pst.setString(3, txtIdCli.getText());
					
					// exibir uma caixa de mensagem mostrando que o usu?rio foi editado com sucesso.
					int confirma = pst.executeUpdate();
					if (confirma == 1) {
						JOptionPane.showMessageDialog(null, "Dados de Cliente alterado com Sucesso");
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
		private void excluirCliente() {
			// validacao dos campos obrigatorios
			//confirmar a exclusao do usuario
			int confirma = JOptionPane.showConfirmDialog(null, "Deseja realmente Excluir o usu?rio?", "Aten??o!", JOptionPane.YES_NO_OPTION);
			if(confirma ==JOptionPane.YES_OPTION) {
				// instrucao sql para deletar usuario o mesmo comando que damos no sql para
				// Editar um usu?rio
				String delete = "delete from clientes where idCli=?";
				try {
					// estabelecer uma conexao atraves da classe DAO que ? respons?vel pela liga??o
					// do sql abrindo a conex?o
					Connection con = dao.conectar();
					// preparar a instru??o sql PreparedStatement vai substituir (?) pelo conte?do
					// cadastrado no sql cada
					PreparedStatement pst = con.prepareStatement(delete);
					// substituir parametros setamos o 2 de acordo com a posi??o de cadastro de
					// usu?rio no sql (?)
					pst.setString(1, txtIdCli.getText());
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
	
	
	
	//limpar os campos e gerenciar os botoes
	private void limpar() {
	txtCliente.setText(null);
	txtFoneCli.setText(null);
	btnEditarCliente.setEnabled(false);
	btnExcluirCliente.setEnabled(false);
	btnAdicionarCliente.setEnabled(true);
	}
}

