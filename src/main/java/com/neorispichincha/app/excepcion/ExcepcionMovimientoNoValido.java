package com.neorispichincha.app.excepcion;

public class ExcepcionMovimientoNoValido extends RuntimeException{
    public ExcepcionMovimientoNoValido(String mensaje) {
        super(mensaje);
    }
}
