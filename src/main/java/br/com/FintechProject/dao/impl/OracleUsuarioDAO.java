package br.com.FintechProject.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import br.com.FintechProject.bean.ModelUsuario;
import br.com.FintechProject.dao.UsuarioDAO;
import br.com.FintechProject.exception.DBException;
import br.com.FintechProject.singleton.ConexaoBanco;

public class OracleUsuarioDAO implements  UsuarioDAO{
private Connection conexao;
	
	public void cadastrar(ModelUsuario usuario) {
	PreparedStatement ps = null;	
	
	try {
		conexao = ConexaoBanco.getInstance().abrirConexao();
		
		String sql = "INSERT INTO USUARIO(id_usuario,nm_usuario,nr_cpf,dt_nasc,tel_usuario,email_usuario,senha_usuario)" + "VALUES(SQ_USUARIO.nextval, ?, ?, ?,?,?,?)";
		
		ps = conexao.prepareStatement(sql);
		
		
		ps.setString(1, usuario.getNome());
		
		ps.setString(2, usuario.getNr_cpf());
		
		Date data = Date.valueOf(usuario.getDt_nasc());
		ps.setDate(3, data);

		ps.setString(4, usuario.getTel_usuario());
		
		ps.setString(5, usuario.getEmail_usuario());
		
		ps.setString(6, usuario.getSenha_usuario());
		
		
		
		
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

	@Override
	public void atualizar(ModelUsuario usuario) throws DBException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(int id) throws DBException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ModelUsuario buscar(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ModelUsuario> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean validarUsuario(ModelUsuario usuario) {
		
				PreparedStatement ps = null;
				ResultSet rs = null;
				try {
					conexao = ConexaoBanco.getInstance().abrirConexao();
			
					ps = conexao.prepareStatement("SELECT * FROM USUARIO WHERE EMAIL_USUARIO = ? AND SENHA_USUARIO = ?");
					ps.setString(1, usuario.getEmail_usuario());
					ps.setString(2, usuario.getSenha_usuario());
					rs = ps.executeQuery();

					if (rs.next()){
						return true;
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
				return false;				
	}

	@Override
	public String buscarnome(String email_usuario) {
		   
		    String nome = null;
			ModelUsuario usuario = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
				conexao = ConexaoBanco.getInstance().abrirConexao();
				ps = conexao.prepareStatement("SELECT NM_USUARIO FROM USUARIO WHERE EMAIL_USUARIO = ?");
				ps.setString(1, email_usuario);
				rs = ps.executeQuery();

				if (rs.next()){
					nome = rs.getString("NM_USUARIO");
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
			return nome;
		}
	}

