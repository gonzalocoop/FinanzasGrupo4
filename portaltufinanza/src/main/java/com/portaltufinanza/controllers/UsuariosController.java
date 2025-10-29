package com.portaltufinanza.controllers;

import com.portaltufinanza.dtos.UsuariosDTO;
import com.portaltufinanza.entities.Usuarios;
import com.portaltufinanza.serviceinterfaces.IUsuariosService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private IUsuariosService uS;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','USUARIO')")
    public void registrar(@RequestBody UsuariosDTO dto){
        ModelMapper m = new ModelMapper();
        Usuarios s= m.map(dto, Usuarios.class);
        String encodedPassword = passwordEncoder.encode(s.getPassword());
        s.setPassword(encodedPassword);
        uS.insert(s);
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','USUARIO')")
    public List<UsuariosDTO> listar(){
        return uS.list().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x, UsuariosDTO.class);
        }).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void eliminar(@PathVariable("id") Integer id){

        uS.delete(id);
    }

    @PutMapping
    @PreAuthorize("hasAuthority('ADMINISTRADOR')")
    public void modificar(@RequestBody UsuariosDTO dto){
        ModelMapper m = new ModelMapper();
        Usuarios c = m.map(dto, Usuarios.class);
        uS.update(c);
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR','USUARIO')")
    public UsuariosDTO listarId(@PathVariable("id") Integer id){
        ModelMapper m=new ModelMapper();
        UsuariosDTO dto=m.map(uS.listId(id),UsuariosDTO.class);
        return dto;
    }
}
