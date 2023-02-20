package com.neorispichincha.app.dto;

public class MovimientoInsertDto {

    private Long numeroCuenta;
    private int tipoCuenta;
    private Long tipoMovimiento;
    private Float monto;

    public MovimientoInsertDto(){

    }

    public MovimientoInsertDto(Long numeroCuenta, int tipoCuenta, Long tipoMovimiento, Float monto) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.tipoMovimiento = tipoMovimiento;
        this.monto = monto;
    }

    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public int getTipoCuenta() {
        return tipoCuenta;
    }

    public Long getTipoMovimiento() {
        return tipoMovimiento;
    }

    public Float getMonto() {
        return monto;
    }
}
