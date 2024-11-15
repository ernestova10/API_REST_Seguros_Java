package com.es.segurosinseguros.controller;

import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.exception.BadRequestException;
import com.es.segurosinseguros.model.Seguro;
import com.es.segurosinseguros.repository.SeguroRepository;
import com.es.segurosinseguros.service.SeguroService;
import org.antlr.v4.runtime.tree.pattern.ParseTreePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/seguros")
public class SeguroController {
    //Autowired
    @Autowired
    private SeguroService seguroService;

    @GetMapping("/{id}")
    public ResponseEntity<SeguroDTO> getById(@PathVariable String id) {

        //1º Compruebo que el id no es null
        if (id == null || id.equals("a")) {
            // LANZO UNA EXCEPCION PROPIA
            /*
            a) ¿Qué código de estado devolver? -> BAD_REQUEST (400)
            b) ¿Qué informaciónd aríais al cliente?
                -> Un  mensaje: "id no válido"
                -> La URI: localhost:8080/seguros/x
            c) Nombre a nuestra excepción -> BadRequestException
            */

            throw new BadRequestException("id no válido");
        }
        return null;
    }

    @GetMapping("/")
    public List<SeguroDTO> getAll() {
        return seguroService.getAll();
    }

    @PostMapping("/")
    public SeguroDTO create(@RequestBody SeguroDTO seguroDTO) {
        return seguroService.create(seguroDTO);
    }

    @DeleteMapping("/{id}")
    public SeguroDTO delete(
            @PathVariable String id
    ){
        if (id == null || id.isEmpty())
            return null;
        SeguroDTO s = seguroService.delete(id);
        return s;
    }

    @PutMapping("/{id}")
    public ResponseEntity<SeguroDTO> update(@PathVariable String id, @RequestBody SeguroDTO seguroDTO) {
        if (id == null || id.isEmpty()) {
            throw new BadRequestException("id no válido");
        }
        SeguroDTO updatedSeguro = seguroService.update(id, seguroDTO);
        if (updatedSeguro == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedSeguro);
        }
    }
}
