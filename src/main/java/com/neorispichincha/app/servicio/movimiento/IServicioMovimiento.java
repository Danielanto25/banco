package com.neorispichincha.app.servicio.movimiento;

import com.neorispichincha.app.dto.MovimientoInsertDto;
import com.neorispichincha.app.dto.MovimientoReporteDto;
import com.neorispichincha.app.entidad.Movimiento;
import com.neorispichincha.app.servicio.ServicioGenerico;

import java.time.LocalDate;
import java.util.List;

public interface IServicioMovimiento extends ServicioGenerico<Movimiento,Long> {

    List<Movimiento> listar();
    Long realizarMovimiento(MovimientoInsertDto movimientoInsertDto);

    List<MovimientoReporteDto> reportePorClienteYFecha(Long cliente, LocalDate fecha);
}
