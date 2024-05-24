package com.example.buensaborback.controller;

import com.example.buensaborback.domain.entities.Cliente;
import com.example.buensaborback.domain.entities.Empleado;
import com.example.buensaborback.service.EmpleadoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/empleados")
public class EmpleadoController extends BaseControllerImpl<Empleado, EmpleadoServiceImpl>{

    private EmpleadoServiceImpl service;
    public EmpleadoController(EmpleadoServiceImpl service) {
        super(service);
        this.service = service;
    }

    @GetMapping("busqueda/{busqueda}")
    public ResponseEntity<?> buscarXNombre(@PathVariable String busqueda){
        try {
            List<Empleado> empleados = service.buscarXNombre(busqueda.toLowerCase());
            return ResponseEntity.status(HttpStatus.OK).body(empleados);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente luego\"}");
        }
    }
}

