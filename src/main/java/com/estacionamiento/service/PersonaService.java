package com.estacionamiento.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estacionamiento.pojo.Persona;
import com.estacionamiento.pojo.Vehiculo;
import com.estacionamiento.repository.IPersonaRepo;
import com.estacionamiento.repository.IVehiculoRepo;

@Service
public class PersonaService implements IPersonaService {

	@Autowired
	private IPersonaRepo usuarioRepo;
	@Autowired
	private IVehiculoRepo vehiculoRepo;

	public Persona crearUsuario(Persona usuario, Vehiculo vehiculo, Long id) {

		if (usuarioRepo.findByDni(
				usuario.getDni()) != null || vehiculoRepo.findBypatente(vehiculo.getPatente()) != null) {
			throw new RuntimeException("DNI o Patente ya existe");

		}

		return usuarioRepo.save(usuario);

	}

	// Se actualizan todo los datos exepto DNI ya que es id de la entidad y no debe
	// ser cambiado.
	public Persona actualizarUsuario(Persona usuarioActualizado, Long id) {
		Optional<Persona> optionalPersona = usuarioRepo.findById(id);

		if (optionalPersona.isPresent()) {

			Persona usuarioExistente = optionalPersona.get();

			usuarioExistente.setApellido(usuarioActualizado.getApellido());
			usuarioExistente.setNombre(usuarioActualizado.getNombre());
			usuarioExistente.setEmail(usuarioActualizado.getEmail());
			usuarioExistente.setNacimiento(usuarioActualizado.getNacimiento());
			usuarioExistente.setVehiculo(usuarioActualizado.getVehiculo());
			usuarioExistente.setRecargas(usuarioActualizado.getRecargas());
			usuarioExistente.setSaldo(usuarioActualizado.getSaldo());
			usuarioExistente.setCuenta_usuario(usuarioActualizado.getCuenta_usuario());

			return usuarioRepo.save(usuarioExistente);
		} else {
			throw new RuntimeException("Usuario no encontrado");
		}
		

	}

	@Override
	public List<Persona> listar() {

		return usuarioRepo.findAll();
	}

	@Override
	public Persona buscar(Long id) {

		return usuarioRepo.findById(id).orElse(null);
	}

	@Override
	public void borrar(Long id) {
		usuarioRepo.deleteById(id);

		// TODO Auto-generated method stub

	}

	@Override
	public Optional<Persona> buscarOptional(Long id) {
		return usuarioRepo.findById(id);
	}

}
