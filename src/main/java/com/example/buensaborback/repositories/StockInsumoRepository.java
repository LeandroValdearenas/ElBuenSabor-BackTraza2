package com.example.buensaborback.repositories;

import com.example.buensaborback.domain.entities.StockInsumo;

import java.util.Optional;

public interface StockInsumoRepository extends BaseRepository<StockInsumo,Long> {
    Optional<StockInsumo> findByArticuloInsumo_IdAndSucursal_Id(Long id, Long sucursalId);
}
