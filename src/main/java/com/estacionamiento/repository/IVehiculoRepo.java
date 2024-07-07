package com.estacionamiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estacionamiento.pojo.Vehiculo;

public interface IVehiculoRepo extends JpaRepository<Vehiculo, String>  {

	Vehiculo findBypatente(String patente);
}
