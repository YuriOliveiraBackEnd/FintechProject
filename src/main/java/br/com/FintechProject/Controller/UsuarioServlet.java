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

import br.com.FintechProject.bean.ModelUsuario;
import br.com.FintechProject.dao.GastoDAO;
import br.com.FintechProject.dao.UsuarioDAO;
import br.com.FintechProject.exception.DBException;
import br.com.FintechProject.factory.DAOFactory;

/**
 * Servlet implementation class CadastroUsuario
 */
@WebServlet("/cadastrousuario")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	   private UsuarioDAO dao;
	   
	   @Override
	   public void init() throws ServletException{
		   super.init();
		   dao = DAOFactory.getUsuarioDAO();
	   }
	   
    public UsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  try {
	      String  nome = request.getParameter("nome") ;    
          String  nr_cpf = request.getParameter("cpf") ;
          String  tel_usuario = request.getParameter("telefone");
          String  email_usuario = request.getParameter("email");
          String  senha_usuario = request.getParameter("senha");
          String data = request.getParameter("data");
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
          LocalDate dt_nasc = LocalDate.parse(data, formatter);
          
          
          ModelUsuario usuario = new ModelUsuario(nome,nr_cpf,tel_usuario,email_usuario,senha_usuario,dt_nasc);
          
          dao.cadastrar(usuario);
          
          response.sendRedirect("login.jsp");
          
		  }
		  catch(DBException db){
			  response.sendRedirect("telaErroCadastro.jsp");
		  }catch(Exception e) {
			  response.sendRedirect("telaErroCadastro.jsp");
			  
		  }
		  
		
          
	}

}

