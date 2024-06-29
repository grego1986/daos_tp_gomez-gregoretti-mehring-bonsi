package com.estacionamiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.estacionamiento.pojo.Recarga;

public interface IRecargaRepo extends JpaRepository<Recarga, Long>  {

}
