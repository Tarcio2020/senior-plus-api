package org.example.seniorplus.controller;

import org.example.seniorplus.domain.Idoso;
import org.example.seniorplus.service.IdosoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/usuario")
public class IdosoController implements Serializable {

    @Autowired
    private IdosoService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Idoso>> buscarTodos() {
        List<Idoso> list = service.buscarTodos();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/{cpf}", method = RequestMethod.GET)
    public ResponseEntity<Idoso> buscarPorCpf(@PathVariable String cpf) {
        Idoso obj = service.buscarPorCpf(cpf);
        return ResponseEntity.ok().body((Idoso) obj.getEnderecos());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> criar(@RequestBody Idoso idoso) {
        Idoso obj = service.criar(idoso);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{cpf}").buildAndExpand(obj.getCpf()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @RequestMapping(value = "/{cpf}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deletar(@PathVariable String cpf) {
        service.deletar(cpf);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(value = "/{cpf}", method = RequestMethod.PUT)
    public ResponseEntity<Idoso> atualizar(@PathVariable String cpf, @RequestBody Idoso idoso) {
        Idoso objAtualizado = service.atualizar(cpf, idoso);
        return ResponseEntity.ok().body(objAtualizado);
    }

}
