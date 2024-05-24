package com.example.buensaborback.service;

import com.example.buensaborback.domain.entities.StockInsumo;
import com.example.buensaborback.repositories.StockInsumoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class StockInsumoServiceImpl extends BaseServiceImpl<StockInsumo, Long> implements StockInsumoService {

    private StockInsumoRepository stockInsumoRepository;
    public StockInsumoServiceImpl(StockInsumoRepository stockInsumoRepository) {
        super(stockInsumoRepository);
        this.stockInsumoRepository = stockInsumoRepository;
    }

    @Transactional
    public StockInsumo findByArticuloInsumoAndSucursal(Long id, Long sucursalId) throws Exception {
        try {
            Optional<StockInsumo> entityOptional = stockInsumoRepository.findByArticuloInsumo_IdAndSucursal_Id(id, sucursalId);
            return entityOptional.get();
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
