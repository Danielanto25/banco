package com.neorispichincha.app.servicio.cliente.impl;

import com.neorispichincha.app.dto.ClienteListarDto;
import com.neorispichincha.app.entidad.Cliente;
import com.neorispichincha.app.excepcion.NoEncontradoException;
import com.neorispichincha.app.excepcion.RepetidoModelException;
import com.neorispichincha.app.repositorio.ClienteRepositorio;
import com.neorispichincha.app.servicio.cliente.IServicioCliente;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioClienteImpl implements IServicioCliente {

    private final ClienteRepositorio clienteRepositorio;
    private final ServicioConstruirDto servicioConstruirDto;

    public ServicioClienteImpl(ClienteRepositorio clienteRepositorio, ServicioConstruirDto servicioConstruirDto) {
        this.clienteRepositorio = clienteRepositorio;
        this.servicioConstruirDto = servicioConstruirDto;
    }

    @Override
    public List<ClienteListarDto> listar() {
        return servicioConstruirDto.construirClienteListarDto(clienteRepositorio.findAll());
    }

    @Override
    public Long registrar(Cliente cliente) {
        validarRepetido(cliente.getIdentificacion());
    	return clienteRepositorio.save(construirCliente(cliente)).getId();
    }

    @Override
    public Cliente actualizar(Cliente cliente) {

        return clienteRepositorio.save(construirCliente(cliente));
    }

    @Override
    public void eliminar(Long id) {
        validarExistencia(id);
        clienteRepositorio.deleteById(id);
    }

    private Cliente construirCliente(Cliente cliente) {
        return cliente.getId() != null ?
                new Cliente(cliente.getId(), cliente.getNombre(), cliente.getGenero(), cliente.getFechaNacimiento(),
                        cliente.getIdentificacion(), cliente.getDireccion(), cliente.getTelefono(), cliente.getClave(), cliente.getEstado())
                :
                new Cliente(cliente.getNombre(), cliente.getGenero(), cliente.getFechaNacimiento(),
                        cliente.getIdentificacion(), cliente.getDireccion(), cliente.getTelefono(), cliente.getClave(), cliente.getEstado());


    }

    private void validarExistencia(Long id) {
        if (clienteRepositorio.findById(id).isEmpty()) throw new NoEncontradoException("El Cliente no existe");
    }
    private void validarRepetido(String identificacion){
    	
        if(clienteRepositorio.findByIdentificacion(identificacion).isPresent())throw new RepetidoModelException("Documento repetido");
    }
}
