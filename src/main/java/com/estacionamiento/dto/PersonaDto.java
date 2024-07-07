package com.estacionamiento.dto;

import java.time.LocalDate;

import org.springframework.hateoas.RepresentationModel;

import com.estacionamiento.pojo.*;

public class PersonaDto extends RepresentationModel<PersonaDto> {

	private Long dni;
	private String nombre;
	private String apellido;
	private String domicilio;
	private String email;
	private LocalDate nacimiento;
	private Vehiculo vehiculo;
	private CuentaUsuario cuenta_usuario;
	private Saldo saldo;

	public PersonaDto() {
		super();

	}

	public PersonaDto(Persona persona) {
		super();
		this.dni = persona.getDni();
		this.nombre = persona.getNombre();
		this.apellido = persona.getApellido();
		this.domicilio = persona.getDomicilio();
		this.email = persona.getEmail();
		this.nacimiento = persona.getNacimiento();
		this.vehiculo = persona.getVehiculo();
		this.cuenta_usuario = persona.getCuenta_usuario();
		this.saldo = persona.getSaldo();
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

	public CuentaUsuario getCuenta_usuario() {
		return cuenta_usuario;
	}

	public void setCuenta_usuario(CuentaUsuario cuenta_usuario) {
		this.cuenta_usuario = cuenta_usuario;
	}

	public Saldo getSaldo() {
		return saldo;
	}

	public void setSaldo(Saldo saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "PersonaDto [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", domicilio=" + domicilio
				+ ", email=" + email + ", nacimiento=" + nacimiento + ", vehiculo=" + vehiculo + ", cuenta_usuario="
				+ cuenta_usuario + ", saldo=" + saldo + "]";
	}

}
