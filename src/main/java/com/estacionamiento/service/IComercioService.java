package com.estacionamiento.service;

import java.util.List;

import com.estacionamiento.pojo.Comercio;

public interface IComercioService {

	public List<Comercio> listar();
	public void agregar(Comercio comercio);
	public void actualizar(Comercio comercio, Long id);
	public Comercio buscar (Long id);
}
