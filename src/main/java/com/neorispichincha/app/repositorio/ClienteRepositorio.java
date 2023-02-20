package com.neorispichincha.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neorispichincha.app.entidad.Cliente;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{


    Optional<Cliente> findByIdentificacion(String identificacion);
}
