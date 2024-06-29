package com.estacionamiento.service;

import java.util.List;

import com.estacionamiento.pojo.CuentaUsuario;

public interface ICuentaUsuarioService {

	public List<CuentaUsuario> listar();
	public void agregar(CuentaUsuario cuenta);
	public void actualizar(CuentaUsuario cuenta, Long id);
	public void borrar(CuentaUsuario cuenta);
	public CuentaUsuario buscar (Long id);
}
