package com.estacionamiento.dto;

import org.springframework.hateoas.RepresentationModel;

import com.estacionamiento.pojo.Recarga;

public class RecargaDto extends RepresentationModel<RecargaDto> {

	private String patente;
	private Long dni;
	private Long cuit;
	private Float importe;
	
	public RecargaDto (Recarga recarga) {
		super();
		this.patente = recarga.getVehiculo().getPatente();
		this.dni= recarga.getPersona().getDni();
		this.cuit= recarga.getComercio().getCuil();
		this.importe=recarga.getImporte();
	}
	
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public Long getDni() {
		return dni;
	}
	public void setDni(Long dni) {
		this.dni = dni;
	}
	public Long getCuit() {
		return cuit;
	}
	public void setCuit(Long cuit) {
		this.cuit = cuit;
	}
	public Float getImporte() {
		return importe;
	}
	public void setImporte(Float importe) {
		this.importe = importe;
	}
	@Override
	public String toString() {
		return  patente + " - " + dni + " - " + cuit + " - " + importe;
	}
	
	
}
