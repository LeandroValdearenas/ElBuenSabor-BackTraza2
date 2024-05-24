package com.example.buensaborback.repositories;

import com.example.buensaborback.domain.entities.ArticuloInsumo;
import com.example.buensaborback.domain.entities.Cliente;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ClienteRepository extends BaseRepository<Cliente,Long> {
    @Query(value = "select c from Cliente c where concat(LOWER(c.nombre), ' ', c.apellido) LIKE %?1%")
    List<Cliente> buscarXNombre(String busqueda);
}
