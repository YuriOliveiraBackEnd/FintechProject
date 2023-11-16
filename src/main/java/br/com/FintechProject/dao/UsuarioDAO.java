package br.com.FintechProject.dao;

import java.util.List;


import br.com.FintechProject.bean.ModelUsuario;
import br.com.FintechProject.exception.DBException;

public interface UsuarioDAO {
	void cadastrar(ModelUsuario usuario) throws DBException;
	void atualizar(ModelUsuario usuario) throws DBException;
	void remover(int id) throws DBException;
	ModelUsuario buscar(int id);
	List<ModelUsuario> listarTodos();
	boolean validarUsuario(ModelUsuario usuario);
	String buscarnome(String email_usuario);
}
