package com.neorispichincha.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neorispichincha.app.entidad.TipoCuenta;

public interface TipoCuentaRepositorio extends JpaRepository<TipoCuenta, Long> {

}
