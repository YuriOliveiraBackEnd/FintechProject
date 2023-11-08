package br.com.FintechProject.dao;

import java.util.List;


import br.com.FintechProject.bean.ModelGasto;
import br.com.FintechProject.exception.DBException;

public interface GastoDAO {
	void cadastrar(ModelGasto gasto) throws DBException;
	void atualizar(ModelGasto gasto) throws DBException;
	void remover(int id) throws DBException;
	ModelGasto buscar(int id);
	List<ModelGasto> listarTodos();
}
