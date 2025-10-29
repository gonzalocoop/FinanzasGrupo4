package com.portaltufinanza.serviceinterfaces;

import com.portaltufinanza.entities.PrecioCorrespondiente;

import java.util.List;

public interface IPrecioCorrespondienteService {
    public void insert(PrecioCorrespondiente precio);
    public List<PrecioCorrespondiente> list();
    public void delete(int id);
    public void update(PrecioCorrespondiente precio);
    public PrecioCorrespondiente listId(int id);
}
