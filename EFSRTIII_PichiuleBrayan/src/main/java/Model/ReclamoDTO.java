package Model;

import java.sql.Date;

public class ReclamoDTO {
	private int id_reclamo;
	private int id_motivo;
	private int id_cliente;
	private Date fec_reclamo;
	private String des_reclamo;
	private int estado ;
	private String des_motivo;
	

	public ReclamoDTO() {
		super();
	}



	public ReclamoDTO(int id_motivo, Date fec_reclamo, String des_reclamo) {
		super();
		this.id_motivo = id_motivo;
		this.fec_reclamo = fec_reclamo;
		this.des_reclamo = des_reclamo;
	}



	public ReclamoDTO(int id_reclamo, Date fec_reclamo, String des_reclamo, String des_motivo) {
		super();
		this.id_reclamo = id_reclamo;
		this.fec_reclamo = fec_reclamo;
		this.des_reclamo = des_reclamo;
		this.des_motivo = des_motivo;
	}
	


	public ReclamoDTO(int id_motivo, int id_cliente, Date fec_reclamo, String des_reclamo) {
		super();
		this.id_motivo = id_motivo;
		this.id_cliente = id_cliente;
		this.fec_reclamo = fec_reclamo;
		this.des_reclamo = des_reclamo;
	}


	public ReclamoDTO(int id_reclamo, int id_motivo, int id_cliente, Date fec_reclamo, String des_reclamo, int estado) {
		super();
		this.id_reclamo = id_reclamo;
		this.id_motivo = id_motivo;
		this.id_cliente = id_cliente;
		this.fec_reclamo = fec_reclamo;
		this.des_reclamo = des_reclamo;
		this.estado = estado;
	}

	public int getId_reclamo() {
		return id_reclamo;
	}

	public int getId_motivo() {
		return id_motivo;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public Date getFec_reclamo() {
		return fec_reclamo;
	}

	public String getDes_reclamo() {
		return des_reclamo;
	}

	public int getEstado() {
		return estado;
	}

	public void setId_reclamo(int id_reclamo) {
		this.id_reclamo = id_reclamo;
	}

	public void setId_motivo(int id_motivo) {
		this.id_motivo = id_motivo;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public void setFec_reclamo(Date fec_reclamo) {
		this.fec_reclamo = fec_reclamo;
	}

	public void setDes_reclamo(String des_reclamo) {
		this.des_reclamo = des_reclamo;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getDes_motivo() {
		return des_motivo;
	}

	public void setDes_motivo(String des_motivo) {
		this.des_motivo = des_motivo;
	}

	


	
	
	
}