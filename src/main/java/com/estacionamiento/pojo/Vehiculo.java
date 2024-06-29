package com.estacionamiento.pojo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehiculos")
public class Vehiculo {

	@Id
	private String patente;
	@Column(name="marca")
	private String marca;
	@Column(name="modelo")
	private String modelo;
	@OneToOne
	@JoinColumn(name = "persona_id")
	private Persona persona;
	@OneToMany(mappedBy = "vehiculo")
    private List<Recarga> recargas;
	@ManyToMany(mappedBy = "vehiculos")
	private List<Estacionamiento> estacionado;

	public Vehiculo() {
		super();
	}


	public String getPatente() {
		return patente;
	}


	public void setPatente(String patente) {
		this.patente = patente;
	}


	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	public List<Recarga> getRecargas() {
		return recargas;
	}


	public void setRecargas(List<Recarga> recargas) {
		this.recargas = recargas;
	}


	public List<Estacionamiento> getEstacionado() {
		return estacionado;
	}


	public void setEstacionado(List<Estacionamiento> estacionado) {
		this.estacionado = estacionado;
	}
	
	
}
