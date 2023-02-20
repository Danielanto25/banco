package com.neorispichincha.app.dto;

public class CuentaListarDto {
    private Long numeroCuenta;
    private String tipoCuenta;
    private Float saldo;
    private String estado;
    private String cliente;

    public CuentaListarDto() {

    }

    public CuentaListarDto(Long numeroCuenta, String tipoCuenta, Float saldo, String estado, String cliente) {
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        this.estado = estado;
        this.cliente = cliente;
    }

    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public Float getSaldo() {
        return saldo;
    }

    public String getEstado() {
        return estado;
    }

    public String getCliente() {
        return cliente;
    }
}
