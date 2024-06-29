package com.estacionamiento.pojo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="estacionamiento")
public class Estacionamiento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_estacionamiento;
	@ManyToMany
	@JoinTable(name = "estacionamiento_vehiculo")
	private List<Vehiculo> vehiculos;
	private Boolean estado;
	
	public Estacionamiento() {
		super();
	}

	public Long getId_estacionamiento() {
		return id_estacionamiento;
	}

	public void setId_estacionamiento(Long id_estacionamiento) {
		this.id_estacionamiento = id_estacionamiento;
	}

	public List<Vehiculo> getVehiculo() {
		return vehiculos;
	}

	public void setVehiculo(List<Vehiculo> vehiculo) {
		this.vehiculos = vehiculo;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	
}
