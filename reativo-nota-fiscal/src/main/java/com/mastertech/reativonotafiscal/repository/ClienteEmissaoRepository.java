package com.mastertech.reativonotafiscal.repository;

import com.mastertech.reativonotafiscal.model.ClienteEmissao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteEmissaoRepository extends CrudRepository<ClienteEmissao, Long> {

    List<ClienteEmissao> findClienteEmissaoByIdentidade(String identidade);
}
