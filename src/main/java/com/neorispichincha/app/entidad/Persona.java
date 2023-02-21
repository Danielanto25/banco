package com.neorispichincha.app.entidad;

import com.neorispichincha.app.util.ValidadorArgumento;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.Period;

import javax.persistence.*;

@MappedSuperclass
public abstract class Persona {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String genero;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaNacimiento;
    @Column(unique = true,length = 15)
    private String identificacion;
    @Column(length = 150)
    private String direccion;
    private Long telefono;

    public Persona() {

    }

    public Persona(Long id, String nombre, String genero, LocalDate fechaNacimiento, String identificacion,
                   String direccion, Long telefono) {
        super();
        validarArgumentos(nombre, direccion, telefono, fechaNacimiento);
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Persona(String nombre, String genero, LocalDate fechaNacimiento, String identificacion, String direccion,
                   Long telefono) {
        super();
        validarArgumentos(nombre, direccion, telefono, fechaNacimiento);
        this.nombre = nombre;
        this.genero = genero;
        this.fechaNacimiento = fechaNacimiento;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    private void validarArgumentos(String nombre, String direccion, Long telefono, LocalDate fechaNacimiento) {
        ValidadorArgumento.validarObligatorio(nombre, "El nombre del cliente es obligatorio");
        ValidadorArgumento.validarObligatorio(direccion, "La direccion del cliente es obligatorio");
        ValidadorArgumento.validarObligatorio(telefono, "El telefono del cliente es obligatorio");
        ValidadorArgumento.validarObligatorio(fechaNacimiento, "La Fecha de nacimiento del cliente es obligatorio");
        ValidadorArgumento.validarLongitud(direccion,150,"la direccion ingresada supera el maximo de caracteres");
    }

    public Integer obtenerEdad() {
        return Period.between(this.fechaNacimiento, LocalDate.now()).getYears();
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public Long getTelefono() {
        return telefono;
    }

}
