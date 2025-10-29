package com.portaltufinanza.controllers;

import com.portaltufinanza.dtos.MonedaDTO;
import com.portaltufinanza.entities.Moneda;
import com.portaltufinanza.serviceinterfaces.IMonedaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/moneda")
public class MonedaController {
    @Autowired
    private IMonedaService mS;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void registrar(@RequestBody MonedaDTO dto){
        ModelMapper m = new ModelMapper();
        Moneda c= m .map(dto, Moneda.class);
        mS.insert(c);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','USUARIO')")
    public List<MonedaDTO> listar(){
        return mS.list().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x, MonedaDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") Integer id){

        mS.delete(id);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody MonedaDTO dto){
        ModelMapper m = new ModelMapper();
        Moneda c = m.map(dto, Moneda.class);
        mS.update(c);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','USUARIO')")
    public MonedaDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        MonedaDTO dto=m.map(mS.listId(id),MonedaDTO.class);
        return dto;
    }
}
