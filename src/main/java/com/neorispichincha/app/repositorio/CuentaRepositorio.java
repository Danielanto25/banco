package com.neorispichincha.app.repositorio;

import com.neorispichincha.app.entidad.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CuentaRepositorio extends JpaRepository<Cuenta, Long> {

    @Query("FROM Cuenta c where c.numeroCuenta=:numero")
    Cuenta listarPorNumeroDeCuenta(@Param("numero") Long numeroCuenta);
}
