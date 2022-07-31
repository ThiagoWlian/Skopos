package com.skopos.SkoposAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skopos.SkoposAPI.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer>{
	public Optional<UsuarioModel> findByNome(String name);
}
