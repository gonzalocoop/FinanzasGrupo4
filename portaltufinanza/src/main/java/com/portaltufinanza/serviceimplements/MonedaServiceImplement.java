package com.portaltufinanza.serviceimplements;

import com.portaltufinanza.entities.BonoBBP;
import com.portaltufinanza.entities.Moneda;
import com.portaltufinanza.repositories.IMonedaRepository;
import com.portaltufinanza.serviceinterfaces.IMonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonedaServiceImplement implements IMonedaService {

    @Autowired
    private IMonedaRepository mR;
    @Override
    public void insert(Moneda moneda) {
        mR.save(moneda);

    }

    @Override
    public List<Moneda> list() {
        return mR.findAll();    }

    @Override
    public void delete(int id) {
        mR.deleteById(id);
    }

    @Override
    public void update(Moneda moneda) {
        mR.save(moneda);
    }

    @Override
    public Moneda listId(int id) {
        return mR.findById(id).orElse(new Moneda());
    }
}
