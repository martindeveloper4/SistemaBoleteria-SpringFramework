package com.boleteriabernabeu.service;

import java.util.List;


import com.boleteriabernabeu.entity.Compra;
import com.boleteriabernabeu.entity.Entrada;



public interface IEntradaService {
	
	public List<Entrada> listaAllEntradas();
	public Entrada getId(Long id);
	public void saveCompra(Compra compra);
	public void updateEntrada(Long identrada,int cantidad);
	public List<Compra> listAllCompras();
}
