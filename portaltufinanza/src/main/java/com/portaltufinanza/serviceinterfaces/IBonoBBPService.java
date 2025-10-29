package com.portaltufinanza.serviceinterfaces;

import com.portaltufinanza.entities.BonoBBP;

import java.util.List;

public interface IBonoBBPService {
    public void insert(BonoBBP bono);
    public List<BonoBBP> list();
    public void delete(int id);
    public void update(BonoBBP bono);
    public BonoBBP listId(int id);
}
