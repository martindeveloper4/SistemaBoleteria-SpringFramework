package com.boleteriabernabeu.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.boleteriabernabeu.entity.Compra;

@Repository
public interface ICompraRepository extends   CrudRepository<Compra, Long>{
	
}
