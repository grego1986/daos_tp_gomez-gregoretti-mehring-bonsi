package com.estacionamiento.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.estacionamiento.pojo.Comercio;
import com.estacionamiento.service.ComercioService;
import com.estacionamiento.dto.ComercioDto;
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
	
	
	
	
	private ComercioDto buildResponse(Comercio comercio) throws Excepcion {
		try {
			ComercioDto dto = new ComercioDto(comercio);
			 //Self link
			Link selfLink = WebMvcLinkBuilder.linkTo(ComercioController.class)
										.slash(comercio.getCuil())                
										.withSelfRel();
			
			Link ciudadLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UsuarioController.class)
			       													.getById(comercio.getCuil()))
			       													.withRel("persona");
			dto.add(selfLink);
			dto.add(ciudadLink);
			return dto;
		} catch (Exception e) {
			throw new Excepcion(e.getMessage(), 500);
		}
	}
}
