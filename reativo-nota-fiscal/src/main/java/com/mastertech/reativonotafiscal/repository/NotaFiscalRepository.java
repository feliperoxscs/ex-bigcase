package com.mastertech.reativonotafiscal.repository;

import com.mastertech.reativonotafiscal.model.Nfe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotaFiscalRepository extends CrudRepository<Nfe, Long> {
}
