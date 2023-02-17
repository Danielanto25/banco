package com.neorispichincha.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neorispichincha.app.entidad.Movimiento;

public interface MovimientoRepositorio extends JpaRepository<Movimiento, Long>{

}
