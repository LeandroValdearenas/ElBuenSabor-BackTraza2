package com.example.buensaborback.service;

import com.example.buensaborback.domain.entities.ArticuloInsumo;
import com.example.buensaborback.repositories.ArticuloInsumoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArticuloInsumoServiceImpl extends BaseServiceImpl<ArticuloInsumo, Long> implements ArticuloInsumoService {

    private ArticuloInsumoRepository articuloInsumoRepository;
    public ArticuloInsumoServiceImpl(ArticuloInsumoRepository articuloInsumoRepository) {
        super(articuloInsumoRepository);
        this.articuloInsumoRepository = articuloInsumoRepository;
    }

    @Transactional
    public List<ArticuloInsumo> buscarXDenominacion(String busqueda) throws Exception {
        try {
            return articuloInsumoRepository.buscarXDenominacion(busqueda);
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
