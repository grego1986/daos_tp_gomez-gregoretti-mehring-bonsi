package com.estacionamiento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estacionamiento.pojo.Vehiculo;
import com.estacionamiento.repository.IVehiculoRepo;

@Service
public class VehiculoSevice implements IVehiculoService {

	
	@Autowired
	private IVehiculoRepo vehiculoRepo;
	
	@Override
	public List<Vehiculo> listar() {
		
		return vehiculoRepo.findAll();
	}

	@Override
	public void agregar(Vehiculo vehiculo) {
		
		vehiculoRepo.save(vehiculo);
	}

	@Override
	public void actualizar(Vehiculo vehiculo, String id) {
		
		if (vehiculoRepo.existsById(id)) {
            vehiculo.setPatente(id);
            vehiculoRepo.save(vehiculo);
        }
	}

	@Override
	public void borrar(Vehiculo vehiculo) {
		
		vehiculoRepo.delete(vehiculo);
	}

	@Override
	public Vehiculo buscar(String id) {
		
		return vehiculoRepo.findById(id).orElse(null);
	}

}
