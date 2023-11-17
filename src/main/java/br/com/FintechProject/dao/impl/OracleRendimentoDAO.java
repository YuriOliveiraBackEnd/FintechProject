package br.com.FintechProject.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.FintechProject.singleton.ConexaoBanco;
import br.com.FintechProject.bean.ModelRendimento;
import br.com.FintechProject.bean.ModelUsuario;
import br.com.FintechProject.dao.RendimentoDAO;
import br.com.FintechProject.exception.DBException;

public class OracleRendimentoDAO implements RendimentoDAO {
	private Connection conexao;
	
	public void cadastrar(ModelRendimento rendimento) {
	PreparedStatement ps = null;	
	
	try {
		conexao = ConexaoBanco.getInstance().abrirConexao();
		
		String sql = "INSERT INTO RENDIMENTO(id_rendimento,dt_rendimento,rendimento_anual,valor,descricao,tx_titulo,tipo,id_usuario)" + "VALUES(SQ_Rendimento.nextval, ?, ?, ?,?,?,?,?)";
		
		ps = conexao.prepareStatement(sql);
		
		Date data = Date.valueOf(rendimento.getDt_rendimento());
		ps.setDate(1, data);

		ps.setDouble(2, rendimento.getRendimento_anual());
		
		ps.setDouble(3, rendimento.getValor());
		
		ps.setString(4, rendimento.getDescricao());
		
		ps.setString(5, rendimento.getTx_titulo());
		
		ps.setString(6, rendimento.getTipo());
	
		ps.setInt(7, rendimento.getId_usuario());
		
		ps.executeUpdate();
		System.out.println("cadastrado");
	
	} catch (SQLException e) {
		System.out.println("Erro ao abrir!!!");
		e.printStackTrace();
	}finally {
		try {
			ps.close();
			conexao.close();
		} catch (SQLException e) {
			System.out.println("Erro ao fechar!!!");
			e.printStackTrace();
			}
		}
	}
	
	public List<ModelRendimento> listarTodos(){
		//cria uma lista de investimentos
	    List<ModelRendimento> lista = new ArrayList<ModelRendimento>();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    try {
	    	conexao = ConexaoBanco.getInstance().abrirConexao();
	    stmt = conexao.prepareStatement("SELECT * FROM RENDIMENTO Order BY ID_RENDIMENTO");
	    rs = stmt.executeQuery();
		  
	    //Percorre todos os registros encontrados
	    while (rs.next()) {
	    int id_rendimento = rs.getInt("ID_RENDIMENTO");
	    LocalDate dt_rendimento = rs.getDate("DT_RENDIMENTO").toLocalDate();
	    double rendimento_anual = rs.getDouble("RENDIMENTO_ANUAL");
	    double valor = rs.getDouble("VALOR");
	    String descricao = rs.getString("DESCRICAO");
	    String tx_titulo = rs.getString("TX_TITULO");
	    String tipo = rs.getString("TIPO");
	    int id_usuario = rs.getInt("ID_USUARIO");
	  
	        //Cria um objeto Colaborador com as informações encontradas
	        ModelRendimento rendimento = new ModelRendimento(id_rendimento,dt_rendimento,rendimento_anual,valor,descricao,tx_titulo,tipo,id_usuario);
	        //Adiciona o colaborador na lista
	        lista.add(rendimento);
	    }
	    
	    }catch (SQLException e) {
		      e.printStackTrace();
		    }finally {
		      try {
		        stmt.close();
		        rs.close();
		        conexao.close();
		      } catch (SQLException e) {
		        e.printStackTrace();
		      }
		    }
		    return lista;
		  }

	@Override
	public void atualizar(ModelRendimento rendimento) throws DBException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(int id) throws DBException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ModelRendimento buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

		@Override
		public Integer buscarId(String userEmail) {
	        int id_usuario = 0;
			ModelUsuario usuario = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				conexao = ConexaoBanco.getInstance().abrirConexao();
				ps = conexao.prepareStatement("SELECT ID_USUARIO FROM USUARIO WHERE EMAIL_USUARIO = ?");
				ps.setString(1, userEmail);
				rs = ps.executeQuery();

				if (rs.next()){
					id_usuario = rs.getInt("ID_USUARIO");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					ps.close();
					rs.close();
					conexao.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return id_usuario;
		}
	}
	

	
	
