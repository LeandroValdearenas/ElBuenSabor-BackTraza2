package com.example.buensaborback.controller;

import com.example.buensaborback.domain.entities.*;
import com.example.buensaborback.service.PedidoServiceImpl;
import com.example.buensaborback.service.StockInsumoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(path = "api/pedidos")
public class PedidoController extends BaseControllerImpl<Pedido, PedidoServiceImpl>{
    @Autowired
    private StockInsumoServiceImpl stockInsumoService;
    private PedidoServiceImpl service;
    public PedidoController(PedidoServiceImpl service) {
        super(service);
        this.service = service;
    }

    @Override
    public ResponseEntity<?> save(Pedido pedido) {
        pedido.getDetallePedidos().forEach(detallePedido -> {
            // Asignar el pedido
            detallePedido.setPedido(pedido);

            //Calcular subtotales
            detallePedido.setSubTotal(detallePedido.getCantidad() * detallePedido.getArticulo().getPrecioVenta());

            // Descontar el stock
            if (detallePedido.getArticulo() instanceof ArticuloInsumo) {
                descontarStockInsumo((ArticuloInsumo) detallePedido.getArticulo(), pedido.getSucursal().getId(), 1);
            } else if (detallePedido.getArticulo() instanceof ArticuloManufacturado) {
                ArticuloManufacturado articuloManufacturado = (ArticuloManufacturado) detallePedido.getArticulo();
                articuloManufacturado.getArticuloManufacturadoDetalles().forEach(detalle -> {
                    descontarStockInsumo(detalle.getArticuloInsumo(), pedido.getSucursal().getId(), detalle.getCantidad() * detallePedido.getCantidad());
                });
            }
        });

        // Calcular el total
        pedido.setTotal(pedido.getDetallePedidos().stream().map(detalle -> detalle.getSubTotal()).reduce((a,b) -> a + b).get());

        // Guardar el pedido
        ResponseEntity<?> response = super.save(pedido);

        return response;
    }

    private void descontarStockInsumo(ArticuloInsumo articuloInsumo, Long sucursalId, double cantidad) {
        StockInsumo stockInsumo = null;
        try {
            stockInsumo = stockInsumoService.findByArticuloInsumoAndSucursal(articuloInsumo.getId(), sucursalId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (stockInsumo != null) {
            stockInsumo.setStockActual(stockInsumo.getStockActual() - (int) cantidad);
        }
    }

    @GetMapping("busqueda/{busqueda}")
    public ResponseEntity<?> buscarXNombreIdFecha(@PathVariable String busqueda){
        try {
            List<Pedido> pedidos = service.buscarXNombreIdFecha(busqueda.toLowerCase());
            return ResponseEntity.status(HttpStatus.OK).body(pedidos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente luego\"}");
        }
    }
}

