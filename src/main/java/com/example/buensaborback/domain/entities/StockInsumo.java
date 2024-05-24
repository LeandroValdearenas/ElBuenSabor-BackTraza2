package com.example.buensaborback.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.envers.Audited;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Builder
@Audited
public class StockInsumo extends Base {

    private Integer stockActual;
    private Integer stockMaximo;
    private Integer stockMinimo;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "articulo_insumo_id")
    @JsonBackReference(value = "stock_insumo_articulo_insumo")
    private ArticuloInsumo articuloInsumo;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "sucursal_id")
    @JsonIgnoreProperties({"domicilio", "promociones", "horarioCierre", "horarioApertura", "casaMatriz", "empresa", "imagen"})
    private Sucursal sucursal;
}
