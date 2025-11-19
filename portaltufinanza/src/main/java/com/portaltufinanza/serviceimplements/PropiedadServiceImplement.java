package com.portaltufinanza.serviceimplements;

import com.portaltufinanza.entities.BonoBBP;
import com.portaltufinanza.entities.Propiedad;
import com.portaltufinanza.repositories.IPropiedadRepository;
import com.portaltufinanza.serviceinterfaces.IPropiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropiedadServiceImplement implements IPropiedadService {
    @Autowired
    private IPropiedadRepository pR;
    @Override
    public Propiedad insert(Propiedad propiedad) { return pR.save(propiedad); }

    @Override
    public List<Propiedad> list() {
        return pR.findAll();    }

    @Override
    public void delete(int id) {
        pR.deleteById(id);
    }

    @Override
    public void update(Propiedad propiedad) {
        pR.save(propiedad);
    }

    @Override
    public Propiedad listId(int id) {
        return pR.findById(id).orElse(new Propiedad());
    }

    @Override
    public List<Propiedad> propiedadSegunDireccion(String direccion) {
        return pR.propiedadSegunDireccion(direccion);
    }
}
