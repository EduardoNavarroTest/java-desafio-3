package com.example.calculadora.service;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.example.calculadora.entitiy.Cliente;
import com.example.calculadora.repository.ClienteRepository;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public Map<String, Object> obtenerClienteConEdad(Long id) {
        Optional<Cliente> clienteOpt = clienteRepository.findById(id);
        Map<String, Object> response = new HashMap<>();

        if (clienteOpt.isPresent()) {
            Cliente cliente = clienteOpt.get();
            int edad = Period.between(cliente.getFechaNacimiento(), LocalDate.now()).getYears();

            response.put("nombre", cliente.getNombre());
            response.put("apellido", cliente.getApellido());
            response.put("años", edad);
        } else {
            response.put("error", "Cliente no encontrado");
        }

        return response;
    }
}
