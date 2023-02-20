package com.neorispichincha.app.servicio.movimiento.impl;

import com.neorispichincha.app.dto.MovimientoInsertDto;
import com.neorispichincha.app.entidad.Cuenta;
import com.neorispichincha.app.excepcion.ExcepcionMovimientoNoValido;
import com.neorispichincha.app.excepcion.NoEncontradoException;
import com.neorispichincha.app.repositorio.CuentaRepositorio;
import com.neorispichincha.app.repositorio.TipoMovimientoRepositorio;
import com.neorispichincha.app.servicio.movimiento.IServicioValidarMovimiento;
import com.neorispichincha.app.util.EnumTipoMovimiento;
import org.springframework.stereotype.Service;

@Service
public class ServicioValidarMovimiento implements IServicioValidarMovimiento {

    private final CuentaRepositorio cuentaRepositorio;
    private final TipoMovimientoRepositorio tipoMovimientoRepositorio;

    public ServicioValidarMovimiento(CuentaRepositorio cuentaRepositorio, TipoMovimientoRepositorio tipoMovimientoRepositorio) {
        this.cuentaRepositorio = cuentaRepositorio;
        this.tipoMovimientoRepositorio = tipoMovimientoRepositorio;
    }

    @Override
    public Cuenta realizar(MovimientoInsertDto movimientoInsertDto) {
        var cuenta = cuentaRepositorio.listarPorNumeroDeCuenta(movimientoInsertDto.getNumeroCuenta());
        if (cuenta == null) throw new NoEncontradoException("numero de Cuenta invalido");

        if (cuenta.getTipoCuenta().getId() != movimientoInsertDto.getTipoCuenta())
            throw new NoEncontradoException("El tipo de cuenta no coincide");
        if (tipoMovimientoRepositorio.findById(movimientoInsertDto.getTipoMovimiento()).isEmpty() ||
                movimientoInsertDto.getTipoMovimiento() == 0)
            throw new NoEncontradoException("Tipo de movimiento no valido");

        cuenta.actualizarSaldo(validarMovimientoValido(movimientoInsertDto.getTipoMovimiento()
                , cuenta.getSaldo(), movimientoInsertDto.getMonto()));
        return cuenta;

    }

    private Float validarMovimientoValido(Long tipoMovimiento, Float saldoCuenta, Float valorMovimiento) {

        var resultado = EnumTipoMovimiento.DETECTOR.detectarMovimiento(tipoMovimiento) > 0 ?
                saldoCuenta + valorMovimiento : saldoCuenta - valorMovimiento;
        if (resultado < 0) throw new ExcepcionMovimientoNoValido("Saldo no disponible ");
        return resultado;
    }
}
