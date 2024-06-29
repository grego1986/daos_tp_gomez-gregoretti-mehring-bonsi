package com.estacionamiento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estacionamiento.pojo.Persona;
import com.estacionamiento.repository.IPersonaRepo;

@Service 
public class PersonaService implements IPersonaService {

	@Autowired
	private IPersonaRepo personaRepo;
	
	@Override
	public List<Persona> listar() {
		
		return personaRepo.findAll();
	}

	@Override
	public void agregar(Persona persona) {
		
		personaRepo.save(persona);
	}

	@Override
	public void actualizar(Persona persona, Long id) {
		
		if (personaRepo.existsById(id)) {
            persona.setDni(id);
            personaRepo.save(persona);
        }
	}

	@Override
	public void borrar(Persona persona) {
		
		personaRepo.delete(persona);
	}

	@Override
	public Persona buscar(Long id) {
		
		return personaRepo.findById(id).orElse(null);
	}

}
