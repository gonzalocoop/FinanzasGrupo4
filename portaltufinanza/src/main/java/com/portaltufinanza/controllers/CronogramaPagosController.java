package com.portaltufinanza.controllers;

import com.portaltufinanza.dtos.CronogramaPagosDTO;
import com.portaltufinanza.dtos.PrecioCorrespondienteDTO;
import com.portaltufinanza.entities.CronogramaPagos;
import com.portaltufinanza.serviceinterfaces.ICronogramaPagosService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cronogramapagos")
public class CronogramaPagosController {
    @Autowired
    private ICronogramaPagosService cpS;

    @PostMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void registrar(@RequestBody CronogramaPagosDTO dto){
        ModelMapper m = new ModelMapper();
        CronogramaPagos c= m .map(dto, CronogramaPagos.class);
        cpS.insert(c);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','USUARIO')")
    public List<CronogramaPagosDTO> listar(){
        return cpS.list().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x, CronogramaPagosDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") Integer id){

        cpS.delete(id);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody CronogramaPagosDTO dto){
        ModelMapper m = new ModelMapper();
        CronogramaPagos c = m.map(dto, CronogramaPagos.class);
        cpS.update(c);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','USUARIO')")
    public CronogramaPagosDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        CronogramaPagosDTO dto=m.map(cpS.listId(id),CronogramaPagosDTO.class);
        return dto;
    }

    @GetMapping("/todoscronogramascredito")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','USUARIO')")
    public List<CronogramaPagosDTO> TodosCronogramasDeUnCredito(@RequestParam int id_credito) {
        return cpS.TodosCronogramasDeUnCredito(id_credito).stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x, CronogramaPagosDTO.class);
        }).collect(Collectors.toList());
    }
}
