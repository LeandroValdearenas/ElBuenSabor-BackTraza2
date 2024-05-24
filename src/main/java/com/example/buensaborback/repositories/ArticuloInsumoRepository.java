package com.example.buensaborback.repositories;

import com.example.buensaborback.domain.entities.ArticuloInsumo;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArticuloInsumoRepository extends BaseRepository<ArticuloInsumo,Long> {
    @Query(value = "select a from ArticuloInsumo a where LOWER(a.denominacion) LIKE %?1%")
    List<ArticuloInsumo> buscarXDenominacion(String busqueda);
}
