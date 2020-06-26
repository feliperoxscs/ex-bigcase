package com.mastertech.reativonotafiscal.client;

import com.mastertech.reativonotafiscal.dto.ReceitaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "receita", url = "https://www.receitaws.com.br")
public interface ReceitaClient {

    @RequestMapping("/v1/cnpj/{identidade}")
    ReceitaResponse getCapitalSocial(@PathVariable String identidade);
}
