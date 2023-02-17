package com.neorispichincha.app.entidad;

import com.neorispichincha.app.util.ValidadorArgumento;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente extends Persona {

    @Column(nullable = false, length = 4)
    private int clave;
    @ManyToOne
    @JoinColumn(name = "id_estado", nullable = false, foreignKey = @ForeignKey(name = "FK_cliente_estado"))
    private Estado estado;

    public Cliente() {
        super();
    }

    public Cliente(Long id, String nombre, String genero, LocalDate fechaNacimiento, String identificacion, String direccion,
                   Long telefono, int clave, Estado estado) {

        super(id, nombre, genero, fechaNacimiento, identificacion, direccion, telefono);
        validarArgumentos(clave, estado);
        this.clave = clave;
        this.estado = estado;
    }

    public Cliente(String nombre, String genero, LocalDate fechaNacimiento, String identificacion, String direccion, Long telefono,
                   int clave, Estado estado) {

        super(nombre, genero, fechaNacimiento, identificacion, direccion, telefono);
        validarArgumentos(clave, estado);
        this.clave = clave;
        this.estado = estado;
    }

    private void validarArgumentos(int clave, Estado estado) {
        ValidadorArgumento.validarObligatorio(clave, "La clave es obligatorio");
        ValidadorArgumento.validarObligatorio(estado, "El estado es obligatorio");
    }

    public int getClave() {
        return clave;
    }

    public Estado getEstado() {
        return estado;
    }

}
