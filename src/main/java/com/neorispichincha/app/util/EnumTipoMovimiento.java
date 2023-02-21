package com.neorispichincha.app.util;

import java.util.Arrays;

public enum EnumTipoMovimiento {
    RETIRO(1L, -1),
    DEPOSITO(2L, 1),
    CREDITO(3L, 1),
    DETECTOR(0L,0);


    private final Long tipoMovimiento;
    private final int identificador;

    EnumTipoMovimiento(Long tipoMovimiento, int identificador) {
        this.tipoMovimiento = tipoMovimiento;
        this.identificador = identificador;
    }

    public Long getTipoMovimiento() {
    	return tipoMovimiento;
    }

    public int detectarMovimiento(Long tipo) {

        return Arrays.stream(EnumTipoMovimiento.values())
                .filter(tipoUsuario -> tipoUsuario.tipoMovimiento == tipo)
                .findFirst().get().identificador;

    }

}
