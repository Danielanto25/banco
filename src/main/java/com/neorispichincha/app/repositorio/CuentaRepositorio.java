package com.neorispichincha.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neorispichincha.app.entidad.Cuenta;

public interface CuentaRepositorio extends JpaRepository<Cuenta, Long>{

}
