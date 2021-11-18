package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DAO;
import model.JavaBeans;

/**
 * Servlet implementation class Controller
 * urlPatterns recebe requisições da aplicação
 */
@WebServlet(urlPatterns={"/Controller","/main"})
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//criar objetos para acessar a camada model (JavaBeans e DAO)
	JavaBeans javabeans = new JavaBeans();
	DAO dao = new DAO();

    /**
     * Default constructor. 
     */
    public Controller() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Método principal do controller
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		//teste de conexão
		dao.testeConexao();
	}

}
