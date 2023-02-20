package com.neorispichincha.app.servicio.movimiento;

import com.neorispichincha.app.dto.MovimientoInsertDto;
import com.neorispichincha.app.entidad.Movimiento;
import com.neorispichincha.app.servicio.ServicioGenerico;

public interface IServicioMovimiento extends ServicioGenerico<Movimiento,Long> {

    Long realizarMovimiento(MovimientoInsertDto movimientoInsertDto);
}
