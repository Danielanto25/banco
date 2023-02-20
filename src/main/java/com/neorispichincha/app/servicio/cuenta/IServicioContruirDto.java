package com.neorispichincha.app.servicio.cuenta;

import com.neorispichincha.app.dto.CuentaListarDto;
import com.neorispichincha.app.entidad.Cuenta;

import java.util.List;

public interface IServicioContruirDto {

    List<CuentaListarDto> construirCuentaListarDto(List<Cuenta> cuentas);
}
