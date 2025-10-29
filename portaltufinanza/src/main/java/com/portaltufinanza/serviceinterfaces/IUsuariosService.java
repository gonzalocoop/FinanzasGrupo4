package com.portaltufinanza.serviceinterfaces;

import com.portaltufinanza.entities.Usuarios;

import java.util.List;

public interface IUsuariosService {
    public void insert(Usuarios usuario);
    public List<Usuarios> list();
    public void delete(int id);
    public void update(Usuarios usuario);
    public Usuarios listId(int id);
}
