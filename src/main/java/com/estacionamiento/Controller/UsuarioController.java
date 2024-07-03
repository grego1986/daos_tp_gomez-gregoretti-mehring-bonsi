package com.estacionamiento.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estacionamiento.pojo.Persona;
import com.estacionamiento.service.PersonaService;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private PersonaService personaService;
	
	/**
	 * Obtiene una ciudad a través de su id.
	 *  curl --location --request GET 'http://localhost:8081/ciudades/3'
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Persona> getById(@PathVariable Long id) throws Exception
	{
		Optional<Persona> rta =personaService.buscarOptional(id);
		if(rta.isPresent())
		{
			Persona pojo=rta.get();
			return new ResponseEntity<Persona>(pojo, HttpStatus.OK);
		}
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	
}
