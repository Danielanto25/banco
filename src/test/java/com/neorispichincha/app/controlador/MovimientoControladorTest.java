package com.neorispichincha.app.controlador;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neorispichincha.app.dto.MovimientoInsertDto;
import com.neorispichincha.app.entidad.*;
import com.neorispichincha.app.servicio.movimiento.IServicioMovimiento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ControladorMovimiento.class)

public class MovimientoControladorTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IServicioMovimiento servicioMovimiento;

    @Autowired
    private ObjectMapper objectMapper;

    @DisplayName("Junit test de metodo para crear movimiento")
    @Test
    public void realizarMovimientoExitoso() throws Exception {
        Long id = 1L;

        MovimientoInsertDto movimiento = new MovimientoInsertDto();

        when(servicioMovimiento
                .realizarMovimiento((any(MovimientoInsertDto.class))))
                .thenReturn(id);


        ResultActions respuesta = mockMvc
                .perform(post("/api/movimiento")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(movimiento)));

        respuesta.andExpect(status().isCreated())
                .andExpect(result -> {
                    var location = result.getResponse().getHeader("Location");
                    Assertions.assertEquals(location, "api/movimiento/" + id);
                });

    }

    @DisplayName("Junit test de metodo para listar Movimientos")
    @Test
    public void listar() throws Exception {
        List<Movimiento> movimientos = new ArrayList<>();
        movimientos.add(new Movimiento(1L, LocalDate.now(), new TipoMovimiento(1L),
                8000F, 72000F, new Cuenta(1L,
                45698712L, new TipoCuenta(1), 72000F, new Estado(1L),
                new Cliente(
                        1L, "cliente 1", "M", LocalDate.parse("2001-05-25"),
                        "1234567892", "direccion 1", 3156478920L, 7845,
                        new Estado(1L)
                )
        )
        ));
        when(servicioMovimiento.listar()).thenReturn(movimientos);

        ResultActions resultado= mockMvc.perform(get("/api/movimiento"));

        resultado.andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id",is(1)));
    }

}
