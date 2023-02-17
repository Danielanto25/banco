package com.neorispichincha.app.servicio.cliente;

import com.neorispichincha.app.entidad.Cliente;
import org.springframework.stereotype.Service;

import com.neorispichincha.app.repositorio.ClienteRepositorio;

@Service
public class ServicioRegistrarCliente {

    private final ClienteRepositorio clienteRepositorio;

    public ServicioRegistrarCliente(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }


    public Long realizar(Cliente cliente) {
        Cliente clienteValidado = new Cliente(cliente.getId(), cliente.getNombre(), cliente.getGenero(), cliente.getFechaNacimiento(),
                cliente.getIdentificacion(), cliente.getDireccion(), cliente.getTelefono(), cliente.getClave(), cliente.getEstado());

        return clienteRepositorio.save(clienteValidado).getId();

    }
}
