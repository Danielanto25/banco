package com.neorispichincha.app.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cuentas")
public class Cuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cuenta")
    private Long id;

    @Column(name = "numero_de_cuenta", unique = true, nullable = false)
    private Long numeroCuenta;
    @ManyToOne
    @JoinColumn(name = "id_tipo_cuenta", foreignKey = @ForeignKey(name = "FK_cuenta_tipo_cuenta"))
    private TipoCuenta tipoCuenta;

    private Float saldo;
    @ManyToOne
    @JoinColumn(name = "id_estado", foreignKey = @ForeignKey(name = "FK_cuenta_estado"))
    private Estado estado;
    @ManyToOne
    @JoinColumn(name = "id_cliente", foreignKey = @ForeignKey(name = "FK_cuenta_cliente"))
    private Cliente cliente;

    public Cuenta(Long id, Long numeroCuenta, TipoCuenta tipoCuenta, Float saldo, Estado estado,
                  Cliente cliente) {
        super();
        this.id = id;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        this.estado = estado;
        this.cliente = cliente;
    }

    public Cuenta(Long numeroCuenta, TipoCuenta tipoCuenta, Float saldo, Estado estado, Cliente cliente) {
        super();
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldo;
        this.estado = estado;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public Long getNumeroCuenta() {
        return numeroCuenta;
    }

    public TipoCuenta getTipoCuenta() {
        return tipoCuenta;
    }

    public Float getSaldo() {
        return saldo;
    }

    public Estado getEstado() {
        return estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void actualizarSaldo(Float saldo) {
        this.saldo = saldo;
    }

}
