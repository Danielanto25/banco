package com.neorispichincha.app.servicio.cuenta.impl;

import com.neorispichincha.app.dto.CuentaListarDto;
import com.neorispichincha.app.entidad.Cuenta;
import com.neorispichincha.app.repositorio.CuentaRepositorio;
import com.neorispichincha.app.servicio.cuenta.IServicioContruirDto;
import com.neorispichincha.app.servicio.cuenta.IServicioCuenta;
import com.neorispichincha.app.servicio.cuenta.IServicioValidarCuenta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioCuentaImpl implements IServicioCuenta {

    private final CuentaRepositorio cuentaRepositorio;

    private final IServicioContruirDto servicioContruirDto;
    private final IServicioValidarCuenta servicioValidarCuenta;

    public ServicioCuentaImpl(CuentaRepositorio cuentaRepositorio, IServicioContruirDto servicioContruirDto, IServicioValidarCuenta servicioValidarCuenta) {
        this.cuentaRepositorio = cuentaRepositorio;
        this.servicioContruirDto = servicioContruirDto;
        this.servicioValidarCuenta = servicioValidarCuenta;
    }

    @Override
    public List<CuentaListarDto> listar() {
        return servicioContruirDto.construirCuentaListarDto(cuentaRepositorio.findAll());
    }

    @Override
    public Long registrar(Cuenta cuenta) {
        return cuentaRepositorio.save(construirCuentaValidada(cuenta)).getId();
    }

    @Override
    public Cuenta actualizar(Cuenta cuenta) {
        return cuentaRepositorio.save(construirCuentaValidada(cuenta));
    }

    @Override
    public void eliminar(Long id) {

        servicioValidarCuenta.realizar(id);
        cuentaRepositorio.deleteById(id);
    }

    private Cuenta construirCuentaValidada(Cuenta cuenta) {
        return cuenta.getId() != null ? new Cuenta(cuenta.getNumeroCuenta(), cuenta.getTipoCuenta(), cuenta.getSaldo()
                , cuenta.getEstado(), cuenta.getCliente())
                :
                new Cuenta(cuenta.getId(), cuenta.getNumeroCuenta(), cuenta.getTipoCuenta(), cuenta.getSaldo()
                        , cuenta.getEstado(), cuenta.getCliente());


    }

}
