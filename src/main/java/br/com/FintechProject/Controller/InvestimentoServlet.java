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

import br.com.FintechProject.bean.ModelInvestimento;
import br.com.FintechProject.bean.ModelRendimento;
import br.com.FintechProject.dao.InvestimentoDAO;
import br.com.FintechProject.dao.RendimentoDAO;
import br.com.FintechProject.exception.DBException;
import br.com.FintechProject.factory.DAOFactory;

/**
 * Servlet implementation class InvestimentoServlet
 */
@WebServlet("/cadastroinvestimento")
public class InvestimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	   private InvestimentoDAO dao;
	   
	   @Override
	   public void init() throws ServletException{
		   super.init();
		   dao = DAOFactory.getInvestimentoDAO();
	   }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InvestimentoServlet() {
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
		  String  titulo = request.getParameter("titulo");    
          String  descricao = request.getParameter("descricao");
          String  categoria = request.getParameter("categoria");
          double valor =
       	   Double.parseDouble(request.getParameter("valor"));
        
          String data = request.getParameter("data");
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
          LocalDate dt_investimento= LocalDate.parse(data, formatter);
          
      
        
          HttpSession session = request.getSession(false);
          if (session != null) {
      	    String userEmail = (String) session.getAttribute("user");
      	     id_usuario = dao.buscarId(userEmail);
        }
 
     
          ModelInvestimento investimento = new ModelInvestimento(dt_investimento,valor,descricao,titulo,categoria,id_usuario);

          dao.cadastrar(investimento);
		
          response.sendRedirect("telaSucessoInvestimento.jsp");
		}
			  catch(DBException db){
			  response.sendRedirect("telaErroCadastro.jsp");
		  }catch(Exception e) {
			  response.sendRedirect("telaErroCadastro.jsp");
			  
		  }
		  
		doGet(request, response);
	}

}
