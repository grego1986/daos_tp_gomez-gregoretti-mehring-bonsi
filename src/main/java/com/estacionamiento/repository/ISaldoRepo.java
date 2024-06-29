package com.estacionamiento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estacionamiento.pojo.Saldo;

public interface ISaldoRepo extends JpaRepository<Saldo, Integer>  {

}
