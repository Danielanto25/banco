package com.neorispichincha.app.servicio.movimiento.impl;

import com.neorispichincha.app.dto.MovimientoInsertDto;
import com.neorispichincha.app.entidad.Cuenta;
import com.neorispichincha.app.entidad.Movimiento;
import com.neorispichincha.app.entidad.TipoMovimiento;
import com.neorispichincha.app.excepcion.ExcepcionMovimientoNoValido;
import com.neorispichincha.app.excepcion.NoEncontradoException;
import com.neorispichincha.app.repositorio.CuentaRepositorio;
import com.neorispichincha.app.repositorio.MovimientoRepositorio;
import com.neorispichincha.app.repositorio.TipoMovimientoRepositorio;
import com.neorispichincha.app.servicio.cuenta.impl.ValidarExistenciaDeCuenta;
import com.neorispichincha.app.servicio.movimiento.IServicioMovimiento;
import com.neorispichincha.app.util.EnumTipoMovimiento;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class ServicioMovimiento implements IServicioMovimiento {

    private final MovimientoRepositorio movimientoRepositorio;
    private final CuentaRepositorio cuentaRepositorio;
    private final ValidarExistenciaDeCuenta validarExistenciaDeCuenta;
    private final TipoMovimientoRepositorio tipoMovimientoRepositorio;

    public ServicioMovimiento(MovimientoRepositorio movimientoRepositorio, CuentaRepositorio cuentaRepositorio, ValidarExistenciaDeCuenta validarExistenciaDeCuenta, TipoMovimientoRepositorio tipoMovimientoRepositorio) {
        this.movimientoRepositorio = movimientoRepositorio;
        this.cuentaRepositorio = cuentaRepositorio;
        this.validarExistenciaDeCuenta = validarExistenciaDeCuenta;
        this.tipoMovimientoRepositorio = tipoMovimientoRepositorio;
    }

    @Override
    public Long registrar(Movimiento movimiento) {
        return null;
    }

    @Override
    public Movimiento actualizar(Movimiento movimiento) {
        return null;
    }

    @Override
    public void eliminar(Long aLong) {

    }

    @Override
    @Transactional
    public Long realizarMovimiento(MovimientoInsertDto movimientoInsertDto) {

        Cuenta cuenta = validar(movimientoInsertDto);
        Movimiento movimiento =new Movimiento(LocalDateTime.now(),new TipoMovimiento(movimientoInsertDto.getTipoMovimiento())
                ,movimientoInsertDto.getMonto(),cuenta.getSaldo(),cuenta);

        return movimientoRepositorio.save(movimiento).getId();
    }

    private Cuenta validar(MovimientoInsertDto movimientoInsertDto) {
        var cuenta = cuentaRepositorio.listarPorNumeroDeCuenta(movimientoInsertDto.getNumeroCuenta());
        if (cuenta == null) throw new NoEncontradoException("numero de Cuenta invalido");

        if (cuenta.getTipoCuenta().getId() != movimientoInsertDto.getTipoCuenta())
            throw new NoEncontradoException("El tipo de cuenta no coincide");
        if (tipoMovimientoRepositorio.findById(movimientoInsertDto.getTipoMovimiento()).isEmpty())
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
