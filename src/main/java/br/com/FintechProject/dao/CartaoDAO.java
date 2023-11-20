package br.com.FintechProject.dao;

import java.util.List;

import br.com.FintechProject.bean.ModelCartao;
import br.com.FintechProject.bean.ModelGasto;
import br.com.FintechProject.exception.DBException;

public interface CartaoDAO {
	
	void cadastrar(ModelCartao cartao) throws DBException;
	void atualizar(ModelCartao cartao) throws DBException;
	void remover(int id) throws DBException;
	ModelCartao buscar(int id);
	List<ModelCartao> listarTodos(int id_usuariologado);
	Integer buscarId(String userEmail);

}
