package com.portaltufinanza.controllers;

import com.portaltufinanza.dtos.RolesDTO;
import com.portaltufinanza.dtos.UsuariosDTO;
import com.portaltufinanza.entities.Usuarios;
import com.portaltufinanza.serviceinterfaces.IRolesService;
import com.portaltufinanza.serviceinterfaces.IUsuariosService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/registrarusuario")

public class RegistrarUsuarioController {
    @Autowired
    private IUsuariosService uS;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IRolesService rS;


    @PostMapping
    public void registrar(@RequestBody UsuariosDTO dto){
        ModelMapper m = new ModelMapper();
        Usuarios s= m.map(dto, Usuarios.class);
        String encodedPassword = passwordEncoder.encode(s.getPassword());
        s.setPassword(encodedPassword);
        uS.insert(s);
    }

    @GetMapping("/listarusuarios")
    public List<UsuariosDTO> listarUsuarios()
    {
        return uS.list().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x, UsuariosDTO.class);
        }).collect(Collectors.toList());
    }


    @GetMapping("/listarroles")
    public List<RolesDTO> listarRoles()
    {
        return rS.list().stream().map(x->{
            ModelMapper m= new ModelMapper();
            return m.map(x, RolesDTO.class);
        }).collect(Collectors.toList());
    }
}
