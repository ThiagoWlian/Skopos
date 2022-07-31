package com.skopos.SkoposAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.skopos.SkoposAPI.model.EmpresaModel;

public interface EmpresaRepository extends JpaRepository<EmpresaModel, Integer>{
	public EmpresaModel findByCnpj(String cnpj);
}
