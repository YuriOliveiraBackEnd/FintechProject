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

import br.com.FintechProject.bean.ModelGasto;
import br.com.FintechProject.bean.ModelInvestimento;
import br.com.FintechProject.bean.ModelRendimento;
import br.com.FintechProject.dao.GastoDAO;
import br.com.FintechProject.dao.RendimentoDAO;
import br.com.FintechProject.exception.DBException;
import br.com.FintechProject.factory.DAOFactory;

/**
 * Servlet implementation class RendimentoServlet
 */
@WebServlet("/rendimentoservlet")
public class RendimentoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	   private RendimentoDAO dao;
	   
	   @Override
	   public void init() throws ServletException{
		   super.init();
		   dao = DAOFactory.getRendimentoDAO();
	   }
    public RendimentoServlet() {
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
	int id_investimento = Integer.parseInt(request.getParameter("id_investimento"));
	try {
		dao.remover(id_investimento);
		request.setAttribute("msg", "Produto removido");
	}catch(DBException e) {
		e.printStackTrace();
		request.setAttribute("erro", "Erro ao remover");
	}
	listar(request,response);
	
	}
	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		int id_usuario = 0;
		try {
		  String  titulo = request.getParameter("titulo") ;    
          String  descricao = request.getParameter("descricao") ;
          String  categoria = request.getParameter("categoria") ;
          double valor =
       	   Double.parseDouble(request.getParameter("valor"));
          double rendimento_anual =
              	   Double.parseDouble(request.getParameter("rendimento_anual"));
          String data = request.getParameter("data");
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
          LocalDate dt_rendimento= LocalDate.parse(data, formatter);
          
      
        
          HttpSession session = request.getSession(false);
          if (session != null) {
      	    String userEmail = (String) session.getAttribute("user");
      	     id_usuario = dao.buscarId(userEmail);
        }
 

          ModelRendimento rendimento = new ModelRendimento(dt_rendimento,rendimento_anual,valor,descricao,titulo,categoria,id_usuario);

          dao.cadastrar(rendimento);
		
          response.sendRedirect("telaSucessoRendimento.jsp");
		}
			  catch(DBException db){
			  response.sendRedirect("telaErroCadastro.jsp");
		  }catch(Exception e) {
			  response.sendRedirect("telaErroCadastro.jsp");
			  
		  }
		  
		doGet(request, response);
	}
private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		  int id_rendimento =
		        Integer.parseInt(request.getParameter("id_rendimento"));
		  String  titulo = request.getParameter("titulo") ;    
          String  descricao = request.getParameter("descricao") ;
          String  categoria = request.getParameter("categoria") ;
          double valor =
       	   Double.parseDouble(request.getParameter("valor"));
          double rendimento_anual =
              	   Double.parseDouble(request.getParameter("rendimento_anual"));
          String data = request.getParameter("data");
          DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
          LocalDate dt_rendimento= LocalDate.parse(data, formatter);
          int id_usuario =
            	   Integer.parseInt(request.getParameter("id_usuario"));
      
    

          
          ModelRendimento rendimento =  new ModelRendimento(id_rendimento,dt_rendimento,rendimento_anual,valor,descricao,titulo,categoria,id_usuario);
          dao.atualizar(rendimento);
            
		}	  catch(DBException db){
			  response.sendRedirect("telaErroCadastro.jsp");
		  }catch(Exception e) {
			  response.sendRedirect("telaErroCadastro.jsp");
			  
		  }
		  
		listar(request, response);
	
	}
	  @Override
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
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int id_usuariologado = 0;
		    HttpSession session = request.getSession(false);
	         if (session != null) {
	      	    String userEmail = (String) session.getAttribute("user");
	      	  id_usuariologado = dao.buscarId(userEmail);
	        }
		  List<ModelRendimento> lista = dao.listarTodos(id_usuariologado);
		request.setAttribute("rendimentos", lista);
		request.getRequestDispatcher("telaListaRendimento.jsp").forward(request, response);
	}
	private void abrirEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id_rendimento"));
		ModelRendimento rendimento = dao.buscar(id);
		  request.setAttribute("rendimento", rendimento);
		  request.getRequestDispatcher("telaAtualizarRendimento.jsp").forward(request, response);
	}
}


