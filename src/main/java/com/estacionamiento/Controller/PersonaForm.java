package com.estacionamiento.Controller;

import java.time.LocalDate;

import com.estacionamiento.pojo.Persona;
import com.estacionamiento.pojo.Vehiculo;

import jakarta.validation.constraints.*;

public class PersonaForm {

	@NotNull(message = "el DNI no puede ser nulo")
	@Min(1000000000)
	private Long dni;
	@NotNull(message = "el Nombre no puede ser nulo")
	private String nombre;
	@NotNull(message = "el Apellido no puede ser nulo")
	private String apellido;
	@NotNull(message = "el Domicilio no puede ser nulo")
	private String domicilio;
	@NotNull(message = "el Email no puede ser nulo")
	private String email;
	@NotNull(message = "el Nacimiento no puede ser nulo")
	private LocalDate nacimiento;
	@NotNull(message = "el Vehiculo no puede ser nulo")
	private Vehiculo vehiculo;

	public Persona toPojo() {

		Persona p = new Persona();
		p.setDni(this.getDni());
		p.setNombre(this.getNombre());
		p.setApellido(this.getApellido());
		p.setDomicilio(this.getDomicilio());
		p.setEmail(this.getEmail());
		p.setNacimiento(this.getNacimiento());
		p.setVehiculo(this.getVehiculo());

		return p;

	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getNacimiento() {
		return nacimiento;
	}

	public void setNacimiento(LocalDate nacimiento) {
		this.nacimiento = nacimiento;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

}
