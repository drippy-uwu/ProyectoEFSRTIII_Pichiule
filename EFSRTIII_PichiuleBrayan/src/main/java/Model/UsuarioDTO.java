package Model;

import java.util.ArrayList;

public class UsuarioDTO {
	
	private int id_usuario;
	private String nombreUsuario, contrasena;
	private int estado;
	private ClienteDTO cliente;
	
	
	
	
	public UsuarioDTO(String nombreUsuario, String contrasena) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
	}


	public UsuarioDTO() {
		super();
	}


	

	public UsuarioDTO(int id_usuario, String nombreUsuario, String contrasena, int estado) {
		super();
		this.id_usuario = id_usuario;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.estado = estado;
	}


	public UsuarioDTO(int id_usuario, String nombreUsuario, String contrasena, int estado, ClienteDTO cliente) {
		super();
		this.id_usuario = id_usuario;
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.estado = estado;
		this.cliente = cliente;
	}


	public int getId_usuario() {
		return id_usuario;
	}


	public String getNombreUsuario() {
		return nombreUsuario;
	}


	public String getContrasena() {
		return contrasena;
	}


	public int getEstado() {
		return estado;
	}


	public ClienteDTO getCliente() {
		return cliente;
	}


	


	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}


	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}


	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}


	public void setEstado(int estado) {
		this.estado = estado;
	}


	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}


	
}

