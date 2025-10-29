package com.portaltufinanza.serviceinterfaces;

import com.portaltufinanza.entities.CreditoMiVivienda;

import java.util.List;

public interface ICreditoMiViviendaService {
    public void insert(CreditoMiVivienda credito);
    public List<CreditoMiVivienda> list();
    public void delete(int id);
    public void update(CreditoMiVivienda credito);
    public CreditoMiVivienda listId(int id);
}
