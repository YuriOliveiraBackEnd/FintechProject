package br.com.FintechProject.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import br.com.FintechProject.dao.CartaoDAO;
import br.com.FintechProject.exception.DBException;
import br.com.FintechProject.singleton.ConexaoBanco;
import br.com.FintechProject.bean.ModelCartao;
import br.com.FintechProject.bean.ModelGasto;
import br.com.FintechProject.bean.ModelUsuario;


public class OracleCartaoDAO implements CartaoDAO {
private Connection conexao;


  public void cadastrar(ModelCartao cartao) {
    PreparedStatement ps = null;

    try {
      conexao = ConexaoBanco.getInstance().abrirConexao();

      String sql = "INSERT INTO CARTAO(id_cartao, nr_cartao, dt_validade, nm_pessoa, cv_cartao, nm_bandeira, nm_banco, id_usuario)"
      + "VALUES (SQ_Cartao.nextval, ?, ?, ?, ?, ?, ?, ?)";

      ps = conexao.prepareStatement(sql);


			ps.setString(1, cartao.getNr_cartao());
			
			ps.setString(2,cartao.getDt_validade());
			
			ps.setString(3, cartao.getNm_pessoa());
			
			ps.setString(4, cartao.getCv_cartao());
			
			ps.setString(5, cartao.getNm_bandeira());
			
			ps.setString(6, cartao.getNm_banco());

			ps.setInt(7, cartao.getId_usuario());
			
			ps.executeUpdate();

      System.out.println("cadastrado");

    } catch (SQLException e) {
			System.out.println("Erro ao abrir!!!");
			e.printStackTrace();
		}finally {
			try {
				ps.close();
				conexao.close();
			}
				catch (SQLException e) {
					System.out.println("Erro ao fechar!!!");
					e.printStackTrace();
			}
    }
}
@Override
public List<ModelCartao> listarTodos(int id_usuariologado){
	    List<ModelCartao> lista = new ArrayList<ModelCartao>();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    try {
	    	conexao = ConexaoBanco.getInstance().abrirConexao();
	    stmt = conexao.prepareStatement("SELECT * FROM CARTAO WHERE id_usuario = ? ORDER BY ID_CARTAO");
	    stmt.setInt(1, id_usuariologado);
	    rs = stmt.executeQuery();

      //Percorre todos os registros encontrados
	    while (rs.next()) {
	    int id_cartao = rs.getInt("id_cartao");
	    String nr_cartao = rs.getString("nr_cartao");
	    String dt_validade = rs.getString("dt_validade");
	    String nm_pessoa = rs.getString("nm_pessoa");
	    String cv_cartao = rs.getString("cv_cartao");
	    String nm_bandeira = rs.getString("nm_bandeira");
	    String nm_banco = rs.getString("nm_banco");
	    int id_usuario = rs.getInt("id_usuario");

      //Cria um objeto Colaborador com as informações encontradas
      ModelCartao cartao = new ModelCartao(id_cartao, nr_cartao, dt_validade, nm_pessoa, cv_cartao, nm_bandeira,
      nm_banco, id_usuario);
      //Adiciona o colaborador na lista
      lista.add(cartao);
    }
  } catch (SQLException e) {
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
public void atualizar(ModelCartao modelcartao) throws DBException {
	PreparedStatement ps = null;

	try {
		conexao = ConexaoBanco.getInstance().abrirConexao();
		String sql = "UPDATE CARTAO SET nr_cartao = ?, dt_validade = ?, nm_pessoa = ?, cv_cartao = ? , nm_bandeira = ?, nm_banco = ?, id_usuario = ? WHERE id_cartao = ?";
		
		 ps = conexao.prepareStatement(sql);
		
		    ps.setString(1, modelcartao.getNr_cartao());
			
			ps.setString(2,modelcartao.getDt_validade());
			
			ps.setString(3, modelcartao.getNm_pessoa());
			
			ps.setString(4, modelcartao.getCv_cartao());
			
			ps.setString(5, modelcartao.getNm_bandeira());
			
			ps.setString(6, modelcartao.getNm_banco());

			ps.setInt(7, modelcartao.getId_usuario());
			
			ps.setInt(8, modelcartao.getId_cartao());
			
		ps.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
		throw new DBException("Erro ao atualizar.");
	} finally {
		try {
			ps.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
	


@Override
public void remover(int id) throws DBException {

	PreparedStatement ps = null;

	try {
		conexao = ConexaoBanco.getInstance().abrirConexao();
		String sql = "DELETE FROM CARTAO WHERE ID_CARTAO = ?";
		ps = conexao.prepareStatement(sql);
		ps.setInt(1, id);
		ps.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
		throw new DBException("Erro ao remover.");
	} finally {
		try {
			ps.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}



@Override
public ModelCartao buscar(int id) {
	ModelCartao cartao = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	try {
		conexao = ConexaoBanco.getInstance().abrirConexao();
		stmt = conexao.prepareStatement("SELECT * FROM CARTAO WHERE ID_CARTAO= ?");
		stmt.setInt(1, id);
		rs = stmt.executeQuery();

		if (rs.next()){
			  int id_cartao = rs.getInt("id_cartao");
			    String nr_cartao = rs.getString("nr_cartao");
			    String dt_validade = rs.getString("dt_validade");
			    String nm_pessoa = rs.getString("nm_pessoa");
			    String cv_cartao = rs.getString("cv_cartao");
			    String nm_bandeira = rs.getString("nm_bandeira");
			    String nm_banco = rs.getString("nm_banco");
			    int id_usuario = rs.getInt("id_usuario");
			  
//			    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//
//		        String dataformatada = dt_gasto.format(formatter);
			
			cartao = new ModelCartao(id_cartao, nr_cartao, dt_validade, nm_pessoa, cv_cartao, nm_bandeira,
				      nm_banco, id_usuario);
		}
		
	} catch (SQLException e) {
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
	return cartao;
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
	

