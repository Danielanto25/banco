package com.neorispichincha.app.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.neorispichincha.app.entidad.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long>{

}
