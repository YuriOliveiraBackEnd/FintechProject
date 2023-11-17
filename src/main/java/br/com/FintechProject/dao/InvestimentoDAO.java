package br.com.FintechProject.dao;

import java.util.List;


import br.com.FintechProject.bean.ModelInvestimento;
import br.com.FintechProject.exception.DBException;

public interface InvestimentoDAO {
	void cadastrar(ModelInvestimento investimento) throws DBException;
	void atualizar(ModelInvestimento investimento) throws DBException;
	void remover(int id) throws DBException;
	ModelInvestimento buscar(int id);
	List<ModelInvestimento> listarTodos();
	Integer buscarId(String userEmail);
}
