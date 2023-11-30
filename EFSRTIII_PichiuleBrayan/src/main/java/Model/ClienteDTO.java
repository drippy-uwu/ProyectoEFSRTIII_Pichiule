package Model;

import java.sql.Date;

public class ClienteDTO {

	private int  id_cliente, id_tipoDoc;
	private String num_documento, nombre, ape_pat, ape_mat;
	private Date fec_nacimiento;
	private String email;
	private int id_usuario;
	
	
	
	public ClienteDTO() {
		super();
	}

	public ClienteDTO(int id_cliente, int id_tipoDoc, String num_documento, String nombre, String ape_pat,
			String ape_mat, Date fec_nacimiento, String email, int id_usuario) {
		super();
		this.id_cliente = id_cliente;
		this.id_tipoDoc = id_tipoDoc;
		this.num_documento = num_documento;
		this.nombre = nombre;
		this.ape_pat = ape_pat;
		this.ape_mat = ape_mat;
		this.fec_nacimiento = fec_nacimiento;
		this.email = email;
		this.id_usuario = id_usuario;
	}

	public ClienteDTO(int id_tipoDoc, String num_documento, String nombre, String ape_pat, String ape_mat,
			Date fec_nacimiento, String email) {
		super();
		this.id_tipoDoc = id_tipoDoc;
		this.num_documento = num_documento;
		this.nombre = nombre;
		this.ape_pat = ape_pat;
		this.ape_mat = ape_mat;
		this.fec_nacimiento = fec_nacimiento;
		this.email = email;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public int getId_tipoDoc() {
		return id_tipoDoc;
	}

	public String getNum_documento() {
		return num_documento;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApe_pat() {
		return ape_pat;
	}

	public String getApe_mat() {
		return ape_mat;
	}

	public Date getFec_nacimiento() {
		return fec_nacimiento;
	}

	public String getEmail() {
		return email;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public void setId_tipoDoc(int id_tipoDoc) {
		this.id_tipoDoc = id_tipoDoc;
	}

	public void setNum_documento(String num_documento) {
		this.num_documento = num_documento;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApe_pat(String ape_pat) {
		this.ape_pat = ape_pat;
	}

	public void setApe_mat(String ape_mat) {
		this.ape_mat = ape_mat;
	}

	public void setFec_nacimiento(Date fec_nacimiento) {
		this.fec_nacimiento = fec_nacimiento;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	
	
	
	
}
