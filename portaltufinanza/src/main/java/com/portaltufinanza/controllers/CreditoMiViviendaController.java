package com.portaltufinanza.controllers;

import com.portaltufinanza.dtos.CreditoMiViviendaDTO;
import com.portaltufinanza.entities.CreditoMiVivienda;
import com.portaltufinanza.serviceinterfaces.ICreditoMiViviendaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/creditomivivienda")
public class CreditoMiViviendaController {
    @Autowired
    private ICreditoMiViviendaService cmvS;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void registrar(@RequestBody CreditoMiViviendaDTO dto){
        ModelMapper m = new ModelMapper();
        CreditoMiVivienda c= m .map(dto, CreditoMiVivienda.class);
        cmvS.insert(c);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','USUARIO')")
    public List<CreditoMiViviendaDTO> listar(){
        return cmvS.list().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x, CreditoMiViviendaDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") Integer id){

        cmvS.delete(id);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody CreditoMiViviendaDTO dto){
        ModelMapper m = new ModelMapper();
        CreditoMiVivienda c = m.map(dto, CreditoMiVivienda.class);
        cmvS.update(c);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','USUARIO')")
    public CreditoMiViviendaDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        CreditoMiViviendaDTO dto=m.map(cmvS.listId(id),CreditoMiViviendaDTO.class);
        return dto;
    }

    @PostMapping("/generarcreditovacio")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','USUARIO')")
    public void registrarCreditoMiVivienda(@RequestParam LocalDate fechaInicio,
                                           @RequestParam String tipoTasa,
                                           @RequestParam BigDecimal tasaInteres,
                                           @RequestParam String periodicidadTasa,
                                           @RequestParam int numeroCuotas,
                                           @RequestParam String tipoGracia,
                                           @RequestParam int duracionGraciaMeses,
                                           @RequestParam String tipoCapitalizacion,
                                           @RequestParam int idPrecioCorrespondiente,
                                           @RequestParam int idUsuario) {
        cmvS.registrarCreditoMiVivienda(fechaInicio,  tipoTasa,  tasaInteres,  periodicidadTasa,  numeroCuotas,  tipoGracia,  duracionGraciaMeses,  tipoCapitalizacion,  idPrecioCorrespondiente,  idUsuario);
    }
}
