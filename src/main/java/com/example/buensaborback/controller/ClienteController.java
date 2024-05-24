package com.example.buensaborback.controller;

import com.example.buensaborback.domain.entities.ArticuloInsumo;
import com.example.buensaborback.domain.entities.Cliente;
import com.example.buensaborback.service.ClienteServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/clientes")
public class ClienteController extends BaseControllerImpl<Cliente, ClienteServiceImpl>{

    private ClienteServiceImpl service;
    public ClienteController(ClienteServiceImpl service) {
        super(service);
        this.service = service;
    }

    @GetMapping("busqueda/{busqueda}")
    public ResponseEntity<?> buscarXNombre(@PathVariable String busqueda){
        try {
            List<Cliente> clientes = service.buscarXNombre(busqueda.toLowerCase());
            return ResponseEntity.status(HttpStatus.OK).body(clientes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente luego\"}");
        }
    }
}

