package com.neorispichincha.app.servicio.cuenta;

import com.neorispichincha.app.repositorio.CuentaRepositorio;
import org.springframework.stereotype.Service;

@Service
public class ServicioListarCuentas {
    private  final CuentaRepositorio repositorio;

    public ServicioListarCuentas(CuentaRepositorio repositorio) {
        this.repositorio = repositorio;
    }
}
