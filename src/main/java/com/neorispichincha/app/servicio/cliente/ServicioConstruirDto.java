package com.neorispichincha.app.servicio.cliente;

import com.neorispichincha.app.dto.ClienteListarDto;
import com.neorispichincha.app.entidad.Cliente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServicioConstruirDto {


    public List<ClienteListarDto> realizar(List<Cliente> clientes) {
        List<ClienteListarDto> clientesDto = new ArrayList<ClienteListarDto>();
        for (var cliente : clientes) {
            clientesDto.add(
                    new ClienteListarDto(cliente.getNombre(), cliente.getGenero(), cliente.obtenerEdad(), cliente.getDireccion()
                            , cliente.getTelefono(), cliente.getClave(), cliente.getEstado().getNombre()));
        }
        return clientesDto;
    }
}
