package com.arquiteturas.arquiteturahexagonal.infraestructure.repository

import org.springframework.data.jpa.repository.JpaRepository

interface SpringClienteRepository : JpaRepository<ClienteEntity, Long> {
}