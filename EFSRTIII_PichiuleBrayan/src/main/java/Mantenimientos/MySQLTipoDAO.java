package Mantenimientos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Interfaces.TipoDAO;
import Model.TipoDTO;
import utils.MySQLConexion;

public class MySQLTipoDAO implements TipoDAO {

	@Override
	public ArrayList<TipoDTO> listarTipo() {
		ArrayList<TipoDTO> lista = new ArrayList<TipoDTO>();
		Connection cn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		try {
			cn = MySQLConexion.getConexion();
			cs = cn.prepareCall("call listarTipo");
			rs = cs.executeQuery();
			
			while (rs.next()) {
				TipoDTO m = new TipoDTO();
				m.setId_tipoDoc(rs.getInt(1));
				m.setDes_tipoDoc(rs.getString(2));
				lista.add(m);
				
			}
		} catch (Exception e) {
			System.out.println("Sentencia " + e.getMessage());
		}finally {
			try {
				if (cs != null) cs.close();
				if (rs != null) rs.close();
				if (cn != null) cn.close();

			} catch (SQLException e) {
				System.out.println("Cerrar " + e.getMessage());
			}
		}
		
		return lista;
	}

}
