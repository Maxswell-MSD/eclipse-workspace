package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	// parametros de conexao
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/dbmw";
	private String user = "root";
	private String password = "M6936995591845880s";
	
	// metodo de conexao (retorna a conexao)
	public Connection conectar() {
		// criar um objeto para estabelecer a conexao
		Connection con = null;
		// tratamento de excecoes usando atalho contro +espaço para ele tentar acha a palavra.
		try {
			// uso do driver para conectar com o banco ( para estabelecer a conexão)
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
			
			

		} catch (Exception e) {
			// exibir a excecao mostrando qual motivo não consegue acessar
			System.out.println(e);
			return null;
		}

	}
}
