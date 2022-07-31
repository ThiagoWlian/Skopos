package com.skopos.SkoposAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skopos.SkoposAPI.model.PessoaModel;

public interface PessoaRepositoy extends JpaRepository<PessoaModel, Integer>{

}
