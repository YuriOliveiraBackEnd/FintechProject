package br.com.FintechProject.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import br.com.FintechProject.exception.EmailException;
import java.io.IOException;

import br.com.FintechProject.bean.ModelUsuario;
import br.com.FintechProject.bo.EmailBO;
import br.com.FintechProject.dao.UsuarioDAO;
import br.com.FintechProject.factory.DAOFactory;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	  private UsuarioDAO dao;
	  private EmailBO bo;
	   @Override
	   public void init() throws ServletException{
		   super.init();
		   dao = DAOFactory.getUsuarioDAO();
		   bo = new EmailBO();
	   }
	   
  
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
 

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String email_usuario = request.getParameter("email");
	    String senha_usuario = request.getParameter("senha");

	    ModelUsuario usuario = new ModelUsuario(email_usuario, senha_usuario);
	    if (dao.validarUsuario(usuario)) {
	        HttpSession session = request.getSession();
	        session.setAttribute("user", email_usuario);
	        String nome = dao.buscarnome(email_usuario);
	        session.setAttribute("nome", nome);
	        
	        request.getRequestDispatcher("index.jsp").forward(request, response);
//	        String mensagem = "Um login foi realizado";
//	        try {
//            bo.enviarEmail(email_usuario, "Login Realizado", mensagem);
//	        } catch (EmailException e) {
//	            e.printStackTrace();
//	        }
	    } else {
	    	    
           response.sendRedirect("telaErro.jsp");
	     
	    }
	 
	}
	   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	HttpSession session = request.getSession();
	    	session.invalidate();
	    	request.getRequestDispatcher("login.jsp").forward(request, response);
	    }
}



