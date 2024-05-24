package com.example.buensaborback.service;

import com.example.buensaborback.domain.entities.Empleado;
import com.example.buensaborback.domain.entities.Pedido;
import com.example.buensaborback.repositories.PedidoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PedidoServiceImpl extends BaseServiceImpl<Pedido, Long> implements PedidoService {

    private PedidoRepository pedidoRepository;
    public PedidoServiceImpl(PedidoRepository pedidoRepository) {
        super(pedidoRepository);
        this.pedidoRepository = pedidoRepository;
    }

    @Transactional
    public List<Pedido> buscarXNombreIdFecha(String busqueda) throws Exception {
        try {
            return pedidoRepository.buscarXNombreIdFecha(busqueda);
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
