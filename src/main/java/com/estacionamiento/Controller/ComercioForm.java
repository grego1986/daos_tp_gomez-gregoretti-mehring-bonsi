package com.estacionamiento.Controller;

import com.estacionamiento.pojo.Comercio;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ComercioForm {


	@NotNull(message = "el cuit no puede ser nulo")
	@Min(1000000000)
	private Long cuit;
	@NotNull
	@Size(min=2, max=30, message = "razòn social demasiado largo")
	private String r_social;
	@NotNull
	@Size(min=2, max=30)
	private String direccion;
	private Boolean estado;
	
	
	public ComercioForm() {
		super();
	}
	
	public Comercio comercio() {
		Comercio comer = new Comercio();
		comer.setCuil(this.cuit);
		comer.setRazon_social(this.r_social);
		comer.setDireccion(this.direccion);
		comer.setEstado(this.estado);
		return comer;
	}

	public Long getCuit() {
		return cuit;
	}
	public void setCuit(Long cuit) {
		this.cuit = cuit;
	}
	public String getR_social() {
		return r_social;
	}
	public void setR_social(String r_social) {
		this.r_social = r_social;
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
	
    
	
}
