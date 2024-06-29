package com.estacionamiento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estacionamiento.pojo.CuentaUsuario;
import com.estacionamiento.repository.ICuentaUsuarioRepo;


@Service
public class CuentaUsuarioService implements ICuentaUsuarioService{

	@Autowired
	private ICuentaUsuarioRepo cuentaRepo;
	
	@Override
	public List<CuentaUsuario> listar() {
		
		return cuentaRepo.findAll();
	}

	@Override
	public void agregar(CuentaUsuario cuenta) {
		
		cuentaRepo.save(cuenta);
	}

	@Override
	public void actualizar(CuentaUsuario cuenta, Long id) {
		
		if (cuentaRepo.existsById(id)) {
            cuenta.setId_cuenta(id);;
            cuentaRepo.save(cuenta);
        }
	}

	@Override
	public void borrar(CuentaUsuario cuenta) {
		
		cuentaRepo.delete(cuenta);
	}

	@Override
	public CuentaUsuario buscar(Long id) {
		
		return cuentaRepo.findById(id).orElse(null);
	}

}
