package com.example.buensaborback.domain.entities;

import com.example.buensaborback.domain.enums.Estado;
import com.example.buensaborback.domain.enums.FormaPago;
import com.example.buensaborback.domain.enums.TipoEnvio;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@ToString
@Builder
@Audited
public class Pedido extends Base{
    @Temporal(TemporalType.TIME)
    private LocalTime horaEstimadaFinalizacion;
    private Double total;
    private Double totalCosto;
    private Estado estado;
    private TipoEnvio tipoEnvio;
    private FormaPago formaPago;
    @Temporal(TemporalType.DATE)
    private Date fechaPedido;

    @ManyToOne
    @JoinColumn(name = "domicilio_id")
    private Domicilio domicilio;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "sucursal_id")
    @JsonIgnoreProperties({"categorias, promociones"})
    private Sucursal sucursal;

    @OneToOne(mappedBy = "pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonBackReference(value = "pedido_factura")
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonIgnoreProperties({"pedidos", "domicilios", "usuario", "imagen"})
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    @JsonIgnoreProperties({"pedidos", "domicilios", "usuario", "imagen", "rol"})
    private Empleado empleado;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    @Builder.Default
    private Set<DetallePedido> detallePedidos = new HashSet<>();
}
