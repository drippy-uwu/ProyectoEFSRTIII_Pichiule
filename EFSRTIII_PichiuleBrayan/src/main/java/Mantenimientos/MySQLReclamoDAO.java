package Mantenimientos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Interfaces.ReclamoDAO;
import Model.ClienteDTO;
import Model.ReclamoDTO;
import utils.MySQLConexion;

public class MySQLReclamoDAO implements ReclamoDAO {

	@Override
	public ArrayList<ReclamoDTO> listarReclamos(int codigo) {
		ArrayList<ReclamoDTO> lista = new ArrayList<ReclamoDTO>();
		ResultSet rs = null;
		Connection cn = null;
		CallableStatement cs = null;
		
		try {
			cn= MySQLConexion.getConexion();
			cs = cn.prepareCall("call listarReclamos(?)");
			cs.setInt(1, codigo);
			rs = cs.executeQuery();
			
			while (rs.next()) {
				ReclamoDTO r = new ReclamoDTO();
				r.setId_reclamo(rs.getInt(1));
				r.setFec_reclamo(rs.getDate(2));
				r.setDes_motivo(rs.getString(3));
				r.setDes_reclamo(rs.getString(4));
				lista.add(r);
			}
			
		} catch (Exception e) {
			System.out.println("sentencia " +e.getMessage());
		}finally {
			try {
				if (cs != null) cs.close();
			if (rs != null) rs.close();
			if (cn != null) cn.close();
			} catch (SQLException e2) {
				System.out.println("cerrar " +e2.getMessage());
			}
			
		}
		return lista;
	}


	@Override
	public int registrarReclamo(int codigo, ReclamoDTO reclamo) {
		int rs = 0;
		Connection cn = null;
		CallableStatement cs = null;
		try {
			cn = MySQLConexion.getConexion();
			cs = cn.prepareCall("call registrarReclamo(?,?,?,?)");
			cs.setInt(1,reclamo.getId_motivo());
			cs.setInt(2, codigo);
			cs.setDate(3, reclamo.getFec_reclamo());
			cs.setString(4, reclamo.getDes_reclamo());
			
			rs = cs.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("Sentencia " + e.getMessage());
			
		}finally {
			try {
				if(cs != null) cs.close();
				if(cn != null) cn.close();
				
			} catch (SQLException e) {
				System.out.println("Cerrar "+e.getMessage());
			}
		}
		
		return rs;
	}


	@Override
	public ReclamoDTO buscarReclamo(int codigo) {
		ReclamoDTO r = null;
		Connection cn= null;
		CallableStatement cs= null;
		ResultSet rs=null; 
		try {
			cn = MySQLConexion.getConexion();
			cs = cn.prepareCall("call buscarReclamo (?)");
			cs.setInt(1, codigo);
			rs = cs.executeQuery();
			
			while (rs.next()) {
				 
				  r= new ReclamoDTO(
						  rs.getInt(1),
						  rs.getInt(2),
						  rs.getInt(3),
						  rs.getDate(4),
						  rs.getString(5),
						  rs.getInt(1));
			}
			
		} catch (Exception e) {
			System.out.println("sentencia " + e.getMessage());
		}finally {
			try {
				if(cs!=null)cs.close();
				if(rs!=null)rs.close();
				if(cn!=null)cn.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar "+e2.getMessage());
			}	
		}
		return r;
	}


	@Override
	public int actualizarReclamo(int codigo, ReclamoDTO reclamo) {
		
		int rs = 0;
		Connection cn = null;
		CallableStatement cs = null;
		try {
			cn = MySQLConexion.getConexion();
			cs = cn.prepareCall("call actualizarReclamo (?,?,?,?)");
			cs.setInt(1, codigo);
			cs.setInt(2, reclamo.getId_motivo());
			cs.setDate(3, reclamo.getFec_reclamo());
			cs.setString(4, reclamo.getDes_reclamo());
			
			rs = cs.executeUpdate();
			
		}catch (Exception e) {
			System.out.println("sentencia " + e.getMessage());
		}finally {
			try {
				if(cs!=null)cs.close();
				if(cn!=null)cn.close();
			} catch (SQLException e2) {
				System.out.println("Error al cerrar "+e2.getMessage());
			}	
		}
		return rs;
	}


	@Override
	public int eliminarReclamo(int codigo) {
		int rs=0;
		Connection cn= null;
		CallableStatement cs=null;
		try {
			cn=MySQLConexion.getConexion();
			cs = cn.prepareCall("call EliminarReclamo(?)");
			cs.setInt(1, codigo);
			rs = cs.executeUpdate();
		
		}catch (Exception e) {
			System.out.println("Sentencia "+e.getMessage());
		}finally {
			try {
				if(cs!=null)cs.close();
				if(cn!=null)cn.close();
			} catch (SQLException e) {
				System.out.println("cerrar "+e.getMessage());
			}
		}
		return rs;


	}
}