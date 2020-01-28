package com.boleteriabernabeu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boleteriabernabeu.entity.Compra;
import com.boleteriabernabeu.entity.Entrada;
import com.boleteriabernabeu.repository.ICompraRepository;
import com.boleteriabernabeu.repository.IEntradaRepository;
import com.boleteriabernabeu.service.IEntradaService;

@Service
public class EntradaServiceImpl implements IEntradaService{
	
	@Autowired
	private ICompraRepository compraRepository;
	
	@Autowired
	private IEntradaRepository entradaRepository;

	@Override
	public List<Entrada> listaAllEntradas() {
		// TODO Auto-generated method stub
		return (List<Entrada>) entradaRepository.findAll();
	}

	@Override
	public Entrada getId(Long id) {
		
		return entradaRepository.findById(id).get();
	}

	@Override
	public void saveCompra(Compra compra) {
		compraRepository.save(compra);
		
		
	}

	@Override
	public void updateEntrada(Long identrada, int cantidad) {
		// TODO Auto-generated method stub
		entradaRepository.updateEntrada(identrada, cantidad);
	}

	@Override
	public List<Compra> listAllCompras() {
		// TODO Auto-generated method stub
		return (List<Compra>) compraRepository.findAll();
	}
	
	

	

	

	


	


	
	
	
	

}
