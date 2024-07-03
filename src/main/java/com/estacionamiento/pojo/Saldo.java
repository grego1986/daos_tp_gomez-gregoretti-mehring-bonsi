package com.estacionamiento.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="saldo")
public class Saldo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idsaldo;
	@Column(name="saldo")
	private Float saldo;
	@OneToOne
	@JoinColumn(name = "persona_id")
	private Persona persona;

	public Saldo() {
		super();
	}

	public Integer getIdsaldo() {
		return idsaldo;
	}

	public void setIdsaldo(Integer idsaldo) {
		this.idsaldo = idsaldo;
	}

	public Float getSaldo() {
		return saldo;
	}

	public void setSaldo(Float saldo) {
		this.saldo = saldo;
	}

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	

}
