package com.neorispichincha.app.controlador;

import com.neorispichincha.app.dto.MovimientoInsertDto;
import com.neorispichincha.app.dto.MovimientoReporteDto;
import com.neorispichincha.app.entidad.Movimiento;
import com.neorispichincha.app.servicio.movimiento.IServicioMovimiento;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.net.URI;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "/api/movimiento")
public class ControladorMovimiento {

    private final IServicioMovimiento servicioMovimiento;


    public ControladorMovimiento(IServicioMovimiento servicioMovimiento) {
        this.servicioMovimiento = servicioMovimiento;
    }

    @GetMapping
    public ResponseEntity<List<Movimiento>> listar() {
        return ResponseEntity.ok().body(servicioMovimiento.listar());
    }

    @GetMapping("/reporte")
    public ResponseEntity<List<MovimientoReporteDto>> reporte(@PathParam("cliente") Long cliente, @PathParam("fecha") String fecha){
        return ResponseEntity.ok().body(servicioMovimiento.reportePorClienteYFecha(cliente, LocalDate.parse(fecha)));
    }
    @PostMapping("ingreso-manual")
    public ResponseEntity<Void> realizarManual(@RequestBody Movimiento movimiento) {
        var id = servicioMovimiento.registrar(movimiento);
        return ResponseEntity.created(URI.create("api/movimiento" + id)).build();
    }

    @PostMapping
    public ResponseEntity<Void> realizar(@RequestBody MovimientoInsertDto movimientoInsertDto) {
        var id = servicioMovimiento.realizarMovimiento(movimientoInsertDto);
        return ResponseEntity.created(URI.create("api/movimiento" + id)).build();
    }

    @PutMapping
    public ResponseEntity<Movimiento> actualaizar(@RequestBody Movimiento movimiento) {
        return ResponseEntity.ok().body(servicioMovimiento.actualizar(movimiento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        servicioMovimiento.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
