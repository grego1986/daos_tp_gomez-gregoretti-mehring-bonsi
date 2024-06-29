package com.estacionamiento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estacionamiento.pojo.Recarga;
import com.estacionamiento.repository.IRecargaRepo;

@Service
public class RecargaService implements IRecargaService {

	@Autowired
	private IRecargaRepo recargaRepo;
	
	@Override
	public List<Recarga> listar() {
		
		return recargaRepo.findAll();
	}

	@Override
	public void agregar(Recarga recarga) {
		
		recargaRepo.save(recarga);
	}

	@Override
	public void actualizar(Recarga recarga, Long id) {
		
		if (recargaRepo.existsById(id)) {
            recarga.setId_recarga(id);
            recargaRepo.save(recarga);
        }
	}

	@Override
	public void borrar(Recarga recarga) {
		
		recargaRepo.delete(recarga);
	}

	@Override
	public Recarga buscar(Long id) {
		
		return recargaRepo.findById(id).orElse(null);
	}

}
