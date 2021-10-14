package view;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.DAO;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Cliente extends JDialog {
	private JTextField textField;
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
		lblNewLabel.setBounds(351, 235, 67, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(62, 199, 46, 14);
		getContentPane().add(lblId);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome");
		lblNewLabel_1_1.setBounds(62, 235, 46, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setBounds(118, 196, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		txtCliente = new JTextField();
		txtCliente.setColumns(10);
		txtCliente.setBounds(121, 232, 188, 20);
		getContentPane().add(txtCliente);
		
		txtFoneCli = new JTextField();
		txtFoneCli.setColumns(10);
		txtFoneCli.setBounds(428, 232, 109, 20);
		getContentPane().add(txtFoneCli);
		
		JButton btnAdicionarCliente = new JButton("Adicionar");
		btnAdicionarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 adicionarCliente();
				
			}
		});
		btnAdicionarCliente.setBounds(118, 285, 89, 23);
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
		scrollPane.setViewportView(tableCliente);

	}
	// fim do construtor importe a classe DAO crtl + shift + o


	// criar objeto para reutilizar a classe DAO(Conexao com o banco)
	DAO dao = new DAO();
	private JTextField txtPesquisar;
	private JTable tableCliente;
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
	
	// Pesquisa avan�ada de clientes usando abiblioteca rs2xml
	
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
	
	
	
	
	//limpar os campos e gerenciar os botoes
	private void limpar() {
	txtCliente.setText(null);
	txtFoneCli.setText(null);
	}
}

