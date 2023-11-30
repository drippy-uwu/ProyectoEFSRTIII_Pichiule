package Mantenimientos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import Interfaces.ClienteDAO;
import Model.ClienteDTO;
import Model.UsuarioDTO;
import utils.MySQLConexion;

public class MySQLClienteDAO implements ClienteDAO {

	@Override
	public int registrarCliente(UsuarioDTO u, ClienteDTO c) {
		int rs = 0;
		Connection cn = null;
		CallableStatement cs1 = null;
		CallableStatement cs2 = null;
		try {
			cn = MySQLConexion.getConexion();
			cn.setAutoCommit(false);
			
			cs1 = cn.prepareCall("call registrarUsuario (?,?)");
			cs1.setString(1, u.getNombreUsuario());
			cs1.setString(2, u.getContrasena());
			rs = cs1.executeUpdate();
			
			cs2 = cn.prepareCall("call registrarCliente (?,?,?,?,?,?,?)");
			cs2.setInt(1, c.getId_tipoDoc());
			cs2.setString(2, c.getNum_documento());
			cs2.setString(3, c.getNombre());
			cs2.setString(4, c.getApe_pat());
			cs2.setString(5, c.getApe_mat());
			cs2.setDate(6, c.getFec_nacimiento());
			cs2.setString(7, c.getEmail());
			rs = cs2.executeUpdate();
			
			cn.commit();

		} catch (Exception e) {
			try {
				cn.rollback();
				System.out.println("Rollback");
				
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}finally {
			try {
				if(cs1 != null) cs1.close();
				if(cs2 != null) cs2.close();
				if(cn != null) cn.close();

			} catch (Exception e2) {
				System.out.println("cerrar");
			}
		}
		
		return rs;
	}

}
