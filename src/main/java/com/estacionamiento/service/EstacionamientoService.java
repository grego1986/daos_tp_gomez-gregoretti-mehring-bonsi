package com.estacionamiento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estacionamiento.exception.*;
import com.estacionamiento.pojo.Estacionamiento;
import com.estacionamiento.pojo.Vehiculo;
import com.estacionamiento.repository.IEstacionamientoRepo;
import com.estacionamiento.repository.IVehiculoRepo;

@Service
public class EstacionamientoService implements IEstacionamientoService {

	@Autowired
	private IVehiculoRepo vehiculoRepo;
	@Autowired
	private IEstacionamientoRepo estacionamientoRepo;

	@Override
	public Estacionamiento consultarEstacionamiento(String patente) throws Exception {
		Vehiculo vehiculo1 = vehiculoRepo.findBypatente(patente);
		if (vehiculo1 == null) {
			throw new Exception("Vehículo no encontrado");
		}

		List<Estacionamiento> estacionamientos = vehiculo1.getEstacionado();
		if (estacionamientos == null || estacionamientos.isEmpty()) {
			throw new Exception("El vehículo no está estacionado actualmente");
		}

		// Buscar el estacionamiento activo (si existe)
		for (Estacionamiento estacionamiento : estacionamientos) {
			if (estacionamiento.getEstado()) {
				return estacionamiento;
			}
		}
        
		// Si no se encuentra un estacionamiento activo
		throw new Exception("El vehículo no tiene un estacionamiento activo");
 
	}

	@Override
	public Estacionamiento actualizarEstacionamiento(String patente, Vehiculo vehiculo) throws Exception {
		Vehiculo vehiculo1 = vehiculoRepo.findBypatente(patente);
		if (vehiculo1 == null) {
			throw new Exception("Vehículo no encontrado");
		}

		if (vehiculo1.getEstacionado() == null || vehiculo1.getEstacionado().isEmpty()) {
			throw new Exception("El vehículo no está estacionado");
		}

		Estacionamiento estacionamiento1 = vehiculo1.getEstacionado().get(0);
		estacionamiento1.setEstado(false);
		estacionamiento1.getVehiculo().remove(vehiculo1);
		vehiculo1.getEstacionado().remove(estacionamiento1);

		return estacionamientoRepo.save(estacionamiento1);
	}

	@Override
	public Estacionamiento insertarEstacionamiento(Estacionamiento estacionamiento) throws Exception {
		for (Vehiculo vehiculo : estacionamiento.getVehiculo()) {
			Vehiculo vehiculoExistente = vehiculoRepo.findBypatente(vehiculo.getPatente());
			if (vehiculoExistente != null) {
				for (Estacionamiento est : vehiculoExistente.getEstacionado()) {
					if (est.getEstado()) {
						throw new Exception("El vehículo con patente " + vehiculo.getPatente() + " ya está estacionado.");
					}
				}
			}
		}
		estacionamiento = estacionamientoRepo.save(estacionamiento);
		return estacionamiento;

	}

}
