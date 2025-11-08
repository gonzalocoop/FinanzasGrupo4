package com.portaltufinanza.serviceimplements;

import com.portaltufinanza.entities.BonoBBP;
import com.portaltufinanza.entities.Usuarios;
import com.portaltufinanza.repositories.IUsuariosRepository;
import com.portaltufinanza.serviceinterfaces.IUsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServiceImplement implements IUsuariosService {
    @Autowired
    private IUsuariosRepository uR;

    @Override
    public void insert(Usuarios usuario) {
        uR.save(usuario);

    }

    @Override
    public List<Usuarios> list() {
        return uR.findAll();    }

    @Override
    public void delete(int id) {
        uR.deleteById(id);
    }

    @Override
    public void update(Usuarios usuario) {
        uR.save(usuario);
    }

    @Override
    public Usuarios listId(int id) {
        return uR.findById(id).orElse(new Usuarios());
    }

    @Override
    public List<String[]> PropiedadesFinanciadasPorUsuario(Integer id_usuario) {
        return uR.PropiedadesFinanciadasPorUsuario(id_usuario);
    }

    @Override
    public List<String[]> CronogramadePagosPorUsuario(Integer id_usuario) {
        return uR.CronogramadePagosPorUsuario(id_usuario);
    }

    @Override
    public List<String[]> PrecioCorrespondientePorPropiedadPorUsuario(Integer id_usuario) {
        return uR.PrecioCorrespondientePorPropiedadPorUsuario(id_usuario);
    }

    @Override
    public List<String[]> AnalisisdeRentabilidadPorCreditodeUsuario(Integer id_usuario) {
        return uR.AnalisisdeRentabilidadPorCreditodeUsuario(id_usuario);
    }
}
