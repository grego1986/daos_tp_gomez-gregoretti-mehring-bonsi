package com.estacionamiento.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estacionamiento.dto.ComercioDto;
import com.estacionamiento.exception.Excepcion;
import com.estacionamiento.pojo.Comercio;
import com.estacionamiento.pojo.Persona;
import com.estacionamiento.pojo.Vehiculo;
import com.estacionamiento.service.PersonaService;

@RestController
@RequestMapping("/personas")
public class UsuarioController {

	@Autowired
	private PersonaService personaService;

	@PostMapping
	public ResponseEntity<Persona> crearUsuario(@RequestBody PersonaForm form, Persona usuario, Vehiculo vehiculo) {
		Persona nuevoUsuario = personaService.crearUsuario(usuario, vehiculo, null);
		return ResponseEntity.ok(nuevoUsuario);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Persona> actualizarUsuario(@PathVariable Long id, @RequestBody Persona usuario) {
		Persona usuarioActualizado = personaService.actualizarUsuario(usuario, id);

		return ResponseEntity.ok(usuarioActualizado);

	}

	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<Persona>> obtenerUsuario(@PathVariable Long id) throws Exception {
		Persona usuario = personaService.buscar(id);
		EntityModel<Persona> resource = EntityModel.of(usuario);
		Link link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(EstadoEstacionamientoController.class)
				.obtenerEstadoEstacionamiento(usuario.getVehiculo())).withRel("estado-estacionamiento");
		resource.add(link);

		return ResponseEntity.ok(resource);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Persona> eliminarUsuario(@PathVariable Long id) {

		personaService.borrar(id);
		return ResponseEntity.noContent().build();

	}

	@GetMapping
	public ResponseEntity<List<Persona>> obtenerTodosLosUsuarios() {
				
		List<Persona> usuarios = personaService.listar();
		return ResponseEntity.ok(usuarios);
	}
	

}
