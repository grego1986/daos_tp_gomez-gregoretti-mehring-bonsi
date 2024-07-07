package com.estacionamiento.service;

import java.util.List;
import java.util.Optional;

import com.estacionamiento.pojo.Comercio;
import com.estacionamiento.pojo.Persona;


public interface IComercioService {

	public List<Comercio> listar();
	public Optional<Comercio> buscarOptional(Long id);
	public void agregar(Comercio comercio);
	public void actualizar(Comercio comercio, Long id);
	public Comercio buscar (Long id);
	public void delete ( Long id);
}
