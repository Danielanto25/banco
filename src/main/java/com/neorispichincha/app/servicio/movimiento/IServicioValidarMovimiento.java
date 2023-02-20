package com.neorispichincha.app.servicio.movimiento;

import com.neorispichincha.app.dto.MovimientoInsertDto;
import com.neorispichincha.app.entidad.Cuenta;

public interface IServicioValidarMovimiento {
    Cuenta realizar(MovimientoInsertDto movimientoInsertDto);

}
