package com.example.buensaborback.repositories;

import com.example.buensaborback.domain.entities.Cliente;
import com.example.buensaborback.domain.entities.Empleado;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface EmpleadoRepository extends BaseRepository<Empleado,Long> {
    @Query(value = "select e from Empleado e where concat(LOWER(e.nombre), ' ', e.apellido) LIKE %?1%")
    List<Empleado> buscarXNombre(String busqueda);
}
