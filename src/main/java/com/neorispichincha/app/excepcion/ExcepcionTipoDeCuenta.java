package com.neorispichincha.app.excepcion;

public class ExcepcionTipoDeCuenta extends RuntimeException {
    public ExcepcionTipoDeCuenta(String mensaje) {
        super(mensaje);
    }
}
