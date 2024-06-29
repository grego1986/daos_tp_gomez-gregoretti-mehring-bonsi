package com.estacionamiento.service;

import java.util.List;

import com.estacionamiento.pojo.Estacionamiento;

public interface IEstacionamientoService {

	public List<Estacionamiento> listar();
	public void agregar(Estacionamiento estacionamiento);
	public void actualizar(Estacionamiento estacionamiento, Long id);
	public void borrar(Estacionamiento estacionamiento);
	public Estacionamiento buscar (Long id);
}
