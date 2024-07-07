package com.estacionamiento.Controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.estacionamiento.pojo.Comercio;
import com.estacionamiento.pojo.Persona;
import com.estacionamiento.pojo.Recarga;
import com.estacionamiento.pojo.Vehiculo;
import com.estacionamiento.service.ComercioService;
import com.estacionamiento.service.PersonaService;
import com.estacionamiento.service.RecargaService;
import com.estacionamiento.service.VehiculoSevice;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.estacionamiento.error.MensajeError;
import com.estacionamiento.exception.Excepcion;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/recargas")
public class RecargaController {
	
	@Autowired
	private RecargaService recargaService;
	@Autowired
	private ComercioService comercioService;
	@Autowired
	private PersonaService personaService;
	@Autowired
	private VehiculoSevice vehiculoService;
	
	
	
	
	
	
	/**
	 * Inserta una nueva persona en la base de datos
	 * 			curl --location --request POST 'http://localhost:8081/recargas' 
	 *			--header 'Accept: application/json' 
	 * 			--header 'Content-Type: application/json' 
	 *			--data-raw '{
     *                         "patente": "aaa111",
     *                         "dni": 10000001,
     *                         "cuit": 12345678911,
     *                         "importe": 200
     *                      }'
	 * @param rec Recarga a insertar
	 * @return Recarga insertada o error en otro caso
	 * @throws Exception 
	 */
	@PostMapping
	public ResponseEntity<Object> guardar( @Valid @RequestBody RecargaForm form, BindingResult result) throws Exception
	{
		
		if(result.hasErrors())
		{
			//Dos alternativas:
			//throw new ResponseStatusException(HttpStatus.BAD_REQUEST, this.formatearError(result));
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body( this.formatearError(result));
		}
		
		Recarga rec = form.recarga();
		Optional<Persona> p = personaService.buscarOptional(form.getDni().getDni());
		if(p.isPresent())
			rec.setPersona(p.get());
		else
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getError("01", "Ciudad Requerida", "La ciudad indicada no se encuentra en la base de datos."));
//				return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La ciudad indicada no se encuentra en la base de datos.");
		}
		
		Optional<Vehiculo> v = vehiculoService.buscarOptional(form.getPatente().getPatente());
		if(v.isPresent())
			rec.setVehiculo(v.get());
		else
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getError("02", "Ciudad Requerida", "La ciudad indicada no se encuentra en la base de datos."));
//				return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La ciudad indicada no se encuentra en la base de datos.");
		}
		
		Optional<Comercio> c = comercioService.buscarOptional(form.getCuit().getCuil());
		if(c.isPresent())
			rec.setComercio(c.get());
		else
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(getError("03", "Ciudad Requerida", "La ciudad indicada no se encuentra en la base de datos."));
//				return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La ciudad indicada no se encuentra en la base de datos.");
		}
		
		//ahora inserto el cliente
		recargaService.agregar(rec);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(rec.getId_recarga()).toUri(); //Por convención en REST, se devuelve la  url del recurso recién creado

		return ResponseEntity.created(location).build();//201 (Recurso creado correctamente)
		

	}

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Recarga> getById(@PathVariable Long id) throws Exception
	{
		Optional<Recarga> rta = recargaService.buscarOptional(id);
		if(rta.isPresent())
		{
			Recarga pojo=rta.get();
			return new ResponseEntity<Recarga>(pojo, HttpStatus.OK);
		}
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
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
