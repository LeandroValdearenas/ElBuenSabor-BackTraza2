package com.example.buensaborback.service;

import com.example.buensaborback.domain.entities.Cliente;
import com.example.buensaborback.domain.entities.Empleado;
import com.example.buensaborback.repositories.EmpleadoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmpleadoServiceImpl extends BaseServiceImpl<Empleado, Long> implements EmpleadoService {

    private EmpleadoRepository empleadoRepository;
    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository) {
        super(empleadoRepository);
        this.empleadoRepository = empleadoRepository;
    }

    @Transactional
    public List<Empleado> buscarXNombre(String busqueda) throws Exception {
        try {
            return empleadoRepository.buscarXNombre(busqueda);
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
