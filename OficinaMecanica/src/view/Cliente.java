package view;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.DAO;

public class Cliente extends JDialog {
	private JTextField textIdCli;
	private JTextField txtCliente;
	private JTextField txtFoneCli;
	private JTextField txtEmail;
	private JTextField txtEndereco;
	private JTextField txtNumero;
	private JTextField txtCidade;
	private JTextField txtCep;
	private JTextField txtEstado;
	private JTextField txtBairro;
	private JTextField txtCpf;
	private JTextField txtComplemento;

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
		setTitle("MW.Mec\u00E2nica - Clientes");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cliente.class.getResource("/img/carro1.png")));
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 626, 374);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Telefone");
		lblNewLabel.setBounds(8, 170, 67, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(29, 95, 46, 14);
		getContentPane().add(lblId);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nome");
		lblNewLabel_1_1.setBounds(9, 133, 46, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(178, 170, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("CPF");
		lblNewLabel_1_2.setBounds(413, 170, 46, 14);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("CEP");
		lblNewLabel_1_2_1.setBounds(318, 95, 46, 14);
		getContentPane().add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_2 = new JLabel("Endereco");
		lblNewLabel_2.setBounds(275, 133, 77, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("N");
		lblNewLabel_3.setBounds(480, 207, 32, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Cidade");
		lblNewLabel_4.setBounds(8, 207, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Bairro");
		lblNewLabel_5.setBounds(318, 207, 46, 14);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Complemento");
		lblNewLabel_6.setBounds(8, 273, 126, 14);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Estado");
		lblNewLabel_7.setBounds(161, 207, 46, 14);
		getContentPane().add(lblNewLabel_7);
		
		textIdCli = new JTextField();
		textIdCli.setBounds(62, 92, 86, 20);
		getContentPane().add(textIdCli);
		textIdCli.setColumns(10);
		
		txtCliente = new JTextField();
		txtCliente.setColumns(10);
		txtCliente.setBounds(65, 130, 188, 20);
		getContentPane().add(txtCliente);
		
		txtFoneCli = new JTextField();
		txtFoneCli.setColumns(10);
		txtFoneCli.setBounds(62, 167, 109, 20);
		getContentPane().add(txtFoneCli);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(215, 167, 188, 20);
		getContentPane().add(txtEmail);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(360, 130, 188, 20);
		getContentPane().add(txtEndereco);
		
		txtNumero = new JTextField();
		txtNumero.setColumns(10);
		txtNumero.setBounds(516, 204, 32, 20);
		getContentPane().add(txtNumero);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(65, 204, 86, 20);
		getContentPane().add(txtCidade);
		
		txtCep = new JTextField();
		txtCep.setColumns(10);
		txtCep.setBounds(357, 92, 86, 20);
		getContentPane().add(txtCep);
		
		txtEstado = new JTextField();
		txtEstado.setColumns(10);
		txtEstado.setBounds(213, 204, 86, 20);
		getContentPane().add(txtEstado);
		
		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(357, 204, 86, 20);
		getContentPane().add(txtBairro);
		
		txtCpf = new JTextField();
		txtCpf.setColumns(10);
		txtCpf.setBounds(446, 167, 86, 20);
		getContentPane().add(txtCpf);
		
		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(89, 270, 188, 20);
		getContentPane().add(txtComplemento);
		
		JButton btnAdicionarCliente = new JButton("Adicionar");
		btnAdicionarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 adicionarCliente();
				
			}
		});
		btnAdicionarCliente.setBounds(263, 301, 89, 23);
		getContentPane().add(btnAdicionarCliente);

	}
	// fim do construtor importe a classe DAO crtl + shift + o


	// criar objeto para reutilizar a classe DAO(Conexao com o banco)
	DAO dao = new DAO();
	
	
	
	
	
	//metodo para inserir um novo cliente
	private void adicionarCliente() {
	//validacao dos campos obrigatorios
	if (txtCliente.getText().isEmpty()) {
	JOptionPane.showMessageDialog(null, "Preencha o nome do cliente ");
	txtCliente.requestFocus();
	
	} else if (txtCep.getText().isEmpty()) {
		JOptionPane.showMessageDialog(null, "Preencha o CEP ");
		txtCep.requestFocus();
	
	} else if (txtFoneCli.getText().isEmpty()) {
	JOptionPane.showMessageDialog(null, "Preencha o Telefone do cliente ");
	txtFoneCli.requestFocus();
	
	} else if (txtEmail.getText().isEmpty()) {
		JOptionPane.showMessageDialog(null, "Preencha o Email do cliente ");
		txtEmail.requestFocus();
	
	} else if (txtCpf.getText().isEmpty()) {
		JOptionPane.showMessageDialog(null, "Preencha o CPF do Cliente ");
		txtCpf.requestFocus();
		

		
	
		
	} else if (txtEndereco.getText().isEmpty()) {
		JOptionPane.showMessageDialog(null, "Preencha o Endere�o do cliente ");
		txtEndereco.requestFocus();
		
	} else if (txtEstado.getText().isEmpty()) {
		JOptionPane.showMessageDialog(null, "Preencha o Estado ");
		txtEstado.requestFocus();
		
	} else if (txtBairro.getText().isEmpty()) {
		JOptionPane.showMessageDialog(null, "Preencha o Bairro ");
		txtBairro.requestFocus();
		
	} else if (txtCidade.getText().isEmpty()) {
		JOptionPane.showMessageDialog(null, "Preencha A Cidade ");
		txtCidade.requestFocus();
		
	} else if (txtNumero.getText().isEmpty()) {
		JOptionPane.showMessageDialog(null, "Preencha o N�mero Residencial ");
		txtNumero.requestFocus();
		
	
		
	} else if (txtComplemento.getText().isEmpty()) {
		JOptionPane.showMessageDialog(null, "Preencha o Complemento");
		txtComplemento.requestFocus();
		
	

		
		
		
	// logica principal
	// String (query) SQL
	String create = "insert into clientes (nome,cpf,email,telefone,cep,endereco,numero,cidade,bairro,complemento,estado) values(?,?,?,?,?,?,?,?,?,?,?)";
	try {
	//abrir a conexao com o banco
	Connection con = dao.conectar();	
	//preparar a conexao com a instrucao sql(query)
	PreparedStatement pst = con.prepareStatement(create);
	//substituir os parametros(?,?) pelo conteudo das caixas texto
	pst.setString(1, txtCliente.getText());
	pst.setString(2, txtCpf.getText());
	pst.setString(3, txtEmail.getText());
	pst.setString(4, txtFoneCli.getText());
	pst.setString(5, txtCep.getText());
	pst.setString(6, txtEndereco.getText());
	pst.setString(7, txtNumero.getText());
	pst.setString(8, txtCidade.getText());
	pst.setString(9, txtBairro.getText());
	pst.setString(10, txtComplemento.getText());
	pst.setString(11, txtEstado.getText());
	
	
	
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
	//limpar os campos e gerenciar os botoes
	private void limpar() {
	txtCliente.setText(null);
	txtCpf.setText(null);
	txtEmail.setText(null);
	txtFoneCli.setText(null);
	txtCep.setText(null);
	txtEndereco.setText(null);
	txtNumero.setText(null);
	txtCidade.setText(null);
	txtBairro.setText(null);
	txtComplemento.setText(null);
	txtEstado.setText(null);
	
	}
}
