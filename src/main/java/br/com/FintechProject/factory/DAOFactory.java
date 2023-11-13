package br.com.FintechProject.factory;

import br.com.FintechProject.dao.GastoDAO;
import br.com.FintechProject.dao.UsuarioDAO;
import br.com.FintechProject.dao.impl.OracleGastoDAO;
import br.com.FintechProject.dao.impl.OracleUsuarioDAO;

public class DAOFactory {
  public static GastoDAO getGastoDAO()
  {
	  return new OracleGastoDAO();
  }
  public static UsuarioDAO getUsuarioDAO()
  {
	  return new OracleUsuarioDAO();
  }

}
