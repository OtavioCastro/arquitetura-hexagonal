package com.arquiteturas.arquiteturahexagonal.infraestructure.repository

import com.arquiteturas.arquiteturahexagonal.domain.Cliente
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class ClienteEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,
    val nome: String,
    val cpf: String,
    var email: String
) {
    constructor(nome: String, cpf: String, email: String) : this(0, nome, cpf, email)
    fun toCliente() = Cliente(this.nome, this.cpf, this.email)
}