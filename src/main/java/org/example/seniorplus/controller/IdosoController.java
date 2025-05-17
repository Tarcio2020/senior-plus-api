package org.example.seniorplus.controller;

import org.example.seniorplus.domain.Idoso;
import org.example.seniorplus.service.IdosoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@Controller(value="/api/v1/idoso")
public class IdosoController implements Serializable {

    private IdosoService idosoService;

   @GetMapping
    public ResponseEntity<List<Idoso>> findAll() {
       List<Idoso> idosos = idosoService.buscarTodos();
       return ResponseEntity.ok().body(idosos);
   }

    @GetMapping(value = "/{cpf}")
    public ResponseEntity<Idoso> findById(@PathVariable String cpf) {
        Idoso find = idosoService.buscarPorCpf(cpf);
        return find != null ? ResponseEntity.ok(find) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Idoso> save(@RequestBody Idoso idoso) {
       Idoso saved = idosoService.criar(idoso);
       return ResponseEntity.ok().body(saved);
    }

    @DeleteMapping(value = "/{cpf}")
    public ResponseEntity<Idoso> delete(@RequestBody Idoso idoso) {
       idosoService.deletar(idoso.getCpf());
       return ResponseEntity.noContent().build();
    }

}
