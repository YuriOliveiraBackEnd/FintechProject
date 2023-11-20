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
		 String acao = request.getParameter("acao");
		 if("cadastrar".equals(acao))
		 {
			 cadastrar(request,response); 
		 }
		 else if("editar".equals(acao)) {
			 editar(request,response); 
		 }
		 else if("excluir".equals(acao)) {
			 excluir(request,response); 
		 }
	}
	private void excluir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int id_gasto = Integer.parseInt(request.getParameter("id_gasto"));
	try {
		dao.remover(id_gasto);
		request.setAttribute("msg", "Produto removido");
	}catch(DBException e) {
		e.printStackTrace();
		request.setAttribute("erro", "Erro ao remover");
	}
	listar(request,response);
	
	}
	private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		  int id_gasto =
		        Integer.parseInt(request.getParameter("id_gasto"));
		  String  titulo = request.getParameter("titulo") ;    
          String  descricao = request.getParameter("descricao") ;
          String  categoria = request.getParameter("categoria") ;
          String  nr_cartao = request.getParameter("nr_cartao") ;
          double valor =
       	   Double.parseDouble(request.getParameter("valor"));
          int nr_parcelas =
             	   Integer.parseInt(request.getParameter("nr_parcelas"));
          String data = request.getParameter("data");
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
          LocalDate dt_gasto = LocalDate.parse(data, formatter);
          int id_cartao =
              	   Integer.parseInt(request.getParameter("id_cartao"));
          int id_usuario =
            	   Integer.parseInt(request.getParameter("id_usuario"));
        
        
    

          
          ModelGasto gasto = new ModelGasto(id_gasto,nr_parcelas,dt_gasto,valor,descricao,titulo,categoria,id_usuario,id_cartao);

          dao.atualizar(gasto);
            
		}	  catch(DBException db){
			  response.sendRedirect("telaErroCadastro.jsp");
		  }catch(Exception e) {
			  response.sendRedirect("telaErroCadastro.jsp");
			  
		  }
		  
		listar(request, response);
	
	}
	 
	    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String acao = request.getParameter("acao");
		 if("listar".equals(acao))
		 {
			  listar(request, response);	 
		 }
		 else if ("abrir-form-edicao".equals(acao)){
		  abrirEdicao(request, response);
		 }

	  }
		private void abrirEdicao(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			int id = Integer.parseInt(request.getParameter("id_gasto"));
			  ModelGasto gasto = dao.buscar(id);
			  request.setAttribute("gasto", gasto);
			  request.getRequestDispatcher("telaAtualizarGasto.jsp").forward(request, response);
		}
		private void listar(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			    int id_usuariologado = 0;
			    HttpSession session = request.getSession(false);
		         if (session != null) {
		      	    String userEmail = (String) session.getAttribute("user");
		      	  id_usuariologado = dao.buscarId(userEmail);
		        }
			  List<ModelGasto> lista = dao.listarTodos(id_usuariologado);
		    		request.setAttribute("gastos", lista);
		    		request.getRequestDispatcher("telaListaGasto.jsp").forward(request, response);
		}

}
