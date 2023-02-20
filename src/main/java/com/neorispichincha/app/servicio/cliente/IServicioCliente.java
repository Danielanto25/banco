package com.neorispichincha.app.servicio.cliente;

import com.neorispichincha.app.dto.ClienteListarDto;
import com.neorispichincha.app.entidad.Cliente;
import com.neorispichincha.app.servicio.ServicioGenerico;

import java.util.List;

public interface IServicioCliente extends ServicioGenerico<Cliente, Long> {

    List<ClienteListarDto> listar();
}
