package com.neorispichincha.app.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipos_de_cuentas")
public class TipoCuenta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String nombre;

	public TipoCuenta(){

	}

	public TipoCuenta(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	public TipoCuenta( String nombre) {
		this.nombre = nombre; 
	}
	public TipoCuenta(int id){
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}
}
