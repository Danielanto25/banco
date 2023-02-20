package com.neorispichincha.app.controlador;

import com.neorispichincha.app.dto.CuentaListarDto;
import com.neorispichincha.app.entidad.Cuenta;
import com.neorispichincha.app.servicio.cuenta.IServicioCuenta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "api/cuenta")
public class ControladorCuenta {
    private final IServicioCuenta servicioCuenta;

    public ControladorCuenta(IServicioCuenta servicioCuenta) {
        this.servicioCuenta = servicioCuenta;
    }

    @GetMapping
    public ResponseEntity<List<CuentaListarDto>> listar() {
        return ResponseEntity.ok().body(servicioCuenta.listar());
    }

    @PostMapping
    public ResponseEntity<Void> registrar(@RequestBody Cuenta cuenta) {
        var id = servicioCuenta.registrar(cuenta);
        return ResponseEntity.created(URI.create("/api/cuenta/" + id)).build();
    }

    @PutMapping
    ResponseEntity<Cuenta> actualizar(@RequestBody Cuenta cuenta) {
        return ResponseEntity.ok().body(servicioCuenta.actualizar(cuenta));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }


}
