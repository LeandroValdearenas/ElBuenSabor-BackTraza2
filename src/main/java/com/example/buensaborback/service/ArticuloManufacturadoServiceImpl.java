package com.example.buensaborback.service;

import com.example.buensaborback.domain.entities.ArticuloManufacturado;
import com.example.buensaborback.repositories.ArticuloManufacturadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArticuloManufacturadoServiceImpl extends BaseServiceImpl<ArticuloManufacturado, Long> implements ArticuloManufacturadoService {

    private ArticuloManufacturadoRepository articuloManufacturadoRepository;
    public ArticuloManufacturadoServiceImpl(ArticuloManufacturadoRepository articuloManufacturadoRepository) {
        super(articuloManufacturadoRepository);
        this.articuloManufacturadoRepository = articuloManufacturadoRepository;
    }

    @Transactional
    public List<ArticuloManufacturado> buscarXDenominacion(String busqueda) throws Exception {
        try {
            return articuloManufacturadoRepository.buscarXDenominacion(busqueda);
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
