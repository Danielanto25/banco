package com.neorispichincha.app.servicio.cuenta;

import com.neorispichincha.app.dto.CuentaListarDto;
import com.neorispichincha.app.entidad.Cuenta;
import com.neorispichincha.app.servicio.ServicioGenerico;

import java.util.List;

public interface IServicioCuenta extends ServicioGenerico<Cuenta,Long> {

    List<CuentaListarDto> listar();
}
