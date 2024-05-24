package com.example.buensaborback.repositories;

import com.example.buensaborback.domain.entities.Base;
import com.example.buensaborback.domain.entities.StockInsumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<E extends Base, ID extends Serializable> extends JpaRepository<E, ID>{
}
