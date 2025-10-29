package com.portaltufinanza.controllers;

import com.portaltufinanza.dtos.PropiedadDTO;
import com.portaltufinanza.entities.Propiedad;
import com.portaltufinanza.serviceinterfaces.IPropiedadService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/propiedad")
public class PropiedadController {
    @Autowired
    private IPropiedadService pS;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void registrar(@RequestBody PropiedadDTO dto){
        ModelMapper m = new ModelMapper();
        Propiedad c= m .map(dto, Propiedad.class);
        pS.insert(c);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','USUARIO')")
    public List<PropiedadDTO> listar(){
        return pS.list().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x, PropiedadDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") Integer id){

        pS.delete(id);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody PropiedadDTO dto){
        ModelMapper m = new ModelMapper();
        Propiedad c = m.map(dto, Propiedad.class);
        pS.update(c);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','USUARIO')")
    public PropiedadDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        PropiedadDTO dto=m.map(pS.listId(id),PropiedadDTO.class);
        return dto;
    }
}
