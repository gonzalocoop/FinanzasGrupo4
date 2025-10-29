package com.portaltufinanza.serviceinterfaces;

import com.portaltufinanza.entities.Moneda;

import java.util.List;

public interface IMonedaService {
    public void insert(Moneda moneda);
    public List<Moneda> list();
    public void delete(int id);
    public void update(Moneda moneda);
    public Moneda listId(int id);
}
