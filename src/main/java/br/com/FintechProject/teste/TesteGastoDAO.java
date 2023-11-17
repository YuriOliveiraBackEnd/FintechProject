package br.com.FintechProject.teste;

import java.time.LocalDate;


import br.com.FintechProject.dao.GastoDAO;
import br.com.FintechProject.exception.DBException;
import br.com.FintechProject.factory.DAOFactory;
import br.com.FintechProject.bean.ModelGasto;
public class TesteGastoDAO {

	public static void main(String[] args) throws DBException {
		GastoDAO dao = DAOFactory.getGastoDAO();
		
		
		ModelGasto gasto = new ModelGasto();
		gasto.setNr_parcelas(5);
		gasto.setDt_gasto(LocalDate.of(2000, 4, 12));
		gasto.setValor(350.002);
		gasto.setDescricao("ingresso show Racionais meia entrada ");
		gasto.setTx_titulo("show Racionais ");
		gasto.setTipo("Laser");
		gasto.setId_usuario(3);
		
		dao.cadastrar(gasto);
	}

}
