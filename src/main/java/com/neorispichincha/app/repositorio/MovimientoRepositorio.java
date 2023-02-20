package com.neorispichincha.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neorispichincha.app.entidad.Movimiento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface MovimientoRepositorio extends JpaRepository<Movimiento, Long>{

   @Query("FROM Movimiento m where m.cuenta.cliente.id=:cliente and fecha=:fecha")
    List<Movimiento> listarPorUsuarioYFeacha(@Param("cliente") Long usuario, @Param("fecha") LocalDate fecha);
}
