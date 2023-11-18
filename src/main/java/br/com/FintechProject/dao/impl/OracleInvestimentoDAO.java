package br.com.FintechProject.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.com.FintechProject.singleton.ConexaoBanco;
import br.com.FintechProject.bean.ModelInvestimento;
import br.com.FintechProject.bean.ModelUsuario;
import br.com.FintechProject.dao.InvestimentoDAO;
import br.com.FintechProject.exception.DBException;

public class OracleInvestimentoDAO implements InvestimentoDAO {
	private Connection conexao;
	
	public void cadastrar(ModelInvestimento investimento) {
	PreparedStatement ps = null;	
	
	try {
		conexao = ConexaoBanco.getInstance().abrirConexao();
		
		String sql = "INSERT INTO INVESTIMENTO(id_investimento,dt_investimento,valor,descricao,tx_titulo,tipo,id_usuario)" + "VALUES(SQ_investimento.nextval, ?, ?, ?,?,?,?)";
		
		ps = conexao.prepareStatement(sql);
		
		Date data = Date.valueOf(investimento.getDt_investimento());
		ps.setDate(1, data);

		ps.setDouble(2, investimento.getValor());
		
		ps.setString(3, investimento.getDescricao());
		
		ps.setString(4, investimento.getTx_titulo());
		
		ps.setString(5, investimento.getTipo());
	
		ps.setInt(6, investimento.getId_usuario());
		
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
	
	public List<ModelInvestimento> listarTodos(){
		//cria uma lista de investimentos
	    List<ModelInvestimento> lista = new ArrayList<ModelInvestimento>();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    try {
	    	conexao = ConexaoBanco.getInstance().abrirConexao();
	    stmt = conexao.prepareStatement("SELECT * FROM INVESTIMENTO Order BY ID_INVESTIMENTO");
	    rs = stmt.executeQuery();
		  
	    //Percorre todos os registros encontrados
	    while (rs.next()) {
	    int id_investimento = rs.getInt("ID_INVESTIMENTO");
	    LocalDate dt_investimento = rs.getDate("DT_INVESTIMENTO").toLocalDate();
	    double valor = rs.getDouble("VALOR");
	    String descricao = rs.getString("DESCRICAO");
	    String tx_titulo = rs.getString("TX_TITULO");
	    String tipo = rs.getString("TIPO");
	    int id_usuario = rs.getInt("ID_USUARIO");
	  
	    
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        String dataformatada = dt_investimento.format(formatter);
	        //Cria um objeto Colaborador com as informações encontradas
	        ModelInvestimento investimento = new ModelInvestimento(id_investimento,dataformatada,valor,descricao,tx_titulo,tipo,id_usuario);
	        //Adiciona o colaborador na lista
	        lista.add(investimento);
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
	public void atualizar(ModelInvestimento investimento) throws DBException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(int id) throws DBException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ModelInvestimento buscar(int id) {
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
	
	
