package br.com.davi.producer.service;

import br.com.davi.producer.response.EnderecoResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

//@FeignClient(name = "viacep", url="https://viacep.com.br/ws")
@Headers("Accept: application/json")
public interface ViaCepService {

//    @GetMapping(value = "/{cep}/json")
    @RequestLine("GET /{cep}/json")
    EnderecoResponse obterCep(@Param String cep);
}