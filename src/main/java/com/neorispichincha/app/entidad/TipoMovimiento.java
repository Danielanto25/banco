package com.neorispichincha.app.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipos_de_movimiento")
public class TipoMovimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;

	public TipoMovimiento() {

	}

	public TipoMovimiento(Long id) {
		this.id = id;
	}

	public TipoMovimiento(Long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}

	public TipoMovimiento(String nombre) {

		this.nombre = nombre;
	}

	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

}
