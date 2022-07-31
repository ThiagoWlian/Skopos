package com.skopos.SkoposAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skopos.SkoposAPI.model.PermissaoModel;

public interface PermissaoRepository extends JpaRepository<PermissaoModel, Integer> {

	public Optional<PermissaoModel> getByNome(String nome);

}
