package com.example.calculadora.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.calculadora.entitiy.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
