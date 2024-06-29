package com.estacionamiento.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="recargas")
public class Recarga {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_recarga;
	@ManyToOne
	@JoinColumn(name = "comercio_id")
	private Comercio comercio;
	@ManyToOne
	@JoinColumn(name = "persona_id")
	private Persona persona;
	@ManyToOne
	@JoinColumn(name = "vehiculo_id")
	private Vehiculo vehiculo;
	@Column(name="importe")
	private Float importe;
	
	public Recarga() {
		super();
	}

	public Long getId_recarga() {
		return id_recarga;
	}

	public void setId_recarga(Long id_recarga) {
		this.id_recarga = id_recarga;
	}

	public Comercio getComercio() {
		return comercio;
	}

	public void setComercio(Comercio comercio) {
		this.comercio = comercio;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Vehiculo getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
	}

	public Float getImporte() {
		return importe;
	}

	public void setImporte(Float importe) {
		this.importe = importe;
	}
	
	
}
