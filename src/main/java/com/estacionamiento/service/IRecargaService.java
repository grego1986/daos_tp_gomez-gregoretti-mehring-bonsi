package com.estacionamiento.service;

import java.util.List;
import java.util.Optional;

import com.estacionamiento.pojo.Recarga;

public interface IRecargaService {

	public List<Recarga> listar();
	public void agregar(Recarga recarga);
	public void actualizar(Recarga recarga, Long id);
	public void borrar(Recarga recarga);
	public Recarga buscar (Long id);
	public Optional<Recarga> buscarOptional(Long id);
}
