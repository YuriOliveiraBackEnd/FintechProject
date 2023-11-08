package br.com.FintechProject.dao;

import java.util.List;


import br.com.FintechProject.bean.ModelRendimento;
import br.com.FintechProject.exception.DBException;

public interface RendimentoDAO {
	void cadastrar(ModelRendimento rendimento) throws DBException;
	void atualizar(ModelRendimento rendimento) throws DBException;
	void remover(int id) throws DBException;
	ModelRendimento buscar(int id);
	List<ModelRendimento> listarTodos();
}
