package com.neorispichincha.app.servicio.movimiento.impl;

import java.time.LocalDate;
import java.util.List;

import com.neorispichincha.app.dto.MovimientoReporteDto;
import com.neorispichincha.app.servicio.movimiento.IServicioTransformarDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neorispichincha.app.dto.MovimientoInsertDto;
import com.neorispichincha.app.entidad.Cuenta;
import com.neorispichincha.app.entidad.Movimiento;
import com.neorispichincha.app.entidad.TipoMovimiento;
import com.neorispichincha.app.excepcion.NoEncontradoException;
import com.neorispichincha.app.repositorio.CuentaRepositorio;
import com.neorispichincha.app.repositorio.MovimientoRepositorio;
import com.neorispichincha.app.servicio.movimiento.IServicioMovimiento;
import com.neorispichincha.app.servicio.movimiento.IServicioValidarMovimiento;

@Service
public class ServicioMovimiento implements IServicioMovimiento {

    private final MovimientoRepositorio movimientoRepositorio;
    private final CuentaRepositorio cuentaRepositorio;
    private final IServicioValidarMovimiento servicioValidarMovimiento;
    private final IServicioTransformarDto servicioTransformarDto;

    public ServicioMovimiento(MovimientoRepositorio movimientoRepositorio, CuentaRepositorio cuentaRepositorio, IServicioValidarMovimiento servicioValidarMovimiento, IServicioTransformarDto servicioTransformarDto) {
        this.movimientoRepositorio = movimientoRepositorio;
        this.cuentaRepositorio = cuentaRepositorio;
        this.servicioValidarMovimiento = servicioValidarMovimiento;
        this.servicioTransformarDto = servicioTransformarDto;
    }


    @Override
    public Long registrar(Movimiento movimiento) {
        return movimientoRepositorio.save(construirMovimientoValidado(movimiento)).getId();
    }

    @Override
    public Movimiento actualizar(Movimiento movimiento) {
        return movimientoRepositorio.save(construirMovimientoValidado(movimiento));
    }

    @Override
    public void eliminar(Long id) {
        validarExistencia(id);
        movimientoRepositorio.deleteById(id);
    }

    @Override
    public List<Movimiento> listar() {
        return movimientoRepositorio.findAll();
    }

    @Override
    @Transactional
    public Long realizarMovimiento(MovimientoInsertDto movimientoInsertDto) {

        Cuenta cuenta = servicioValidarMovimiento.realizar(movimientoInsertDto);
        Movimiento movimiento = new Movimiento(LocalDate.now(), new TipoMovimiento(movimientoInsertDto.getTipoMovimiento())
                , movimientoInsertDto.getMonto(), cuenta.getSaldo(), cuenta);
        cuentaRepositorio.save(cuenta);

        return movimientoRepositorio.save(movimiento).getId();
    }

    @Override
    public List<MovimientoReporteDto> reportePorClienteYFecha(Long cliente, LocalDate fecha) {
        return servicioTransformarDto.convertirAMovimientoReporteDto(
                movimientoRepositorio.listarPorUsuarioYFeacha(cliente, fecha));
    }

    private void validarExistencia(Long id) {
        if (movimientoRepositorio.findById(id).isEmpty()) throw new NoEncontradoException("Movimiento no encontrado");
    }

    private Movimiento construirMovimientoValidado(Movimiento movimiento) {
        return movimiento.getId() != null ?
                new Movimiento(movimiento.getId(), movimiento.getFecha(), movimiento.getTipoMovimiento(),
                        movimiento.getValor(), movimiento.getSaldo(), movimiento.getCuenta()) :
                new Movimiento(movimiento.getFecha(), movimiento.getTipoMovimiento(),
                        movimiento.getValor(), movimiento.getSaldo(), movimiento.getCuenta());
    }


}
