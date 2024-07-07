package com.estacionamiento.Controller;

import com.estacionamiento.pojo.Comercio;
import com.estacionamiento.pojo.Persona;
import com.estacionamiento.pojo.Recarga;
import com.estacionamiento.pojo.Vehiculo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RecargaForm {


	@NotNull(message = "el cuit no puede ser nulo")
	private Comercio cuit;
	@NotNull(message = "el dni no puede ser nulo")
	private Persona dni;
	@NotNull
	private Vehiculo patente;
	@NotNull(message = "el importe no puede ser nulo")
	@Min(100)
	private Float importe;
	
	public Recarga recarga() {
		Recarga rec = new Recarga();
		rec.setComercio(this.cuit);
		rec.setPersona(this.dni);
		rec.setVehiculo(this.patente);
		rec.setImporte(this.importe);
		return rec;
	}


	public Comercio getCuit() {
		return cuit;
	}



	public void setCuit(Comercio cuit) {
		this.cuit = cuit;
	}



	public Persona getDni() {
		return dni;
	}



	public void setDni(Persona dni) {
		this.dni = dni;
	}



	public Vehiculo getPatente() {
		return patente;
	}



	public void setPatente(Vehiculo patente) {
		this.patente = patente;
	}



	public Float getImporte() {
		return importe;
	}
	
	

	public void setImporte(Float importe) {
		this.importe = importe;
	}
	
	
}
