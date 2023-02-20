package com.neorispichincha.app.servicio.movimiento.impl;

import com.neorispichincha.app.dto.MovimientoReporteDto;
import com.neorispichincha.app.entidad.Movimiento;
import com.neorispichincha.app.servicio.movimiento.IServicioTransformarDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioTransformarDto implements IServicioTransformarDto {

    @Override
    public List<MovimientoReporteDto> convertirAMovimientoReporteDto(List<Movimiento> movimientos) {
        List<MovimientoReporteDto> movimientosReporteDto= new ArrayList<>();
        for(Movimiento movimiento:movimientos){
            movimientosReporteDto.add(new MovimientoReporteDto(movimiento.getFecha(),
                    movimiento.getCuenta().getCliente().getNombre(),movimiento.getCuenta().getTipoCuenta().getNombre(),
                    movimiento.getCuenta().getNumeroCuenta(),movimiento.getCuenta().getCliente().getEstado().getNombre(),
                    movimiento.getTipoMovimiento().getNombre(),movimiento.getValor()));
        }
        return movimientosReporteDto;
    }
}
