package br.com.FintechProject.factory;

import br.com.FintechProject.dao.GastoDAO;
import br.com.FintechProject.dao.impl.OracleGastoDAO;

public class DAOFactory {
  public static GastoDAO getGastoDAO()
  {
	  return new OracleGastoDAO();
  }
}
