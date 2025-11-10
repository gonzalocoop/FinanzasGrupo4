package com.portaltufinanza.serviceinterfaces;

import com.portaltufinanza.entities.CreditoMiVivienda;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface ICreditoMiViviendaService {
    public CreditoMiVivienda insert(CreditoMiVivienda credito);
    public List<CreditoMiVivienda> list();
    public void delete(int id);
    public void update(CreditoMiVivienda credito);
    public CreditoMiVivienda listId(int id);
    public void registrarCreditoMiVivienda(
            BigDecimal cok,
            LocalDate fechaInicio,
            String tipoTasa,
            BigDecimal tasaInteres,
            String periodicidadTasa,
            int numeroCuotas,
            String tipoGracia,
            int duracionGraciaMeses,
            String tipoCapitalizacion,
            int idPrecioCorrespondiente,
            int idUsuario
    );
    public void calcularYActualizarTEM(int id_credito);
}
