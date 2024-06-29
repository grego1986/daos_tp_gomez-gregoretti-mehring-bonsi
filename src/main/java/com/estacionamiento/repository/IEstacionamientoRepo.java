package com.estacionamiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.estacionamiento.pojo.Estacionamiento;

public interface IEstacionamientoRepo extends JpaRepository<Estacionamiento, Long>  {

}
