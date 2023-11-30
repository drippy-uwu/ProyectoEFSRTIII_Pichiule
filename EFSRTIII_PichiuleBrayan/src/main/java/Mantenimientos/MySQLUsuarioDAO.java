package Mantenimientos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Interfaces.UsuarioDAO;
import Model.ClienteDTO;
import Model.ReclamoDTO;
import Model.UsuarioDTO;
import utils.MySQLConexion;

public class MySQLUsuarioDAO implements UsuarioDAO {

	@Override
	public UsuarioDTO validar(String usuario, String contrasena) {
		
		UsuarioDTO u = null;
		ClienteDTO c = null;
		Connection cn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		
		try {
			cn = MySQLConexion.getConexion();
			cs = cn.prepareCall("call logearUsuario (?,?)");
			cs.setString(1, usuario);
			cs.setString(2, contrasena);
			rs = cs.executeQuery();
			
			while (rs.next()) {
				u = new UsuarioDTO();
				c = new ClienteDTO();
				u.setId_usuario(rs.getInt(1));
				u.setNombreUsuario(rs.getString(2));
				u.setContrasena(rs.getString(3));
				u.setEstado(rs.getInt(4));
				
				c.setId_cliente(rs.getInt(5));
				c.setId_tipoDoc(rs.getInt(6));
				c.setNum_documento(rs.getString(7));
				c.setNombre(rs.getString(8));
				c.setApe_pat(rs.getString(9));
				c.setApe_mat(rs.getString(10));
				c.setFec_nacimiento(rs.getDate(11));
				c.setEmail(rs.getString(12));
				c.setId_usuario(13);
				
				u.setCliente(c);
			
				
			
			}	
		} catch (Exception e) {
			System.out.println("SENTANCIA " + e.getMessage());
		}finally {
			try {
				if (cs != null) cs.close();
				if (rs != null) rs.close();
				if (cn != null) cn.close();
				
			} catch (SQLException e) {
				System.out.println("Cerrar " +e.getMessage());
			}
		}
		
		
		
		return u;
	}
	
	
	
	
	

	
}
