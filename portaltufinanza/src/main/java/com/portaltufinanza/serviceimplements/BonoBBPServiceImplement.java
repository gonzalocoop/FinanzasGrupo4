package com.portaltufinanza.serviceimplements;

import com.portaltufinanza.entities.BonoBBP;
import com.portaltufinanza.repositories.IBonoBBPRepository;
import com.portaltufinanza.serviceinterfaces.IBonoBBPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BonoBBPServiceImplement implements IBonoBBPService {
    @Autowired
    private IBonoBBPRepository bR;

    @Override
    public void insert(BonoBBP bono) {
        bR.save(bono);
    }

    @Override
    public List<BonoBBP> list() {
        return bR.findAll();
    }

    @Override
    public void delete(int id) {
        bR.deleteById(id);
    }

    @Override
    public void update(BonoBBP bono) {
        bR.save(bono);
    }

    @Override
    public BonoBBP listId(int id) {
        return bR.findById(id).orElse(new BonoBBP());
    }
}
