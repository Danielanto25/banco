package com.neorispichincha.app.servicio.cliente;

import com.neorispichincha.app.dto.ClienteListarDto;
import com.neorispichincha.app.repositorio.ClienteRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioListarCliente {

    private final ClienteRepositorio clienteRepositorio;

    private final ServicioConstruirDto servicioConstruirDto;

    public ServicioListarCliente(ClienteRepositorio clienteRepositorio, ServicioConstruirDto servicioConstruirDto) {
        this.clienteRepositorio = clienteRepositorio;
        this.servicioConstruirDto = servicioConstruirDto;
    }

    public List<ClienteListarDto> realizar(){
        return servicioConstruirDto.realizar(clienteRepositorio.findAll());
    }
}
