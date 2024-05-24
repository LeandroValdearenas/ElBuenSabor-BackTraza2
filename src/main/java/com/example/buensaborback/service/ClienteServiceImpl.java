package com.example.buensaborback.service;

import com.example.buensaborback.domain.entities.ArticuloInsumo;
import com.example.buensaborback.domain.entities.Cliente;
import com.example.buensaborback.repositories.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClienteServiceImpl extends BaseServiceImpl<Cliente, Long> implements ClienteService {

    private ClienteRepository clienteRepository;
    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        super(clienteRepository);
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public List<Cliente> buscarXNombre(String busqueda) throws Exception {
        try {
            return clienteRepository.buscarXNombre(busqueda);
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
