package com.boleteriabernabeu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.boleteriabernabeu.entity.Entrada;

@Repository
public interface IEntradaRepository extends  CrudRepository<Entrada, Long>{
	
	@Procedure("actualizar_entradas")
	public void updateEntrada(Long identrada,int cantidad);
	
	
}
