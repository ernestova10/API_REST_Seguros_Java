package com.es.segurosinseguros.controller;

import com.es.segurosinseguros.dto.AsistenciaMedicaDTO;
import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.exception.BadRequestException;
import com.es.segurosinseguros.service.AsistenciaMedicaService;
import com.es.segurosinseguros.service.SeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/asistencia")
public class AsistenciaMedicaController {
    @Autowired
    private AsistenciaMedicaService asistenciaMedicaService;

    @GetMapping("/{id}")
    public ResponseEntity<AsistenciaMedicaDTO> getById(@PathVariable String id) {

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
        return asistenciaMedicaService.getAll();
    }

}
