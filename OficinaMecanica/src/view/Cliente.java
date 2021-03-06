package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import Atxy2k.CustomTextField.RestrictedTextField;
import model.DAO;
import net.proteanit.sql.DbUtils;
import java.awt.Cursor;

public class Cliente extends JDialog {
	private JTextField txtIdCli;
	private JTextField txtCliente;
	private JTextField txtFone;
	private JTextField txtEndereco;
	private JTextField txtEmail;
	private JTextField txtCep;
	private JTextField txtCpf;
	private JTextField txtCidade;
	private JTextField txtBairro;
	private JTextField txtComplemento;
	private JTextField txtNu;

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
		getContentPane().setBackground(SystemColor.window);
		setBackground(Color.BLACK);
		setTitle("MW.Mec\u00E2nica - Cliente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cliente.class.getResource("/img/carro1.png")));
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 618, 377);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(24, 158, 46, 14);
		getContentPane().add(lblNewLabel);

		txtIdCli = new JTextField();
		txtIdCli.setEnabled(false);
		txtIdCli.setBounds(54, 155, 46, 20);
		getContentPane().add(txtIdCli);
		txtIdCli.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 186, 46, 14);
		getContentPane().add(lblNewLabel_1);

		txtCliente = new JTextField();
		txtCliente.setBounds(60, 183, 116, 20);
		getContentPane().add(txtCliente);
		txtCliente.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Telefone");
		lblNewLabel_2.setBounds(184, 189, 62, 14);
		getContentPane().add(lblNewLabel_2);

		txtFone = new JTextField();
		txtFone.setBounds(236, 186, 86, 20);
		getContentPane().add(txtFone);
		txtFone.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Endere\u00E7o");
		lblNewLabel_3.setBounds(10, 220, 62, 14);
		getContentPane().add(lblNewLabel_3);

		txtEndereco = new JTextField();
		txtEndereco.setBounds(70, 217, 191, 20);
		getContentPane().add(txtEndereco);
		txtEndereco.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setBounds(328, 189, 62, 14);
		getContentPane().add(lblNewLabel_4);

		txtEmail = new JTextField();
		txtEmail.setBounds(378, 186, 86, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("CEP");
		lblNewLabel_5.setBounds(125, 158, 46, 14);
		getContentPane().add(lblNewLabel_5);

		txtCep = new JTextField();
		txtCep.setBounds(156, 155, 86, 20);
		getContentPane().add(txtCep);
		txtCep.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("CPF");
		lblNewLabel_6.setBounds(475, 189, 31, 14);
		getContentPane().add(lblNewLabel_6);

		txtCpf = new JTextField();
		txtCpf.setBounds(516, 186, 76, 20);
		getContentPane().add(txtCpf);
		txtCpf.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("Cidade");
		lblNewLabel_7.setBounds(10, 248, 46, 14);
		getContentPane().add(lblNewLabel_7);

		txtCidade = new JTextField();
		txtCidade.setBounds(70, 245, 191, 20);
		getContentPane().add(txtCidade);
		txtCidade.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("UF");
		lblNewLabel_8.setBounds(296, 248, 46, 14);
		getContentPane().add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Bairro");
		lblNewLabel_9.setBounds(388, 217, 46, 14);
		getContentPane().add(lblNewLabel_9);

		txtBairro = new JTextField();
		txtBairro.setBounds(444, 214, 142, 20);
		getContentPane().add(txtBairro);
		txtBairro.setColumns(10);

		JLabel lblNewLabel_10 = new JLabel("Complemento");
		lblNewLabel_10.setBounds(10, 276, 97, 14);
		getContentPane().add(lblNewLabel_10);

		txtComplemento = new JTextField();
		txtComplemento.setBounds(99, 273, 191, 20);
		getContentPane().add(txtComplemento);
		txtComplemento.setColumns(10);

		JLabel lblNewLabel_11 = new JLabel("N\u00FAmero");
		lblNewLabel_11.setBounds(271, 217, 46, 14);
		getContentPane().add(lblNewLabel_11);

		txtNu = new JTextField();
		txtNu.setBounds(321, 214, 40, 20);
		getContentPane().add(txtNu);
		txtNu.setColumns(10);

		btnAdicionarCliente = new JButton("Adicionar");
		btnAdicionarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAdicionarCliente.setContentAreaFilled(false);
		btnAdicionarCliente.setBorder(null);
		btnAdicionarCliente.setIcon(new ImageIcon(Cliente.class.getResource("/img/create.png")));
		btnAdicionarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Chamando o metodo de valida??o de cliente botao
				adicionarCliente();
			}
		});
		btnAdicionarCliente.setBounds(318, 273, 72, 72);
		getContentPane().add(btnAdicionarCliente);

		txtPesquisar = new JTextField();
		txtPesquisar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// evento de digitar pesquisa igual do google de sugestoes de nomes de forma
				// automatica
				pesquisarCliente();
			}
		});
		txtPesquisar.setBounds(175, 12, 197, 20);
		getContentPane().add(txtPesquisar);
		txtPesquisar.setColumns(10);

		JButton btnNewButton = new JButton("");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(null);
		btnNewButton.setIcon(new ImageIcon(Cliente.class.getResource("/img/lupa.png")));
		btnNewButton.setBounds(125, 11, 32, 32);
		getContentPane().add(btnNewButton);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(10, 54, 582, 93);
		getContentPane().add(desktopPane);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setForeground(SystemColor.activeCaption);
		scrollPane.setBorder(null);
		scrollPane.setBackground(SystemColor.window);
		scrollPane.setBounds(0, 0, 582, 93);
		desktopPane.add(scrollPane);

		tableCliente = new JTable();
		tableCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Criando evento de preenchimento ao direcionar o cursor do mouse sobre um
				// usu?rio listado
				setarCampos();
			}
		});
		scrollPane.setViewportView(tableCliente);

		cboUf = new JComboBox();
		cboUf.setModel(new DefaultComboBoxModel(
				new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA",
						"PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		cboUf.setBounds(321, 244, 54, 22);
		getContentPane().add(cboUf);

		// uso da biblioteca Atxy2k para valida?a? do campo cep
		RestrictedTextField validar = new RestrictedTextField(txtCep);

		JButton btnCep = new JButton("Buscar");
		btnCep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Buscar por cep
				if (txtCep.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Informe o CEP");
					txtCep.requestFocus();
					// se a condi??o for verdadeira o else sera ignorado
				} else {
					// Buscar CEP
					buscarCep();

				}
			}
		});
		btnCep.setBounds(321, 154, 89, 23);
		getContentPane().add(btnCep);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// limpando busca por cep
				limpar();
			}
		});
		btnLimpar.setBounds(424, 154, 89, 23);
		getContentPane().add(btnLimpar);

		btnEditarUsuario = new JButton("Editar");
		btnEditarUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditarUsuario.setContentAreaFilled(false);
		btnEditarUsuario.setBorderPainted(false);
		btnEditarUsuario.setBorder(null);
		btnEditarUsuario.setIcon(new ImageIcon(Cliente.class.getResource("/img/update.png")));
		btnEditarUsuario.setEnabled(false);
		btnEditarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cliando evento de editar clientes
				editarCliente();
			}
		});
		btnEditarUsuario.setBounds(405, 273, 72, 72);
		getContentPane().add(btnEditarUsuario);

		btnExcluirUsuario = new JButton("Excluir");
		btnExcluirUsuario.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluirUsuario.setContentAreaFilled(false);
		btnExcluirUsuario.setBorder(null);
		btnExcluirUsuario.setIcon(new ImageIcon(Cliente.class.getResource("/img/delete.png")));
		btnExcluirUsuario.setEnabled(false);
		btnExcluirUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Criando evento de deletar cliente cadastrado
				excluirCliente();
			}
		});
		btnExcluirUsuario.setBounds(501, 273, 72, 72);
		getContentPane().add(btnExcluirUsuario);
		validar.setOnlyNums(true);
		validar.setLimit(8);

	}// Criando liga??o de busca dom4j

	private void buscarCep() {
		String Logradouro = "";
		String tipoLogradouro = "";
		String resultado = null;
		String cep = txtCep.getText();
		try {
			URL url = new URL("http://cep.republicavirtual.com.br/web_cep.php?cep=" + cep + "&formato=xml");
			SAXReader xml = new SAXReader();
			Document documento = xml.read(url);
			Element root = documento.getRootElement();
			for (Iterator<Element> it = root.elementIterator(); it.hasNext();) {
				Element element = it.next();
				// Se ele encontrar o nome da variavel farar o preenchimento de busca dos campos
				if (element.getQualifiedName().equals("cidade")) {
					// identificando e extraindo um documento do xml
					txtCidade.setText(element.getText());
				}
				if (element.getQualifiedName().equals("bairro")) {
					// identificando e extraindo um documento do xml
					txtBairro.setText(element.getText());
				}
				// Identificando Uf
				if (element.getQualifiedName().equals("uf")) {
					// identificando e extraindo um documento do xml
					cboUf.setSelectedItem(element.getText());
				}

				if (element.getQualifiedName().equals("tipo_logradouro")) {
					// identificando e extraindo um documento do xml
					tipoLogradouro = element.getText();

				}
				if (element.getQualifiedName().equals("logradouro")) {
					// identificando e extraindo um documento do xml
					Logradouro = element.getText();

				}
				// setar o campo endereco
				txtEndereco.setText(tipoLogradouro + " " + Logradouro);
				// Alertando se o cep n?o existir
				if (element.getQualifiedName().equals("resultado")) {
					resultado = element.getText();
					if (resultado.equals("1")) {
						// Colocando icone de ok de cep encontado
						/*
						 * lblStatus.setIcon(new
						 * javax.swing.ImageIcon(getClass().getResource("/img/okcep.png")));
						 */
					} else
						JOptionPane.showMessageDialog(null, "CEP n?o encontrado");

				}

			}

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// fim do construtor importe a classe DAO crtl + shift + o

	// criar objeto para reutilizar a classe DAO(Conexao com o banco)
	DAO dao = new DAO();
	private JTextField txtPesquisar;
	private JTable tableCliente;
	private JComboBox cboUf;
	private JButton btnExcluirUsuario;
	private JButton btnEditarUsuario;
	private JButton btnAdicionarCliente;

	// metodo para inserir um novo cliente
	private void adicionarCliente() {
		// validacao dos campos obrigatorios
		if (txtCliente.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o nome do cliente ");
			txtCliente.requestFocus();
		} else if (txtCep.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Cep do cliente ");
			txtCep.requestFocus();
		}

		else if (txtFone.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o telefone do cliente ");
			txtFone.requestFocus();
		} else if (txtEmail.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Email do cliente ");
			txtEmail.requestFocus();
		} else if (txtCpf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o CPF do cliente ");
			txtCpf.requestFocus();
		} else if (txtEndereco.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Endere?o do cliente ");
			txtEndereco.requestFocus();
		} else if (txtNu.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o N?mero residencial do cliente ");
			txtNu.requestFocus();
		} else if (txtBairro.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha o Bairro do cliente ");
			txtBairro.requestFocus();
		} else if (txtCidade.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha a Cidade do cliente ");
			txtCidade.requestFocus();
			
			
			
		}
		

		//////////////// L?gica Principal
		//////////////// ////////////////////////////////////////////////////////
		else {
			// logica principal
			// String (query) SQL
			String create = "insert into clientes (nome,cpf,email,telefone,cep,endereco,numero,cidade,bairro,complemento) values(?,?,?,?,?,?,?,?,?,?)";
			try {
				// abrir a conexao com o banco
				Connection con = dao.conectar();
				// preparar a conexao com a instrucao sql(query)
				PreparedStatement pst = con.prepareStatement(create);

				// substituir os parametros(?,?) pelo conteudo das caixas texto
				pst.setString(1, txtCliente.getText());
				pst.setString(2, txtCpf.getText());
				pst.setString(3, txtEmail.getText());
				pst.setString(4, txtFone.getText());
				pst.setString(5, txtCep.getText());
				pst.setString(6, txtEndereco.getText());
				pst.setString(7, txtNu.getText());
				pst.setString(8, txtCidade.getText());
				pst.setString(9, txtBairro.getText());
				pst.setString(10, txtComplemento.getText());

				// executar a query confirmando a inclusao do cliente
				int confirma = pst.executeUpdate();
				if (confirma == 1) {
					JOptionPane.showMessageDialog(null, "Cliente adicionado com sucesso.");
				}

				// encerrar a conexao
				con.close();

				// limpar os campos
				limpar();
				// a linha abaixo trata o problema do campo unique no login, devolvendo uma
				// mensagem amigavel ao usuario se o login ja existir
			} catch (java.sql.SQLIntegrityConstraintViolationException ex) {
				JOptionPane.showMessageDialog(null, "CPF ou Email J? Registrado\nCadastre novamente ");
				txtCpf.setText(null);
				txtCpf.requestFocus();
				txtEmail.setText(null);
				txtEmail.requestFocus();
			}

			catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	// Pesquisa avan?ada de clientes usando abiblioteca rs2xml

	private void pesquisarCliente() {

		String read = "select * from clientes where nome like ? order by nome";
		try {
			// abrir a conexao com o banco
			Connection con = dao.conectar();
			// preparar a query(instrucao sql) para pesquisar no banco
			PreparedStatement pst = con.prepareStatement(read);
			// substituir o parametro(?) Atencao ao % para completar a query
			pst.setString(1, txtPesquisar.getText() + "%");
			// obter os dados do banco (resultado)
			ResultSet rs = pst.executeQuery();
			// popular(preencher) a tabela com os dados do banco
			tableCliente.setModel(DbUtils.resultSetToTableModel(rs));

		} catch (Exception e) {
			System.out.println(e);

		}
	}

	///////////////////////////////////// EDITAR CLIENTE
	///////////////////////////////////// //////////////////////////////////////////////
	// EDITAR CLIENTE (CRUD Update) EDITAR CLIENTE CADASTRADO
	private void editarCliente() {
		// confirmar a exclusao do usuario
		int editar = JOptionPane.showConfirmDialog(null, "Deseja realmente Editar o usu?rio?", "Aten??o!",
				JOptionPane.YES_NO_OPTION);
		if (editar == JOptionPane.YES_OPTION)
			// validacao dos campos obrigatorios
			if (txtCliente.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o nome do Cliente");
				txtCliente.requestFocus();
			} else if (txtCpf.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o CPF");
				txtCpf.requestFocus();
			} else if (txtEmail.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o Email");
				txtEmail.requestFocus();

			} else if (txtFone.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o Telefone");
				txtFone.requestFocus();

			} else if (txtCep.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o CEP");
				txtCep.requestFocus();
			} else if (txtEndereco.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o Endere?o");
				txtEndereco.requestFocus();
			} else if (txtNu.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o N?mero residencial");
				txtNu.requestFocus();
			} else if (txtCidade.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha a Cidade");
				txtCidade.requestFocus();
			} else if (txtBairro.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o Bairro");
				txtBairro.requestFocus();
				cboUf.requestFocus();
			
				

			}
		
		
			
			else {
				// instrucao sql para Editar usuario o mesmo comando que damos no sql para
				// Editar um usu?rio
				String update = "update clientes set nome=?,cpf=?,email=?,telefone=?,cep=?,endereco=?,numero=?,cidade=?,bairro=?,complemento=? where idCli=?";
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
					pst.setString(2, txtCpf.getText());
					pst.setString(3, txtEmail.getText());
					pst.setString(4, txtFone.getText());
					pst.setString(5, txtCep.getText());
					pst.setString(6, txtEndereco.getText());
					pst.setString(7, txtNu.getText());
					pst.setString(8, txtCidade.getText());
					pst.setString(9, txtBairro.getText());
					pst.setString(10, txtComplemento.getText());
					pst.setString(11, txtIdCli.getText());
					

					// exibir uma caixa de mensagem mostrando que o usu?rio foi editado com sucesso.
					int confirma = pst.executeUpdate();
					if (confirma == 1) {
						JOptionPane.showMessageDialog(null, "Dados de Cliente alterado com Sucesso");
					}
					// criando acao limpar caixa de texto quando os dados forem cadastrado
					limpar();

					con.close();
					// a linha abaixo trata o problema do campo unique no cadastro de cliente ,
					// devolvendo uma mensagem amigavel ao usuario se o Cliente ja existir
				} catch (java.sql.SQLIntegrityConstraintViolationException ex) {
					JOptionPane.showMessageDialog(null, "CPF ou Email J? Registrado\nCadastre novamente ");
					txtCpf.setText(null);
					txtCpf.requestFocus();
					txtEmail.setText(null);
					txtEmail.requestFocus();
				}

				catch (Exception e) {
					System.out.println(e);
				}
			}

	}

	/////////////////////// DELETE (CRUD)
	/////////////////////// ///////////////////////////////////////////////
	// Exluir usuario (CRUD Delete) excluir um usu?rio pela janela interativa Java
	private void excluirCliente() {
		// validacao dos campos obrigatorios
		// confirmar a exclusao do usuario
		int confirma = JOptionPane.showConfirmDialog(null, "Deseja realmente Excluir o usu?rio?", "Aten??o!",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
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
				// exibir uma caixa de mensagem mostrando que o usu?rio foi excluido com
				// sucesso.
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

	// setar os campos do formulario com o conteudo da tabela assim que colocar o
	// cursor do mouse sobre o id ele vai preencher os campos
	private void setarCampos() {
		int setar = tableCliente.getSelectedRow();
		// (setar, 0) 0 -> 1? campo da tabela | 1 -> 2? campo da tabela ...
		txtIdCli.setText(tableCliente.getModel().getValueAt(setar, 0).toString());
		txtCliente.setText(tableCliente.getModel().getValueAt(setar, 1).toString());
		txtCpf.setText(tableCliente.getModel().getValueAt(setar, 2).toString());
		txtEmail.setText(tableCliente.getModel().getValueAt(setar, 3).toString());
		txtFone.setText(tableCliente.getModel().getValueAt(setar, 4).toString());
		txtCep.setText(tableCliente.getModel().getValueAt(setar, 5).toString());
		txtEndereco.setText(tableCliente.getModel().getValueAt(setar, 6).toString());
		txtNu.setText(tableCliente.getModel().getValueAt(setar, 7).toString());
		txtCidade.setText(tableCliente.getModel().getValueAt(setar, 8).toString());
		txtBairro.setText(tableCliente.getModel().getValueAt(setar, 9).toString());
		txtComplemento.setText(tableCliente.getModel().getValueAt(setar, 10).toString());
		btnEditarUsuario.setEnabled(true);
		btnExcluirUsuario.setEnabled(true);
		btnAdicionarCliente.setEnabled(false);

	}

	// limpar os campos e gerenciar os botoes
	private void limpar() {
		txtCliente.setText(null);
		txtCpf.setText(null);
		txtEmail.setText(null);
		txtFone.setText(null);
		txtCep.setText(null);
		txtEndereco.setText(null);
		txtNu.setText(null);
		txtCidade.setText(null);
		txtBairro.setText(null);
		txtComplemento.setText(null);
		cboUf.setSelectedItem(null);
		btnEditarUsuario.setEnabled(false);
		btnExcluirUsuario.setEnabled(false);
		btnAdicionarCliente.setEnabled(true);

	}
}
