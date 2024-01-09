package com.arquiteturas.arquiteturahexagonal.domain.ports.primary

import com.arquiteturas.arquiteturahexagonal.application.ClienteDTO
import com.arquiteturas.arquiteturahexagonal.application.ClienteUpdateDTO
import com.arquiteturas.arquiteturahexagonal.domain.Cliente

interface ClienteServicePort {
   fun getAllClientes() : List<Cliente>
   fun getCliente(id: Long) : Cliente
   fun saveCliente(clienteDTO: ClienteDTO)
   fun updateCliente(clienteUpdateDTO: ClienteUpdateDTO)
   fun deleteCliente(id: Long)
}