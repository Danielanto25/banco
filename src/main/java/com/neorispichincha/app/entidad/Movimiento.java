package com.neorispichincha.app.entidad;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movimientos")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fecha;
    @ManyToOne
    @JoinColumn(name = "id_tipo_movimiento", foreignKey = @ForeignKey(name = "fk_movimiento_tipo_movimiento"))
    private TipoMovimiento tipoMovimiento;
    private Float valor;
    private Float saldo;
    @ManyToOne
    @JoinColumn(name = "id_cuenta", foreignKey = @ForeignKey(name = "fk_cuenta_movimiento"))
    private Cuenta cuenta;

    public Movimiento() {

    }

    public Movimiento(Long id, LocalDateTime fecha, TipoMovimiento tipoMovimiento, Float valor, Float saldo, Cuenta cuenta) {
        this.id = id;
        this.fecha = fecha;
        this.tipoMovimiento = tipoMovimiento;
        this.valor = valor;
        this.saldo = saldo;
        this.cuenta = cuenta;
    }

    public Movimiento(LocalDateTime fecha, TipoMovimiento tipoMovimiento, Float valor, Float saldo, Cuenta cuenta) {
        this.fecha = fecha;
        this.tipoMovimiento = tipoMovimiento;
        this.valor = valor;
        this.saldo = saldo;
        this.cuenta = cuenta;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public TipoMovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    public Float getValor() {
        return valor;
    }

    public Float getSaldo() {
        return saldo;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }
}
