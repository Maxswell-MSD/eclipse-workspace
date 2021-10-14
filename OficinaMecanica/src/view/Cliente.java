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
	private JTextField txtIdCli;
	private JTextField txtCliente;
	private JTextField txtFone;
	private JTextField txtEndereco;
	private JTextField txtEmail;
	private JTextField txtCep;
	private JTextField txtCpf;
	private JTextField txtCidade;
	private JTextField txtEstado;
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
		setTitle("MW.Mec\u00E2nica - Cliente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cliente.class.getResource("/img/carro1.png")));
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 618, 377);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setBounds(30, 123, 46, 14);
		getContentPane().add(lblNewLabel);
		
		txtIdCli = new JTextField();
		txtIdCli.setEnabled(false);
		txtIdCli.setBounds(60, 120, 46, 20);
		getContentPane().add(txtIdCli);
		txtIdCli.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setBounds(10, 165, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(60, 162, 116, 20);
		getContentPane().add(txtCliente);
		txtCliente.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Telefone");
		lblNewLabel_2.setBounds(184, 168, 62, 14);
		getContentPane().add(lblNewLabel_2);
		
		txtFone = new JTextField();
		txtFone.setBounds(236, 165, 86, 20);
		getContentPane().add(txtFone);
		txtFone.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Endere\u00E7o");
		lblNewLabel_3.setBounds(10, 196, 62, 14);
		getContentPane().add(lblNewLabel_3);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(70, 193, 191, 20);
		getContentPane().add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setBounds(328, 168, 62, 14);
		getContentPane().add(lblNewLabel_4);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(378, 165, 86, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("CEP");
		lblNewLabel_5.setBounds(131, 123, 46, 14);
		getContentPane().add(lblNewLabel_5);
		
		txtCep = new JTextField();
		txtCep.setBounds(162, 120, 86, 20);
		getContentPane().add(txtCep);
		txtCep.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("CPF");
		lblNewLabel_6.setBounds(475, 168, 31, 14);
		getContentPane().add(lblNewLabel_6);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(516, 165, 76, 20);
		getContentPane().add(txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Cidade");
		lblNewLabel_7.setBounds(10, 224, 46, 14);
		getContentPane().add(lblNewLabel_7);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(70, 221, 191, 20);
		getContentPane().add(txtCidade);
		txtCidade.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Estado");
		lblNewLabel_8.setBounds(276, 224, 46, 14);
		getContentPane().add(lblNewLabel_8);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(331, 221, 86, 20);
		getContentPane().add(txtEstado);
		txtEstado.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Bairro");
		lblNewLabel_9.setBounds(388, 196, 46, 14);
		getContentPane().add(lblNewLabel_9);
		
		txtBairro = new JTextField();
		txtBairro.setBounds(444, 193, 142, 20);
		getContentPane().add(txtBairro);
		txtBairro.setColumns(10);
		
		JLabel lblNewLabel_10 = new JLabel("Complemento");
		lblNewLabel_10.setBounds(10, 255, 97, 14);
		getContentPane().add(lblNewLabel_10);
		
		txtComplemento = new JTextField();
		txtComplemento.setBounds(99, 252, 191, 20);
		getContentPane().add(txtComplemento);
		txtComplemento.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("N\u00FAmero");
		lblNewLabel_11.setBounds(271, 196, 46, 14);
		getContentPane().add(lblNewLabel_11);
		
		txtNu = new JTextField();
		txtNu.setBounds(321, 193, 40, 20);
		getContentPane().add(txtNu);
		txtNu.setColumns(10);
		
		JButton btnAdicionarCliente = new JButton("Adicionar");
		btnAdicionarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Chamando o metodo de valida��o de cliente botao
				adicionarCliente();
			}
		});
		btnAdicionarCliente.setBounds(255, 283, 89, 23);
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
				} 
			else if (txtCep.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha o Cep do cliente ");
				txtCep.requestFocus();
				}
					
					else if (txtFone.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o telefone do cliente ");
					txtFone.requestFocus();
					}
				 else if (txtEmail.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o Email do cliente ");
						txtEmail.requestFocus();
						}
				 else if (txtCpf.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o CPF do cliente ");
						txtCpf.requestFocus();
						}
				 else if (txtEndereco.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o Endere�o do cliente ");
						txtEndereco.requestFocus();
						}
				 else if (txtNu.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o N�mero residencial do cliente ");
						txtNu.requestFocus();
						}
				 else if (txtBairro.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o Bairro do cliente ");
						txtBairro.requestFocus();
						}
				 else if (txtCidade.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha a Cidade do cliente ");
						txtCidade.requestFocus();
						}
				 else if (txtEstado.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o Estado ");
						txtEstado.requestFocus();
						}
			
		//////////////// L�gica Principal ////////////////////////////////////////////////////////	
				 else {
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
							pst.setString(4, txtFone.getText());
							pst.setString(5, txtCep.getText());
							pst.setString(6, txtEndereco.getText());
							pst.setString(7, txtNu.getText());
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
		txtFone.setText(null);
		txtCep.setText(null);
		txtEndereco.setText(null);
		txtNu.setText(null);
		txtCidade.setText(null);
		txtBairro.setText(null);
		txtComplemento.setText(null);
		txtEstado.setText(null);
}
}

