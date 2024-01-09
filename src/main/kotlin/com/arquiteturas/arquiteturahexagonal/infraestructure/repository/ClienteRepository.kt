package com.arquiteturas.arquiteturahexagonal.infraestructure.repository

import com.arquiteturas.arquiteturahexagonal.application.ClienteDTO
import com.arquiteturas.arquiteturahexagonal.application.ClienteUpdateDTO
import com.arquiteturas.arquiteturahexagonal.domain.Cliente
import com.arquiteturas.arquiteturahexagonal.domain.ports.secondary.ClientePortRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
class ClienteRepository(
    val clienteRepository: SpringClienteRepository
) : ClientePortRepository {
    override fun getAll(): List<Cliente> = clienteRepository.findAll().map { it.toCliente() }

    override fun getCliente(id: Long): Cliente = clienteRepository.findById(id).get().toCliente()

    @Transactional
    override fun saveCliente(clienteDTO: ClienteDTO) {
        val clienteEntity = ClienteEntity(
            clienteDTO.nome,
            clienteDTO.cpf,
            clienteDTO.email
        )
        clienteRepository.save(clienteEntity)
    }

    @Transactional
    override fun updateCliente(clienteUpdateDTO: ClienteUpdateDTO) {
        val clienteToUpdate = clienteRepository.findById(clienteUpdateDTO.id).get()
        clienteToUpdate.email = clienteUpdateDTO.email
        clienteRepository.save(clienteToUpdate)
    }

    @Transactional
    override fun deleteCliente(id: Long) = clienteRepository.deleteById(id)
}