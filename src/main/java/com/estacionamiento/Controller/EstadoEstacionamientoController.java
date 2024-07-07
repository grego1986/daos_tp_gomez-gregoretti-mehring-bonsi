package com.estacionamiento.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.estacionamiento.pojo.Vehiculo;
import com.estacionamiento.service.EstacionamientoService;


@RestController

public class EstadoEstacionamientoController {
       //Para HATEOS
	
	@Autowired
	private EstacionamientoService estacionamientoService;
	
	@GetMapping("/{patenteVehiculo}")
    public String obtenerEstadoEstacionamiento(@PathVariable Vehiculo vehiculo) throws Exception {
		estacionamientoService.consultarEstacionamiento(vehiculo.getPatente());   //ver por que no puedo con id
		
        return "Estado del estacionamiento para el vehículo con patente: " + vehiculo;
    }
	
	
	
	
	
}
