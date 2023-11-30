package Mantenimientos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Interfaces.MotivoDAO;
import Model.MotivoDTO;
import utils.MySQLConexion;

public class MySQLMotivoDAO implements MotivoDAO {

	@Override
	public ArrayList<MotivoDTO> listarMotivo() {
		ArrayList<MotivoDTO> lista = new ArrayList<MotivoDTO>();
		Connection cn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		try {
			cn = MySQLConexion.getConexion();
			cs = cn.prepareCall("call listarMotivo");
			rs = cs.executeQuery();
			
			while (rs.next()) {
				MotivoDTO m = new MotivoDTO();
				m.setId_motivo(rs.getInt(1));
				m.setDes_motivo(rs.getString(2));
				lista.add(m);
				
			}
		}catch (Exception e) {
		System.out.println("Sentencia " + e.getMessage());
		}finally {
			try {
				if (cs != null) cs.close();
				if (rs != null) rs.close();
				if (cn != null) cn.close();

		}catch (SQLException e) {
			System.out.println("Cerrar " +e.getMessage());
		}

}
		return lista;
		}
}
