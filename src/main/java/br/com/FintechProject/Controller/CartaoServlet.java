package br.com.FintechProject.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.FintechProject.bean.ModelCartao;
import br.com.FintechProject.bean.ModelUsuario;
import br.com.FintechProject.dao.CartaoDAO;
import br.com.FintechProject.dao.GastoDAO;
import br.com.FintechProject.exception.DBException;
import br.com.FintechProject.factory.DAOFactory;

/**
 * Servlet implementation class CartaoServlet
 */
@WebServlet("/cadastrocartao")
public class CartaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   private CartaoDAO dao;
	   
	   @Override
	   public void init() throws ServletException{
		   super.init();
		   dao = DAOFactory.getCartaoDAO();
	   }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartaoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_usuario = 0;
		try {
		      String  nr_cartao = request.getParameter("nr_cartao") ;    
	          String  dt_validade = request.getParameter("dt_validade") ;
	          String  nm_pessoa = request.getParameter("nm_pessoa");
	          String  cv_cartao = request.getParameter("cv_cartao");
	          String  nm_bandeira = request.getParameter("nm_bandeira");
	          String  nm_banco = request.getParameter("nm_banco");
	          
	          HttpSession session = request.getSession(false);
	   
	          if (session != null) {
	        	    String userEmail = (String) session.getAttribute("user");
	        	     id_usuario = dao.buscarId(userEmail);
	          }
	      

	          ModelCartao cartao = new ModelCartao(nr_cartao,dt_validade,nm_pessoa,cv_cartao,nm_bandeira,nm_banco,id_usuario);

	          dao.cadastrar(cartao);
	          
	          response.sendRedirect("telaSucessoCartao.jsp");
	          
			  }
			  catch(DBException db){
				  response.sendRedirect("telaErroCadastro.jsp");
			  }catch(Exception e) {
				  response.sendRedirect("telaErroCadastro.jsp");
				  
			  }
			  
			
		doGet(request, response);
	}

}
