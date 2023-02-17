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
	private Integer id;
	private LocalDateTime fecha;
	@ManyToOne
	@JoinColumn(name = "id_tipo_movimiento", foreignKey = @ForeignKey(name = "fk_movimiento_tipo_movimiento"))
	private TipoMovimiento tipoMovimiento;
	private Float valor;
	private Float saldo;

	public Movimiento(LocalDateTime fecha, TipoMovimiento tipoMovimiento, Float valor, Float saldo) {
		super();
		this.fecha = fecha;
		this.tipoMovimiento = tipoMovimiento;
		this.valor = valor;
		this.saldo = saldo;
	}

	public Movimiento(Integer id, LocalDateTime fecha, TipoMovimiento tipoMovimiento, Float valor, Float saldo) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.tipoMovimiento = tipoMovimiento;
		this.valor = valor;
		this.saldo = saldo;
	}

	public Integer getId() {
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

}
