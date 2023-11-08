package br.com.FintechProject.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.FintechProject.dao.CartaoDAO;
import br.com.FintechProject.exception.DBException;
import br.com.FintechProject.singleton.ConexaoBanco;
import br.com.FintechProject.bean.ModelCartao;


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

public List<ModelCartao> listarTodos(){
  //cria uma lista de gastos
	    List<ModelCartao> lista = new ArrayList<ModelCartao>();
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    try {
	    	conexao = ConexaoBanco.getInstance().abrirConexao();
	    stmt = conexao.prepareStatement("SELECT * FROM Cartao Order BY ID_Cartao");
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
	// TODO Auto-generated method stub
	
}

@Override
public void remover(int id) throws DBException {
	// TODO Auto-generated method stub
	
}

@Override
public ModelCartao buscar(int id) {
	// TODO Auto-generated method stub
	return null;
}
	
}
