package com.estacionamiento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estacionamiento.pojo.Estacionamiento;
import com.estacionamiento.repository.IEstacionamientoRepo;

@Service
public class EstacionamientoService implements IEstacionamientoService {

	@Autowired
	private IEstacionamientoRepo estacionamientoRepo;
	
	@Override
	public List<Estacionamiento> listar() {
		
		return estacionamientoRepo.findAll();
	}

	@Override
	public void agregar(Estacionamiento estacionamiento) {
		
		estacionamientoRepo.save(estacionamiento);
	}

	@Override
	public void actualizar(Estacionamiento estacionamiento, Long id) {
		
		if (estacionamientoRepo.existsById(id)) {
            estacionamiento.setId_estacionamiento(id);
            estacionamientoRepo.save(estacionamiento);
        }
	}

	@Override
	public void borrar(Estacionamiento estacionamiento) {
		
		estacionamientoRepo.delete(estacionamiento);
	}

	@Override
	public Estacionamiento buscar(Long id) {
		
		return estacionamientoRepo.findById(id).orElse(null);
	}

}
