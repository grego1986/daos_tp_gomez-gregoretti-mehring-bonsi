package com.estacionamiento.pojo;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "personas")
public class Persona {
	@Id
	private Long dni;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "apellido")
	private String apellido;
	@Column(name = "domicilio")
	private String domicilio;
	@Column(name = "email")
	private String email;
	@Column(name = "nacimiento")
	private LocalDate nacimiento;
	@OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
	private Vehiculo vehiculo;
	@OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
	private CuentaUsuario cuenta_usuario;
	@OneToOne(mappedBy = "persona", cascade = CascadeType.ALL)
	private Saldo saldo;
	@OneToMany(mappedBy = "persona")
    private List<Recarga> recargas;
    
    
	public Persona() {
		super();
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


	public Saldo getSaldo() {
		return saldo;
	}


	public void setSaldo(Saldo saldo) {
		this.saldo = saldo;
	}


	public String getDomicilio() {
		return domicilio;
	}


	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}


	public CuentaUsuario getCuenta_usuario() {
		return cuenta_usuario;
	}


	public void setCuenta_usuario(CuentaUsuario cuenta_usuario) {
		this.cuenta_usuario = cuenta_usuario;
	}


	public List<Recarga> getRecargas() {
		return recargas;
	}


	public void setRecargas(List<Recarga> recargas) {
		this.recargas = recargas;
	}
    
    
}
