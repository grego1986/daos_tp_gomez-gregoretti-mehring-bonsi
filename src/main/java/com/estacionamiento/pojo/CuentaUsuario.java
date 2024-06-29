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
@Table(name="cuentas_usuarios")
public class CuentaUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_cuenta;
	@Column(name="user")
	private String usuario;
	@Column(name="password")
	private String pasword;
	@OneToOne
	@JoinColumn(name = "persona_id")
	private Persona persona;
	
	public CuentaUsuario() {
		super();
	}

	public Long getId_cuenta() {
		return id_cuenta;
	}

	public void setId_cuenta(Long id_cuenta) {
		this.id_cuenta = id_cuenta;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPasword() {
		return pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}
	
	
}
