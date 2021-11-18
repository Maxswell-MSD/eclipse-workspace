package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	// parametros de conexao
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbagenda";
	private String user = "root";
	private String password = "M6936995591845880s";

	// metodo de conexao (retorna a conexao)
	public Connection conectar() {
		// criar um objeto para estabelecer a conexao
		Connection con = null;
		// tratamento de excecoes usando atalho contro +espa�o para ele tentar acha a
		// palavra.
		try {
			// uso do driver para conectar com o banco ( para estabelecer a conex�o)
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;

		} catch (Exception e) {
			// exibir a excecao mostrando qual motivo n�o consegue acessar
			System.out.println(e);
			return null;
		}
		

	}
	//teste de conex�o com o banco
			public void testeConexao() {
				try {
					//abrir a conex�o com o banco
					Connection con = conectar();
					if (con == null) {
						System.out.println("Erro de conex�o");
					} else {
						System.out.println("Banco conectado");
					}
					con.close();
				}catch (Exception e) {
					System.out.println(e);
				}
				
			}
}
