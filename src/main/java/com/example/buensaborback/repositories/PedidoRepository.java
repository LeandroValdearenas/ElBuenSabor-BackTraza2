package com.example.buensaborback.repositories;

import com.example.buensaborback.domain.entities.Pedido;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends BaseRepository<Pedido,Long> {
    @Query(value = "select p from Pedido p where LOWER(concat(p.cliente.nombre, ' ', p.cliente.apellido)) LIKE %:busqueda% OR concat('0', p.id) LIKE %:busqueda%")
    List<Pedido> buscarXNombreIdFecha(String busqueda);
}
