package com.estacionamiento.service;

import com.estacionamiento.pojo.Estacionamiento;
import com.estacionamiento.pojo.Vehiculo;

public interface IEstacionamientoService {

	/* Obtiene los estacionamientos a partir de su id */
	public Estacionamiento consultarEstacionamiento(String patente) throws Exception;

	/* Actualiza datos de un estacionamiento */
	public Estacionamiento actualizarEstacionamiento(String patente, Vehiculo vehiculo) throws Exception;

	/* Inserta un registro de estacionamiento */
	public Estacionamiento insertarEstacionamiento(Estacionamiento estacionamiento) throws Exception;

}
