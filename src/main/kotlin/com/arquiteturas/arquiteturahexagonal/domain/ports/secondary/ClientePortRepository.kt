package com.arquiteturas.arquiteturahexagonal.domain.ports.secondary

import com.arquiteturas.arquiteturahexagonal.application.ClienteDTO
import com.arquiteturas.arquiteturahexagonal.application.ClienteUpdateDTO
import com.arquiteturas.arquiteturahexagonal.domain.Cliente

interface ClientePortRepository {
    fun getAll(): List<Cliente>
    fun getCliente(id: Long): Cliente
    fun saveCliente(clienteDTO: ClienteDTO)
    fun updateCliente(clienteUpdateDTO: ClienteUpdateDTO)
    fun deleteCliente(id: Long)
}