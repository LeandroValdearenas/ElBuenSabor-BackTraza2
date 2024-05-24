package com.example.buensaborback.service;


import com.example.buensaborback.domain.entities.Categoria;

import java.util.List;

public interface CategoriaService extends BaseService<Categoria, Long>{
    Categoria findWithSucursalesById(Long sucursalId) throws Exception;
}
