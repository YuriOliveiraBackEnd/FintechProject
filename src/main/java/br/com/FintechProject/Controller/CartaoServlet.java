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
import br.com.FintechProject.bean.ModelUsuario;
import br.com.FintechProject.dao.CartaoDAO;
import br.com.FintechProject.dao.GastoDAO;
import br.com.FintechProject.exception.DBException;
import br.com.FintechProject.factory.DAOFactory;

/**
 * Servlet implementation class CartaoServlet
 */
@WebServlet("/cartaoservlet")
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
	int id_cartao = Integer.parseInt(request.getParameter("id_cartao"));
	try {
		dao.remover(id_cartao);
		request.setAttribute("msg", "Produto removido");
	}catch(DBException e) {
		e.printStackTrace();
		request.setAttribute("erro", "Erro ao remover");
	}
	listar(request,response);
	
	}
	private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws IOException {
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
	}

private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	try {
		 int id_cartao =
	           	   Integer.parseInt(request.getParameter("id_cartao"));
	    String  nr_cartao = request.getParameter("nr_cartao") ;    
        String  dt_validade = request.getParameter("dt_validade") ;
        String  nm_pessoa = request.getParameter("nm_pessoa");
        String  cv_cartao = request.getParameter("cv_cartao");
        String  nm_bandeira = request.getParameter("nm_bandeira");
        String  nm_banco = request.getParameter("nm_banco");
        int id_usuario =
            	   Integer.parseInt(request.getParameter("id_usuario"));
        


      
        ModelCartao cartao = new ModelCartao(id_cartao,nr_cartao,dt_validade,nm_pessoa,cv_cartao,nm_bandeira,nm_banco,id_usuario);


      dao.atualizar(cartao);
        
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
	  List<ModelCartao> lista = dao.listarTodos(id_usuariologado);
	request.setAttribute("cartoes", lista);
	request.getRequestDispatcher("telaListaCartao.jsp").forward(request, response);
}

private void abrirEdicao(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	int id = Integer.parseInt(request.getParameter("id_cartao"));
	  ModelCartao cartao = dao.buscar(id);
	  request.setAttribute("cartao", cartao);
	  request.getRequestDispatcher("telaAtualizarCartao.jsp").forward(request, response);
}
}