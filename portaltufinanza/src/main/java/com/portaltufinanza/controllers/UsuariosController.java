package com.portaltufinanza.controllers;

import com.portaltufinanza.dtos.QueryCronogramaPagosxUserDTO;
import com.portaltufinanza.dtos.QueryPrecioCorrespondientePorPropiedadyUsuario;
import com.portaltufinanza.dtos.QueryPropiedadxUserDTO;
import com.portaltufinanza.dtos.UsuariosDTO;
import com.portaltufinanza.entities.Usuarios;
import com.portaltufinanza.serviceinterfaces.IUsuariosService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
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

    @GetMapping("/list/PropiedadesFinanciadasPorUsuario")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'USUARIO')")
    public List<QueryPropiedadxUserDTO> PropiedadesPorUsuario(@RequestParam Integer id_usuario) {
        List<QueryPropiedadxUserDTO> dtoLista = new ArrayList<>();
        List<String[]> filaLista = uS.PropiedadesFinanciadasPorUsuario(id_usuario);
        for (String[] columna : filaLista) {
            QueryPropiedadxUserDTO dto = new QueryPropiedadxUserDTO();
            dto.setNombre(columna[0]);
            dto.setIdPropiedad(Integer.parseInt(columna[1].toString()));
            dto.setDireccion(columna[2]);
            dto.setPrecioPropiedad(new BigDecimal(columna[3].toString()));
            dto.setTipoPropiedad(columna[4]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/list/CronogramaPagosPorUsuario")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'USUARIO')")
    public List<QueryCronogramaPagosxUserDTO> CronogramaPagosPorUsuario(@RequestParam Integer id_usuario) {
        List<QueryCronogramaPagosxUserDTO> dtoLista = new ArrayList<>();
        List<String[]> filaLista = uS.CronogramadePagosPorUsuario(id_usuario);
        for (String[] columna : filaLista) {
            QueryCronogramaPagosxUserDTO dto = new QueryCronogramaPagosxUserDTO();
            dto.setNombre(columna[0]);
            dto.setId_cronograma(Integer.parseInt(columna[1].toString()));
            dto.setAmortizacion_cuota(new BigDecimal(columna[2].toString()));
            dto.setCuota_fija(new BigDecimal(columna[3].toString()));
            dto.setFecha_cuota(LocalDate.parse(columna[4]));
            dto.setInteres_cuota(new BigDecimal(columna[5].toString()));
            dto.setNumero_cuota(Integer.parseInt(columna[6]));
            dto.setSaldo_restante(new BigDecimal(columna[7].toString()));
            dto.setSeguro_bien(new BigDecimal(columna[8].toString()));
            dto.setSeguro_desgravamen(new BigDecimal(columna[9].toString()));
            dto.setIdCredito(Integer.parseInt(columna[10]));
            dtoLista.add(dto);
        }
        return dtoLista;
    }

    @GetMapping("/list/PrecioCorrespondientePorPropiedadPorUsuario")
    @PreAuthorize("hasAnyAuthority('ADMINISTRADOR', 'USUARIO')")
    public List<QueryPrecioCorrespondientePorPropiedadyUsuario> PrecioCorrespondientePorPropiedadPorUsuario(@RequestParam Integer id_usuario) {
        List<QueryPrecioCorrespondientePorPropiedadyUsuario> dtoLista = new ArrayList<>();
        List<String[]> filaLista = uS.PrecioCorrespondientePorPropiedadPorUsuario(id_usuario);
        for (String[] columna : filaLista) {
            QueryPrecioCorrespondientePorPropiedadyUsuario dto = new QueryPrecioCorrespondientePorPropiedadyUsuario();
            dto.setNombre_cliente(columna[0]);
            dto.setCuota_inicial(new BigDecimal(columna[1].toString()));
            dto.setPrecio_calculado(new BigDecimal(columna[2].toString()));
            dto.setCostos_notariales(new BigDecimal(columna[3].toString()));
            dto.setRegistros_publicos(new BigDecimal(columna[4].toString()));
            dto.setCostos_transaccion(new BigDecimal(columna[5].toString()));
            dto.setMonto_bono(new BigDecimal(columna[6].toString()));
            dto.setPrecio_propiedad(new BigDecimal(columna[7].toString()));
            dto.setNombre_moneda(columna[8]);
            dtoLista.add(dto);
        }
        return dtoLista;
    }

}
