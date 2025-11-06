package com.portaltufinanza.serviceinterfaces;

import com.portaltufinanza.entities.PrecioCorrespondiente;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPrecioCorrespondienteService {
    public void insert(PrecioCorrespondiente precio);
    public List<PrecioCorrespondiente> list();
    public void delete(int id);
    public void update(PrecioCorrespondiente precio);
    public PrecioCorrespondiente listId(int id);
    public List<PrecioCorrespondiente> precioSegunDireccionPropiedad(String direccion);
    public void registrarPrecioCorrespondiente(int id_propiedad, int id_moneda);
}
