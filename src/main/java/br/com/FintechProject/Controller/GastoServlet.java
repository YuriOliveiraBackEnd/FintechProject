package br.com.FintechProject.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import br.com.FintechProject.dao.GastoDAO;
import br.com.FintechProject.factory.DAOFactory;

/**
 * Servlet implementation class GastoServlet
 */
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
		  String  titulo = request.getParameter("titulo") ;    
          String  descricao = request.getParameter("descricao") ;
          String  categoria = request.getParameter("categoria") ;
          double valor =
       	   Double.parseDouble(request.getParameter("valor"));
         
          String data = request.getParameter("data");

          // Crie um objeto LocalDate usando um formatador de data
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
          LocalDate dataformatada = LocalDate.parse(data, formatter);
          
          int nr_parcelas =
              	   Integer.parseInt(request.getParameter("nr_parcelas"));
                
          
		doGet(request, response);
	}

}
