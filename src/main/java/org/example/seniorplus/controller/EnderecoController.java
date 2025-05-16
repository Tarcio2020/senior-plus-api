package org.example.seniorplus.controller;

import org.example.seniorplus.domain.Endereco;
import org.example.seniorplus.domain.Idoso;
import org.example.seniorplus.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Endereco>> findAll() {
        List<Endereco> list = service.getAllEndereco();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/{cpf}", method = RequestMethod.GET)
    public ResponseEntity<Endereco> findById(@PathVariable String cpf) {
        Endereco obj = service.getEnderecoById(cpf);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Endereco endereco) {
        Endereco obj = service.saveEndereco(endereco);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{cpf}").buildAndExpand(obj.getCpf()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{cpf}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String cpf) {
        service.deleteEndereco(cpf);
        return ResponseEntity.noContent().build();
    }


}
