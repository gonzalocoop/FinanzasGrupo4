package com.portaltufinanza.controllers;

import com.portaltufinanza.dtos.PrecioCorrespondienteDTO;
import com.portaltufinanza.entities.PrecioCorrespondiente;
import com.portaltufinanza.serviceinterfaces.IPrecioCorrespondienteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/preciocorrespondiente")
public class PrecioCorrespondienteController {
    @Autowired
    private IPrecioCorrespondienteService pcS;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void registrar(@RequestBody PrecioCorrespondienteDTO dto){
        ModelMapper m = new ModelMapper();
        PrecioCorrespondiente c= m .map(dto, PrecioCorrespondiente.class);
        pcS.insert(c);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','USUARIO')")
    public List<PrecioCorrespondienteDTO> listar(){
        return pcS.list().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x, PrecioCorrespondienteDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") Integer id){

        pcS.delete(id);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody PrecioCorrespondienteDTO dto){
        ModelMapper m = new ModelMapper();
        PrecioCorrespondiente c = m.map(dto, PrecioCorrespondiente.class);
        pcS.update(c);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','USUARIO')")
    public PrecioCorrespondienteDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        PrecioCorrespondienteDTO dto=m.map(pcS.listId(id),PrecioCorrespondienteDTO.class);
        return dto;
    }
}
