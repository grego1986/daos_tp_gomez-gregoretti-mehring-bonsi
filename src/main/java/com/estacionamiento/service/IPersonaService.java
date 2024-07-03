package com.estacionamiento.service;

import java.util.List;
import java.util.Optional;

import com.estacionamiento.pojo.Persona;

public interface IPersonaService {
	
	public List<Persona> listar();
	public void agregar(Persona persona);
	public void actualizar(Persona persona, Long id);
	public void borrar(Persona persona);
	public Persona buscar (Long id);
	public Optional<Persona> buscarOptional(Long id);
}
