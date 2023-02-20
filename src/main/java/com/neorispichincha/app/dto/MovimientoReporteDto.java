package com.neorispichincha.app.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class MovimientoReporteDto {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fecha;
    private String nombre;
    private String tipoCuenta;
    private Long numeroCuenta;
    private String estado;
    private String tipoMovimiento;
    private Float valor;

    public MovimientoReporteDto() {
    }

    public MovimientoReporteDto(LocalDate fecha, String nombre, String tipoCuenta, Long numeroCuenta, String estado, String tipoMovimiento, Float valor) {
        this.fecha = fecha;
        this.nombre = nombre;
        this.tipoCuenta = tipoCuenta;
        this.numeroCuenta = numeroCuenta;
        this.estado = estado;
        this.tipoMovimiento = tipoMovimiento;
        this.valor = valor;
    }

    public Float getValor() {
        return valor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getEstado() {
        return estado;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }
}
