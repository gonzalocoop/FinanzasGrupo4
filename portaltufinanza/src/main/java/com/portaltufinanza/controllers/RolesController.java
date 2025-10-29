package com.portaltufinanza.controllers;

import com.portaltufinanza.dtos.RolesDTO;
import com.portaltufinanza.entities.Roles;
import com.portaltufinanza.serviceinterfaces.IRolesService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolesController {
    @Autowired
    private IRolesService rS;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void registrar(@RequestBody RolesDTO dto){
        ModelMapper m = new ModelMapper();
        Roles c= m .map(dto, Roles.class);
        rS.insert(c);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','USUARIO')")
    public List<RolesDTO> listar(){
        return rS.list().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x, RolesDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") Integer id){

        rS.delete(id);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody RolesDTO dto){
        ModelMapper m = new ModelMapper();
        Roles c = m.map(dto, Roles.class);
        rS.update(c);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','USUARIO')")
    public RolesDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        RolesDTO dto=m.map(rS.listId(id),RolesDTO.class);
        return dto;
    }
}
