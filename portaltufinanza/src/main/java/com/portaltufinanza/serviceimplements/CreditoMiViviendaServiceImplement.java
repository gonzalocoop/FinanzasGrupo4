package com.portaltufinanza.serviceimplements;

import com.portaltufinanza.entities.BonoBBP;
import com.portaltufinanza.entities.CreditoMiVivienda;
import com.portaltufinanza.repositories.ICreditoMiViviendaRepository;
import com.portaltufinanza.serviceinterfaces.ICreditoMiViviendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class CreditoMiViviendaServiceImplement implements ICreditoMiViviendaService {

    @Autowired
    private ICreditoMiViviendaRepository cmvR;

    @Override
    public void insert(CreditoMiVivienda credito) {
        cmvR.save(credito);
    }

    @Override
    public List<CreditoMiVivienda> list() {
        return cmvR.findAll();
    }

    @Override
    public void delete(int id) {
        cmvR.deleteById(id);

    }

    @Override
    public void update(CreditoMiVivienda credito) {
        cmvR.save(credito);

    }

    @Override
    public CreditoMiVivienda listId(int id) {
        return cmvR.findById(id).orElse(new CreditoMiVivienda());
    }

    @Override
    public void registrarCreditoMiVivienda(BigDecimal cok, LocalDate fechaInicio, String tipoTasa, BigDecimal tasaInteres, String periodicidadTasa, int numeroCuotas, String tipoGracia, int duracionGraciaMeses, String tipoCapitalizacion, int idPrecioCorrespondiente, int idUsuario) {
        cmvR.registrarCreditoMiVivienda(cok, fechaInicio,  tipoTasa,  tasaInteres,  periodicidadTasa,  numeroCuotas,  tipoGracia,  duracionGraciaMeses,  tipoCapitalizacion,  idPrecioCorrespondiente,  idUsuario);
        }

    @Override
    public void calcularYActualizarTEM(int id_credito) {
        cmvR.calcularYActualizarTEM(id_credito);
    }

    @Override
    public void generarCronogramaPagos(int id_credito) {
        cmvR.generarCronogramaPagos(id_credito);
    }

    @Override
    public void calcularVanTir(int id_credito) {
        cmvR.calcularVanTir(id_credito);
    }

    @Override
    public void convertirTasasAnuales(int id_credito) {
        cmvR.convertirTasasAnuales(id_credito);
    }


}
