package com.estacionamiento.pojo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="comercios")
public class Comercio {

	@Id
	private Long cuil;
	@Column(name="r_social")
	private String razon_social;
	@Column(name="direccion")
	private String direccion;
	@Column(name="estado")
	private Boolean estado;
	@OneToMany(mappedBy = "comercio")
    private List<Recarga> recargas;
	
	public Comercio() {
		super();
	}

	public Long getCuil() {
		return cuil;
	}

	public void setCuil(Long cuil) {
		this.cuil = cuil;
	}

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

	public List<Recarga> getRecargas() {
		return recargas;
	}

	public void setRecargas(List<Recarga> recargas) {
		this.recargas = recargas;
	}
	
}
