package dao;

import Interfaces.ClienteDAO;
import Interfaces.MotivoDAO;
import Interfaces.ReclamoDAO;
import Interfaces.TipoDAO;
import Interfaces.UsuarioDAO;

public abstract class DAOFactory {

	public static final int MYSQL = 1;
	public static final int SQL = 2;
	
	public abstract UsuarioDAO getUsuarioDAO();
	public abstract TipoDAO getTipoDAO();
	public abstract ClienteDAO getClienteDAO();
	public abstract ReclamoDAO getReclamoDAO();
	public abstract MotivoDAO getMotivoDAO();
	
	public static DAOFactory getDAOFactory (int qBD) {
		switch (qBD) {
		case MYSQL: {
			
			return new MySQLDAOFactory();
		}
		default:
			return null;
		}
	}

}
