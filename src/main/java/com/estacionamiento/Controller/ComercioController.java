package com.estacionamiento.Controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.estacionamiento.pojo.Comercio;
import com.estacionamiento.service.ComercioService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.validation.Valid;

import com.estacionamiento.dto.ComercioDto;
import com.estacionamiento.error.MensajeError;
import com.estacionamiento.exception.Excepcion;


@RestController
@RequestMapping("/comercios")
public class ComercioController {
	
	@Autowired
    private ComercioService comercioService;
	
	@GetMapping( produces = { MediaType.APPLICATION_JSON_VALUE})
	public List<ComercioDto> listarComercios() throws Excepcion {
		
		List<Comercio> comercio = comercioService.listar();
		List<ComercioDto> dtos=new ArrayList<ComercioDto>();
		for (Comercio comer : comercio) {
			
	        dtos.add(buildResponse(comer));
		}
		return dtos;


	}

	
	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ComercioDto> getById(@PathVariable Long id) throws Excepcion
	{
		Optional<Comercio> rta = comercioService.buscarOptional(id);
		if(rta.isPresent())
		{
			Comercio comercio = rta.get();
			return new ResponseEntity<ComercioDto>(buildResponse(comercio), HttpStatus.OK);
		}
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		
	}
	
	
	/**
	 * Inserta una nueva persona en la base de datos
	 * 			curl --location --request POST 'http://localhost:8081/personas' 
	 *			--header 'Accept: application/json' 
	 * 			--header 'Content-Type: application/json' 
	 *			--data-raw '{
	 *			    "dni": 27837171,
	 *			    "apellido": "perez",
	 *			    "nombre": "juan",
	 *			    "idCiudad": 2
	 *			}'
	 * @param p Persona  a insertar
	 * @return Persona insertada o error en otro caso
	 * @throws Exception 
	 */
	@PostMapping
	public ResponseEntity<Object> guardar( @Valid @RequestBody ComercioForm form, BindingResult result) throws Exception
	{
		
		if(result.hasErrors())
		{
			//Dos alternativas:
			//throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatearError(result));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( this.formatearError(result));
		}
		
		Comercio comercio = form.comercio();	
		//ahora inserto el cliente
		comercioService.agregar(comercio);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cuit}")
				.buildAndExpand(comercio.getCuil()).toUri(); //Por convención en REST, se devuelve la  url del recurso recién creado

		return ResponseEntity.created(location).build();//201 (Recurso creado correctamente)
		

	}
	
	/**
	 * Modifica una persona existente en la base de datos:
	 * 			curl --location --request PUT 'http://localhost:8081/personas/27837176' 
	 *			--header 'Accept: application/json' 
	 * 			--header 'Content-Type: application/json' 
	 *			--data-raw '{
	 *			    "apellido": "Perez",
	 *			    "nombre": "Juan Martin"
	 *			    "idCiudad": 1
	 *			}'
	 * @param p Persona a modificar
	 * @return Persona Editada o error en otro caso
	 * @throws Excepcion 
	 */
	@PutMapping("/id={cuit}")
	public ResponseEntity<Object>  actualizar(@RequestBody ComercioForm form, @PathVariable long cuit) throws Exception
	{
		Optional<Comercio> rta = comercioService.buscarOptional(cuit);
		if(!rta.isPresent())
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuentra el comercio que desea modificar.");
			
		else
		{
			Comercio comerUpdate = form.comercio();
			if(!comerUpdate.getCuil().equals(cuit))
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getError("03", "Dato no editable", "Noi puede modificar el dni."));
			comercioService.actualizar(comerUpdate, cuit);
			return ResponseEntity.ok(buildResponse(comerUpdate));
		}
		
	}
	/**
	 * Borra la persona con el dni indicado
	 * 	  curl --location --request DELETE 'http://localhost:8081/personas/27837176'
	 * @param dni Dni de la persona a borrar
	 * @return ok en caso de borrar exitosamente la persona, error en otro caso
	 */
	@DeleteMapping("/id={cuit}")
	public ResponseEntity<String> eliminar(@PathVariable Long cuit)
	{
		if(!comercioService.buscarOptional(cuit).isPresent())
			return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("No existe un comercio con ese cuit");
		comercioService.delete(cuit);
		
		return ResponseEntity.ok().build();
		
	}
	
	
	
	
	
	private ComercioDto buildResponse(Comercio comercio) throws Excepcion {
		try {
			ComercioDto dto = new ComercioDto(comercio);
			 //Self link
			Link selfLink = WebMvcLinkBuilder.linkTo(ComercioController.class)
										.slash(comercio.getCuil())                
										.withSelfRel();
			
			Link ciudadLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(RecargaController.class)
			       													.getById(comercio.getCuil()))
			       													.withRel("recarga");
			dto.add(selfLink);
			dto.add(ciudadLink);
			return dto;
		} catch (Exception e) {
			throw new Excepcion(e.getMessage(), 500);
		}
	}
	
	private String formatearError(BindingResult result) throws JsonProcessingException
	{
//		primero transformamos la lista de errores devuelta por Java Bean Validation
		List<Map<String, String>> errores= result.getFieldErrors().stream().map(err -> {
															Map<String, String> error= new HashMap<>();
															error.put(err.getField(),err.getDefaultMessage() );
															return error;
														}).collect(Collectors.toList());
		MensajeError e1=new MensajeError();
		e1.setCodigo("01");
		e1.setMensajes(errores);
		
		//ahora usamos la librería Jackson para pasar el objeto a json
		ObjectMapper maper = new ObjectMapper();
		String json = maper.writeValueAsString(e1);
		return json;
	}

	private String getError(String code, String err, String descr) throws JsonProcessingException
	{
		MensajeError e1=new MensajeError();
		e1.setCodigo(code);
		ArrayList<Map<String,String>> errores=new ArrayList<>();
		Map<String, String> error=new HashMap<String, String>();
		error.put(err, descr);
		errores.add(error);
		e1.setMensajes(errores);
		
		//ahora usamos la librería Jackson para pasar el objeto a json
				ObjectMapper maper = new ObjectMapper();
				String json = maper.writeValueAsString(e1);
				return json;
	}
}
