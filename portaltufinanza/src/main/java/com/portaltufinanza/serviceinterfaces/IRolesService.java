package com.portaltufinanza.serviceinterfaces;

import com.portaltufinanza.entities.Roles;

import java.util.List;

public interface IRolesService {
    public void insert(Roles rol);
    public List<Roles> list();
    public void delete(int id);
    public void update(Roles rol);
    public Roles listId(int id);
}
