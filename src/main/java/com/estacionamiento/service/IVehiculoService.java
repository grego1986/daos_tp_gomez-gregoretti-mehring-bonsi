package com.estacionamiento.service;

import java.util.List;
import java.util.Optional;
import com.estacionamiento.pojo.Vehiculo;

public interface IVehiculoService {

	public List<Vehiculo> listar();
	public void agregar(Vehiculo vehiculo);
	public void actualizar(Vehiculo vehiculo, String id);
	public void borrar(Vehiculo vehiculo);
	public Vehiculo buscar (String id);
	public Optional<Vehiculo> buscarOptional(String id);
}
