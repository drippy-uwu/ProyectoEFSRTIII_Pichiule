package Interfaces;

import java.util.ArrayList;

import Model.ClienteDTO;
import Model.ReclamoDTO;

public interface ReclamoDAO {

	public ArrayList<ReclamoDTO> listarReclamos(int codigo);
	
	public int registrarReclamo (int codigo ,ReclamoDTO reclamo);
	
	public ReclamoDTO buscarReclamo (int codigo);
	
	public int actualizarReclamo (int codigo, ReclamoDTO reclamo);
	
	public int eliminarReclamo (int codigo);
}
