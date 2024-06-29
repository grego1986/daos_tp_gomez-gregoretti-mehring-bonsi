package com.estacionamiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estacionamiento.pojo.CuentaUsuario;

@Repository
public interface ICuentaUsuarioRepo extends JpaRepository<CuentaUsuario, Long> {

}
