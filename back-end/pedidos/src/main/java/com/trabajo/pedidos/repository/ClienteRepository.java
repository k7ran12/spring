package com.trabajo.pedidos.repository;

import com.trabajo.pedidos.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
