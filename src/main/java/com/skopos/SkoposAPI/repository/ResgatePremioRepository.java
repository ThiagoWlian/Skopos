package com.skopos.SkoposAPI.repository;

import com.skopos.SkoposAPI.dto.PremioListaDto;
import com.skopos.SkoposAPI.model.ResgatePremioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResgatePremioRepository extends JpaRepository<ResgatePremioModel, Integer> {

    @Query("SELECT new com.skopos.SkoposAPI.dto.PremioListaDto(p.id, p.nome, p.descricao, p.imagemCaminho, rp.status) FROM ResgatePremioModel rp " +
            "JOIN PremioModel p ON p.id = rp.premio.id WHERE p.empresa.id = ?1 AND rp.status = 'Resgatado'")
    public List<PremioListaDto> findPremiosParaEnviar(int idEmpresa);

    @Query("SELECT new com.skopos.SkoposAPI.dto.PremioListaDto(rp.premio.id, p.nome, p.descricao, p.imagemCaminho, rp.status) FROM ResgatePremioModel rp " +
            "JOIN PremioModel p " +
            "ON p.id = rp.premio.id " +
            "WHERE rp.pessoa.id = ?1")
    public List<PremioListaDto> findPremiosParaUsuario(int idPessoa);

    @Query("SELECT P FROM ResgatePremioModel P WHERE P.premio.id = ?1 AND P.status = 'Resgatado'")
    public List<ResgatePremioModel> findFirstByPremioId(int idPremio);
}
