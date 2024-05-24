package com.example.buensaborback.service;

import com.example.buensaborback.domain.entities.Categoria;
import com.example.buensaborback.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class CategoriaServiceImpl extends BaseServiceImpl<Categoria, Long> implements CategoriaService {

    private CategoriaRepository categoriaRepository;
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        super(categoriaRepository);
        this.categoriaRepository = categoriaRepository;
    }

    @Transactional
    public Categoria findWithSucursalesById(Long sucursalId) throws Exception {
        try {
            return categoriaRepository.findWithSucursalesById(sucursalId);
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
