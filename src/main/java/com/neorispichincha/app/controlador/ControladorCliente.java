package com.neorispichincha.app.controlador;

import com.neorispichincha.app.dto.ClienteListarDto;
import com.neorispichincha.app.servicio.cliente.ServicioListarCliente;
import com.neorispichincha.app.servicio.cliente.ServicioRegistrarCliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/cliente")
public class ControladorCliente {
    private final ServicioRegistrarCliente registrarCliente;
    private final ServicioListarCliente listarCliente;


    public ControladorCliente(ServicioRegistrarCliente registrarCliente, ServicioListarCliente listarCliente) {
        this.registrarCliente = registrarCliente;
        this.listarCliente = listarCliente;
    }
    @GetMapping()
    public ResponseEntity<List<ClienteListarDto>> listar(){
        return ResponseEntity.ok()
                .body(this.listarCliente.realizar());
    }
}
