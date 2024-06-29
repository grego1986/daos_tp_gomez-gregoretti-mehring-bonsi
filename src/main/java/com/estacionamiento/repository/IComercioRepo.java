package com.estacionamiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estacionamiento.pojo.Comercio;

@Repository
public interface IComercioRepo extends JpaRepository<Comercio, Long> {

}
