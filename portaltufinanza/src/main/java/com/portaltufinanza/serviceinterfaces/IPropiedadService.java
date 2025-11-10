package com.portaltufinanza.serviceinterfaces;

import com.portaltufinanza.entities.Propiedad;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPropiedadService {
    public void insert(Propiedad propiedad);
    public List<Propiedad> list();
    public void delete(int id);
    public void update(Propiedad propiedad);
    public Propiedad listId(int id);
    List<Propiedad> propiedadSegunDireccion(String direccion);
}
