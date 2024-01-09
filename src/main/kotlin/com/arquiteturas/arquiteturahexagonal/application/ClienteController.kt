package com.arquiteturas.arquiteturahexagonal.application

import com.arquiteturas.arquiteturahexagonal.domain.ports.primary.ClienteServicePort
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("cliente")
class ClienteController(
    val clienteServicePort: ClienteServicePort
) {

    @GetMapping
    fun getAllClientes() = clienteServicePort.getAllClientes()

    @GetMapping("/{id}")
    fun getCliente(@PathVariable id: Long) = clienteServicePort.getCliente(id)

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveCliente(@RequestBody clienteDto: ClienteDTO) = clienteServicePort.saveCliente(clienteDto)

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun updateCliente(@RequestBody clienteUpdateDTO: ClienteUpdateDTO) = clienteServicePort.updateCliente(clienteUpdateDTO)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteCliente(@PathVariable id: Long) = clienteServicePort.deleteCliente(id)
}