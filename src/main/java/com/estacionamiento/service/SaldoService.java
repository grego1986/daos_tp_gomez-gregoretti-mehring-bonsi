package com.estacionamiento.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estacionamiento.pojo.Saldo;
import com.estacionamiento.repository.ISaldoRepo;

@Service
public class SaldoService implements ISaldoService {

	
	@Autowired
	private ISaldoRepo saldoRepo;
	
	@Override
	public List<Saldo> listar() {
		
		return saldoRepo.findAll();
	}

	@Override
	public void agregar(Saldo saldo) {
		
		saldoRepo.save(saldo);
	}


	@Override
	public void borrar(Saldo saldo) {
		
		saldoRepo.delete(saldo);
	}

	

	@Override
	public void actualizar(Saldo saldo, Integer id) {
		
		if (saldoRepo.existsById(id)) {
            saldo.setIdsaldo(id);
            saldoRepo.save(saldo);
        }
	}

	@Override
	public Saldo buscar(Integer id) {
		
		return saldoRepo.findById(id).orElse(null);
	}

}
