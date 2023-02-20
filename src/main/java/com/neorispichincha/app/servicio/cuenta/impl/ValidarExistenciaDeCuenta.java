package com.neorispichincha.app.servicio.cuenta.impl;

import com.neorispichincha.app.excepcion.NoEncontradoException;
import com.neorispichincha.app.repositorio.CuentaRepositorio;
import com.neorispichincha.app.servicio.cuenta.IServicioValidarCuenta;
import org.springframework.stereotype.Service;

@Service
public class ValidarExistenciaDeCuenta implements IServicioValidarCuenta {

    private final CuentaRepositorio cuentaRepositorio;

    public ValidarExistenciaDeCuenta(CuentaRepositorio cuentaRepositorio) {
        this.cuentaRepositorio = cuentaRepositorio;
    }

    public void realizar(Long id) {
        if (cuentaRepositorio.findById(id).isEmpty()) throw new NoEncontradoException("La cuenta no existe");
    }
}
