package com.portaltufinanza.serviceimplements;

import com.portaltufinanza.entities.BonoBBP;
import com.portaltufinanza.entities.CronogramaPagos;
import com.portaltufinanza.repositories.ICronogramaPagosRepository;
import com.portaltufinanza.serviceinterfaces.ICronogramaPagosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CronogramaPagosServiceImplement implements ICronogramaPagosService {
    @Autowired
    private ICronogramaPagosRepository cpR;

    @Override
    public void insert(CronogramaPagos cronograma) {
        cpR.save(cronograma);

    }

    @Override
    public List<CronogramaPagos> list() {
        return cpR.findAll();    }

    @Override
    public void delete(int id) {
        cpR.deleteById(id);
    }

    @Override
    public void update(CronogramaPagos cronograma) {
        cpR.save(cronograma);
    }

    @Override
    public CronogramaPagos listId(int id) {
        return cpR.findById(id).orElse(new CronogramaPagos());
    }

    @Override
    public List<CronogramaPagos> TodosCronogramasDeUnCredito(int id_credito) {
        return cpR.TodosCronogramasDeUnCredito(id_credito);
    }
}
