package com.portaltufinanza.repositories;

import com.portaltufinanza.entities.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUsuariosRepository extends JpaRepository<Usuarios,Integer> {
    public Usuarios findOneByUsername(String username);

    @Query(value="SELECT u.nombre_cliente, p.*\n" +
            "FROM usuarios u\n" +
            "JOIN credito_mi_vivienda c ON c.id_usuario = u.id_usuario\n" +
            "JOIN propiedad p ON p.id_propiedad = c.id_propiedad\n" +
            "WHERE u.id_usuario = :id_usuario;",nativeQuery = true)
    public List<String[]> PropiedadesFinanciadasPorUsuario(@Param("id_usuario")Integer id_usuario);

    @Query(value="SELECT u.nombre_cliente, cr.*\n" +
            "FROM usuarios u\n" +
            "JOIN credito_mi_vivienda c  ON c.id_usuario  = u.id_usuario\n" +
            "JOIN cronograma_pagos   cr ON cr.id_credito  = c.id_credito\n" +
            "WHERE u.id_usuario = :id_usuario;", nativeQuery = true)
    public List<String[]> CronogramadePagosPorUsuario(@Param("id_usuario")Integer id_usuario);
}
