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
import java.util.List;

import br.com.FintechProject.bean.ModelCartao;
import br.com.FintechProject.bean.ModelGasto;
import br.com.FintechProject.dao.GastoDAO;
import br.com.FintechProject.exception.DBException;
import br.com.FintechProject.factory.DAOFactory;

/**
 * Servlet implementation class GastoServlet
 */
@WebServlet("/gastoservlet")
public class GastoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private GastoDAO dao;
   
   @Override
   public void init() throws ServletException{
	   super.init();
	   dao = DAOFactory.getGastoDAO();
   }
    public GastoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id_usuario = 0;
		int id_cartao = 0;
		try {
		String  titulo = request.getParameter("titulo") ;    
          String  descricao = request.getParameter("descricao") ;
          String  categoria = request.getParameter("categoria") ;
          String  nr_cartao = request.getParameter("nr_cartao") ;
          double valor =
       	   Double.parseDouble(request.getParameter("valor"));
         
          String data = request.getParameter("data");
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
          LocalDate dt_gasto = LocalDate.parse(data, formatter);
          
          int nr_parcelas =
              	   Integer.parseInt(request.getParameter("nr_parcelas"));
        
          HttpSession session = request.getSession(false);
          if (session != null) {
      	    String userEmail = (String) session.getAttribute("user");
      	     id_usuario = dao.buscarId(userEmail);
        }
          id_cartao = dao.buscarCartao(nr_cartao);
          
          ModelGasto gasto = new ModelGasto(nr_parcelas,dt_gasto,valor,descricao,titulo,categoria,id_usuario,id_cartao);

          dao.cadastrar(gasto);
          
          response.sendRedirect("telaSucessoGasto.jsp");   
		}	  catch(DBException db){
			  response.sendRedirect("telaErroCadastro.jsp");
		  }catch(Exception e) {
			  response.sendRedirect("telaErroCadastro.jsp");
			  
		  }
		  
		doGet(request, response);
	}
	  @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    		List<ModelGasto> lista = dao.listarTodos();
	    		request.setAttribute("gastos", lista);
	    		request.getRequestDispatcher("telaListaGasto.jsp").forward(request, response);	
	    }

}
