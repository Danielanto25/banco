package com.neorispichincha.app.servicio.cliente;

import com.neorispichincha.app.excepcion.NoEncontradoException;
import com.neorispichincha.app.repositorio.ClienteRepositorio;
import org.springframework.stereotype.Service;

@Service
public class ServicioEliminarCliente {

    private final ClienteRepositorio clienteRepositorio;

    public ServicioEliminarCliente(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    public void realizar(Long id) {
        validarExistencia(id);
        clienteRepositorio.deleteById(id);

    }

    private void validarExistencia(Long id) {
        if (clienteRepositorio.findById(id).isEmpty()) throw new NoEncontradoException("El Cliente no existe");

    }
}
