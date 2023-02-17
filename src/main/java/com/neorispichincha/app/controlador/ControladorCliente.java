package com.neorispichincha.app.controlador;

import com.neorispichincha.app.dto.ClienteListarDto;
import com.neorispichincha.app.entidad.Cliente;
import com.neorispichincha.app.servicio.cliente.ServicioActulizarCliente;
import com.neorispichincha.app.servicio.cliente.ServicioEliminarCliente;
import com.neorispichincha.app.servicio.cliente.ServicioListarCliente;
import com.neorispichincha.app.servicio.cliente.ServicioRegistrarCliente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/cliente")
public class ControladorCliente {
    private final ServicioRegistrarCliente registrarCliente;
    private final ServicioListarCliente listarCliente;
    private final ServicioActulizarCliente actualizarCliente;
    private final ServicioEliminarCliente eliminarCliente;


    public ControladorCliente(ServicioRegistrarCliente registrarCliente, ServicioListarCliente listarCliente, ServicioActulizarCliente actualizarCliente, ServicioEliminarCliente eliminarCliente) {
        this.registrarCliente = registrarCliente;
        this.listarCliente = listarCliente;
        this.actualizarCliente = actualizarCliente;

        this.eliminarCliente = eliminarCliente;
    }

    @GetMapping
    public ResponseEntity<List<ClienteListarDto>> listar() {
        return ResponseEntity.ok()
                .body(this.listarCliente.realizar());
    }

    @PostMapping
    public ResponseEntity<Void> registrar(@RequestBody Cliente cliente) {
        var idCliente = registrarCliente.realizar(cliente);
        return ResponseEntity.created(URI.create("/api/cliente/" + idCliente)).build();
    }

    @PutMapping
    public ResponseEntity<Void> actualizar(@RequestBody Cliente cliente) {
        var idCliente = actualizarCliente.realizar(cliente);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathParam("id") Long id) {
        return ResponseEntity.notFound().build();
    }
}
