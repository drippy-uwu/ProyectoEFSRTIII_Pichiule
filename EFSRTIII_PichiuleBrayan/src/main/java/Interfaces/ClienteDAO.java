package Interfaces;

import Model.ClienteDTO;
import Model.UsuarioDTO;

public interface ClienteDAO {

	public int registrarCliente (UsuarioDTO u, ClienteDTO c);
}
