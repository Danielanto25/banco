package com.neorispichincha.app.controlador;

import com.neorispichincha.app.dto.ClienteListarDto;
import com.neorispichincha.app.entidad.Cliente;
import com.neorispichincha.app.servicio.cliente.IServicioCliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/cliente")
public class ControladorCliente {
    private final IServicioCliente servicioCliente;

    public ControladorCliente(IServicioCliente servicioCliente) {
        this.servicioCliente = servicioCliente;
    }


    @GetMapping
    public ResponseEntity<List<ClienteListarDto>> listar() {
        return ResponseEntity.ok()
                .body(this.servicioCliente.listar());
    }

    @PostMapping
    public ResponseEntity<Void> registrar(@RequestBody Cliente cliente) {
        var idCliente = servicioCliente.registrar(cliente);
        return ResponseEntity.created(URI.create("/api/cliente/" + idCliente)).build();
    }

    @PutMapping
    public ResponseEntity<Cliente> actualizar(@RequestBody Cliente cliente) {
        var clienteActualizado = servicioCliente.actualizar(cliente);
        return ResponseEntity.ok().body(clienteActualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathParam("id") Long id) {
        return ResponseEntity.noContent().build();
    }
}
