package com.skopos.SkoposAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.skopos.SkoposAPI.model.EmpresaModel;

public interface EmpresaRepository extends JpaRepository<EmpresaModel, Integer>{
	public EmpresaModel findByCnpj(String cnpj);
	public Optional<EmpresaModel> findByCnpjOptional(String cnpj);
}
