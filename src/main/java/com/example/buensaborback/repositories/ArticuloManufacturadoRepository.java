package com.example.buensaborback.repositories;

import com.example.buensaborback.domain.entities.ArticuloManufacturado;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticuloManufacturadoRepository extends BaseRepository<ArticuloManufacturado,Long> {
    @Query(value = "select a from ArticuloManufacturado a where LOWER(a.denominacion) LIKE %:busqueda%")
    List<ArticuloManufacturado> buscarXDenominacion(String busqueda);
}
