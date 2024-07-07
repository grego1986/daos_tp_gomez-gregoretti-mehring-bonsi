package com.estacionamiento.dto;

import org.springframework.hateoas.RepresentationModel;
import com.estacionamiento.pojo.Estacionamiento;

public class EstacionamientoDTO extends RepresentationModel<EstacionamientoDTO> {

	private Long id_estacionamiento;
	private Boolean estado;

	public EstacionamientoDTO() {
		super();
	}

	public EstacionamientoDTO(Estacionamiento estacionamiento) {
		super();
		this.id_estacionamiento = estacionamiento.getId_estacionamiento();
		this.estado = estacionamiento.getEstado();
	}

	public Long getId_estacionamiento() {
		return id_estacionamiento;
	}

	public void setId_estacionamiento(Long id_estacionamiento) {
		this.id_estacionamiento = id_estacionamiento;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}

}
