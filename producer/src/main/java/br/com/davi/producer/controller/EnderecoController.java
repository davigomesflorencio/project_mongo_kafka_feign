package br.com.davi.producer.controller;

import br.com.davi.producer.FeignBuilderFactory;
import br.com.davi.producer.http.EnderecoJson;
import br.com.davi.producer.response.EnderecoResponse;
import br.com.davi.producer.service.EnderecoService;
import br.com.davi.producer.service.ViaCepService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("endereco")
public class EnderecoController {

    private ViaCepService viaCepService;

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping(value="/{cep}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<EnderecoResponse> obterCep(@PathVariable("cep") String cep) {
        viaCepService= FeignBuilderFactory.createClient(ViaCepService.class);
        log.info(viaCepService.obterCep(cep));

        EnderecoResponse enderecoResponse = viaCepService.obterCep(cep);

        return ResponseEntity.ok(enderecoResponse);
    }

    @PostMapping
    public ResponseEntity<EnderecoResponse> enviarEndereco(@RequestBody EnderecoJson enderecoJson) throws JsonProcessingException {

        log.info("## Dados envidos pelo cliente: {}", enderecoJson);
        viaCepService= FeignBuilderFactory.createClient(ViaCepService.class);
        EnderecoResponse enderecoResponse = viaCepService.obterCep(enderecoJson.getCep());

        enderecoResponse.setComplemento(enderecoJson.getComplemento());

        ObjectMapper objectMapper = new ObjectMapper();
        String mensagem = objectMapper.writeValueAsString(enderecoResponse);

        enderecoService.sendMessage(mensagem);
        log.info("## Endereço retornado pela API de CEP: {}", enderecoResponse);

        return ResponseEntity.ok(enderecoResponse);
    }
}