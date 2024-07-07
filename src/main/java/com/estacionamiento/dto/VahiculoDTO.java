package com.estacionamiento.dto;

public class VahiculoDTO {

	private Long idVehiculo;
	private String patente;
	
	
	public VahiculoDTO(){
		
	}
	
	public VahiculoDTO(Long idVehiculo, String patente) {
		super();
		this.idVehiculo = idVehiculo;
		this.patente = patente;
	}

	public Long getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getPatente() {
		return patente;
	}

	public void setPatente(String patente) {
		this.patente = patente;
	}
	
	
	
}
