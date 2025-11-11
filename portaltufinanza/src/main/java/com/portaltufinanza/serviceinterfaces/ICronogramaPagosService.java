package com.portaltufinanza.serviceinterfaces;

import com.portaltufinanza.entities.CronogramaPagos;
import com.portaltufinanza.entities.PrecioCorrespondiente;

import java.util.List;

public interface ICronogramaPagosService {
    public void insert(CronogramaPagos cronograma);
    public List<CronogramaPagos> list();
    public void delete(int id);
    public void update(CronogramaPagos cronograma);
    public CronogramaPagos listId(int id);
    public List<CronogramaPagos> TodosCronogramasDeUnCredito(int id_credito);
}
