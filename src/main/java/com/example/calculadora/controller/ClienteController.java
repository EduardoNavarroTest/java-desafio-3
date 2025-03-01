package com.example.calculadora.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.example.calculadora.service.ClienteService;

import java.util.Map;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping("/{id}")
    public Map<String, Object> obtenerCliente(@PathVariable Long id) {
        return clienteService.obtenerClienteConEdad(id);
    }
}

