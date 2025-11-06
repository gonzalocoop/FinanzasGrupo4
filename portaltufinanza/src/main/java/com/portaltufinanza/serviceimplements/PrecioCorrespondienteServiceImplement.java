package com.portaltufinanza.serviceimplements;

import com.portaltufinanza.entities.BonoBBP;
import com.portaltufinanza.entities.PrecioCorrespondiente;
import com.portaltufinanza.repositories.IPrecioCorrespondienteRepository;
import com.portaltufinanza.serviceinterfaces.IPrecioCorrespondienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrecioCorrespondienteServiceImplement implements IPrecioCorrespondienteService {

    @Autowired
    private IPrecioCorrespondienteRepository pcR;

    @Override
    public void insert(PrecioCorrespondiente precio) {
        pcR.save(precio);

    }

    @Override
    public List<PrecioCorrespondiente> list() {
        return pcR.findAll();    }

    @Override
    public void delete(int id) {
        pcR.deleteById(id);
    }

    @Override
    public void update(PrecioCorrespondiente precio) {
        pcR.save(precio);
    }

    @Override
    public PrecioCorrespondiente listId(int id) {
        return pcR.findById(id).orElse(new PrecioCorrespondiente());
    }

    @Override
    public List<PrecioCorrespondiente> precioSegunDireccionPropiedad(String direccion) {
        return pcR.precioSegunDireccionPropiedad(direccion);
    }

    @Override
    public void registrarPrecioCorrespondiente(int id_propiedad, int id_moneda) {
        pcR.registrarPrecioCorrespondiente(id_propiedad, id_moneda);
    }
}
