package br.com.FintechProject.singleton;

import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.SQLException;

public class ConexaoBanco {
	
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USUARIO = "System";
	private static final String SENHA = "123456789";
	
	private static ConexaoBanco instance;
	
	private ConexaoBanco() {}
		
	public static ConexaoBanco getInstance() {
			if(instance == null) {
				instance = new ConexaoBanco();
		}
			return instance;
	}
	

	
	public  Connection abrirConexao() {
		
		Connection conexao = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
			
			
			
		} catch (ClassNotFoundException e) {
			System.out.println("Classe não encontrada!");
		} catch (SQLException e) {
			System.out.println("Erro de conexão!");
		}
		
		return conexao;
	}

}
