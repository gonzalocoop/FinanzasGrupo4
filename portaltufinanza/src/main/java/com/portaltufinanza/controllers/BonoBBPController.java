package com.portaltufinanza.controllers;

import com.portaltufinanza.dtos.BonoBBPDTO;
import com.portaltufinanza.entities.BonoBBP;
import com.portaltufinanza.serviceinterfaces.IBonoBBPService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bonobbp")
public class BonoBBPController {
    @Autowired
    private IBonoBBPService bbpS;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void registrar(@RequestBody BonoBBPDTO dto){
        ModelMapper m = new ModelMapper();
        BonoBBP c= m .map(dto, BonoBBP.class);
        bbpS.insert(c);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','USUARIO')")
    public List<BonoBBPDTO> listar(){
        return bbpS.list().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x, BonoBBPDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") Integer id){

        bbpS.delete(id);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody BonoBBPDTO dto){
        ModelMapper m = new ModelMapper();
        BonoBBP c = m.map(dto, BonoBBP.class);
        bbpS.update(c);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','USUARIO')")
    public BonoBBPDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        BonoBBPDTO dto=m.map(bbpS.listId(id),BonoBBPDTO.class);
        return dto;
    }
}
