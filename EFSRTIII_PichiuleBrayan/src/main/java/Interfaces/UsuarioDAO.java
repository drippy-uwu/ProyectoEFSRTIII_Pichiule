package Interfaces;

import Model.UsuarioDTO;

public interface UsuarioDAO {

	public UsuarioDTO validar (String usuario, String contrasena);
	
}
