package com.neorispichincha.app.servicio.cliente.impl;

import com.neorispichincha.app.dto.ClienteListarDto;
import com.neorispichincha.app.entidad.Cliente;
import com.neorispichincha.app.servicio.cliente.IServicioConsruirDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioConstruirDto implements IServicioConsruirDto {


    @Override
    public List<ClienteListarDto> construirClienteListarDto(List<Cliente> clientes) {
        List<ClienteListarDto> clientesDto = new ArrayList<ClienteListarDto>();
        for (var cliente : clientes) {
            clientesDto.add(
                    new ClienteListarDto(cliente.getNombre(), cliente.getGenero(), cliente.obtenerEdad(), cliente.getDireccion()
                            , cliente.getTelefono(), cliente.getClave(), cliente.getEstado().getNombre()));
        }
        return clientesDto;
    }
}
