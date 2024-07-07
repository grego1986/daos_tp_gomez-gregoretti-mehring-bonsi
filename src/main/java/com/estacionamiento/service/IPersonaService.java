package com.estacionamiento.service;

import java.util.List;
import java.util.Optional;

import com.estacionamiento.pojo.Persona;
import com.estacionamiento.pojo.Vehiculo;

public interface IPersonaService {

	public List<Persona> listar();

	public Persona crearUsuario(Persona usuario, Vehiculo vehiculo, Long id);

	public Persona actualizarUsuario(Persona persona, Long id);

	public Persona buscar(Long id);

	public void borrar(Long id);
	
	public Optional<Persona> buscarOptional(Long id);

}
