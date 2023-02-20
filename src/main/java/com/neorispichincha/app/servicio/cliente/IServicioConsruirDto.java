package com.neorispichincha.app.servicio.cliente;

import com.neorispichincha.app.dto.ClienteListarDto;
import com.neorispichincha.app.entidad.Cliente;

import java.util.List;

public interface IServicioConsruirDto {
    List<ClienteListarDto> construirClienteListarDto(List<Cliente> cliente);
}
