package br.com.davi.api.service;

import br.com.davi.api.model.Endereco;
import br.com.davi.api.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco save(Endereco endereco){
        enderecoRepository.save(endereco);
        return endereco;
    }

    public List<Endereco> getListaEndereco(){
        return enderecoRepository.findAll();
    }

}