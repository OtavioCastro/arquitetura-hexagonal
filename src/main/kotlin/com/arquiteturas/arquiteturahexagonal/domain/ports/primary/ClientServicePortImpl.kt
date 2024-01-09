package com.arquiteturas.arquiteturahexagonal.domain.ports.primary

import com.arquiteturas.arquiteturahexagonal.application.ClienteDTO
import com.arquiteturas.arquiteturahexagonal.application.ClienteUpdateDTO
import com.arquiteturas.arquiteturahexagonal.domain.Cliente
import com.arquiteturas.arquiteturahexagonal.domain.ports.secondary.ClientePortRepository
import org.springframework.stereotype.Service

@Service
class ClientServicePortImpl(
    val clientePortRepository: ClientePortRepository
): ClienteServicePort {

    override fun getAllClientes(): List<Cliente> = clientePortRepository.getAll()

    override fun getCliente(id: Long): Cliente = clientePortRepository.getCliente(id)

    override fun saveCliente(clienteDTO: ClienteDTO) = clientePortRepository.saveCliente(clienteDTO)

    override fun updateCliente(clienteUpdateDTO: ClienteUpdateDTO)  = clientePortRepository.updateCliente(clienteUpdateDTO)

    override fun deleteCliente(id: Long) = clientePortRepository.deleteCliente(id)
}