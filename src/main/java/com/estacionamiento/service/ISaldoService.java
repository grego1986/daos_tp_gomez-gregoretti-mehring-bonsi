package com.estacionamiento.service;

import java.util.List;

import com.estacionamiento.pojo.Saldo;

public interface ISaldoService {

	public List<Saldo> listar();
	public void agregar(Saldo saldo);
	public void actualizar(Saldo saldo, Integer id);
	public void borrar(Saldo saldo);
	public Saldo buscar (Integer id);
}
