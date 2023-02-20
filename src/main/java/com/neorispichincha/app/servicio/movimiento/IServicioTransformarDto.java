package com.neorispichincha.app.servicio.movimiento;

import com.neorispichincha.app.dto.MovimientoReporteDto;
import com.neorispichincha.app.entidad.Movimiento;

import java.util.List;

public interface IServicioTransformarDto {
    List<MovimientoReporteDto> convertirAMovimientoReporteDto(List<Movimiento> movimientos);
}
