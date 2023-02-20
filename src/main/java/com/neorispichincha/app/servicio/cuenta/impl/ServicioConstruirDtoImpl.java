package com.neorispichincha.app.servicio.cuenta.impl;

import com.neorispichincha.app.dto.CuentaListarDto;
import com.neorispichincha.app.entidad.Cuenta;
import com.neorispichincha.app.servicio.cuenta.IServicioContruirDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioConstruirDtoImpl implements IServicioContruirDto {

    @Override
    public List<CuentaListarDto> construirCuentaListarDto(List<Cuenta> cuentas) {
        List<CuentaListarDto> cuentasListarDto = new ArrayList<>();
        for (var cuenta : cuentas) {

            cuentasListarDto.add(new CuentaListarDto(cuenta.getNumeroCuenta(), cuenta.getTipoCuenta().getNombre(),
                    cuenta.getSaldo(), cuenta.getEstado().getNombre(), cuenta.getCliente().getNombre()));

        }
        return cuentasListarDto;
    }
}
