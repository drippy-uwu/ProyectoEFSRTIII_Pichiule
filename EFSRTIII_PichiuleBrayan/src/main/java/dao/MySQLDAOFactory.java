package dao;

import Interfaces.ClienteDAO;
import Interfaces.MotivoDAO;
import Interfaces.ReclamoDAO;
import Interfaces.TipoDAO;
import Interfaces.UsuarioDAO;
import Mantenimientos.MySQLClienteDAO;
import Mantenimientos.MySQLMotivoDAO;
import Mantenimientos.MySQLReclamoDAO;
import Mantenimientos.MySQLTipoDAO;
import Mantenimientos.MySQLUsuarioDAO;

public class MySQLDAOFactory extends DAOFactory {

	@Override
	public UsuarioDAO getUsuarioDAO() {
		
		return new MySQLUsuarioDAO ();
	}

	@Override
	public TipoDAO getTipoDAO() {
		// TODO Auto-generated method stub
		return new MySQLTipoDAO();
	}

	@Override
	public ClienteDAO getClienteDAO() {
		return new MySQLClienteDAO();
	}

	@Override
	public ReclamoDAO getReclamoDAO() {
		// TODO Auto-generated method stub
		return  new MySQLReclamoDAO();
	}

	@Override
	public MotivoDAO getMotivoDAO() {
		// TODO Auto-generated method stub
		return new MySQLMotivoDAO();
	}

}
