package com.es.segurosinseguros.service;

import com.es.segurosinseguros.dto.SeguroDTO;
import com.es.segurosinseguros.model.Seguro;
import com.es.segurosinseguros.repository.SeguroRepository;
import com.es.segurosinseguros.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeguroService {
    @Autowired
    private SeguroRepository repository;

    public SeguroDTO getById(String id) {

        Long idEntity = Long.parseLong(id);

        Seguro s = repository.findById(idEntity).orElse(null);

        return Mapper.entityToDTO(s);
    }

    public List<SeguroDTO> getAll() {
        List<SeguroDTO> seguroDTOList = new ArrayList<>();
        List<Seguro> listaSeguro = repository.findAll();

        for (Seguro s : listaSeguro){
            SeguroDTO seguroDTO = new SeguroDTO();
            seguroDTO.setNif(s.getNif());
            seguroDTO.setNombre(s.getNombre());
            seguroDTO.setApe1(s.getApe1());
            seguroDTO.setApe2(s.getApe2());
            seguroDTO.setEdad(s.getEdad());
            seguroDTO.setNumHijos(s.getNumHijos());
            seguroDTO.setSexo(s.getSexo());
            seguroDTO.setCasado(s.isCasado());
            seguroDTO.setEmbarazada(s.isEmbarazada());

            seguroDTOList.add(seguroDTO);
        }
        return seguroDTOList;
    }

    public SeguroDTO create(SeguroDTO s) {
        Seguro savedSeguro = Mapper.DTOToEntity(s);
        repository.save(savedSeguro);

        return s;
    }

    public SeguroDTO delete(String id) {
        Long idL = 0L;
        try{
            idL = Long.parseLong(id);
        } catch (NumberFormatException e) {
            System.out.println("Error al pasear el id");
            return null;
        }
        Seguro s = repository.findById(idL).orElse(null);
        if (s == null)
            return null;
        else{
            repository.delete(s);
            return Mapper.entityToDTO(s);
        }
    }

    public SeguroDTO update(String id, SeguroDTO seguroDTO) {
        Long idL = 0L;
        try {
            idL = Long.parseLong(id);
        } catch (NumberFormatException e) {
            System.out.println("Error al parsear el id");
            return null;
        }
        Seguro existingSeguro = repository.findById(idL).orElse(null);
        if (existingSeguro == null) {
            return null;
        } else {
            existingSeguro.setNif(seguroDTO.getNif());
            existingSeguro.setNombre(seguroDTO.getNombre());
            existingSeguro.setApe1(seguroDTO.getApe1());
            existingSeguro.setApe2(seguroDTO.getApe2());
            existingSeguro.setEdad(seguroDTO.getEdad());
            existingSeguro.setNumHijos(seguroDTO.getNumHijos());
            existingSeguro.setSexo(seguroDTO.getSexo());
            existingSeguro.setCasado(seguroDTO.isCasado());
            existingSeguro.setEmbarazada(seguroDTO.isEmbarazada());
            repository.save(existingSeguro);
            return Mapper.entityToDTO(existingSeguro);
        }
    }
}
