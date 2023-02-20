package com.neorispichincha.app.servicio;

public interface ServicioGenerico<T, ID> {

    ID registrar(T t);

    T actualizar(T t);

    void eliminar(ID id);
}
