package com.estacionamiento.Controller;

import com.estacionamiento.pojo.Estacionamiento;
import com.estacionamiento.pojo.Vehiculo;
import com.estacionamiento.service.EstacionamientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



	@RestController
	@RequestMapping("/api/estacionamiento")
	public class EstacionamientoController {
	    @Autowired
	    private EstacionamientoService estacionamientoService;

	    @PostMapping
	    public ResponseEntity<?> insertarEstacionamiento(@RequestParam Estacionamiento estacionamiento) {
	        try {
	            Estacionamiento resultado = estacionamientoService.insertarEstacionamiento(estacionamiento);
	            return ResponseEntity.ok(resultado);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	        }
	    }

	    @PutMapping
	    public ResponseEntity<?> actualizarEstacionamiento(@RequestParam String patente, @RequestParam Vehiculo vehiculo) {
	        try {
	            Estacionamiento resultado = estacionamientoService.actualizarEstacionamiento(patente, vehiculo);
	            return ResponseEntity.ok(resultado);
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	        }
	    }

	    @GetMapping(value = "/{patente}", produces = { MediaType.APPLICATION_JSON_VALUE})
	    public ResponseEntity<?> consultarEstacionamiento(@PathVariable String patente) {
	        try {
	            Estacionamiento resultado = estacionamientoService.consultarEstacionamiento(patente);
	            if (resultado.getEstado()) {
	            	 return ResponseEntity.ok("estacionado");
	            } else {
	            	return ResponseEntity.ok("libre");
	            }
	           
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	        }
	    }
	}

