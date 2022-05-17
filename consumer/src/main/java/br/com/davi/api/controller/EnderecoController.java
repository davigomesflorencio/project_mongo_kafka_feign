package br.com.davi.api.controller;

import br.com.davi.api.model.Endereco;
import br.com.davi.api.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<Endereco> saveEndereco(@RequestBody Endereco endereco){
        enderecoService.save(endereco);
        return ResponseEntity.ok(endereco);
    }

    @GetMapping
    public ResponseEntity<List<Endereco>> getListaEndereco(){
        List<Endereco> listaEndereco = enderecoService.getListaEndereco();
        return ResponseEntity.ok(listaEndereco);
    }

}