package com.estacionamiento.dto;

import org.springframework.hateoas.RepresentationModel;

import com.estacionamiento.pojo.Comercio;



public class ComercioDto extends RepresentationModel<ComercioDto> {

	private Long cuit;
	private String rSocial;
	private String direccion;
	private Boolean estado;
	
	public ComercioDto() {
		super();
	}

	

	public ComercioDto(Comercio comercio) {
		super();
		this.cuit = comercio.getCuil();
		this.rSocial = comercio.getRazon_social();
		this.direccion = comercio.getDireccion();
		this.estado = comercio.getEstado();
	}

	public Long getCuit() {
		return cuit;
	}

	public void setCuit(Long cuit) {
		this.cuit = cuit;
	}

	public String getrSocial() {
		return rSocial;
	}

	public void setrSocial(String rSocial) {
		this.rSocial = rSocial;
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

	@Override
	public String toString() {
		return  cuit + " - " + rSocial + " - " + direccion + " - " + estado;
	}
	
	
}
