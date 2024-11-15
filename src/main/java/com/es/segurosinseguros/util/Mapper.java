package com.es.segurosinseguros.util;

import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.model.Seguro;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    public static SeguroDTO entityToDTO(Seguro s) {
        SeguroDTO dto = new SeguroDTO();
        dto.setNif(s.getNif());
        dto.setNombre(s.getNombre());
        dto.setApe1(s.getApe1());
        dto.setApe2(s.getApe2());
        dto.setEdad(s.getEdad());
        dto.setNumHijos(s.getNumHijos());
        dto.setSexo(s.getSexo());
        dto.setCasado(s.isCasado());
        dto.setEmbarazada(s.isEmbarazada());
        return dto;
    }

    public static Seguro DTOToEntity(SeguroDTO dto) {
        Seguro seguro = new Seguro();
        seguro.setNif(dto.getNif());
        seguro.setNombre(dto.getNombre());
        seguro.setApe1(dto.getApe1());
        seguro.setApe2(dto.getApe2());
        seguro.setEdad(dto.getEdad());
        seguro.setNumHijos(dto.getNumHijos());
        seguro.setSexo(dto.getSexo());
        seguro.setCasado(dto.isCasado());
        seguro.setEmbarazada(dto.isEmbarazada());
        return seguro;
    }

    
}
