package com.neorispichincha.app.dto;

public class ClienteListarDto {

    private String nombre;
    private String genero;
    private int edad;
    private String direccion;
    private Long telefono;
    private int clave;
    private String estado;

    public ClienteListarDto() {
    }


    public ClienteListarDto(String nombre, String genero, int edad, String direccion, Long telefono, int clave, String estado) {
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;

        this.direccion = direccion;
        this.telefono = telefono;
        this.clave = clave;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getGenero() {
        return genero;
    }

    public int getEdad() {
        return edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public Long getTelefono() {
        return telefono;
    }

    public int getClave() {
        return clave;
    }

    public String getEstado() {
        return estado;
    }
}
