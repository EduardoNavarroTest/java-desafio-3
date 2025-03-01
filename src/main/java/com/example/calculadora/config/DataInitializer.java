package com.example.calculadora.config;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.calculadora.entitiy.Cliente;
import com.example.calculadora.repository.ClienteRepository;

import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final ClienteRepository clienteRepository;

    @Override
    public void run(String... args) {
        if (clienteRepository.count() == 0) { // Solo insertar si la BD está vacía
            List<Cliente> clientes = List.of(
                new Cliente(null, "Juan", "Pérez", LocalDate.of(1990, 5, 15)),
                new Cliente(null, "María", "González", LocalDate.of(1985, 8, 20)),
                new Cliente(null, "Carlos", "López", LocalDate.of(1992, 12, 10))
            );

            clienteRepository.saveAll(clientes);
            System.out.println("✅ Datos iniciales insertados en la base de datos.");
        } else {
            System.out.println("⚡ La base de datos ya contiene datos. No se insertaron nuevos registros.");
        }
    }
}
